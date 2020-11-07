package com.pratik.moviesapp.models

data class Movie(val results: Array<Results>, val page: String, val total_pages: String, val total_results: String) {
    override fun toString(): String {
        return "ClassPojo [results = $results, page = $page, total_pages = $total_pages, total_results = $total_results]"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Movie

        if (!results.contentEquals(other.results)) return false
        if (page != other.page) return false
        if (total_pages != other.total_pages) return false
        if (total_results != other.total_results) return false

        return true
    }

    override fun hashCode(): Int {
        var result = results.contentHashCode()
        result = 31 * result + page.hashCode()
        result = 31 * result + total_pages.hashCode()
        result = 31 * result + total_results.hashCode()
        return result
    }
}