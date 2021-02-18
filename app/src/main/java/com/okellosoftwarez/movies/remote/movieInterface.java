package com.okellosoftwarez.movies.remote;


import com.okellosoftwarez.movies.model.movie;
import com.okellosoftwarez.movies.util.constants;
import com.squareup.picasso.BuildConfig;

import retrofit2.Call;
import retrofit2.http.GET;

public interface movieInterface {

    @GET("popular?api_key=" + constants.MOVIE_API_KEY + "&language=en-US&page=1")
    Call<movie> getMoviesPerPage();

}
