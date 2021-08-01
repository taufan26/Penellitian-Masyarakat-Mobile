package app.ppip.penelitian_mobile.activities;

import androidx.annotation.NonNull;

import java.util.List;

import app.ppip.penelitian_mobile.api.ApiClient;
import app.ppip.penelitian_mobile.api.ApiInterface;
import app.ppip.penelitian_mobile.interfaces.LaporanKemajuanPenelitainView;
import app.ppip.penelitian_mobile.interfaces.LogbookPenelitianView;
import app.ppip.penelitian_mobile.model.laporanKemajuanPenelitian.LaporanKemeajuanPenelitianItem;
import app.ppip.penelitian_mobile.model.logbookPenelitian.LogbookPenelitianItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LaporanKemajuanPenelitianPresenter {

    private LaporanKemajuanPenelitainView view;

    public LaporanKemajuanPenelitianPresenter(LaporanKemajuanPenelitainView view) {
        this.view = view;
    }

    public void getDataLaporanKemajuan(String user_id) {
        view.showLoading();

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<LaporanKemeajuanPenelitianItem>> call = apiInterface.LAPORAN_KEMAJUAN_PENELITIAN_CALL(user_id);
        call.enqueue(new Callback<List<LaporanKemeajuanPenelitianItem>>() {
            @Override
            public void onResponse(@NonNull Call<List<LaporanKemeajuanPenelitianItem>> call, @NonNull Response<List<LaporanKemeajuanPenelitianItem>> response) {
                view.hideLoading();
                if (response.isSuccessful() && response.body() !=null){
                    view.onGetResult(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<LaporanKemeajuanPenelitianItem>> call, @NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }
}
