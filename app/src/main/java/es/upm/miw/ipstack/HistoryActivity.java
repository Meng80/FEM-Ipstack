package es.upm.miw.ipstack;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class HistoryActivity extends AppCompatActivity {
    @NonNull
    public static Query sChatQuery =
            FirebaseDatabase.getInstance("https://ipstack-5abdc-default-rtdb.europe-west1.firebasedatabase.app/").getReference().child("ipstacks").limitToLast(50);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
    }

    public static void addRealtimeDB(IpHistory ipHistory) {
        sChatQuery.getRef().push().setValue(ipHistory)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Log.i("HistoryActivity", "IpHistory added successfully");
                    } else {
                        Log.e("HistoryActivity", "Failed to add IpHistory", task.getException());
                    }
                });
    }

    @Override
    public void onStart() {
        super.onStart();
        attachRecyclerViewAdapter();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    private void attachRecyclerViewAdapter() {
        final RecyclerView.Adapter adapter = newAdapter();
        RecyclerView recyclerView =  findViewById(R.id.rvHistoryIpstack);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
              recyclerView.smoothScrollToPosition(adapter.getItemCount());
            }
        });
        recyclerView.setAdapter(adapter);
    }

    @NonNull
    protected RecyclerView.Adapter newAdapter() {
        FirebaseRecyclerOptions<IpHistory> options =
                new FirebaseRecyclerOptions.Builder<IpHistory>()
                        .setQuery(sChatQuery, IpHistory.class)
                        .setLifecycleOwner(this)
                        .build();

        return new FirebaseRecyclerAdapter<IpHistory, IpHolder>(options) {
            @Override
            public IpHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new IpHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.activity_item, parent, false));
            }
            @Override
            protected void onBindViewHolder(@NonNull IpHolder holder, int position, @NonNull IpHistory model) {
                holder.bind(model);
            }
        };
    }

}
