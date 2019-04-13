package com.pratik.moviesapp.models

import android.os.Parcel
import android.os.Parcelable


class Movie(var results: Array<Results>?, var page: String?, var total_pages: String?,
            val total_results: String) : Parcelable{


    constructor(parcel: Parcel) : this(
            parcel.createTypedArray(Results.CREATOR),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

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

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedArray(results, flags)
        parcel.writeString(page)
        parcel.writeString(total_pages)
        parcel.writeString(total_results)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }

}
