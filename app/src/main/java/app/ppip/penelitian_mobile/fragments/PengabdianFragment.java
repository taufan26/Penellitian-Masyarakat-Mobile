package app.ppip.penelitian_mobile.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import app.ppip.penelitian_mobile.R;
import app.ppip.penelitian_mobile.activities.LaporanAkhirPengabdianActivity;
import app.ppip.penelitian_mobile.activities.LaporanKemajuanPengabdianActivity;
import app.ppip.penelitian_mobile.adapters.SessionManager;
import app.ppip.penelitian_mobile.activities.LogbookPengabdianActivity;
import app.ppip.penelitian_mobile.activities.UsulanPengabdianActivity;
import app.ppip.penelitian_mobile.model.LaporanKemajuanPengabdian.LaporanKemajuanPengabdian;

public class PengabdianFragment  extends Fragment {


    SessionManager sessionManger;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_pengabdian, container, false);

        sessionManger = new SessionManager(PengabdianFragment.this.getActivity());

        CardView cv_usulan = rootView.findViewById(R.id.menu_usulan_pengabdian);
        CardView cv_logbook = rootView.findViewById(R.id.menu_logbook_pengabdian);
        CardView cv_laporanKemajuan = rootView.findViewById(R.id.menu_lapkem_pengabdian);
        CardView cv_laporanAkhir = rootView.findViewById(R.id.menu_lapak_pengabdian);

        cv_usulan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplicationContext(), UsulanPengabdianActivity.class);
                startActivity(i);
            }
        });

        cv_logbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplicationContext(), LogbookPengabdianActivity.class);
                startActivity(i);
            }
        });

        cv_laporanKemajuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplicationContext(), LaporanKemajuanPengabdianActivity.class);
                startActivity(i);
            }
        });

        cv_laporanAkhir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplicationContext(), LaporanAkhirPengabdianActivity.class);
                startActivity(i);
            }
        });

        return rootView;
    }


}
