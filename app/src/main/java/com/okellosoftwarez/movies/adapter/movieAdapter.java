package com.okellosoftwarez.movies.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.okellosoftwarez.movies.R;
import com.okellosoftwarez.movies.databinding.MovieRecyclerBinding;
import com.okellosoftwarez.movies.model.results;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.okellosoftwarez.movies.util.constants.BaseUrlImage;

public class movieAdapter extends RecyclerView.Adapter<movieAdapter.movieViewHolder> {
    MovieRecyclerBinding recyclerBinding;
    Context context;
    ArrayList<results> resultsArrayList;

    public movieAdapter(Context context, ArrayList<results> resultsArrayList) {
        this.context = context;
        this.resultsArrayList = resultsArrayList;
    }

    @NonNull
    @Override
    public movieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        recyclerBinding = MovieRecyclerBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
//        return new movieViewHolder(recyclerBinding.getRoot());
        return new movieViewHolder(recyclerBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull movieViewHolder holder, int position) {
        results currentResult = resultsArrayList.get(position);
        holder.bind(currentResult);

//        Picasso.get().load(BaseUrlImage + currentResult.getPoster_path()).placeholder(R.drawable.baseline_movie).into(recyclerBinding.movieImage);
////        holder.movieName.setText(popularResults.getTitle());
//        recyclerBinding.movieName.setText(currentResult.getTitle());

    }

    @Override
    public int getItemCount() {
        if (resultsArrayList != null){
            return resultsArrayList.size();
        }
        return 0;
    }

    public class movieViewHolder extends RecyclerView.ViewHolder{

        MovieRecyclerBinding binding;
        public movieViewHolder(@NonNull MovieRecyclerBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(results currentResult) {
            Picasso.get().load(BaseUrlImage + currentResult.getPoster_path()).placeholder(R.drawable.baseline_movie).into(binding.movieImage);
//        holder.movieName.setText(popularResults.getTitle());
            binding.movieName.setText(currentResult.getTitle());
        }
    }
}
