package app.ppip.penelitian_mobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import app.ppip.penelitian_mobile.R;
import app.ppip.penelitian_mobile.adapters.SessionManager;

public class LaporanKemajuanPenelitianDetailActivity extends AppCompatActivity {

    TextView tv_judul, tv_tanggal, tv_nama, tv_luaranTipe, tv_luaranTahun, tv_luaranJenis, tv_luaranStatus, tv_luaranRencana, button;
    SessionManager sessionManger;
    String Id, Judul, Tanggal, Nama, LuaranTipe, LuaranTahun, LuaranJenis, LuaranStatus, LuaranRencana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan_kemajuan_penelitian_detail);

        tv_judul = findViewById(R.id.detail_laporan_kemajuan_judul_penelitian);
        tv_tanggal = findViewById(R.id.detail_laporan_kemajuan_tanggal_penelitian);
        tv_nama = findViewById(R.id.detail_laporan_kemajuan_nama_penelitian);
        tv_luaranTipe = findViewById(R.id.detail_laporan_kemajuan_tipe_penelitian);
        tv_luaranTahun = findViewById(R.id.detail_laporan_kemajuan_luaran_tahun_penelitian);
        tv_luaranJenis = findViewById(R.id.detail_laporan_kemajuan_luaran_jenis_penelitian);
        tv_luaranStatus = findViewById(R.id.detail_laporan_kemajuan_luaran_status_penelitian);
        tv_luaranRencana = findViewById(R.id.detail_laporan_kemajuan_luaran_rencana_penelitian);
        button = findViewById(R.id.laporan_kemajuan_penelitian_btn);


        Intent intent = getIntent();
        Id = intent.getStringExtra("laporan_kemajuan_id");
        Judul = intent.getStringExtra("usulan_penelitian_judul");
        Tanggal = intent.getStringExtra("laporan_kemajuan_date");
        Nama = intent.getStringExtra("laporan_kemajuan_base_name");
        LuaranTipe = intent.getStringExtra("usulan_luaran_penelitian_tipe");
        LuaranTahun = intent.getStringExtra("usulan_luaran_penelitian_tahun");
        LuaranJenis = intent.getStringExtra("usulan_luaran_penelitian_jenis");
        LuaranStatus = intent.getStringExtra("usulan_luaran_penelitian_status");
        LuaranRencana = intent.getStringExtra("usulan_luaran_penelitian_rencana");

        tv_judul.setText(Judul);
        tv_tanggal.setText(Tanggal);
        tv_luaranTipe.setText(LuaranTipe);
        tv_nama.setText(Nama);
        tv_luaranTahun.setText(LuaranTahun);
        tv_luaranJenis.setText(LuaranJenis);
        tv_luaranStatus.setText(LuaranStatus);
        tv_luaranRencana.setText(LuaranRencana);
        

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}