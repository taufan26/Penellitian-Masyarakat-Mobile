package app.ppip.penelitian_mobile.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
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

public class LogbookDetailPengabdianActivity extends AppCompatActivity {

    String judul, logbook_id, tanggal, kegiatan, presentase;
    TextView tv_judul;
    EditText ed_tanggal, ed_kegitan, ed_presentase;
    ImageView im_save, im_back, im_delete;
    ProgressDialog progressDialog;
    ApiInterface apiInterface;

    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logbook_detail_pengabdian);

        tv_judul = findViewById(R.id.detail_logbook_judul_pengabdian);
        ed_tanggal = findViewById(R.id.logbook_edit_tanggal_pengabdian);
        ed_kegitan = findViewById(R.id.logbook_edit_kegiatan_pengabdian);
        ed_presentase = findViewById(R.id.logbook_edit_presentase_pengabdian);
        im_save = findViewById(R.id.logbook_edit_save_pengabdian);
        im_delete = findViewById(R.id.logbook_edit_delete_pengabdian);
        im_back = findViewById(R.id.logbook_edit_back_pengabdian);

        Intent intent = getIntent();
        judul = intent.getStringExtra("judul");
        logbook_id = intent.getStringExtra("logbook_id");
        tanggal = intent.getStringExtra("tanggal");
        kegiatan = intent.getStringExtra("kegiatan");
        presentase = intent.getStringExtra("presentase");

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("loading....");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

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

        ed_tanggal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(LogbookDetailPengabdianActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        setDataFromIntentExtra();

        im_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tanggal = ed_tanggal.getText().toString().trim();
                String kegiatan = ed_kegitan.getText().toString().trim();
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
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
                updateLogbook(logbook_id, tanggal, kegiatan, presentase, update_at);
            }
        });

        im_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert.setTitle("Konfirmasi !");
                alert.setMessage("Apakah Anda Yakin?");
                alert.setNegativeButton("IYA", (dialog, which) -> {
                    dialog.dismiss();
                    deleteLogbook(logbook_id);
                });
                alert.setPositiveButton("Batal",
                        (dialog, which) -> dialog.dismiss());

                alert.show();
            }
        });

        im_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setDataFromIntentExtra() {
        if (logbook_id != null){
            tv_judul.setText(judul);
            ed_tanggal.setText(tanggal);
            ed_kegitan.setText(kegiatan);
            ed_presentase.setText(presentase);
        }
    }

    private void updateLogbook(final String logbook_id, final String tanggal, final String kegiatan, final String presentase, final String update_at) {
        progressDialog.show();
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<TambahLogbookPengabdian> call = apiInterface.EDIT_LOGBOOK_CALL_PENGABDIAN(logbook_id, tanggal, kegiatan, presentase, update_at);
        call.enqueue(new Callback<TambahLogbookPengabdian>() {
            @Override
            public void onResponse(Call<TambahLogbookPengabdian> call, Response<TambahLogbookPengabdian> response) {
                progressDialog.dismiss();

                if (response.isSuccessful() && response.body() != null){
                    Boolean status = response.body().getStatus();
                    if (status){
                        Toast.makeText(LogbookDetailPengabdianActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        finish();
                    }else {
                        Toast.makeText(LogbookDetailPengabdianActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<TambahLogbookPengabdian> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(LogbookDetailPengabdianActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteLogbook(String logbook_id) {

        progressDialog.show();
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<TambahLogbookPengabdian> call = apiInterface.DELETE_LOGBOOK_PENGABDIAN_CALL(logbook_id);
        call.enqueue(new Callback<TambahLogbookPengabdian>() {
            @Override
            public void onResponse(Call<TambahLogbookPengabdian> call, Response<TambahLogbookPengabdian> response) {
                progressDialog.dismiss();

                if (response.isSuccessful() && response.body() != null){
                    Boolean status = response.body().getStatus();
                    if (status){
                        Toast.makeText(LogbookDetailPengabdianActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        finish();
                    }else {
                        Toast.makeText(LogbookDetailPengabdianActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<TambahLogbookPengabdian> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(LogbookDetailPengabdianActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateLabel() {
        String myFormat = "yyyy/MM/dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        ed_tanggal.setText(sdf.format(myCalendar.getTime()));
    }
}