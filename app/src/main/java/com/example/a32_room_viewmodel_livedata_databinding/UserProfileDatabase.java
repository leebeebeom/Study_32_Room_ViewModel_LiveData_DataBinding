package com.example.a32_room_viewmodel_livedata_databinding;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = UserProfile.class, version = 1)
public abstract class UserProfileDatabase extends RoomDatabase {
    public abstract UserProfileDao userProfileDao();
}
