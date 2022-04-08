package com.aptech.android_exam.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "song")
public class Song {

    @PrimaryKey(autoGenerate = true)
    private int songId ;
    @ColumnInfo(name = "singer")
    private String singer ;
    @ColumnInfo(name = "author")
    private String author ;
    @ColumnInfo(name = "thumbnail")
    private String thumbnail ;
    @ColumnInfo(name = "link")
    private String link ;

    public Song() {
    }

    public Song(String singer, String author, String thumbnail, String link) {
        this.singer = singer;
        this.author = author;
        this.thumbnail = thumbnail;
        this.link = link;
    }

    public Song(int songId, String singer, String author, String thumbnail, String link) {
        this.songId = songId;
        this.singer = singer;
        this.author = author;
        this.thumbnail = thumbnail;
        this.link = link;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
