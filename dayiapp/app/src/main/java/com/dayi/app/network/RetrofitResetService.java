package com.dayi.app.network;

import com.dayi.app.bean.AppConfigs;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by zhilian-2 on 2016/1/12.
 */
public interface RetrofitResetService {

    @Headers({"Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"})
    @GET("/v3/app_config/android")
    Observable<AppConfigs> getAppConfig(
            @Header("ceshi") String test,
            @Query("token") String token);

//    @GET("group/{id}/users")
//    Call<List<User>> groupList(@Path("id") int groupId);

}
