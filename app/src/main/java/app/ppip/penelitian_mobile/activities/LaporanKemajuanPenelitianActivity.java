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
            String laporan_kemajuan_penelitian_id = data.get(position).getLaporanKemajuanPenelitianId();
            String laporan_kemajuan_date = data.get(position).getLaporanKemajuanDate();
            String laporan_kemajuan_base_name = data.get(position).getLaporanKemajuanBaseName();
            String laporan_kemajuan_original_name = data.get(position).getLaporanKemajuanOriginalName();
            String laporan_kemajuan_extension = data.get(position).getLaporanKemajuanOriginalName();
            String laporan_kemajuan_tipe = data.get(position).getLaporanKemajuanOriginalName();


            Intent intent = new Intent(this, LaporanKemajuanPenelitianDetailActivity.class);
            intent.putExtra("usulan_penelitian_judul", usulan_penelitian_judul);
            intent.putExtra("laporan_kemajuan_id", laporan_kemajuan_id);
            intent.putExtra("laporan_kemajuan_penelitian_id", laporan_kemajuan_penelitian_id);
            intent.putExtra("laporan_kemajuan_date", laporan_kemajuan_date);
            intent.putExtra("laporan_kemajuan_base_name", laporan_kemajuan_base_name);
            intent.putExtra("laporan_kemajuan_original_name", laporan_kemajuan_original_name);
            intent.putExtra("laporan_kemajuan_extension", laporan_kemajuan_extension);
            intent.putExtra("laporan_kemajuan_tipe", laporan_kemajuan_tipe);
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