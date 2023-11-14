package es.upm.miw.ipstack;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.BuildConfig;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
        public static String LOG_TAG = "Ipstack - Main";

        private static final int RC_SIGN_IN = 2019;

        public static FirebaseAuth mFirebaseAuth;
        private FirebaseAuth.AuthStateListener mFirebaseAuthListener;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            mFirebaseAuth = FirebaseAuth.getInstance();
            mFirebaseAuthListener = this::signIn;

            findViewById(R.id.logoutButton).setOnClickListener(view -> { mFirebaseAuth.addAuthStateListener(mFirebaseAuthListener);});

        }

    private void signIn(FirebaseAuth firebaseAuth) {
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user == null) {
            startActivityForResult(
                    AuthUI.getInstance().
                            createSignInIntentBuilder().
                            setAvailableProviders(Collections.singletonList(
                                    new AuthUI.IdpConfig.EmailBuilder().build()
                            )).
                            setIsSmartLockEnabled(!BuildConfig.DEBUG, true).
                            build(),
                    RC_SIGN_IN);
        } else {
            Log.i(LOG_TAG, "User: " + user.getEmail() + " loged in");
            startActivity(new Intent(this, IpstackDetailsActivity.class));

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mFirebaseAuth.removeAuthStateListener(mFirebaseAuthListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, R.string.signed_in, Toast.LENGTH_SHORT).show();
                Log.i(LOG_TAG, "onActivityResult " + getString(R.string.signed_in));
                startActivity(new Intent(this, IpstackDetailsActivity.class));
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, R.string.signed_cancelled, Toast.LENGTH_SHORT).show();
                Log.i(LOG_TAG, "onActivityResult " + getString(R.string.signed_cancelled));
                finish();
            }
        }
    }
}
