package es.upm.miw.ipstack;

import static es.upm.miw.ipstack.MainActivity.mFirebaseAuth;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import es.upm.miw.ipstack.model.Ipstack;
import es.upm.miw.ipstack.service.IpstackRESTAPIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class IpstackDetailsActivity extends AppCompatActivity {

    private static final String IPSTACK_ACCESS_KEY = "1a5f5af600b62caf2e59a299c55657b8";
    private static final String IPSTACK_BASE_URL = "http://api.ipstack.com/";
    private TextView tvIp;
    private TextView tvCountry;
    private TextView tvCity;
    private TextView tvRegion;
    private TextView tvRandomIp;
    private IpstackRESTAPIService ipstackService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipstack_details);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IPSTACK_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ipstackService = retrofit.create(IpstackRESTAPIService.class);
        this.tvCountry = findViewById(R.id.tvIpstackDetailsCountry);
        this.tvCity = findViewById(R.id.tvIpstackDetailsCity);
        this.tvIp = findViewById(R.id.tvIpstackDetailsIp);
        this.tvRegion = findViewById(R.id.tvIpstackDetailsRegion);
        this.tvRandomIp = findViewById(R.id.tvRandomIp);
        findViewById(R.id.signOutButton).setOnClickListener(view -> {signOut();});
        findViewById(R.id.historyButton).setOnClickListener(view -> {startActivity(new Intent(this,HistoryActivity.class));});
    }

    public  String generateRandomIpAddress() {
            Random random = new Random();
            StringBuilder ipAddress = new StringBuilder();

            for (int i = 0; i < 4; i++) {
                ipAddress.append(random.nextInt(256));
                if (i < 3) {
                    ipAddress.append(".");
                }
            }
            return ipAddress.toString();
        }

    public void getIpInfo() {
        String personIp = generateRandomIpAddress();
        Log.i("IpstackActivity", personIp);
        Call<Ipstack> ipInfoCall = ipstackService.getIpstackIP(personIp,IPSTACK_ACCESS_KEY);
        ipInfoCall.enqueue(new Callback<Ipstack>() {
            @Override
            public void onResponse(Call<Ipstack> call, Response<Ipstack> response) {
                Ipstack ipstackData = response.body();
                if (ipstackData != null) {
                    Log.i("IpstackActivity", ipstackData.getIp());
                    displayIpInfo(ipstackData);
                    saveIpstackDataToFirebase(ipstackData);
                } else {
                    Log.e("IpstackActivity", "Failed to get Ipstack data");
                }
            }
            @Override
            public void onFailure(Call<Ipstack> call, Throwable t) {
                Log.e("IpstackActivity", "Error fetching Ipstack data", t);

            }
        });
    }

    private void saveIpstackDataToFirebase(Ipstack ipstackData) {
        IpHistory ipHistory = new IpHistory(
                mFirebaseAuth.getCurrentUser().getUid(),
                ipstackData.getCity(),
                ipstackData.getCountry_name(),
                ipstackData.getZip(),
                ipstackData.getRegion_name()
        );

        HistoryActivity.addRealtimeDB(ipHistory);
    }

    public void btnBusqueda(View btn) {
        this.getIpInfo();
    }

    private void displayIpInfo(Ipstack ipstackData) {
        tvRandomIp.setText(generateRandomIpAddress());
        tvIp.setText( ipstackData.getZip());
        tvCity.setText(ipstackData.getCity());
        tvCountry.setText( ipstackData.getCountry_name());
        tvRegion.setText(ipstackData.getRegion_name());
    }

    private void signOut() {
        mFirebaseAuth.signOut();
        finish();
    }

}

