package com.example.myapp.UI.ViewModels;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapp.data.Drinks.Drink;
import com.example.myapp.data.Repository.DatabaseRepository;
import com.example.myapp.data.Repository.DrinkRepository;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    static DatabaseRepository repo;
    static DrinkRepository repo2;


    public HomeViewModel(@NonNull Application application) {
        super(application);

    }

    public void init(Context context){
        if(repo==null){
            repo = DatabaseRepository.getGetInstance(context);
        }
        if(repo2==null){
            repo2 = DrinkRepository.getGetInstance();
        }
    }


    public MutableLiveData<String> getCurrentClub(){
        return repo2.getClub();
    }

    public void deleteAllPerClub(String currentClub) {
        repo.deleteAllPerClub(currentClub);
    }

    public List<Drink> getAllPerClub(String currentClub){
        return repo.getDrinksPerClub(currentClub);
    }


}
