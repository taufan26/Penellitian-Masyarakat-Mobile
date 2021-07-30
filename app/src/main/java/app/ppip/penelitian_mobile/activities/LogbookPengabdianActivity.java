package app.ppip.penelitian_mobile.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
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

    private static final int INTENT_LOGBOOK_EDIT_PENGABDIAN = 100;
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefresh;
    LogbookPengabdianPresenter presenter;
    LogbookPengabdianAdapter adapter;
    LogbookPengabdianAdapter.ItemClickListener itemClickListener;
    SessionManager sessionManager;
    String user_id;
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
            String judul = data.get(position).getUsulanPengabdianJudul();
            String logbook_id = data.get(position).getLogbookId();
            String tanggal = data.get(position).getLogbookDate();
            String kegiatan = data.get(position).getLogbookUraianKegiatan();
            String presentase = data.get(position).getLogbookPresentase();

            Intent intent = new Intent(this, LogbookDetailPengabdianActivity.class);
            intent.putExtra("judul", judul);
            intent.putExtra("logbook_id", logbook_id);
            intent.putExtra("tanggal", tanggal);
            intent.putExtra("kegiatan", kegiatan);
            intent.putExtra("presentase", presentase);
            startActivityForResult(intent, INTENT_LOGBOOK_EDIT_PENGABDIAN);
        }));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == INTENT_LOGBOOK_EDIT_PENGABDIAN && resultCode == RESULT_OK){
            presenter.getDataLogbook(user_id);
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