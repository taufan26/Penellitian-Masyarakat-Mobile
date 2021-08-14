package app.ppip.penelitian_mobile.fragments;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import app.ppip.penelitian_mobile.R;
import app.ppip.penelitian_mobile.activities.InfoAplikasiActivity;
import app.ppip.penelitian_mobile.activities.MainActivity;
import app.ppip.penelitian_mobile.activities.UsulanPenelitianActivity;
import app.ppip.penelitian_mobile.adapters.SessionManager;
import app.ppip.penelitian_mobile.activities.LoginActivity;
import app.ppip.penelitian_mobile.activities.ProfileActivity;
import app.ppip.penelitian_mobile.api.ApiClient;
import app.ppip.penelitian_mobile.api.ApiInterface;
import app.ppip.penelitian_mobile.model.counting.Counting;
import app.ppip.penelitian_mobile.model.counting.DataCounting;
import app.ppip.penelitian_mobile.model.feature.Feature;
import app.ppip.penelitian_mobile.model.feature.FeatureItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    SessionManager sessionManager;
    ApiInterface apiInterface;
    String  user_id, count_penelitian, count_pengabdian, count_riwayat_penelitian, count_riwayat_pengabdian;
    ProgressDialog progressDialog;
    TextView tv_penelitian, tv_pengabdian, tv_riwayat_penelitian, tv_riwayat_pengabdian;
    private static final String TAG = "PushNotification";
    private static final String CHANNEL_ID = "101";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        sessionManager = new SessionManager(HomeFragment.this.getActivity());
        if (!sessionManager.isLoggedIn()){
            moveToLogin();
        }

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        ImageView cv_logout = rootView.findViewById(R.id.logout);
        CardView cv_profile = rootView.findViewById(R.id.menu_profile);
        CardView cv_info = rootView.findViewById(R.id.menu_info);
        tv_penelitian = rootView.findViewById(R.id.menu_count_penelitian);
        tv_pengabdian = rootView.findViewById(R.id.menu_count_pengabdian);
        tv_riwayat_penelitian = rootView.findViewById(R.id.menu_count_riwayat_penelitian);
        tv_riwayat_pengabdian = rootView.findViewById(R.id.menu_count_riwayat_pengabdian);

        progressDialog = new ProgressDialog(this.getActivity());
        progressDialog.setMessage("loading....");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        AlertDialog.Builder alert = new AlertDialog.Builder(this.getActivity());

        user_id  = sessionManager.getUserDetail().get(SessionManager.USER_ID);
        count_penelitian = sessionManager.getCountingDetail().get(SessionManager.COUNTING_PENELITIAN);
        count_pengabdian = sessionManager.getCountingDetail().get(SessionManager.COUNTING_PENGABDIAN);
        count_riwayat_penelitian = sessionManager.getCountingDetail().get(SessionManager.COUNTING_RIWAYAT_PENELITIAN);
        count_riwayat_pengabdian = sessionManager.getCountingDetail().get(SessionManager.COUNTING_RIWAYAT_PENGABDIAN);

        tv_penelitian.setText(count_penelitian);
        tv_pengabdian.setText(count_pengabdian);
        tv_riwayat_penelitian.setText(count_riwayat_penelitian);
        tv_riwayat_pengabdian.setText(count_riwayat_pengabdian);


        cv_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert.setTitle("Konfirmasi !");
                alert.setMessage("Apakah Anda Yakin Ingin Logout?");
                alert.setPositiveButton("IYA", (dialog, which) -> {
                    dialog.dismiss();
                    sessionManager.logoutSession();
                    moveToLogin();
                });
                alert.setNegativeButton("Batal",
                        (dialog, which) -> dialog.dismiss());

                alert.show();
            }
        });

        cv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplicationContext(), ProfileActivity.class);
                startActivity(i);
            }
        });

        cv_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplicationContext(), InfoAplikasiActivity.class);
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

//    private void getCounting() {
//        progressDialog.show();
//        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
//        Call<Counting> countingCall = apiInterface.GetCounting();
//        countingCall.enqueue(new Callback<Counting>() {
//            @Override
//            public void onResponse(@NonNull Call<Counting> call, @NonNull Response<Counting> response) {
//                progressDialog.dismiss();
//                if (response.isSuccessful() && response.body() != null) {
//                    sessionManager = new SessionManager(HomeFragment.this.getActivity());
//                    DataCounting data = response.body().getDataCounting();
//                    sessionManager.createCounting(data);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Counting> call, Throwable t) {
//                progressDialog.dismiss();
//                Toast.makeText(HomeFragment.this.getActivity(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

}
