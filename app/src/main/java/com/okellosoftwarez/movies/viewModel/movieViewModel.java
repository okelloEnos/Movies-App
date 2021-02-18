package com.okellosoftwarez.movies.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.okellosoftwarez.movies.model.results;
import com.okellosoftwarez.movies.repository.movieRepository;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

//@HiltViewModel
public class movieViewModel extends ViewModel {
    private movieRepository mRepository;
    private MutableLiveData<ArrayList<results>> movies = new MutableLiveData<>();


    @Inject
    public movieViewModel(movieRepository mRepository) {
        this.mRepository = mRepository;
    }

    public LiveData<ArrayList<results>> getMovies() {
        movies = mRepository.loadMovies();
        return movies ;
    }
}
