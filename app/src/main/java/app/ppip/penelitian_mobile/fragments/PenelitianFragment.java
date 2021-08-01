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
import app.ppip.penelitian_mobile.activities.LaporanAkhirPenelitianActivity;
import app.ppip.penelitian_mobile.activities.LaporanKemajuanPenelitianActivity;
import app.ppip.penelitian_mobile.activities.LaporanKemajuanPenelitianDetailActivity;
import app.ppip.penelitian_mobile.adapters.SessionManager;
import app.ppip.penelitian_mobile.activities.LogbookPenelitianActivity;
import app.ppip.penelitian_mobile.activities.UsulanPenelitianActivity;

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
}
