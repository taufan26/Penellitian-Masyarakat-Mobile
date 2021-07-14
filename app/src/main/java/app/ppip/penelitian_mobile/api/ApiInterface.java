package app.ppip.penelitian_mobile.api;

import app.ppip.penelitian_mobile.model.biodata.Biodata;
import app.ppip.penelitian_mobile.model.login.Login;
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
}
