package com.example.lesson5android3sasha.data.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FilmService {

    private static FilmService mInstance;
    private static final String BASE_URL = "https://ghibliapi.herokuapp.com/";
    private final Retrofit mRetrofit;

    private FilmService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .addInterceptor(interceptor);

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();
    }

    public static FilmService getInstance() {
        if (mInstance == null) {
            mInstance = new FilmService();
        }
        return mInstance;
    }

    public FilmApi getFilmApi() {
        return mRetrofit.create(FilmApi.class);
    }

}
