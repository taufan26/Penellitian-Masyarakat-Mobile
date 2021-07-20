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
                Intent i = new Intent(getActivity().getApplicationContext(), UsulanPengabdianActivity.class);
                startActivity(i);
            }
        });

        return rootView;
    }


}
