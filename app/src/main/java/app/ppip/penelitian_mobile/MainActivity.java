package app.ppip.penelitian_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManager(MainActivity.this);
        if (sessionManager.isLoggedIn() == false){
            moveToLogin();
        }

        CardView cv_logout = findViewById(R.id.menu_logout);
        CardView cv_profile = findViewById(R.id.menu_profile);
        CardView cv_usulan = findViewById(R.id.menu_usulan);
        CardView cv_logbook = findViewById(R.id.menu_logbook);

        cv_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManager.logoutSession();
                moveToLogin();
            }
        });

        cv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(i);
            }
        });

        cv_usulan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), UsulanActivity.class);
                startActivity(i);
            }
        });

        cv_logbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), LogbookActivity.class);
                startActivity(i);
            }
        });

    }

    private void moveToLogin() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }
}