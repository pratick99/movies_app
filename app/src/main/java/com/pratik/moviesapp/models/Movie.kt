package com.pratik.moviesapp.models


class Movie(var results: Array<Results>?, var page: String?, var total_pages: String?, val total_results: String) {


    override fun toString(): String {
        return "ClassPojo [results = $results, page = $page, total_pages = $total_pages, total_results = $total_results]"
    }
}
