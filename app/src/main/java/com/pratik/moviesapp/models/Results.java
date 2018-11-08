package com.pratik.moviesapp.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

@Entity(tableName = "movie")
public class Results implements Parcelable {

    private String vote_average;

    private String backdrop_path;

    private boolean adult;

    @PrimaryKey
    private String id;

    private String title;

    private String overview;

    private String original_language;

    private int[] genre_ids;

    private String release_date;

    private String original_title;

    private String vote_count;

    private String poster_path;

    private String video;

    private String popularity;

    //used by room database to store the entries into the table
    public Results(String vote_average, String backdrop_path, boolean adult, String id, String title,
                   String overview, String original_language, int[] genre_ids, String release_date,
                   String original_title, String vote_count, String poster_path, String video,
                   String popularity) {
        this.vote_average = vote_average;
        this.backdrop_path = backdrop_path;
        this.adult = adult;
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.original_language = original_language;
        this.genre_ids = genre_ids;
        this.release_date = release_date;
        this.original_title = original_title;
        this.vote_count = vote_count;
        this.poster_path = poster_path;
        this.video = video;
        this.popularity = popularity;
    }

    protected Results(Parcel in) {
        vote_average = in.readString();
        backdrop_path = in.readString();
        adult = in.readByte() != 0;
        id = in.readString();
        title = in.readString();
        overview = in.readString();
        original_language = in.readString();
        genre_ids = in.createIntArray();
        release_date = in.readString();
        original_title = in.readString();
        vote_count = in.readString();
        poster_path = in.readString();
        video = in.readString();
        popularity = in.readString();
    }

    public static final Creator<Results> CREATOR = new Creator<Results>() {
        @Override
        public Results createFromParcel(Parcel in) {
            return new Results(in);
        }

        @Override
        public Results[] newArray(int size) {
            return new Results[size];
        }
    };

    public String getVote_average ()
    {
        return vote_average;
    }

    public void setVote_average (String vote_average)
    {
        this.vote_average = vote_average;
    }

    public String getBackdrop_path ()
    {
        return backdrop_path;
    }

    public void setBackdrop_path (String backdrop_path)
    {
        this.backdrop_path = backdrop_path;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getOverview ()
    {
        return overview;
    }

    public void setOverview (String overview)
    {
        this.overview = overview;
    }

    public String getOriginal_language ()
    {
        return original_language;
    }

    public void setOriginal_language (String original_language)
    {
        this.original_language = original_language;
    }

    public String getRelease_date ()
    {
        return release_date;
    }

    public void setRelease_date (String release_date)
    {
        this.release_date = release_date;
    }

    public String getOriginal_title ()
    {
        return original_title;
    }

    public void setOriginal_title (String original_title)
    {
        this.original_title = original_title;
    }

    public String getVote_count ()
    {
        return vote_count;
    }

    public void setVote_count (String vote_count)
    {
        this.vote_count = vote_count;
    }

    public String getPoster_path ()
    {
        return poster_path;
    }

    public void setPoster_path (String poster_path)
    {
        this.poster_path = poster_path;
    }

    public String getVideo ()
    {
        return video;
    }

    public void setVideo (String video)
    {
        this.video = video;
    }

    public String getPopularity ()
    {
        return popularity;
    }

    public void setPopularity (String popularity)
    {
        this.popularity = popularity;
    }

    public boolean isAdult() {
        return adult;
    }

    public int[] getGenre_ids() {
        return genre_ids;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [vote_average = "+vote_average+", backdrop_path = "+backdrop_path+", adult = "+adult+", id = "+id+", title = "+title+", overview = "+overview+", original_language = "+original_language+", genre_ids = "+genre_ids+", release_date = "+release_date+", original_title = "+original_title+", vote_count = "+vote_count+", poster_path = "+poster_path+", video = "+video+", popularity = "+popularity+"]";
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public void setGenre_ids(int[] genre_ids) {
        this.genre_ids = genre_ids;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(vote_average);
        parcel.writeString(backdrop_path);
        parcel.writeByte((byte) (adult ? 1 : 0));
        parcel.writeString(id);
        parcel.writeString(title);
        parcel.writeString(overview);
        parcel.writeString(original_language);
        parcel.writeIntArray(genre_ids);
        parcel.writeString(release_date);
        parcel.writeString(original_title);
        parcel.writeString(vote_count);
        parcel.writeString(poster_path);
        parcel.writeString(video);
        parcel.writeString(popularity);
    }
}
