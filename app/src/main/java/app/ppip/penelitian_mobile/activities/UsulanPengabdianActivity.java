package app.ppip.penelitian_mobile.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import app.ppip.penelitian_mobile.interfaces.PengabdianView;
import app.ppip.penelitian_mobile.R;
import app.ppip.penelitian_mobile.adapters.SessionManager;
import app.ppip.penelitian_mobile.adapters.UsulanPengabdianAdapter;
import app.ppip.penelitian_mobile.model.usulanPengabdian.DataUsulanPengabdian;

public class UsulanPengabdianActivity extends AppCompatActivity implements PengabdianView {

    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefresh;
    PengabdianPresenter presenter;
    UsulanPengabdianAdapter adapter;
    UsulanPengabdianAdapter.ItemClickListener itemClickListener;
    SessionManager sessionManger;
    String  user_id, Tahun, Mulai, Selesai, TahunAkhir;
    TextView tahun, mulai, selesai, akhir;

    List<DataUsulanPengabdian> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usulan_pengabdian);
        sessionManger = new SessionManager(UsulanPengabdianActivity.this);
        user_id  = sessionManger.getUserDetail().get(SessionManager.USER_ID);

        recyclerView = findViewById(R.id.list_usulanpengabdian);
        swipeRefresh = findViewById(R.id.swipe);
        tahun = findViewById(R.id.periode_pengabdian);
        akhir = findViewById(R.id.periode_akhir_pengabdian);
        mulai = findViewById(R.id.mulai_pengabdian);
        selesai = findViewById(R.id.selesai_pengabdian);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        presenter = new PengabdianPresenter(this);
        presenter.getData(user_id);

        swipeRefresh.setOnRefreshListener(
                () -> presenter.getData(user_id)
        );

        itemClickListener = (((view, position) -> {
            String judul = data.get(position).getUsulanPengabdianJudul();
            Toast.makeText(this, judul, Toast.LENGTH_SHORT).show();
        }));

        Tahun = sessionManger.getFeatureDetail().get(SessionManager.UNLOCK_FEATURE_START_YEAR);
        TahunAkhir = sessionManger.getFeatureDetail().get(SessionManager.UNLOCK_FEATURE_END_YEAR);
        Mulai = sessionManger.getFeatureDetail().get(SessionManager.UNLOCK_FEATURE_START_TIME);
        Selesai = sessionManger.getFeatureDetail().get(SessionManager.UNLOCK_FEATURE_END_TIME);
        tahun.setText(Tahun);
        mulai.setText(Mulai);
        selesai.setText(Selesai);
        akhir.setText(TahunAkhir);

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
    public void onGetResult(List<DataUsulanPengabdian> datas) {
        adapter = new UsulanPengabdianAdapter(this, datas, itemClickListener);
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