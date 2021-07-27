package app.ppip.penelitian_mobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import app.ppip.penelitian_mobile.R;
import app.ppip.penelitian_mobile.adapters.SessionManager;
import app.ppip.penelitian_mobile.adapters.UsulanPenelitianAdapter;
import app.ppip.penelitian_mobile.model.usulanPenelitian.UsulanPenelitianItem;

public class UsulanDetailActivity extends AppCompatActivity {

    TextView judul;
    SessionManager sessionManger;
    String Id, Judul, Skema, Bidang, Kegiatan, Tahun, Kategori, Status, Mahasiswa, Submit, Komentar;
    UsulanPenelitianAdapter.ItemClickListener itemClickListener;
    List<UsulanPenelitianItem> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usulan_detail);

        judul = findViewById(R.id.detail_usulan_judul);

        Intent intent  = getIntent();
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
    }

    private void SetDataFromIntentExtra() {

    }
}