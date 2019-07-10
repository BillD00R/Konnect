package com.github.soisearach;

import com.github.soisearach.api.RetrofitInterfaceApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInterface {

    private static RetrofitInterfaceApi retrofitInterface;
    private static Retrofit retrofit;

    public static RetrofitInterfaceApi getApi() {
        if (retrofitInterface == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://webhook.site/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            retrofitInterface = retrofit.create(RetrofitInterfaceApi.class);
        }
        return retrofitInterface;
    }
}
