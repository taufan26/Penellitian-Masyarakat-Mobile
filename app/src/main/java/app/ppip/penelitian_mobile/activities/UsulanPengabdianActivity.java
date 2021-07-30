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

import app.ppip.penelitian_mobile.interfaces.PengabdianView;
import app.ppip.penelitian_mobile.R;
import app.ppip.penelitian_mobile.adapters.SessionManager;
import app.ppip.penelitian_mobile.adapters.UsulanPengabdianAdapter;
import app.ppip.penelitian_mobile.model.usulanPengabdian.DataUsulanPengabdian;

public class UsulanPengabdianActivity extends AppCompatActivity implements PengabdianView {

    private static final int INTENT_DETAIL_PENGABDIAN = 100;
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
            String id = data.get(position).getUsulanPengabdianId();
            String reviewer_id = data.get(position).getUsulanPengabdianReviewerId();
            String kategori = data.get(position).getUsulanPengabdianKategori();
            String skema_id = data.get(position).getUsulanPengabdianSkemaId();
            String bidang_id = data.get(position).getUsulanPengabdianBidangId();
            String lama_kegiatan = data.get(position).getUsulanPengabdianLamaKegiatan();
            String tahun = data.get(position).getUsulanPengabdianTahun();
            String submit = data.get(position).getUsulanPengabdianSubmit();
            String status = data.get(position).getUsulanPengabdianStatus();
            String komentar = data.get(position).getUsulanPengabdianKomentar();
            String mahasiswa = data.get(position).getUsulanPengabdianMahasiswaTerlibat();


            Intent intent = new Intent(this, UsulanDetailPengabdianActivity.class);
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
            startActivityForResult(intent, INTENT_DETAIL_PENGABDIAN);
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
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == INTENT_DETAIL_PENGABDIAN && resultCode == RESULT_OK){
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