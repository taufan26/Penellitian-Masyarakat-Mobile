package app.ppip.penelitian_mobile;

import androidx.annotation.NonNull;

import java.util.List;

import app.ppip.penelitian_mobile.api.ApiClient;
import app.ppip.penelitian_mobile.api.ApiInterface;
import app.ppip.penelitian_mobile.model.usulanPengabdian.DataUsulanPengabdian;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PengabdianPresenter {

    private PengabdianView view;

    public PengabdianPresenter(PengabdianView view) {
        this.view = view;
    }

    void getData(String user_id) {
        view.showLoading();

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<DataUsulanPengabdian>> call = apiInterface.USULAN_PENGABDIAN_CALL(user_id);
        call.enqueue(new Callback<List<DataUsulanPengabdian>>() {
            @Override
            public void onResponse(@NonNull  Call<List<DataUsulanPengabdian>> call, @NonNull Response<List<DataUsulanPengabdian>> response) {
                view.hideLoading();
                if (response.isSuccessful() && response.body() !=null){
                    view.onGetResult(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<DataUsulanPengabdian>> call, @NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }
}
