package app.ppip.penelitian_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import app.ppip.penelitian_mobile.api.ApiClient;
import app.ppip.penelitian_mobile.api.ApiInterface;
import app.ppip.penelitian_mobile.model.biodata.Biodata;
import app.ppip.penelitian_mobile.model.biodata.DataBio;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {

    ImageView showFoto;
    TextView Nama, Email;
    SessionManager sessionManger;
    String email, nama, foto;
    Button home, biodata, anggota;
    String  user_id;
    ProgressDialog progressDialog;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        sessionManger = new SessionManager(ProfileActivity.this);

        //inisialisasi
        showFoto = findViewById(R.id.profile_image);
        Nama = findViewById(R.id.profile_name);
        Email = findViewById(R.id.profile_email);
        home = findViewById(R.id.button_home);
        biodata = findViewById(R.id.button_biodata);
        anggota = findViewById(R.id.button_anggota);

        email = sessionManger.getUserDetail().get(SessionManager.USER_EMAIL);
        nama = sessionManger.getUserDetail().get(SessionManager.USER_NAME);
        foto = sessionManger.getUserDetail().get(SessionManager.USER_IMAGE);

        Nama.setText(nama);
        Email.setText(email);
        Picasso.get().load(Urls.image_url+foto).into(showFoto);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("loading....");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        biodata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                user_id  = sessionManger.getUserDetail().get(SessionManager.USER_ID);
                biodata(user_id);
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
                    progressDialog.dismiss();

                    sessionManger = new SessionManager(ProfileActivity.this);
                    DataBio data = response.body().getData();
                    sessionManger.createBiodataList(data);

                    Toast.makeText(ProfileActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ProfileActivity.this, BiodataActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    progressDialog.dismiss();
                    Toast.makeText(ProfileActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Biodata> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(ProfileActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}
