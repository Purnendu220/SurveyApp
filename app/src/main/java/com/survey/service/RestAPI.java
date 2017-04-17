package com.survey.service;



import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;


/**
 * Project : Mobikasa Retrofit Lib
 * Description :"for managing url calls like GET,POST.",
 * Creating RestAPI Interface to Send HTTP Request using Retrofit and We have to create an interface to handle our requests. So create a new RestAPI interface that will handle all HTTP Request.
 */
public interface RestAPI {

    /*
    * Guideline
    * 1. If Api takes json :-
    * @POST(URL)
      Call<MODEL> signUpNew(@Body MODEL model );
    *
    * 2. If Api takes key pair :-
    * @FormUrlEncoded
      @POST(URL)
      Call<MODEL> logIn(@Field("key") String key1, @Field("key") String key2, @Field("key") String key3);
    *
    * 3. @Multipart
        @POST(URL)
        Call<MODEL> register(@Part("key") String key1, @Part("key") String key2);

    * 4. Get Request
    *   @GET("URL")
        Call<MODEL> getUser(@Path("key") String key);
    *
    * 5. if we need to add Header in api
    * @Headers({
        "Accept: application/vnd.github.v3.full+json",
        "User-Agent: Retrofit-Sample-App"
         })
    *
    * */


    @Headers("Content-Type: text/plain; charset=utf-8")
    @POST(ServiceConstants.SIGN_IN_REQUEST)
    Call<ServiceResponse> loginUser(@Query(ServiceConstants.family_bussiness) String family_bussiness,
                                    @Query(ServiceConstants.family_cast) String family_cast,
                                    @Query(ServiceConstants.time) String time,
                                    @Query(ServiceConstants.education) String education,
                                    @Query(ServiceConstants.house_no) String house_no,
                                    @Query(ServiceConstants.member_count) String member_count,
                                    @Query(ServiceConstants.member_detail) String member_detail,
                                    @Query(ServiceConstants.mobile_no) String mobile_no,
                                    @Query(ServiceConstants.family_no) String family_no,
                                    @Query(ServiceConstants.owner_name) String owner_name,
                                    @Query(ServiceConstants.family_time) String family_time);




}

