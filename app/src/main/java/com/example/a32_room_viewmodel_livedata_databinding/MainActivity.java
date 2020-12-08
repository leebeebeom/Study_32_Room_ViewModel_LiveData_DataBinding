package com.example.a32_room_viewmodel_livedata_databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.a32_room_viewmodel_livedata_databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        MainViewModel viewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(MainViewModel.class);

        binding.btnAdd.setOnClickListener(v -> viewModel.insertTask(binding));

        viewModel.getAll().observe(this, userProfiles -> {
            String result = "사용자 정보";
            for (UserProfile userProfile : userProfiles) {
                result += "\n" + userProfile.getName() + ", " + userProfile.getPhone() + ", " + userProfile.getAddress();
                binding.textDb.setText(result);
            }
        });

    }
}