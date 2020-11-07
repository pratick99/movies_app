package com.pratik.moviesapp.models

import android.os.Parcel
import android.os.Parcelable

data class Results(
        var vote_average: String? = null,
        var backdrop_path: String? = null,
        var isAdult: Boolean = false,
        var id: String? = null,
        var title: String? = null,
        var overview: String? = null,
        var original_language: String? = null,
        var genre_ids: IntArray?,
        var release_date: String? = null,
        var original_title: String? = null,
        var vote_count: String? = null,
        var poster_path: String? = null,
        var video: String? = null,
        var popularity: String? = null) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readByte() != 0.toByte(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.createIntArray(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun toString(): String {
        return "ClassPojo [vote_average = $vote_average, backdrop_path = $backdrop_path, adult = $isAdult, id = $id, title = $title, overview = $overview, original_language = $original_language, genre_ids = $genre_ids, release_date = $release_date, original_title = $original_title, vote_count = $vote_count, poster_path = $poster_path, video = $video, popularity = $popularity]"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Results

        if (vote_average != other.vote_average) return false
        if (backdrop_path != other.backdrop_path) return false
        if (isAdult != other.isAdult) return false
        if (id != other.id) return false
        if (title != other.title) return false
        if (overview != other.overview) return false
        if (original_language != other.original_language) return false
        if (!genre_ids.contentEquals(other.genre_ids)) return false
        if (release_date != other.release_date) return false
        if (original_title != other.original_title) return false
        if (vote_count != other.vote_count) return false
        if (poster_path != other.poster_path) return false
        if (video != other.video) return false
        if (popularity != other.popularity) return false

        return true
    }

    override fun hashCode(): Int {
        var result = vote_average?.hashCode() ?: 0
        result = 31 * result + (backdrop_path?.hashCode() ?: 0)
        result = 31 * result + isAdult.hashCode()
        result = 31 * result + (id?.hashCode() ?: 0)
        result = 31 * result + (title?.hashCode() ?: 0)
        result = 31 * result + (overview?.hashCode() ?: 0)
        result = 31 * result + (original_language?.hashCode() ?: 0)
        result = 31 * result + genre_ids.contentHashCode()
        result = 31 * result + (release_date?.hashCode() ?: 0)
        result = 31 * result + (original_title?.hashCode() ?: 0)
        result = 31 * result + (vote_count?.hashCode() ?: 0)
        result = 31 * result + (poster_path?.hashCode() ?: 0)
        result = 31 * result + (video?.hashCode() ?: 0)
        result = 31 * result + (popularity?.hashCode() ?: 0)
        return result
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(vote_average)
        parcel.writeString(backdrop_path)
        parcel.writeByte(if (isAdult) 1 else 0)
        parcel.writeString(id)
        parcel.writeString(title)
        parcel.writeString(overview)
        parcel.writeString(original_language)
        parcel.writeIntArray(genre_ids)
        parcel.writeString(release_date)
        parcel.writeString(original_title)
        parcel.writeString(vote_count)
        parcel.writeString(poster_path)
        parcel.writeString(video)
        parcel.writeString(popularity)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Results> {
        override fun createFromParcel(parcel: Parcel): Results {
            return Results(parcel)
        }

        override fun newArray(size: Int): Array<Results?> {
            return arrayOfNulls(size)
        }
    }
}