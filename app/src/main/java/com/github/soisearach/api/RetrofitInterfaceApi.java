package com.github.soisearach.api;

import com.github.soisearach.AnswerData;
import com.github.soisearach.MyNotification;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Query;

import java.util.List;

public interface RetrofitInterfaceApi {

    @GET("9dd3ef87-bf83-4531-8bb8-131148e62ace")
    Call<List<AnswerData<String>>> getData(@Query("name") String resourceName, @Query("num") int count);
    @PUT("9dd3ef87-bf83-4531-8bb8-131148e62ace")
    Call<List<AnswerData<String>>> putData(@Body MyNotification myNotification);
}
