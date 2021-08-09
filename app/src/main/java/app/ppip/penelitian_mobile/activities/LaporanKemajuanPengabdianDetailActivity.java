package app.ppip.penelitian_mobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.URLUtil;
import android.widget.TextView;
import android.widget.Toast;

import app.ppip.penelitian_mobile.R;
import app.ppip.penelitian_mobile.adapters.SessionManager;
import app.ppip.penelitian_mobile.utils.Urls;

public class LaporanKemajuanPengabdianDetailActivity extends AppCompatActivity {

    TextView tv_judul, tv_tanggal, tv_nama, tv_luaranTipe, tv_luaranTahun, tv_luaranJenis,
            tv_luaranStatus, tv_luaranRencana, button, download;
    String Id, Judul, Tanggal, Nama, LuaranTipe, LuaranTahun, LuaranJenis, LuaranStatus, LuaranRencana, original;

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
        download = findViewById(R.id.laporan_kemajuan_pengabdian_download_btn);


        Intent intent = getIntent();
        Judul = intent.getStringExtra("usulan_pengabdian_judul");
        Tanggal = intent.getStringExtra("laporan_kemajuan_date");
        Nama = intent.getStringExtra("laporan_kemajuan_base_name");
        LuaranTipe = intent.getStringExtra("usulan_luaran_pengabdian_tipe");
        LuaranTahun = intent.getStringExtra("usulan_luaran_pengabdian_tahun");
        LuaranJenis = intent.getStringExtra("usulan_luaran_pengabdian_jenis");
        LuaranStatus = intent.getStringExtra("usulan_luaran_pengabdian_status");
        LuaranRencana = intent.getStringExtra("usulan_luaran_pengabdian_rencana");
        original = intent.getStringExtra("laporan_kemajuan_original_name");

        tv_judul.setText(Judul);
        tv_tanggal.setText(Tanggal);
        tv_luaranTipe.setText(LuaranTipe);
        tv_nama.setText(Nama);
        tv_luaranTahun.setText(LuaranTahun);
        tv_luaranJenis.setText(LuaranJenis);
        tv_luaranStatus.setText(LuaranStatus);
        tv_luaranRencana.setText(LuaranRencana);

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getUrl = Urls.file_url+original;

                DownloadManager.Request request  = new DownloadManager.Request(Uri.parse(getUrl));
                String title = URLUtil.guessFileName(getUrl,null,null);
                request.setTitle(title);
                request.setDescription("Downloading Laporan Harap Tunggu . . . .");
                String cookie = CookieManager.getInstance().getCookie(getUrl);
                request.addRequestHeader("cookie", cookie);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,title);

                DownloadManager downloadManager = (DownloadManager)getSystemService(DOWNLOAD_SERVICE);
                downloadManager.enqueue(request);

                Toast.makeText(LaporanKemajuanPengabdianDetailActivity.this, "Mulai Downloading.", Toast.LENGTH_SHORT).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}