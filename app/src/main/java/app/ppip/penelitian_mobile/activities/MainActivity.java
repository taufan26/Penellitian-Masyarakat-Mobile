package app.ppip.penelitian_mobile.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.ProgressDialog;
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
import app.ppip.penelitian_mobile.api.ApiClient;
import app.ppip.penelitian_mobile.api.ApiInterface;
import app.ppip.penelitian_mobile.fragments.HomeFragment;
import app.ppip.penelitian_mobile.fragments.PenelitianFragment;
import app.ppip.penelitian_mobile.fragments.PengabdianFragment;
import app.ppip.penelitian_mobile.R;
import app.ppip.penelitian_mobile.model.counting.Counting;
import app.ppip.penelitian_mobile.model.counting.DataCounting;
import app.ppip.penelitian_mobile.model.feature.Feature;
import app.ppip.penelitian_mobile.model.feature.FeatureItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String CHANNEL_ID = "101";
    private static final String TAG = "PushNotification";
    SessionManager sessionManager;
    BottomNavigationView bottom_nav;
    ProgressDialog progressDialog;
    ApiInterface apiInterface;
    String  user_id;
    Deque<Integer> integerDeque = new ArrayDeque<>(3);
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("loading....");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        sessionManager = new SessionManager(MainActivity.this);
        user_id  = sessionManager.getUserDetail().get(SessionManager.USER_ID);
        if (sessionManager.isLoggedIn()){
            getToken();
            createNotificationChannel();
            subscribetoTopic();
            getfeature();
            getCounting(user_id);
        }

        bottom_nav = findViewById(R.id.bottom_navigation);
        integerDeque.push(R.id.nav_beranda);
        loadFragment(new HomeFragment());
        bottom_nav.setSelectedItemId(R.id.nav_beranda);
        bottom_nav.setOnNavigationItemSelectedListener(navListener);

    }

    private void getCounting(String user_id) {
        progressDialog.show();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Counting> countingCall = apiInterface.GetCounting(user_id);
        countingCall.enqueue(new Callback<Counting>() {
            @Override
            public void onResponse(@NonNull Call<Counting> call, @NonNull Response<Counting> response) {
                progressDialog.dismiss();
                if (response.isSuccessful() && response.body() != null) {
                    sessionManager = new SessionManager(MainActivity.this);
                    DataCounting data = response.body().getDataCounting();
                    sessionManager.createCounting(data);
                }
            }

            @Override
            public void onFailure(Call<Counting> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
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

    public void getfeature() {
        //progressDialog.show();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Feature> featurecall = apiInterface.GetFeture();
        featurecall.enqueue(new Callback<Feature>() {
            @Override
            public void onResponse(@NonNull Call<Feature> call, @NonNull Response<Feature> response) {
                //progressDialog.dismiss();
                if (response.isSuccessful() && response.body() != null) {
                    sessionManager = new SessionManager(MainActivity.this);
                    FeatureItem data = response.body().getData();
                    sessionManager.createFeatureSession(data);
                }
            }

            @Override
            public void onFailure(Call<Feature> call, Throwable t) {
                //progressDialog.dismiss();
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
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