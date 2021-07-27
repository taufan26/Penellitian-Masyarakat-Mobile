package app.ppip.penelitian_mobile.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import app.ppip.penelitian_mobile.R;
import app.ppip.penelitian_mobile.activities.UsulanPenelitianActivity;
import app.ppip.penelitian_mobile.adapters.SessionManager;
import app.ppip.penelitian_mobile.activities.LoginActivity;
import app.ppip.penelitian_mobile.activities.ProfileActivity;
import app.ppip.penelitian_mobile.api.ApiClient;
import app.ppip.penelitian_mobile.api.ApiInterface;
import app.ppip.penelitian_mobile.model.biodata.Biodata;
import app.ppip.penelitian_mobile.model.biodata.DataBio;
import app.ppip.penelitian_mobile.model.feature.Feature;
import app.ppip.penelitian_mobile.model.feature.FeatureItem;
import app.ppip.penelitian_mobile.model.keanggotaan.DataAnggota;
import app.ppip.penelitian_mobile.model.keanggotaan.Keanggotaan;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    SessionManager sessionManager;
    ApiInterface apiInterface;
    String  user_id;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        sessionManager = new SessionManager(HomeFragment.this.getActivity());
        if (sessionManager.isLoggedIn() == false){
            moveToLogin();
        }

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        CardView cv_logout = rootView.findViewById(R.id.menu_logout);
        CardView cv_profile = rootView.findViewById(R.id.menu_profile);
        user_id  = sessionManager.getUserDetail().get(SessionManager.USER_ID);
        biodata(user_id);
        anggota(user_id);
        getfeature();

        cv_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManager.logoutSession();
                moveToLogin();
            }
        });

        cv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplicationContext(), ProfileActivity.class);
                startActivity(i);
            }
        });

        return rootView;
    }
    private void moveToLogin() {
        Intent intent = new Intent(HomeFragment.this.getActivity(), LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        getActivity().finish();
    }

    private void anggota(String user_id) {

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Keanggotaan> keanggotaanCall = apiInterface.AnggotaanResponse(user_id);
        keanggotaanCall.enqueue(new Callback<Keanggotaan>() {
            @Override
            public void onResponse(Call<Keanggotaan> call, Response<Keanggotaan> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isStatus()){

                    sessionManager = new SessionManager(HomeFragment.this.getActivity());
                    DataAnggota data = response.body().getDataAnggota();
                    sessionManager.createAnggotaSession(data);

                }else {
                    Toast.makeText(HomeFragment.this.getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Keanggotaan> call, Throwable t) {
                Toast.makeText(HomeFragment.this.getActivity(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void biodata(String user_id) {

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Biodata> biodataCall = apiInterface.biodataResponse(user_id);
        biodataCall.enqueue(new Callback<Biodata>() {
            @Override
            public void onResponse(Call<Biodata> call, Response<Biodata> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isStatus()){

                    sessionManager = new SessionManager(HomeFragment.this.getActivity());
                    DataBio data = response.body().getData();
                    sessionManager.createBiodataList(data);


                }else {

                    Toast.makeText(HomeFragment.this.getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Biodata> call, Throwable t) {
                Toast.makeText(HomeFragment.this.getActivity(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getfeature() {

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Feature> featurecall = apiInterface.GetFeture();
        featurecall.enqueue(new Callback<Feature>() {
            @Override
            public void onResponse(@NonNull Call<Feature> call, @NonNull Response<Feature> response) {
                if (response.isSuccessful() && response.body() != null) {
                    sessionManager = new SessionManager(HomeFragment.this.getActivity());
                    FeatureItem data = response.body().getData();
                    sessionManager.createFeatureSession(data);
                }
            }

            @Override
            public void onFailure(Call<Feature> call, Throwable t) {
                Toast.makeText(HomeFragment.this.getActivity(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
