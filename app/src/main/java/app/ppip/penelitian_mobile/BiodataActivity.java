package app.ppip.penelitian_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class BiodataActivity extends AppCompatActivity {

    ImageView foto;
    TextView bio_hp, jk, alamat, tempat, tanggal, institusi, programstudi, jabatan, ktp, btnbio;
    SessionManager sessionManger;
    String hp, Sex, Alamat, TL, TTL, Institusi, ProgramStudi, Jabatan, KTP, image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata);

        sessionManger = new SessionManager(BiodataActivity.this);

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
        foto = findViewById(R.id.bio_image);

        hp = sessionManger.getBiodataDetail().get(SessionManager.BOIDATA_HP_NUMBER);
        Sex = sessionManger.getBiodataDetail().get(SessionManager.BOIDATA_SEX);
        Alamat = sessionManger.getBiodataDetail().get(SessionManager.BOIDATA_ADDRESS);
        TL = sessionManger.getBiodataDetail().get(SessionManager.BOIDATA_BIRTHPLACE);
        TTL = sessionManger.getBiodataDetail().get(SessionManager.BOIDATA_BIRTHDATE);
        Institusi = sessionManger.getBiodataDetail().get(SessionManager.BOIDATA_COLLEGE);
        ProgramStudi = sessionManger.getBiodataDetail().get(SessionManager.BOIDATA_STUDY_PROGRAM);
        Jabatan = sessionManger.getBiodataDetail().get(SessionManager.BOIDATA_POSITION);
        KTP = sessionManger.getBiodataDetail().get(SessionManager.BOIDATA_KTP_NUMBER);
        image = sessionManger.getUserDetail().get(SessionManager.USER_IMAGE);


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
        Picasso.get().load(Urls.image_url+image).into(foto);

        btnbio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(i);
            }
        });


    }
}