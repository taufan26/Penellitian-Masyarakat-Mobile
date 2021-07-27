package app.ppip.penelitian_mobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import app.ppip.penelitian_mobile.utils.CircleTransform;
import app.ppip.penelitian_mobile.R;
import app.ppip.penelitian_mobile.adapters.SessionManager;
import app.ppip.penelitian_mobile.utils.Urls;

public class ProfileActivity extends AppCompatActivity {

    ImageView showFoto;
    TextView Nama, Email, home, biodata, anggota;
    SessionManager sessionManger;
    String email, nama, foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        sessionManger = new SessionManager(ProfileActivity.this);

        //inisialisasi
        showFoto = findViewById(R.id.profile_image);
        Nama = findViewById(R.id.profile_name);
        Email = findViewById(R.id.profile_email);
        home = findViewById(R.id.button_home);
        biodata = findViewById(R.id.button_biodata);
        anggota = findViewById(R.id.button_anggota);

        email = sessionManger.getUserDetail().get(SessionManager.USER_EMAIL);
        nama = sessionManger.getUserDetail().get(SessionManager.USER_NAME);
        foto = sessionManger.getUserDetail().get(SessionManager.USER_IMAGE);

        Nama.setText(nama);
        Email.setText(email);
        Picasso.get().load(Urls.image_url+foto).transform(new CircleTransform()).into(showFoto);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        biodata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, BiodataActivity.class);
                startActivity(intent);
            }
        });

        anggota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, AnggotaActivity.class);
                startActivity(intent);
            }
        });
    }

}
