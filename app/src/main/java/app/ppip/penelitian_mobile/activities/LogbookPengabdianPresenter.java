package app.ppip.penelitian_mobile.activities;

import androidx.annotation.NonNull;

import java.util.List;

import app.ppip.penelitian_mobile.api.ApiClient;
import app.ppip.penelitian_mobile.api.ApiInterface;
import app.ppip.penelitian_mobile.interfaces.LogbookPenelitianView;
import app.ppip.penelitian_mobile.interfaces.LogbookPengabdianView;
import app.ppip.penelitian_mobile.interfaces.PengabdianView;
import app.ppip.penelitian_mobile.model.logbookPenelitian.LogbookPenelitianItem;
import app.ppip.penelitian_mobile.model.logbookPengabdian.LogbookPengabdianItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogbookPengabdianPresenter {

    private LogbookPengabdianView view;

    public LogbookPengabdianPresenter(LogbookPengabdianView view) {
        this.view = view;
    }

    public void getDataLogbook(String user_id) {
        view.showLoading();

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<LogbookPengabdianItem>> call = apiInterface.LOGBOOK_PENGABDIAN_CALL(user_id);
        call.enqueue(new Callback<List<LogbookPengabdianItem>>() {
            @Override
            public void onResponse(@NonNull Call<List<LogbookPengabdianItem>> call, @NonNull Response<List<LogbookPengabdianItem>> response) {
                view.hideLoading();
                if (response.isSuccessful() && response.body() !=null){
                    view.onGetResult(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<LogbookPengabdianItem>> call, @NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }
}
