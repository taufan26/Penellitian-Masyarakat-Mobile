package app.ppip.penelitian_mobile.api;

import java.util.Date;
import java.util.List;

import app.ppip.penelitian_mobile.model.LaporanKemajuanPengabdian.LaporanKemajuanPengabdianItem;
import app.ppip.penelitian_mobile.model.biodata.Biodata;
import app.ppip.penelitian_mobile.model.feature.Feature;
import app.ppip.penelitian_mobile.model.keanggotaan.Keanggotaan;
import app.ppip.penelitian_mobile.model.laporanAkhirPenelitian.LaporanAkhirPenelitianItem;
import app.ppip.penelitian_mobile.model.laporanAkhirPengabdian.LaporanAkhirPengabdianItem;
import app.ppip.penelitian_mobile.model.laporanKemajuanPenelitian.LaporanKemeajuanPenelitianItem;
import app.ppip.penelitian_mobile.model.logbookPenelitian.LogbookPenelitianItem;
import app.ppip.penelitian_mobile.model.logbookPenelitian.TambahLogbookPenelitian;
import app.ppip.penelitian_mobile.model.logbookPengabdian.LogbookPengabdianItem;
import app.ppip.penelitian_mobile.model.logbookPengabdian.TambahLogbookPengabdian;
import app.ppip.penelitian_mobile.model.login.Login;
import app.ppip.penelitian_mobile.model.usulanPenelitian.UsulanPenelitianItem;
import app.ppip.penelitian_mobile.model.usulanPengabdian.DataUsulanPengabdian;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("login.php")
    Call<Login> loginResponse(
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("biodata.php")
    Call<Biodata> biodataResponse(
            @Field("user_id") String user_id
    );

    @FormUrlEncoded
    @POST("keanggotaan.php")
    Call<Keanggotaan> AnggotaanResponse(
            @Field("user_id") String user_id
    );

    @FormUrlEncoded
    @POST("usulanPengabdian.php")
    Call<List<DataUsulanPengabdian>> USULAN_PENGABDIAN_CALL(
            @Field("user_id") String user_id
    );

    @FormUrlEncoded
    @POST("usulanPenelitian.php")
    Call<List<UsulanPenelitianItem>> USULAN_PENELITIAN_CALL(
            @Field("user_id") String user_id
    );

    @GET("periode.php")
    Call<Feature> GetFeture();

    @FormUrlEncoded
    @POST("logbookPenelitian.php")
    Call<List<LogbookPenelitianItem>> LOGBOOK_PENELITAN_CALL(
            @Field("user_id") String user_id
    );

    @FormUrlEncoded
    @POST("logbookPengabdian.php")
    Call<List<LogbookPengabdianItem>> LOGBOOK_PENGABDIAN_CALL(
            @Field("user_id") String user_id
    );

    @FormUrlEncoded
    @POST("tambahLogbookPenelitian.php")
    Call<TambahLogbookPenelitian> TAMBAH_LOGBOOK_CALL(
            @Field("usulan_id") String usulan_id,
            @Field("tanggal") String tanggal,
            @Field("kegiatan") String kegiatan,
            @Field("presentase") String presentase,
            @Field("create_at") String create_at,
            @Field("update_at") String update_at
    );

    @FormUrlEncoded
    @POST("editLogbookPenelitian.php")
    Call<TambahLogbookPenelitian> EDIT_LOGBOOK_CALL(
            @Field("logbook_id") String logbook_id,
            @Field("tanggal") String tanggal,
            @Field("kegiatan") String kegiatan,
            @Field("presentase") String presentase,
            @Field("update_at") String update_at
    );

    @FormUrlEncoded
    @POST("deleteLogbookPenelitian.php")
    Call<TambahLogbookPenelitian> DELETE_LOGBOOK_PENELITIAN_CALL(
            @Field("logbook_id") String logbook_id
    );

    @FormUrlEncoded
    @POST("tambahLogbookPengabdian.php")
    Call<TambahLogbookPengabdian> TAMBAH_LOGBOOK_PENGABDIAN_CALL(
            @Field("usulan_id") String usulan_id,
            @Field("tanggal") String tanggal,
            @Field("kegiatan") String kegiatan,
            @Field("presentase") String presentase,
            @Field("create_at") String create_at,
            @Field("update_at") String update_at
    );

    @FormUrlEncoded
    @POST("editLogbookPengabdian.php")
    Call<TambahLogbookPengabdian> EDIT_LOGBOOK_CALL_PENGABDIAN(
            @Field("logbook_id") String logbook_id,
            @Field("tanggal") String tanggal,
            @Field("kegiatan") String kegiatan,
            @Field("presentase") String presentase,
            @Field("update_at") String update_at
    );

    @FormUrlEncoded
    @POST("deleteLogbookPengabdian.php")
    Call<TambahLogbookPengabdian> DELETE_LOGBOOK_PENGABDIAN_CALL(
            @Field("logbook_id") String logbook_id
    );

    @FormUrlEncoded
    @POST("laporanKemajuanPenelitian.php")
    Call<List<LaporanKemeajuanPenelitianItem>> LAPORAN_KEMAJUAN_PENELITIAN_CALL(
            @Field("user_id") String user_id
    );

    @FormUrlEncoded
    @POST("laporanKemajuanPengabdian.php")
    Call<List<LaporanKemajuanPengabdianItem>> LAPORAN_KEMAJUAN_PENGABDIAN_CALL(
            @Field("user_id") String user_id
    );

    @FormUrlEncoded
    @POST("laporanAkhirPenelitian.php")
    Call<List<LaporanAkhirPenelitianItem>> LAPORAN_AKHIR_PENELITIAN_CALL(
            @Field("user_id") String user_id
    );

    @FormUrlEncoded
    @POST("laporanAkhirPengabdian.php")
    Call<List<LaporanAkhirPengabdianItem>> LAPORAN_AKHIR_PENGABDIAN_CALL(
            @Field("user_id") String user_id
    );
}
