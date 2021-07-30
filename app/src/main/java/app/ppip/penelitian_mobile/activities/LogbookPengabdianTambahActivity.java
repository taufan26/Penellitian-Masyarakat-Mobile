package app.ppip.penelitian_mobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import app.ppip.penelitian_mobile.R;
import app.ppip.penelitian_mobile.api.ApiClient;
import app.ppip.penelitian_mobile.api.ApiInterface;
import app.ppip.penelitian_mobile.model.logbookPenelitian.TambahLogbookPenelitian;
import app.ppip.penelitian_mobile.model.logbookPengabdian.TambahLogbookPengabdian;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogbookPengabdianTambahActivity extends AppCompatActivity {

    TextView judul, tambah_btn;
    EditText ed_tanggal, ed_kegiatan, ed_presentase;
    String Judul, usulan_id;
    ProgressDialog progressDialog;
    ApiInterface apiInterface;

    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logbook_pengabdian_tambah);

        judul = findViewById(R.id.logbook_tambah_judul_pegabdian);
        ed_tanggal = findViewById(R.id.logbook_tambah_tanggal_pengabdian);
        ed_kegiatan = findViewById(R.id.logbook_tambah_kegiatan_pengabdian);

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        ed_presentase = findViewById(R.id.logbook_tambah_presentase_pengabdian);
        tambah_btn = findViewById(R.id.logbook_pengabdian_tambah_btn);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("loading....");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        Intent intent = getIntent();
        usulan_id = intent.getStringExtra("id");
        Judul = intent.getStringExtra("judul");

        judul.setText(Judul);

        ed_tanggal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(LogbookPengabdianTambahActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        tambah_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tanggal = ed_tanggal.getText().toString().trim();
                String kegiatan = ed_kegiatan.getText().toString().trim();
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                String create_at = timestamp.toString().trim();
                String update_at = timestamp.toString().trim();
                double presentase_value;
                String presentase= ed_presentase.getText().toString().trim();
                if(!presentase.isEmpty())
                    try
                    {
                        presentase_value= Double.parseDouble(presentase);
                        // it means it is double
                    } catch (Exception e1) {
                        // this means it is not double
                        e1.printStackTrace();
                    }
                tambahLogbook(usulan_id, tanggal, kegiatan, presentase, create_at, update_at);
            }
        });
    }


    private void tambahLogbook(final String usulan_id, final String tanggal,
                               final String kegiatan, final String presentase, final String create_at, final String update_at) {
        progressDialog.show();

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<TambahLogbookPengabdian> call = apiInterface.TAMBAH_LOGBOOK_PENGABDIAN_CALL(usulan_id, tanggal, kegiatan, presentase, create_at, update_at);

        call.enqueue(new Callback<TambahLogbookPengabdian>() {
            @Override
            public void onResponse(Call<TambahLogbookPengabdian> call, Response<TambahLogbookPengabdian> response) {
                progressDialog.dismiss();

                if (response.isSuccessful() && response.body() != null){
                    Boolean status = response.body().getStatus();
                    if (status){
                        Toast.makeText(LogbookPengabdianTambahActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LogbookPengabdianTambahActivity.this, LogbookPengabdianActivity.class);
                        startActivity(intent);
                        finish();
                    }else {
                        Toast.makeText(LogbookPengabdianTambahActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<TambahLogbookPengabdian> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(LogbookPengabdianTambahActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateLabel() {
        String myFormat = "yyyy/MM/dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        ed_tanggal.setText(sdf.format(myCalendar.getTime()));
    }

}