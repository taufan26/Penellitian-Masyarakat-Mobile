package app.ppip.penelitian_mobile.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import app.ppip.penelitian_mobile.R;
import app.ppip.penelitian_mobile.adapters.LaporanKemajuanPenelitianAdapter;
import app.ppip.penelitian_mobile.adapters.LogbookPenelitianAdapter;
import app.ppip.penelitian_mobile.adapters.SessionManager;
import app.ppip.penelitian_mobile.interfaces.LaporanKemajuanPenelitainView;
import app.ppip.penelitian_mobile.model.laporanKemajuanPenelitian.LaporanKemeajuanPenelitianItem;
import app.ppip.penelitian_mobile.model.logbookPenelitian.LogbookPenelitianItem;

public class LaporanKemajuanPenelitianActivity extends AppCompatActivity implements LaporanKemajuanPenelitainView {

    private static final int INTENT_LAPORAN_KEMAJUAN_DETAIL = 100;
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefresh;
    LaporanKemajuanPenelitianPresenter presenter;
    LaporanKemajuanPenelitianAdapter adapter;
    LaporanKemajuanPenelitianAdapter.ItemClickListener itemClickListener;
    SessionManager sessionManager;
    String user_id;

    List<LaporanKemeajuanPenelitianItem> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan_kemajuan_penelitian);

        sessionManager = new SessionManager(LaporanKemajuanPenelitianActivity.this);
        user_id = sessionManager.getUserDetail().get(SessionManager.USER_ID);

        swipeRefresh = findViewById(R.id.swipe_laporan_kemajuan_penelitian);
        recyclerView = findViewById(R.id.list_laporan_kemajuan_penelitian);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        presenter = new LaporanKemajuanPenelitianPresenter(this);
        presenter.getDataLaporanKemajuan(user_id);


        swipeRefresh.setOnRefreshListener(
                () -> presenter.getDataLaporanKemajuan(user_id)
        );

        itemClickListener = (((view, position) -> {
            String usulan_penelitian_judul = data.get(position).getUsulanPenelitianJudul();
            String laporan_kemajuan_id = data.get(position).getLaporanKemajuanId();
            String laporan_kemajuan_luaran_id = data.get(position).getLaporanKemajuanLuaranId();
            String laporan_kemajuan_date = data.get(position).getLaporanKemajuanDate();
            String laporan_kemajuan_base_name = data.get(position).getLaporanKemajuanBaseName();
            String usulan_luaran_id = data.get(position).getUsulanLuaranId();
            String usulan_luaran_penelitian_id = data.get(position).getUsulanLuaranPenelitianId();
            String usulan_luaran_penelitian_tipe = data.get(position).getUsulanLuaranPenelitianTipe();
            String usulan_luaran_penelitian_tahun = data.get(position).getUsulanLuaranPenelitianTahun();
            String usulan_luaran_penelitian_jenis = data.get(position).getUsulanLuaranPenelitianJenis();
            String usulan_luaran_penelitian_status = data.get(position).getUsulanLuaranPenelitianStatus();
            String usulan_luaran_penelitian_rencana = data.get(position).getUsulanLuaranPenelitianRencana();


            Intent intent = new Intent(this, LaporanKemajuanPenelitianDetailActivity.class);
            intent.putExtra("usulan_penelitian_judul", usulan_penelitian_judul);
            intent.putExtra("laporan_kemajuan_id", laporan_kemajuan_id);
            intent.putExtra("laporan_kemajuan_luaran_id", laporan_kemajuan_luaran_id);
            intent.putExtra("laporan_kemajuan_date", laporan_kemajuan_date);
            intent.putExtra("laporan_kemajuan_base_name", laporan_kemajuan_base_name);
            intent.putExtra("usulan_luaran_id", usulan_luaran_id);
            intent.putExtra("usulan_luaran_penelitian_id", usulan_luaran_penelitian_id);
            intent.putExtra("usulan_luaran_penelitian_tipe", usulan_luaran_penelitian_tipe);
            intent.putExtra("usulan_luaran_penelitian_tahun", usulan_luaran_penelitian_tahun);
            intent.putExtra("usulan_luaran_penelitian_jenis", usulan_luaran_penelitian_jenis);
            intent.putExtra("usulan_luaran_penelitian_status", usulan_luaran_penelitian_status);
            intent.putExtra("usulan_luaran_penelitian_rencana", usulan_luaran_penelitian_rencana);
            startActivityForResult(intent, INTENT_LAPORAN_KEMAJUAN_DETAIL);
        }));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == INTENT_LAPORAN_KEMAJUAN_DETAIL && resultCode == RESULT_OK){
            presenter.getDataLaporanKemajuan(user_id);
        }
    }

    @Override
    public void showLoading() {
        swipeRefresh.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        swipeRefresh.setRefreshing(false);
    }

    @Override
    public void onGetResult(List<LaporanKemeajuanPenelitianItem> datas) {
        adapter = new LaporanKemajuanPenelitianAdapter(this, datas, itemClickListener);
        adapter.notifyDataSetChanged();
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        data = datas;
    }

    @Override
    public void onErrorLoading(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}