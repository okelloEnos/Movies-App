package com.okellosoftwarez.movies.DI;


import android.util.Log;

import androidx.core.app.ActivityCompat;

import com.okellosoftwarez.movies.remote.movieInterface;
import com.okellosoftwarez.movies.util.constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.ApplicationComponent;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class appModule {

    @Provides
    @Singleton
    public Retrofit provideRetrofit(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build();

        return retrofit;
    }

    @Provides
    @Singleton
    public movieInterface provideMovieInterface(Retrofit retrofit){
        movieInterface movieInterface = retrofit.create(movieInterface.class);
        return movieInterface;
    }
}
