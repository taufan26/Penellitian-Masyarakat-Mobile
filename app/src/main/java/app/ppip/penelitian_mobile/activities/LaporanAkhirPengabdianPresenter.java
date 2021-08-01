package app.ppip.penelitian_mobile.activities;

import androidx.annotation.NonNull;

import java.util.List;

import app.ppip.penelitian_mobile.api.ApiClient;
import app.ppip.penelitian_mobile.api.ApiInterface;
import app.ppip.penelitian_mobile.interfaces.LaporanAkhirPenelitianView;
import app.ppip.penelitian_mobile.interfaces.LaporanAkhirPengabdianView;
import app.ppip.penelitian_mobile.model.laporanAkhirPenelitian.LaporanAkhirPenelitianItem;
import app.ppip.penelitian_mobile.model.laporanAkhirPengabdian.LaporanAkhirPengabdianItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LaporanAkhirPengabdianPresenter {

    private LaporanAkhirPengabdianView view;

    public LaporanAkhirPengabdianPresenter(LaporanAkhirPengabdianView view) {
        this.view = view;
    }

    public void getDataLaporanAkhir(String user_id) {
        view.showLoading();

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<LaporanAkhirPengabdianItem>> call = apiInterface.LAPORAN_AKHIR_PENGABDIAN_CALL(user_id);
        call.enqueue(new Callback<List<LaporanAkhirPengabdianItem>>() {
            @Override
            public void onResponse(@NonNull Call<List<LaporanAkhirPengabdianItem>> call, @NonNull Response<List<LaporanAkhirPengabdianItem>> response) {
                view.hideLoading();
                if (response.isSuccessful() && response.body() !=null){
                    view.onGetResult(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<LaporanAkhirPengabdianItem>> call, @NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }
}
