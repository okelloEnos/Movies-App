package com.okellosoftwarez.movies.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.okellosoftwarez.movies.model.movie;
import com.okellosoftwarez.movies.model.results;
import com.okellosoftwarez.movies.remote.movieInterface;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class movieRepository {
    private movieInterface mInterface;
    private MutableLiveData<ArrayList<results>> movieList = new MutableLiveData<>();

    @Inject
    public movieRepository(movieInterface mInterface) {
        this.mInterface = mInterface;
    }

    public MutableLiveData<ArrayList<results>> loadMovies(){
        Call <movie> movieCall = mInterface.getMoviesPerPage();
        movieCall.enqueue(new Callback<movie>() {
            @Override
            public void onResponse(Call<movie> call, Response<movie> response) {
                if (response != null && response.isSuccessful()){

                    movieList.setValue(response.body().getResultsList());

//                    return movieList;

                }
                else {
                    Log.d("Repository", "onResponse: response not successful");
                }
            }

            @Override
            public void onFailure(Call<movie> call, Throwable t) {
                Log.d("Repository", "onFailure: No movies retrieved");

            }
        });
        return movieList;
    }

//    public MutableLiveData<ArrayList<results>> getMovieList() {
//        if (movieList == null){
//            movieList = new MutableLiveData<>();
//            loadMovies();
//        }
//
//        return movieList;
//    }
}
