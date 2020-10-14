package com.tgsbesar.myapplication.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Insert
    void insert(User user);

    @Query("SELECT * FROM user where noRM=(:noRM) and password=(:password)")
    User login(String noRM, String password);

    @Query("UPDATE user SET full_name=:fullname, umur=:umur, jeniskelamin=:jeniskelamin, nohp=:nohp, alamat=:alamat where noRM=(:noRM)")
    void update(String noRM, String fullname, String umur, int jeniskelamin, String nohp, String alamat);

    @Query("SELECT * FROM user where noRM=(:noRM)")
    User search(String noRM);
}
