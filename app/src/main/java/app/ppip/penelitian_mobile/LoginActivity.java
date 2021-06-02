package app.ppip.penelitian_mobile;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import app.ppip.penelitian_mobile.api.ApiClient;
import app.ppip.penelitian_mobile.api.ApiInterface;
import app.ppip.penelitian_mobile.model.login.Data;
import app.ppip.penelitian_mobile.model.login.Login;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private CheckBox ShowPass;
    EditText emailLogin, passwordLogin;
    TextView btnlogin;
    String Email, Password;
    ProgressDialog progressDialog;
    ApiInterface apiInterface;
    SessionManager sessionManger;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // inisialisasi login
        emailLogin = findViewById(R.id.loginemail);
        passwordLogin= findViewById(R.id.loginpass);

        btnlogin = findViewById(R.id.login_btn);
        btnlogin.setOnClickListener(this);

        //viewpass
        ShowPass = findViewById(R.id.showPass);
        ShowPass.setOnClickListener(this);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("loading....");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.login_btn:
                progressDialog.show();
                Email = emailLogin.getText().toString();
                Password = passwordLogin.getText().toString();
                login(Email,Password);
                break;
            case R.id.showPass:
                showpass();
                break;
        }
    }

    private void showpass() {
        if(ShowPass.isChecked()){
            //Saat Checkbox dalam keadaan Checked, maka password akan di tampilkan
            passwordLogin.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }else {
            //Jika tidak, maka password akan di sembuyikan
            passwordLogin.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    private void login(String email, String password) {

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Login> loginCall = apiInterface.loginResponse(email, password);
        loginCall.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isStatus()){
                    progressDialog.dismiss();

                    sessionManger = new SessionManager(LoginActivity.this);
                    Data data = response.body().getData();
                    sessionManger.createLoginSession(data);

                    Toast.makeText(LoginActivity.this, response.body().getData().getUserName(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(LoginActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
