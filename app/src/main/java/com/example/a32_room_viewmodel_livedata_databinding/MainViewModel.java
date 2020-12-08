package com.example.a32_room_viewmodel_livedata_databinding;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import com.example.a32_room_viewmodel_livedata_databinding.databinding.ActivityMainBinding;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    UserProfileDatabase db;
    UserProfileDao userProfileDao;
    UserProfile userProfile;


    public MainViewModel(@NonNull Application application) {
        super(application);
        db = Room.databaseBuilder(application, UserProfileDatabase.class, "db").build();
        userProfileDao = db.userProfileDao();
    }

    public void insertTask(ActivityMainBinding binding) {
        String name = binding.editName.getText().toString();
        String phone = binding.editPhone.getText().toString();
        String address = binding.editAddress.getText().toString();
        UserProfile userProfile = new UserProfile(name, phone, address);
        new Thread(() -> {
            userProfileDao.insert(userProfile);
        }).start();

    }
    public LiveData<List<UserProfile>> getAll(){
        return userProfileDao.getAll();
    }

}
