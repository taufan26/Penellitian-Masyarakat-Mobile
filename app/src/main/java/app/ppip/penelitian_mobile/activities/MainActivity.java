package app.ppip.penelitian_mobile.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayDeque;
import java.util.Deque;

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
    BottomNavigationView bottom_nav;
    ApiInterface apiInterface;
    String  user_id;
    Deque<Integer> integerDeque = new ArrayDeque<>(3);
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManager(MainActivity.this);
        user_id  = sessionManager.getUserDetail().get(SessionManager.USER_ID);
        getToken();
        createNotificationChannel();
        subscribetoTopic();

        bottom_nav = findViewById(R.id.bottom_navigation);


        integerDeque.push(R.id.nav_beranda);

        loadFragment(new HomeFragment());

        bottom_nav.setSelectedItemId(R.id.nav_beranda);
        bottom_nav.setOnNavigationItemSelectedListener(navListener);
        
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container,fragment,fragment.getClass().getSimpleName())
                .commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    int id = item.getItemId();
                    if (integerDeque.contains(id)){
                        if (id == R.id.nav_beranda){
                            if (integerDeque.size() != 1){
                                if (flag){
                                    integerDeque.addFirst(R.id.nav_beranda);
                                    flag = false;
                                }
                            }
                        }
                        integerDeque.remove(id);
                    }
                    integerDeque.push(id);
                    loadFragment(getFrament(item.getItemId()));
                    return true;
                }
            };

    private Fragment getFrament(int itemId) {
        switch (itemId){
            case R.id.nav_penelitian:
                bottom_nav.getMenu().getItem(0).setChecked(true);
                return new PenelitianFragment();
            case R.id.nav_beranda:
                bottom_nav.getMenu().getItem(1).setChecked(true);
                return new HomeFragment();
            case R.id.nav_pengabdian:
                bottom_nav.getMenu().getItem(2).setChecked(true);
                return new PengabdianFragment();
        }
        bottom_nav.getMenu().getItem(1).setChecked(true);
        return new HomeFragment();
    }

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

    @Override
    public void onBackPressed() {
        integerDeque.pop();
        if (!integerDeque.isEmpty()){
            loadFragment(getFrament(integerDeque.peek()));
        }else {
            finish();
        }
    }
}