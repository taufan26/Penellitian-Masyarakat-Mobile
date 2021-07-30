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
import app.ppip.penelitian_mobile.adapters.SessionManager;
import app.ppip.penelitian_mobile.adapters.UsulanPenelitianAdapter;
import app.ppip.penelitian_mobile.interfaces.LogbookPenelitianView;
import app.ppip.penelitian_mobile.model.logbookPenelitian.LogbookPenelitianItem;
import app.ppip.penelitian_mobile.model.usulanPenelitian.UsulanPenelitianItem;

public class LogbookPenelitianActivity extends AppCompatActivity implements LogbookPenelitianView {

    private static final int INTENT_LOGBOOK_EDIT = 100;
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefresh;
    LogbookPenelitianPresenter presenter;
    LogbookPenelitianAdapter adapter;
    LogbookPenelitianAdapter.ItemClickListener itemClickListener;
    SessionManager sessionManager;
    String user_id;

    List<LogbookPenelitianItem> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logbook_penelitian);

        sessionManager = new SessionManager(LogbookPenelitianActivity.this);
        user_id = sessionManager.getUserDetail().get(SessionManager.USER_ID);

        swipeRefresh = findViewById(R.id.swipe_logbook_penelitian);
        recyclerView = findViewById(R.id.list_logbook_penelitian);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        presenter = new LogbookPenelitianPresenter(this);
        presenter.getDataLogbook(user_id);


        swipeRefresh.setOnRefreshListener(
                () -> presenter.getDataLogbook(user_id)
        );

        itemClickListener = (((view, position) -> {
            String judul = data.get(position).getUsulanPenelitianJudul();
            String logbook_id = data.get(position).getLogbookId();
            String tanggal = data.get(position).getLogbookDate();
            String kegiatan = data.get(position).getLogbookUraianKegiatan();
            String presentase = data.get(position).getLogbookPresentase();

            Intent intent = new Intent(this, LogbookDetailPenelitianActivity.class);
            intent.putExtra("judul", judul);
            intent.putExtra("logbook_id", logbook_id);
            intent.putExtra("tanggal", tanggal);
            intent.putExtra("kegiatan", kegiatan);
            intent.putExtra("presentase", presentase);
            startActivityForResult(intent, INTENT_LOGBOOK_EDIT);
        }));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == INTENT_LOGBOOK_EDIT && resultCode == RESULT_OK){
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
    public void onGetResult(List<LogbookPenelitianItem> datas) {
        adapter = new LogbookPenelitianAdapter(this, datas, itemClickListener);
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