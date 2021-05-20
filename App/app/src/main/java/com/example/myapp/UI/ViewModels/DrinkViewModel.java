package com.example.myapp.UI.ViewModels;




import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapp.data.Drinks.Drink;
import com.example.myapp.data.Repository.DrinkRepository;


import java.util.List;


public class DrinkViewModel extends ViewModel {
    private MutableLiveData<List<Drink>> drinks;
    private DrinkRepository repository;


    public DrinkViewModel(){

    }



    public MutableLiveData<List<Drink>> getData(){
        repository = DrinkRepository.getGetInstance();
        return repository.fetchData();
    }
}


    /*public DrinkViewModel(@NonNull Application application) {
        super(application);
        repository= DrinkRepository.getGetInstance(application);

    }*/

   /* public LiveData<List<FavoriteDrinks>> getDrinks(){
        return repository.getAllDrinks();
    }*/










