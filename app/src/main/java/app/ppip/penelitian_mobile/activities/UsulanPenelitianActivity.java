package app.ppip.penelitian_mobile.activities;

import androidx.annotation.NonNull;
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

import app.ppip.penelitian_mobile.api.ApiClient;
import app.ppip.penelitian_mobile.api.ApiInterface;
import app.ppip.penelitian_mobile.interfaces.PenelitianView;
import app.ppip.penelitian_mobile.R;
import app.ppip.penelitian_mobile.adapters.SessionManager;
import app.ppip.penelitian_mobile.adapters.UsulanPenelitianAdapter;
import app.ppip.penelitian_mobile.model.feature.Feature;
import app.ppip.penelitian_mobile.model.feature.FeatureItem;
import app.ppip.penelitian_mobile.model.usulanPenelitian.UsulanPenelitianItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsulanPenelitianActivity extends AppCompatActivity implements PenelitianView {

    private static final int INTENT_DETAIL = 100;
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefresh;
    PenelitianPresenter presenter;
    UsulanPenelitianAdapter adapter;
    UsulanPenelitianAdapter.ItemClickListener itemClickListener;
    SessionManager sessionManager;
    String user_id, Tahun, Mulai, Selesai, TahunAkhir;
    ApiInterface apiInterface;
    TextView tahun, mulai, selesai, akhir;

    List<UsulanPenelitianItem> data;
    List<FeatureItem> featureItemList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usulan_penelitain);


        sessionManager = new SessionManager(UsulanPenelitianActivity.this);
        user_id = sessionManager.getUserDetail().get(SessionManager.USER_ID);

        swipeRefresh = findViewById(R.id.swipe_penelitian);
        recyclerView = findViewById(R.id.list_usulan);
        tahun = findViewById(R.id.periode_penelitan);
        akhir = findViewById(R.id.periode_akhir_penelitan);
        mulai = findViewById(R.id.mulai_penelitian);
        selesai = findViewById(R.id.selesai_penelitian);
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
            String id = data.get(position).getUsulanPenelitianId();
            String reviewer_id = data.get(position).getUsulanPenelitianReviewerId();
            String kategori = data.get(position).getUsulanPenelitianKategori();
            String skema_id = data.get(position).getUsulanPenelitianSkemaId();
            String bidang_id = data.get(position).getUsulanPenelitianBidangId();
            String lama_kegiatan = data.get(position).getUsulanPenelitianLamaKegiatan();
            String tahun = data.get(position).getUsulanPenelitianTahun();
            String submit = data.get(position).getUsulanPenelitianSubmit();
            String status = data.get(position).getUsulanPenelitianStatus();
            String komentar = data.get(position).getUsulanPenelitianKomentar();
            String mahasiswa = data.get(position).getUsulanPenelitianMahasiswaTerlibat();


            Intent intent = new Intent(this, UsulanDetailActivity.class);
            intent.putExtra("id", id);
            intent.putExtra("judul", judul);
            intent.putExtra("reviewer_id", reviewer_id);
            intent.putExtra("kategori", kategori);
            intent.putExtra("skema_id", skema_id);
            intent.putExtra("bidang_id", bidang_id);
            intent.putExtra("lama_kegiatan", lama_kegiatan);
            intent.putExtra("tahun", tahun);
            intent.putExtra("submit", submit);
            intent.putExtra("status", status);
            intent.putExtra("komentar", komentar);
            intent.putExtra("mahasiswa", mahasiswa);
            startActivityForResult(intent, INTENT_DETAIL);

        }));


        Tahun = sessionManager.getFeatureDetail().get(SessionManager.UNLOCK_FEATURE_START_YEAR);
        TahunAkhir = sessionManager.getFeatureDetail().get(SessionManager.UNLOCK_FEATURE_END_YEAR);
        Mulai = sessionManager.getFeatureDetail().get(SessionManager.UNLOCK_FEATURE_START_TIME);
        Selesai = sessionManager.getFeatureDetail().get(SessionManager.UNLOCK_FEATURE_END_TIME);
        tahun.setText(Tahun);
        mulai.setText(Mulai);
        selesai.setText(Selesai);
        akhir.setText(TahunAkhir);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == INTENT_DETAIL && resultCode == RESULT_OK) {
            presenter.getData(user_id);
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