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
import app.ppip.penelitian_mobile.activities.LaporanAkhirPenelitianActivity;
import app.ppip.penelitian_mobile.activities.LaporanKemajuanPenelitianActivity;
import app.ppip.penelitian_mobile.activities.LaporanKemajuanPenelitianDetailActivity;
import app.ppip.penelitian_mobile.adapters.SessionManager;
import app.ppip.penelitian_mobile.activities.LogbookPenelitianActivity;
import app.ppip.penelitian_mobile.activities.UsulanPenelitianActivity;
import app.ppip.penelitian_mobile.api.ApiClient;
import app.ppip.penelitian_mobile.api.ApiInterface;
import app.ppip.penelitian_mobile.model.feature.Feature;
import app.ppip.penelitian_mobile.model.feature.FeatureItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PenelitianFragment extends Fragment {

    SessionManager sessionManger;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_penelitian, container, false);

        sessionManger = new SessionManager(PenelitianFragment.this.getActivity());

        CardView cv_usulan = rootView.findViewById(R.id.menu_usulan_penelitian);
        CardView cv_logbook = rootView.findViewById(R.id.menu_logbook_penelitian);
        CardView cv_laporan_kemajuan = rootView.findViewById(R.id.menu_lapkem_penelitian);
        CardView cv_laporan_akhir = rootView.findViewById(R.id.menu_lapak_penelitian);


        cv_usulan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplicationContext(), UsulanPenelitianActivity.class);
                getfeature();
                startActivity(i);
            }
        });

        cv_logbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplicationContext(), LogbookPenelitianActivity.class);
                startActivity(i);
            }
        });

        cv_laporan_kemajuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplicationContext(), LaporanKemajuanPenelitianActivity.class);
                startActivity(i);
            }
        });

        cv_laporan_akhir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplicationContext(), LaporanAkhirPenelitianActivity.class);
                startActivity(i);
            }
        });

        return rootView;
    }

    public void getfeature() {

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Feature> featurecall = apiInterface.GetFeture();
        featurecall.enqueue(new Callback<Feature>() {
            @Override
            public void onResponse(@NonNull Call<Feature> call, @NonNull Response<Feature> response) {
                if (response.isSuccessful() && response.body() != null) {
                    sessionManger = new SessionManager(PenelitianFragment.this.getActivity());
                    FeatureItem data = response.body().getData();
                    sessionManger.createFeatureSession(data);
                }
            }

            @Override
            public void onFailure(Call<Feature> call, Throwable t) {
                Toast.makeText(PenelitianFragment.this.getActivity(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
