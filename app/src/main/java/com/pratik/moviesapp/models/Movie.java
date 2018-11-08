package com.pratik.moviesapp.models;


public class Movie {

    private Results[] results;

    private String page;

    private String total_pages;

    private String total_results;

    public Movie(Results[] results, String page, String total_pages, String total_results) {
        this.results = results;
        this.page = page;
        this.total_pages = total_pages;
        this.total_results = total_results;
    }

    public Results[] getResults ()
    {
        return results;
    }

    public String getPage() {
        return page;
    }

    public String getTotal_pages() {
        return total_pages;
    }

    public String getTotal_results() {
        return total_results;
    }

    public void setResults (Results[] results)
    {
        this.results = results;
    }


    public void setPage (String page)
    {
        this.page = page;
    }


    public void setTotal_pages (String total_pages)
    {
        this.total_pages = total_pages;
    }


    @Override
    public String toString()
    {
        return "ClassPojo [results = "+results+", page = "+page+", total_pages = "+total_pages+", total_results = "+total_results+"]";
    }
}
