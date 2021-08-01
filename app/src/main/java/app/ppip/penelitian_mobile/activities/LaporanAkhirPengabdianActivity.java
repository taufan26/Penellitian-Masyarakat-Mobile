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
import app.ppip.penelitian_mobile.adapters.LaporanAkhirPenelitianAdapter;
import app.ppip.penelitian_mobile.adapters.LaporanAkhirPengabdianAdapter;
import app.ppip.penelitian_mobile.adapters.SessionManager;
import app.ppip.penelitian_mobile.interfaces.LaporanAkhirPengabdianView;
import app.ppip.penelitian_mobile.model.laporanAkhirPenelitian.LaporanAkhirPenelitianItem;
import app.ppip.penelitian_mobile.model.laporanAkhirPengabdian.LaporanAkhirPengabdianItem;

public class LaporanAkhirPengabdianActivity extends AppCompatActivity implements LaporanAkhirPengabdianView {

    private static final int INTENT_LAPORAN_AKHIR_PENGABDIAN_DETAIL = 100;
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefresh;
    LaporanAkhirPengabdianPresenter presenter;
    LaporanAkhirPengabdianAdapter adapter;
    LaporanAkhirPengabdianAdapter.ItemClickListener itemClickListener;
    SessionManager sessionManager;
    String user_id;

    List<LaporanAkhirPengabdianItem> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan_akhir_pengabdian);

        sessionManager = new SessionManager(LaporanAkhirPengabdianActivity.this);
        user_id = sessionManager.getUserDetail().get(SessionManager.USER_ID);

        swipeRefresh = findViewById(R.id.swipe_laporan_akhir_pengabdian);
        recyclerView = findViewById(R.id.list_laporan_akhir_pengabdian);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        presenter = new LaporanAkhirPengabdianPresenter(this);
        presenter.getDataLaporanAkhir(user_id);


        swipeRefresh.setOnRefreshListener(
                () -> presenter.getDataLaporanAkhir(user_id)
        );

        itemClickListener = (((view, position) -> {
            String usulan_penelitian_judul = data.get(position).getUsulanPengabdianJudul();
            String laporan_akhir_id = data.get(position).getLaporanAkhirId();
            String laporan_akhir_penelitian_id = data.get(position).getLaporanAkhirPengabdianId();
            String laporan_akhir_date = data.get(position).getLaporanAkhirDate();
            String laporan_akhir_original_name = data.get(position).getLaporanAkhirOriginalName();
            String laporan_akhir_hash_name = data.get(position).getLaporanAkhirHashName();
            String laporan_akhir_base_name = data.get(position).getLaporanAkhirBaseName();
            String laporan_akhir_file_size = data.get(position).getLaporanAkhirFileSize();
            String laporan_akhir_extension = data.get(position).getLaporanAkhirExtension();


            Intent intent = new Intent(this, LaporanAkhirDetailPengabdianActivity.class);
            intent.putExtra("usulan_pengabdian_judul", usulan_penelitian_judul);
            intent.putExtra("laporan_akhir_id", laporan_akhir_id);
            intent.putExtra("laporan_akhir_penelitian_id", laporan_akhir_penelitian_id);
            intent.putExtra("laporan_akhir_date", laporan_akhir_date);
            intent.putExtra("laporan_akhir_original_name", laporan_akhir_original_name);
            intent.putExtra("laporan_akhir_hash_name", laporan_akhir_hash_name);
            intent.putExtra("laporan_akhir_base_name", laporan_akhir_base_name);
            intent.putExtra("laporan_akhir_file_size", laporan_akhir_file_size);
            intent.putExtra("laporan_akhir_extension", laporan_akhir_extension);
            startActivityForResult(intent, INTENT_LAPORAN_AKHIR_PENGABDIAN_DETAIL);
        }));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == INTENT_LAPORAN_AKHIR_PENGABDIAN_DETAIL && resultCode == RESULT_OK){
            presenter.getDataLaporanAkhir(user_id);
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
    public void onGetResult(List<LaporanAkhirPengabdianItem> datas) {
        adapter = new LaporanAkhirPengabdianAdapter(this, datas, itemClickListener);
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