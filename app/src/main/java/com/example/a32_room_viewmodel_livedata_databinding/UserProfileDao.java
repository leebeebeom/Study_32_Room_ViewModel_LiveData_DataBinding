package com.example.a32_room_viewmodel_livedata_databinding;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserProfileDao {
    @Query("SELECT * FROM UserProfile")
    LiveData<List<UserProfile>> getAll();

    @Insert
    void insert(UserProfile userProfile);
    @Update
    void update(UserProfile userProfile);
    @Delete
    void delete(UserProfile userProfile);
}
