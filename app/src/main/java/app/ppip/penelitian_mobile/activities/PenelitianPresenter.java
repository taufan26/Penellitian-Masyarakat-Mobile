package app.ppip.penelitian_mobile.activities;

import androidx.annotation.NonNull;

import java.util.List;

import app.ppip.penelitian_mobile.adapters.SessionManager;
import app.ppip.penelitian_mobile.api.ApiClient;
import app.ppip.penelitian_mobile.api.ApiInterface;
import app.ppip.penelitian_mobile.interfaces.PenelitianView;
import app.ppip.penelitian_mobile.model.feature.FeatureItem;
import app.ppip.penelitian_mobile.model.usulanPenelitian.UsulanPenelitianItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PenelitianPresenter {

    private PenelitianView view;

    public PenelitianPresenter(PenelitianView view) {
        this.view = view;
    }

    public void getData(String user_id) {
        view.showLoading();

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<UsulanPenelitianItem>> call = apiInterface.USULAN_PENELITIAN_CALL(user_id);
        call.enqueue(new Callback<List<UsulanPenelitianItem>>() {
            @Override
            public void onResponse(@NonNull Call<List<UsulanPenelitianItem>> call, @NonNull Response<List<UsulanPenelitianItem>> response) {
                view.hideLoading();
                if (response.isSuccessful() && response.body() !=null){
                    view.onGetResult(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<UsulanPenelitianItem>> call, @NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }

}
