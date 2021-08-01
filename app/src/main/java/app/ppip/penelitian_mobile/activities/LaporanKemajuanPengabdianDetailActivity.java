package app.ppip.penelitian_mobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import app.ppip.penelitian_mobile.R;
import app.ppip.penelitian_mobile.adapters.SessionManager;

public class LaporanKemajuanPengabdianDetailActivity extends AppCompatActivity {

    TextView tv_judul, tv_tanggal, tv_nama, tv_luaranTipe, tv_luaranTahun, tv_luaranJenis, tv_luaranStatus, tv_luaranRencana, button;
    SessionManager sessionManger;
    String Id, Judul, Tanggal, Nama, LuaranTipe, LuaranTahun, LuaranJenis, LuaranStatus, LuaranRencana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan_kemajuan_pengabdian_detail);

        tv_judul = findViewById(R.id.detail_laporan_kemajuan_judul_pengabdian);
        tv_tanggal = findViewById(R.id.detail_laporan_kemajuan_tanggal_pengabdian);
        tv_nama = findViewById(R.id.detail_laporan_kemajuan_nama_pengabdian);
        tv_luaranTipe = findViewById(R.id.detail_laporan_kemajuan_tipe_pengabdian);
        tv_luaranTahun = findViewById(R.id.detail_laporan_kemajuan_luaran_tahun_pengabdian);
        tv_luaranJenis = findViewById(R.id.detail_laporan_kemajuan_luaran_jenis_pengabdian);
        tv_luaranStatus = findViewById(R.id.detail_laporan_kemajuan_luaran_status_pengabdian);
        tv_luaranRencana = findViewById(R.id.detail_laporan_kemajuan_luaran_rencana_pengabdian);
        button = findViewById(R.id.laporan_kemajuan_pengabdian_btn);


        Intent intent = getIntent();
        Id = intent.getStringExtra("laporan_kemajuan_id");
        Judul = intent.getStringExtra("usulan_pengabdian_judul");
        Tanggal = intent.getStringExtra("laporan_kemajuan_date");
        Nama = intent.getStringExtra("laporan_kemajuan_base_name");
        LuaranTipe = intent.getStringExtra("usulan_luaran_pengabdian_tipe");
        LuaranTahun = intent.getStringExtra("usulan_luaran_pengabdian_tahun");
        LuaranJenis = intent.getStringExtra("usulan_luaran_pengabdian_jenis");
        LuaranStatus = intent.getStringExtra("usulan_luaran_pengabdian_status");
        LuaranRencana = intent.getStringExtra("usulan_luaran_pengabdian_rencana");

        tv_judul.setText(Judul);
        tv_tanggal.setText(Tanggal);
        tv_luaranTipe.setText(LuaranTipe);
        tv_nama.setText(Nama);
        tv_luaranTahun.setText(LuaranTahun);
        tv_luaranJenis.setText(LuaranJenis);
        tv_luaranStatus.setText(LuaranStatus);
        tv_luaranRencana.setText(LuaranRencana);
    }
}