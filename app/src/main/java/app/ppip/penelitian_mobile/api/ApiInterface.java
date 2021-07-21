package app.ppip.penelitian_mobile.api;

import java.util.List;

import app.ppip.penelitian_mobile.model.biodata.Biodata;
import app.ppip.penelitian_mobile.model.keanggotaan.Keanggotaan;
import app.ppip.penelitian_mobile.model.login.Login;
import app.ppip.penelitian_mobile.model.usulanPengabdian.DataUsulanPengabdian;
import app.ppip.penelitian_mobile.model.usulanPengabdian.UsulanPengabdian;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
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
}
