package com.example.lesson5android3sasha.data.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

@Entity(tableName = "filmModel")
public class FilmModel implements Serializable {

    @NonNull
    @PrimaryKey
    @SerializedName("id")
    @Expose
    private String id;

    @ColumnInfo(name = "title")
    @SerializedName("title")
    @Expose
    private String title;

    @ColumnInfo(name = "original_title")
    @SerializedName("original_title")
    @Expose
    private String originalTitle;

    @ColumnInfo(name = "original_title_romanised")
    @SerializedName("original_title_romanised")
    @Expose
    private String originalTitleRomanised;

    @ColumnInfo(name = "description")
    @SerializedName("description")
    @Expose
    private String description;

    @ColumnInfo(name = "director")
    @SerializedName("director")
    @Expose
    private String director;

    @ColumnInfo(name = "producer")
    @SerializedName("producer")
    @Expose
    private String producer;

    @ColumnInfo(name = "release_date")
    @SerializedName("release_date")
    @Expose
    private String releaseDate;

    @ColumnInfo(name = "running_time")
    @SerializedName("running_time")
    @Expose
    private String runningTime;

    @ColumnInfo(name = "rt_score")
    @SerializedName("rt_score")
    @Expose
    private String rtScore;

    @Ignore
    @SerializedName("people")
    @Expose
    private List<String> people = null;

    @Ignore
    @SerializedName("species")
    @Expose
    private List<String> species = null;

    @Ignore
    @SerializedName("locations")
    @Expose
    private List<String> locations = null;

    @Ignore
    @SerializedName("vehicles")
    @Expose
    private List<String> vehicles = null;

    @ColumnInfo(name = "url")
    @SerializedName("url")
    @Expose
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOriginalTitleRomanised() {
        return originalTitleRomanised;
    }

    public void setOriginalTitleRomanised(String originalTitleRomanised) {
        this.originalTitleRomanised = originalTitleRomanised;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(String runningTime) {
        this.runningTime = runningTime;
    }

    public String getRtScore() {
        return rtScore;
    }

    public void setRtScore(String rtScore) {
        this.rtScore = rtScore;
    }

    public List<String> getPeople() {
        return people;
    }

    public void setPeople(List<String> people) {
        this.people = people;
    }

    public List<String> getSpecies() {
        return species;
    }

    public void setSpecies(List<String> species) {
        this.species = species;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public List<String> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<String> vehicles) {
        this.vehicles = vehicles;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
