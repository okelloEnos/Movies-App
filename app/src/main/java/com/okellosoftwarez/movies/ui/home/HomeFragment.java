package com.okellosoftwarez.movies.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.okellosoftwarez.movies.R;
import com.okellosoftwarez.movies.adapter.movieAdapter;
import com.okellosoftwarez.movies.databinding.FragmentHomeBinding;
import com.okellosoftwarez.movies.model.results;
import com.okellosoftwarez.movies.viewModel.movieViewModel;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeFragment extends Fragment {
    private FragmentHomeBinding homeBinding;
    LinearLayoutManager layoutManager;
    movieAdapter movieAdapter;

    @Inject
    movieViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

//        homeViewModel = new ViewModelProvider(this).get(movieViewModel.class);
        homeBinding = FragmentHomeBinding.inflate(inflater, container, false);
//        View root = inflater.inflate(R.layout.fragment_home, container, false);
        View root = homeBinding.getRoot();

        homeBinding.movieRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(requireActivity());
        homeBinding.movieRecyclerView.setLayoutManager(layoutManager);

        homeViewModel.getMovies().observe(getViewLifecycleOwner(), new Observer<ArrayList<results>>() {
            @Override
            public void onChanged(ArrayList<results> results) {
//                homeBinding.textHome.setText("Champion" + results.size());
                Log.d("HomeFrag", "onChanged: " + results.toString());
                movieAdapter = new movieAdapter(requireContext(), results);
                homeBinding.movieRecyclerView.setAdapter(movieAdapter);

            }
        });
        return root;
    }
}