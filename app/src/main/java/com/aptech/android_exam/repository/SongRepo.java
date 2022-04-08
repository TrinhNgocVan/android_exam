package com.aptech.android_exam.repository;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.aptech.android_exam.entity.Song;

import java.util.List;

@Dao
public interface SongRepo {
    @Query("Select * from song limit 100")
    List<Song> getlAll();
    @Insert
    void add(Song c);
    @Update
    void update(Song c);
    @Delete
    void delete(Song c );
    @Query("select * from song where songId = :id")
    Song getyId(int id);
}
