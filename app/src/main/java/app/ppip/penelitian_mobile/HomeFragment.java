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

public class HomeFragment extends Fragment {
    SessionManager sessionManager;

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
}
