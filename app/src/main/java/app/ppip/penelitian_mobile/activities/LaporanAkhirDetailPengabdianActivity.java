package app.ppip.penelitian_mobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import app.ppip.penelitian_mobile.R;
import app.ppip.penelitian_mobile.adapters.SessionManager;

public class LaporanAkhirDetailPengabdianActivity extends AppCompatActivity {

    TextView tv_judul, tv_tanggal, tv_nama, tv_dokument, tv_extensi, button;
    SessionManager sessionManger;
    String Id, Judul, Tanggal, Nama, Dokument, Extensi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan_akhir_detail_pengabdian);

        tv_judul = findViewById(R.id.detail_laporan_akhir_judul_pengabdian);
        tv_tanggal = findViewById(R.id.detail_laporan_akhir_tanggal_pengabdian);
        tv_nama = findViewById(R.id.detail_laporan_akhir_nama_pengabdian);
        tv_dokument = findViewById(R.id.detail_laporan_akhir_dokument_pengabdian);
        tv_extensi = findViewById(R.id.detail_laporan_akhir_extensi_pengabdian);
        button = findViewById(R.id.laporan_akhir_pengabdian_btn);


        Intent intent = getIntent();
        Id = intent.getStringExtra("laporan_akhir_id");
        Judul = intent.getStringExtra("usulan_pengabdian_judul");
        Tanggal = intent.getStringExtra("laporan_akhir_date");
        Nama = intent.getStringExtra("laporan_akhir_base_name");
        Dokument = intent.getStringExtra("laporan_akhir_original_name");
        Extensi = intent.getStringExtra("laporan_akhir_extension");

        tv_judul.setText(Judul);
        tv_tanggal.setText(Tanggal);
        tv_dokument.setText(Dokument);
        tv_nama.setText(Nama);
        tv_extensi.setText(Extensi);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}