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
    TextView Nama, Email, btnbio;
    SessionManager sessionManger;
    String email, nama, foto;
    TextView bio_hp, jk, alamat, tempat, tanggal, institusi, programstudi, jabatan, ktp;
    String hp, Sex, Alamat, TL, TTL, Institusi, ProgramStudi, Jabatan, KTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        sessionManger = new SessionManager(ProfileActivity.this);

        //inisialisasi
        showFoto = findViewById(R.id.profile_image);
        Nama = findViewById(R.id.profile_name);
        Email = findViewById(R.id.profile_email);

        //inisialisasi
        bio_hp = findViewById(R.id.bio_hp);
        jk = findViewById(R.id.bio_sex);
        alamat = findViewById(R.id.bio_alamat);
        tempat = findViewById(R.id.bio_tempat);
        tanggal = findViewById(R.id.bio_tanggallahir);
        institusi = findViewById(R.id.bio_institusi);
        programstudi = findViewById(R.id.bio_studi);
        jabatan = findViewById(R.id.bio_jabatan);
        ktp = findViewById(R.id.bio_ktp);
        btnbio = findViewById(R.id.bio_btn);

        email = sessionManger.getUserDetail().get(SessionManager.USER_EMAIL);
        nama = sessionManger.getUserDetail().get(SessionManager.USER_NAME);
        foto = sessionManger.getUserDetail().get(SessionManager.USER_IMAGE);
        hp = sessionManger.getBiodataDetail().get(SessionManager.BOIDATA_HP_NUMBER);
        Alamat = sessionManger.getBiodataDetail().get(SessionManager.BOIDATA_ADDRESS);
        Sex = sessionManger.getBiodataDetail().get(SessionManager.BOIDATA_SEX);
        TL = sessionManger.getBiodataDetail().get(SessionManager.BOIDATA_BIRTHPLACE);
        TTL = sessionManger.getBiodataDetail().get(SessionManager.BOIDATA_BIRTHDATE);
        Institusi = sessionManger.getBiodataDetail().get(SessionManager.BOIDATA_COLLEGE);
        ProgramStudi = sessionManger.getBiodataDetail().get(SessionManager.BOIDATA_STUDY_PROGRAM);
        Jabatan = sessionManger.getBiodataDetail().get(SessionManager.BOIDATA_POSITION);
        KTP = sessionManger.getBiodataDetail().get(SessionManager.BOIDATA_KTP_NUMBER);

        Nama.setText(nama);
        Email.setText(email);
        Picasso.get().load(Urls.image_url+foto).transform(new CircleTransform()).into(showFoto);
        bio_hp.setText(hp);
        if (Sex.equals("1")){
            jk.setText("Laki-Laki");
        }else {
            jk.setText("Perempuan");
        }
        alamat.setText(Alamat);
        tempat.setText(TL);
        tanggal.setText(TTL);
        institusi.setText(Institusi);
        programstudi.setText(ProgramStudi);
        jabatan.setText(Jabatan);
        ktp.setText(KTP);

        btnbio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
