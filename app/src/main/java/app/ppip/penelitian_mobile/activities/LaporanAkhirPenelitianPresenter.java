package app.ppip.penelitian_mobile.activities;

import androidx.annotation.NonNull;

import java.util.List;

import app.ppip.penelitian_mobile.api.ApiClient;
import app.ppip.penelitian_mobile.api.ApiInterface;
import app.ppip.penelitian_mobile.interfaces.LaporanAkhirPenelitianView;
import app.ppip.penelitian_mobile.interfaces.LaporanKemajuanPenelitainView;
import app.ppip.penelitian_mobile.model.laporanAkhirPenelitian.LaporanAkhirPenelitianItem;
import app.ppip.penelitian_mobile.model.laporanKemajuanPenelitian.LaporanKemeajuanPenelitianItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LaporanAkhirPenelitianPresenter {

    private LaporanAkhirPenelitianView view;

    public LaporanAkhirPenelitianPresenter(LaporanAkhirPenelitianView view) {
        this.view = view;
    }

    public void getDataLaporanAkhir(String user_id) {
        view.showLoading();

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<LaporanAkhirPenelitianItem>> call = apiInterface.LAPORAN_AKHIR_PENELITIAN_CALL(user_id);
        call.enqueue(new Callback<List<LaporanAkhirPenelitianItem>>() {
            @Override
            public void onResponse(@NonNull Call<List<LaporanAkhirPenelitianItem>> call, @NonNull Response<List<LaporanAkhirPenelitianItem>> response) {
                view.hideLoading();
                if (response.isSuccessful() && response.body() !=null){
                    view.onGetResult(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<LaporanAkhirPenelitianItem>> call, @NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }
}
