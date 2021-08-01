package app.ppip.penelitian_mobile.activities;

import androidx.annotation.NonNull;

import java.util.List;

import app.ppip.penelitian_mobile.api.ApiClient;
import app.ppip.penelitian_mobile.api.ApiInterface;
import app.ppip.penelitian_mobile.interfaces.LaporanKemajuanPenelitainView;
import app.ppip.penelitian_mobile.interfaces.LaporanKemajuanPengabdianView;
import app.ppip.penelitian_mobile.model.LaporanKemajuanPengabdian.LaporanKemajuanPengabdianItem;
import app.ppip.penelitian_mobile.model.laporanKemajuanPenelitian.LaporanKemeajuanPenelitianItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LaporanKemajuanPengabdianPresenter {

    private LaporanKemajuanPengabdianView view;

    public LaporanKemajuanPengabdianPresenter(LaporanKemajuanPengabdianView view) {
        this.view = view;
    }

    public void getDataLaporanKemajuan(String user_id) {
        view.showLoading();

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<LaporanKemajuanPengabdianItem>> call = apiInterface.LAPORAN_KEMAJUAN_PENGABDIAN_CALL(user_id);
        call.enqueue(new Callback<List<LaporanKemajuanPengabdianItem>>() {
            @Override
            public void onResponse(@NonNull Call<List<LaporanKemajuanPengabdianItem>> call, @NonNull Response<List<LaporanKemajuanPengabdianItem>> response) {
                view.hideLoading();
                if (response.isSuccessful() && response.body() !=null){
                    view.onGetResult(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<LaporanKemajuanPengabdianItem>> call, @NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }
}
