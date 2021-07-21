package app.ppip.penelitian_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import app.ppip.penelitian_mobile.model.usulanPengabdian.DataUsulanPengabdian;

public class UsulanPengabdianActivity extends AppCompatActivity implements PengabdianView {

    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefresh;
    PengabdianPresenter presenter;
    UsulanPengabdianAdapter adapter;
    UsulanPengabdianAdapter.ItemClickListener itemClickListener;
    SessionManager sessionManger;
    String  user_id;

    List<DataUsulanPengabdian> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usulan_pengabdian);
        sessionManger = new SessionManager(UsulanPengabdianActivity.this);
        user_id  = sessionManger.getUserDetail().get(SessionManager.USER_ID);

        recyclerView = findViewById(R.id.list_usulanpengabdian);
        swipeRefresh = findViewById(R.id.swipe);
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