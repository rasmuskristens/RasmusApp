package com.example.myapp.UI.ViewModels;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapp.data.Drinks.Drink;
import com.example.myapp.data.Repository.DrinkRepository;

import java.util.List;

public class MapViewModel extends AndroidViewModel {
    static DrinkRepository repo;

    public MapViewModel(@NonNull Application application) {
        super(application);
        if(repo==null){
            repo = DrinkRepository.getGetInstance();
        }

    }

    public void setClub(String clubId){

        repo.setData(clubId);

        repo.setClub(clubId);
    }
}
