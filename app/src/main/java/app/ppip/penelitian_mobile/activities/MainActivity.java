package app.ppip.penelitian_mobile.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.messaging.FirebaseMessaging;

import app.ppip.penelitian_mobile.adapters.SessionManager;
import app.ppip.penelitian_mobile.api.ApiInterface;
import app.ppip.penelitian_mobile.fragments.HomeFragment;
import app.ppip.penelitian_mobile.fragments.PenelitianFragment;
import app.ppip.penelitian_mobile.fragments.PengabdianFragment;
import app.ppip.penelitian_mobile.R;

public class MainActivity extends AppCompatActivity {
    private static final String CHANNEL_ID = "101";
    private static final String TAG = "PushNotification";
    SessionManager sessionManager;
    ApiInterface apiInterface;
    String  user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManager(MainActivity.this);
        user_id  = sessionManager.getUserDetail().get(SessionManager.USER_ID);
        getToken();
        createNotificationChannel();
        subscribetoTopic();

        BottomNavigationView bottom_nav = findViewById(R.id.bottom_navigation);
        bottom_nav.setOnNavigationItemSelectedListener(navListener);



        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectionFragment = null;
                    switch (item.getItemId()){
                        case R.id.nav_beranda:
                            selectionFragment = new HomeFragment();
                            break;
                        case R.id.nav_penelitian:
                            selectionFragment = new PenelitianFragment();
                            break;
                        case R.id.nav_pengabdian:
                            selectionFragment = new PengabdianFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectionFragment).commit();

                    return true;
                }
            };

    private void getToken() {
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                //If task is failed then
                if (!task.isSuccessful()) {
                    Log.d(TAG, "onComplete: Failed to get the Token");
                }

                //Token
                String token = task.getResult();
                Log.d(TAG, "onComplete: " + token);
            }
        });
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "firebaseNotifChannel";
            String description = "Receve Firebase notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getApplicationContext().getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void subscribetoTopic(){
        FirebaseMessaging.getInstance().subscribeToTopic(user_id)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(MainActivity.this, "Selamat Datang!", Toast.LENGTH_SHORT).show();
                    }
                });
    }

}