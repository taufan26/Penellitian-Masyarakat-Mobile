package app.ppip.penelitian_mobile.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import app.ppip.penelitian_mobile.R;
import app.ppip.penelitian_mobile.adapters.LogbookPenelitianAdapter;
import app.ppip.penelitian_mobile.adapters.LogbookPengabdianAdapter;
import app.ppip.penelitian_mobile.adapters.SessionManager;
import app.ppip.penelitian_mobile.interfaces.LogbookPengabdianView;
import app.ppip.penelitian_mobile.model.logbookPenelitian.LogbookPenelitianItem;
import app.ppip.penelitian_mobile.model.logbookPengabdian.LogbookPengabdianItem;

public class LogbookPengabdianActivity extends AppCompatActivity implements LogbookPengabdianView {

    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefresh;
    LogbookPengabdianPresenter presenter;
    LogbookPengabdianAdapter adapter;
    LogbookPengabdianAdapter.ItemClickListener itemClickListener;
    SessionManager sessionManager;
    String user_id, Tahun, Mulai, Selesai, TahunAkhir;
    TextView tahun, mulai, selesai, akhir;

    List<LogbookPengabdianItem> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logbook_pengabdian);

        sessionManager = new SessionManager(LogbookPengabdianActivity.this);
        user_id = sessionManager.getUserDetail().get(SessionManager.USER_ID);

        swipeRefresh = findViewById(R.id.swipe_logbook_pengabdian);
        recyclerView = findViewById(R.id.list_logbook_pengabdian);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        presenter = new LogbookPengabdianPresenter(this);
        presenter.getDataLogbook(user_id);

        swipeRefresh.setOnRefreshListener(
                () -> presenter.getDataLogbook(user_id)
        );

        itemClickListener = (((view, position) -> {

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
    public void onGetResult(List<LogbookPengabdianItem> datas) {
        adapter = new LogbookPengabdianAdapter(this, datas, itemClickListener);
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