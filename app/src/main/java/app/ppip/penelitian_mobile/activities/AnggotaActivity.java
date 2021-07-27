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

public class AnggotaActivity extends AppCompatActivity {

    ImageView foto;
    TextView id, userid, role, tugas, tanggal, btnanggota, annama, anemail;
    SessionManager sessionManger;
    String Id, Userid, Role, Tugas, TL,image, Annama ,Anemail ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anggota);

        sessionManger = new SessionManager(AnggotaActivity.this);

        //inisialisasi
        id = findViewById(R.id.anggota_id);
        userid = findViewById(R.id.anggota_userid);
        role = findViewById(R.id.anggota_role);
        tugas = findViewById(R.id.anggota_tugas);
        tanggal = findViewById(R.id.anggota_dibuat);
        btnanggota = findViewById(R.id.anggota_btn);
        foto = findViewById(R.id.anggota_image);
        annama = findViewById(R.id.anggota_name);
        anemail = findViewById(R.id.anggota_email);

        Id = sessionManger.getAnggotaDetail().get(SessionManager.ANGGOTA_ID);
        Userid = sessionManger.getAnggotaDetail().get(SessionManager.ANGGOTA_USER_ID);
        Role = sessionManger.getAnggotaDetail().get(SessionManager.ANGGOTA_ROLE);
        TL = sessionManger.getAnggotaDetail().get(SessionManager.ANGGOTA_CREATE);
        Tugas = sessionManger.getAnggotaDetail().get(SessionManager.ANGGOTA_TUGAS);
        image = sessionManger.getUserDetail().get(SessionManager.USER_IMAGE);
        Annama = sessionManger.getUserDetail().get(SessionManager.USER_NAME);
        Anemail = sessionManger.getUserDetail().get(SessionManager.USER_EMAIL);

        id.setText(Id);
        userid.setText(Userid);
        role.setText(Role);
        tanggal.setText(TL);
        tugas.setText(Tugas);
        annama.setText(Annama);
        anemail.setText(Anemail);
        Picasso.get().load(Urls.image_url+image).transform(new CircleTransform()).into(foto);

        btnanggota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(i);
            }
        });

    }
}