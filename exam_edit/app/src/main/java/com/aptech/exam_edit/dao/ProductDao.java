package com.aptech.exam_edit.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.aptech.exam_edit.entity.Product;

import java.util.List;

@Dao
public interface ProductDao {
    @Query("Select * from product limit 100")
    List<Product> getlAll();
    @Insert
    void add(Product c);
    @Update
    void update(Product c);
    @Delete
    void delete(Product c );
    @Query("select * from product where id = :id")
    Product getyId(int id);
}
