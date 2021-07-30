package app.ppip.penelitian_mobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import app.ppip.penelitian_mobile.R;
import app.ppip.penelitian_mobile.adapters.SessionManager;

public class UsulanDetailPenelitianActivity extends AppCompatActivity {

    private static final int INTENT_ADD = 100;
    TextView judul, pengusul, kegiatan, tahun, status, skema, bidang, mahasiswa, komentar, button, btn_tambah;
    SessionManager sessionManger;
    String Id, Judul, Skema, Bidang, Kegiatan, Tahun, Kategori, Status, Mahasiswa, Submit, Komentar, Pengusul;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usulan_detail);

        judul = findViewById(R.id.detail_judul_penelitian);
        pengusul = findViewById(R.id.detail_pengusul_penelitan);
        kegiatan = findViewById(R.id.detail_kegiatan_penelitan);
        tahun = findViewById(R.id.detail_tahun_penelitan);
        status = findViewById(R.id.detail_status_penelitan);
        skema = findViewById(R.id.detail_Skema_penelitan);
        bidang = findViewById(R.id.detail_bidang_penelitan);
        komentar = findViewById(R.id.detail_komentar_penelitan);
        mahasiswa = findViewById(R.id.detail_mahasiswa_penelitan);
        button = findViewById(R.id.detail_penelitan_btn);
        btn_tambah = findViewById(R.id.detail_penelitan_btn_tambah);

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
        }else {
            skema.setText(Skema);
        }

        if (Bidang.equals("1")) {
            bidang.setText("Nostrum");
        } else if (Bidang.equals("2")) {
            bidang.setText("Consequuntur");
        } else if (Bidang.equals("3")) {
            bidang.setText("Porro");
        }else {
            bidang.setText(Bidang);
        }

        if (Komentar != null) {
            komentar.setText(Komentar);
        }else {
            komentar.setText("-");
        }

        sessionManger = new SessionManager(UsulanDetailPenelitianActivity.this);
        Pengusul = sessionManger.getUserDetail().get(SessionManager.USER_NAME);

        pengusul.setText(Pengusul);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });

        btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LogbookPenelitanTambahActivity.class);
                i.putExtra("id", Id);
                i.putExtra("judul", Judul);
                startActivityForResult(i, INTENT_ADD);
            }
        });
    }

}