package app.ppip.penelitian_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class PenelitianFragment extends Fragment {

    SessionManager sessionManger;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_penelitian, container, false);

        sessionManger = new SessionManager(PenelitianFragment.this.getActivity());

        CardView cv_usulan = rootView.findViewById(R.id.menu_usulan_penelitian);
        CardView cv_logbook = rootView.findViewById(R.id.menu_logbook_penelitian);

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

        return rootView;
    }
}
