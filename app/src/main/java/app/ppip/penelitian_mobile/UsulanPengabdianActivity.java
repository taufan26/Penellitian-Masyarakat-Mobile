package app.ppip.penelitian_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import app.ppip.penelitian_mobile.api.ApiClient;
import app.ppip.penelitian_mobile.api.ApiInterface;
import app.ppip.penelitian_mobile.model.keanggotaan.DataAnggota;
import app.ppip.penelitian_mobile.model.usulanPengabdian.DataUsulanPengabdian;
import app.ppip.penelitian_mobile.model.usulanPengabdian.UsulanPengabdian;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsulanPengabdianActivity extends AppCompatActivity implements MainView {

    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefresh;
    MainPresenter presenter;
    UsulanAdapter adapter;
    UsulanAdapter.ItemClickListener itemClickListener;
    SessionManager sessionManger;
    String  anggota_id;

    List<DataUsulanPengabdian> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usulan_pengabdian);
        sessionManger = new SessionManager(UsulanPengabdianActivity.this);
        anggota_id  = sessionManger.getAnggotaDetail().get(SessionManager.ANGGOTA_ID_ID);

        recyclerView = findViewById(R.id.list_usulanpengabdian);
        swipeRefresh = findViewById(R.id.swipe);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        presenter = new MainPresenter(this);
        presenter.getData(anggota_id);

        swipeRefresh.setOnRefreshListener(
                () -> presenter.getData(anggota_id)
        );

        itemClickListener = (((view, position) -> {
            String judul = data.get(position).getUsulanPengabdianJudul();
            Toast.makeText(this, judul, Toast.LENGTH_SHORT).show();
        }));

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
        adapter = new UsulanAdapter(this, datas, itemClickListener);
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