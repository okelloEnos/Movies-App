package com.okellosoftwarez.movies.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class movie {

    private int page;
    @SerializedName("results")
    private ArrayList<results> resultsList;
    private int total_pages;
    private int total_results;

    public movie(int page, ArrayList<results> resultsList, int total_pages, int total_results) {

        this.page = page;
        this.resultsList = resultsList;
        this.total_pages = total_pages;
        this.total_results = total_results;
    }

    public int getPage() {
        return page;
    }

    public ArrayList<results> getResultsList() {
        return resultsList;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }
}
