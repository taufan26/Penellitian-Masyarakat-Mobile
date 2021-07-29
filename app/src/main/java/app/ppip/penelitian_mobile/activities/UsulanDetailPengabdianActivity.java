package app.ppip.penelitian_mobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import app.ppip.penelitian_mobile.R;
import app.ppip.penelitian_mobile.adapters.SessionManager;

public class UsulanDetailPengabdianActivity extends AppCompatActivity {

    TextView judul, pengusul, kegiatan, tahun, status, skema, bidang, mahasiswa, komentar, button, btn_tambah;
    SessionManager sessionManger;
    String Id, Judul, Skema, Bidang, Kegiatan, Tahun, Kategori, Status, Mahasiswa, Submit, Komentar, Pengusul;
    private static final int INTENT_ADD_PENGABDIAN = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usulan_detail_pengabdian);

        judul = findViewById(R.id.detail_judul_pengabdian);
        pengusul = findViewById(R.id.detail_pengusul_pengabdian);
        kegiatan = findViewById(R.id.detail_kegiatan_pengabdian);
        tahun = findViewById(R.id.detail_tahun_pengabdian);
        status = findViewById(R.id.detail_status_pengabdian);
        skema = findViewById(R.id.detail_Skema_pengabdian);
        bidang = findViewById(R.id.detail_bidang_pengabdian);
        komentar = findViewById(R.id.detail_komentar_pengabdian);
        mahasiswa = findViewById(R.id.detail_mahasiswa_pengabdian);
        button = findViewById(R.id.detail_pengabdian_btn);
        btn_tambah = findViewById((R.id.detail_pengabdian_btn_tambah));

        Intent intent = getIntent();
        Id = intent.getStringExtra("id");
        Judul = intent.getStringExtra("judul");
        Skema = intent.getStringExtra("skema_id");
        Bidang = intent.getStringExtra("bidang_id");
        Kegiatan = intent.getStringExtra("lama_kegiatan");
        Kategori = intent.getStringExtra("Kategori");
        Status = intent.getStringExtra("status");
        Mahasiswa = intent.getStringExtra("mahasiswa");
        Tahun = intent.getStringExtra("tahun");
        Submit = intent.getStringExtra("submit");
        Komentar = intent.getStringExtra("komentar");

        judul.setText(Judul);
        kegiatan.setText(Kegiatan);
        mahasiswa.setText(Mahasiswa);
        tahun.setText(Tahun);

        if (Status.equals("diterima")) {
            status.setText("Diterima");
        } else if (Status.equals("dikirim")) {
            status.setText("Dikirim");
        } else if (Status.equals("ditolak")) {
            status.setText("Ditolak");
        } else if (Status.equals("dinilai")) {
            status.setText("Dinilai");
        } else if (Status.equals("pending")) {
            status.setText("Pending");
        } else if (Status.equals("revisi")) {
            status.setText("Revisi");
        }

        if (Skema.equals("1")) {
            skema.setText("Sed");
        } else if (Skema.equals("2")) {
            skema.setText("Praesentium");
        } else if (Skema.equals("3")) {
            skema.setText("Delectus");
        }

        if (Bidang.equals("1")) {
            bidang.setText("Nostrum");
        } else if (Bidang.equals("2")) {
            bidang.setText("Consequuntur");
        } else if (Bidang.equals("3")) {
            bidang.setText("Porro");
        }

        if (Komentar != null) {
            komentar.setText(Komentar);
        }else {
            komentar.setText("-");
        }

        sessionManger = new SessionManager(UsulanDetailPengabdianActivity.this);
        Pengusul = sessionManger.getUserDetail().get(SessionManager.USER_NAME);

        pengusul.setText(Pengusul);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), UsulanPengabdianActivity.class);
                startActivity(i);
            }
        });

        btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LogbookPengabdianTambahActivity.class);
                i.putExtra("id", Id);
                i.putExtra("judul", Judul);
                startActivityForResult(i, INTENT_ADD_PENGABDIAN);
            }
        });
    }
}