package com.pratik.moviesapp.models


class Movie(var results: Array<Results>?, var page: String?, var total_pages: String?,
            val total_results: String) {


    override fun toString(): String {
        return "ClassPojo [results = $results, page = $page, total_pages = $total_pages, total_results = $total_results]"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Movie

        if (results != null) {
            if (other.results == null) return false
            if (!results!!.contentEquals(other.results!!)) return false
        } else if (other.results != null) return false
        if (page != other.page) return false
        if (total_pages != other.total_pages) return false
        if (total_results != other.total_results) return false

        return true
    }

    override fun hashCode(): Int {
        var result = results?.contentHashCode() ?: 0
        result = 31 * result + (page?.hashCode() ?: 0)
        result = 31 * result + (total_pages?.hashCode() ?: 0)
        result = 31 * result + total_results.hashCode()
        return result
    }
}
