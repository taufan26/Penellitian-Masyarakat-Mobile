package app.ppip.penelitian_mobile.activities;

import androidx.annotation.NonNull;

import java.util.List;

import app.ppip.penelitian_mobile.api.ApiClient;
import app.ppip.penelitian_mobile.api.ApiInterface;
import app.ppip.penelitian_mobile.interfaces.LogbookPenelitianView;
import app.ppip.penelitian_mobile.interfaces.PenelitianView;
import app.ppip.penelitian_mobile.model.logbookPenelitian.LogbookPenelitianItem;
import app.ppip.penelitian_mobile.model.usulanPenelitian.UsulanPenelitianItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogbookPenelitianPresenter {

    private LogbookPenelitianView view;

    public LogbookPenelitianPresenter(LogbookPenelitianView view) {
        this.view = view;
    }

    public void getDataLogbook(String user_id) {
        view.showLoading();

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<LogbookPenelitianItem>> call = apiInterface.LOGBOOK_PENELITAN_CALL(user_id);
        call.enqueue(new Callback<List<LogbookPenelitianItem>>() {
            @Override
            public void onResponse(@NonNull Call<List<LogbookPenelitianItem>> call, @NonNull Response<List<LogbookPenelitianItem>> response) {
                view.hideLoading();
                if (response.isSuccessful() && response.body() !=null){
                    view.onGetResult(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<LogbookPenelitianItem>> call, @NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }
}
