package app.ppip.penelitian_mobile;

import android.app.ProgressDialog;
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

import app.ppip.penelitian_mobile.api.ApiClient;
import app.ppip.penelitian_mobile.api.ApiInterface;
import app.ppip.penelitian_mobile.model.keanggotaan.DataAnggota;
import app.ppip.penelitian_mobile.model.keanggotaan.Keanggotaan;
import app.ppip.penelitian_mobile.model.usulanPengabdian.DataUsulanPengabdian;
import app.ppip.penelitian_mobile.model.usulanPengabdian.UsulanPengabdian;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PengabdianFragment  extends Fragment {

    ApiInterface apiInterface;
    ProgressDialog progressDialog;
    SessionManager sessionManger;
    String  anggota_id;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_pengabdian, container, false);

        sessionManger = new SessionManager(PengabdianFragment.this.getActivity());

        CardView cv_usulan = rootView.findViewById(R.id.menu_usulan_pengabdian);
        progressDialog = new ProgressDialog(this.getActivity());
        progressDialog.setMessage("loading....");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        cv_usulan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                anggota_id  = sessionManger.getAnggotaDetail().get(SessionManager.ANGGOTA_ID_ID);
                usulanPengabdian(anggota_id);
            }
        });

        return rootView;
    }

    private void usulanPengabdian(String anggota_id) {

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<UsulanPengabdian> usulanPengabdianCall = apiInterface.USULAN_PENGABDIAN_CALL(anggota_id);
        usulanPengabdianCall.enqueue(new Callback<UsulanPengabdian>() {
            @Override
            public void onResponse(Call<UsulanPengabdian> call, Response<UsulanPengabdian> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isStatus()){
                    progressDialog.dismiss();

                    sessionManger = new SessionManager(PengabdianFragment.this.getActivity());
                    DataUsulanPengabdian data = response.body().getData();
                    sessionManger.createUsulanPengabdianSession(data);

                    Toast.makeText(PengabdianFragment.this.getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(PengabdianFragment.this.getActivity(), UsulanPengabdianActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }else {
                    progressDialog.dismiss();
                    Toast.makeText(PengabdianFragment.this.getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UsulanPengabdian> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(PengabdianFragment.this.getActivity(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
