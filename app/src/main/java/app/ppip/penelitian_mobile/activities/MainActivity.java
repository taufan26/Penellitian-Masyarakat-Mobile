package app.ppip.penelitian_mobile.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import app.ppip.penelitian_mobile.fragments.HomeFragment;
import app.ppip.penelitian_mobile.fragments.PenelitianFragment;
import app.ppip.penelitian_mobile.fragments.PengabdianFragment;
import app.ppip.penelitian_mobile.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

}