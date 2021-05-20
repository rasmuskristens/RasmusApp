package com.example.myapp.UI.ViewModels;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.myapp.data.Drinks.Drink;
import com.example.myapp.data.Repository.ClickedDrinkRepository;
import com.example.myapp.data.Repository.DatabaseRepository;
import com.example.myapp.data.Repository.DrinkRepository;
import com.example.myapp.data.models.DrinkModel;

import java.util.List;

public class OrderViewModel extends AndroidViewModel {

    private MutableLiveData<List<Drink>> drink;
    private MutableLiveData<Boolean> updating = new MutableLiveData<>();
    private DrinkRepository sendingrepository;
    private ClickedDrinkRepository receivingrepository;
    private DatabaseRepository databaseRepository;


    public OrderViewModel(@NonNull Application application) {
        super(application);


    }

    public void clearDrinks(){
        receivingrepository.clearDrinks();
    }

    public void successMetod(){
        Log.d("dsa","success");
    }

    public void postData(Application app){
        if(drink!=null){
            return;//we have set the drinks list to something already
        }
        //sendingrepository= new DrinkRepository(app);
    }

    public void removeOneItem(Drink drink){
        receivingrepository.deleteOneItem(drink);
    }



    public void addOnClickedItem( DrinkModel drink){
        updating.setValue(true);
    }




    public void reiceiveData(){
        if(drink!=null){
            return;//we have set the drinks list to something already
        }
        receivingrepository= ClickedDrinkRepository.getGetInstance();
    }

    public MutableLiveData<List<Drink>> getClickedItem(){
       return receivingrepository.getOnClickedItem();
    }


    public void init(Context context) {

        reiceiveData();
        database(context);
    }

    private void database(Context context) {
        if(databaseRepository!=null){
            return;//we have set the drinks list to something already
        }
        databaseRepository= DatabaseRepository.getGetInstance(context);
    }

    public void setDrinkInDB(Drink drink1) {
        databaseRepository.setDrinksInDB(drink1);
    }
}
