package com.pratik.moviesapp.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable

@Entity(tableName = "movie")
class Results : Parcelable {

    @PrimaryKey(autoGenerate = true)
    var movieId: Long?= 1

    var vote_average: String? = null

    var backdrop_path: String? = null

    var isAdult: Boolean = false

    var id: String? = null

    var title: String? = null

    var overview: String? = null

    var original_language: String? = null

    @Ignore
    var genre_ids: IntArray? = null

    var release_date: String? = null

    var original_title: String? = null

    var vote_count: String? = null

    var poster_path: String? = null

    var video: String? = null

    var popularity: String? = null

    //used by room database to store the entries into the table
    constructor(movieId : Long, vote_average: String, backdrop_path: String, adult: Boolean, id: String, title: String,
                overview: String, original_language: String, release_date: String,
                original_title: String, vote_count: String, poster_path: String, video: String,
                popularity: String) {
        this.movieId = movieId
        this.vote_average = vote_average
        this.backdrop_path = backdrop_path
        this.isAdult = adult
        this.id = id
        this.title = title
        this.overview = overview
        this.original_language = original_language
        this.release_date = release_date
        this.original_title = original_title
        this.vote_count = vote_count
        this.poster_path = poster_path
        this.video = video
        this.popularity = popularity
    }

    protected constructor(`in`: Parcel) {
        vote_average = `in`.readString()
        backdrop_path = `in`.readString()
        isAdult = `in`.readByte().toInt() != 0
        id = `in`.readString()
        title = `in`.readString()
        overview = `in`.readString()
        original_language = `in`.readString()
        genre_ids = `in`.createIntArray()
        release_date = `in`.readString()
        original_title = `in`.readString()
        vote_count = `in`.readString()
        poster_path = `in`.readString()
        video = `in`.readString()
        popularity = `in`.readString()
    }

    override fun toString(): String {
        return "ClassPojo [vote_average = $vote_average, backdrop_path = $backdrop_path, adult = $isAdult, id = $id, title = $title, overview = $overview, original_language = $original_language, genre_ids = $genre_ids, release_date = $release_date, original_title = $original_title, vote_count = $vote_count, poster_path = $poster_path, video = $video, popularity = $popularity]"
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(vote_average)
        parcel.writeString(backdrop_path)
        parcel.writeByte((if (isAdult) 1 else 0).toByte())
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

    companion object {


        @JvmField val CREATOR: Parcelable.Creator<Results> = object : Parcelable.Creator<Results> {
            override fun createFromParcel(`in`: Parcel): Results {
                return Results(`in`)
            }

            override fun newArray(size: Int): Array<Results?> {
                return arrayOfNulls(size)
            }
        }
    }
}
