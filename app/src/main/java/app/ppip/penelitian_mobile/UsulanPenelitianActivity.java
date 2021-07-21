package app.ppip.penelitian_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import app.ppip.penelitian_mobile.model.usulanPenelitian.UsulanPenelitianItem;

public class UsulanPenelitianActivity extends AppCompatActivity implements PenelitianView {

    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefresh;
    PenelitianPresenter presenter;
    UsulanPenelitianAdapter adapter;
    UsulanPenelitianAdapter.ItemClickListener itemClickListener;
    SessionManager sessionManger;
    String  user_id;

    List<UsulanPenelitianItem> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usulan_penelitain);


        sessionManger = new SessionManager(UsulanPenelitianActivity.this);
        user_id  = sessionManger.getUserDetail().get(SessionManager.USER_ID);

        swipeRefresh = findViewById(R.id.swipe_penelitian);
        recyclerView = findViewById(R.id.list_usulan);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        presenter = new PenelitianPresenter(this);
        presenter.getData(user_id);

        swipeRefresh.setOnRefreshListener(
                () -> presenter.getData(user_id)
        );

        itemClickListener = (((view, position) -> {
            String judul = data.get(position).getUsulanPenelitianJudul();
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
    public void onGetResult(List<UsulanPenelitianItem> datas) {
        adapter = new UsulanPenelitianAdapter(this, datas, itemClickListener);
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