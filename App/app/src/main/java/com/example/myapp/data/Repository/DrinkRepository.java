package com.example.myapp.data.Repository;

import androidx.lifecycle.MutableLiveData;

import com.example.myapp.R;
import com.example.myapp.data.Drinks.Drink;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class DrinkRepository  {// interface

    private static DrinkRepository instance;

    private MutableLiveData<List<Drink>> allDrinks = new MutableLiveData<>();
    private MutableLiveData<List<Drink>> data = new MutableLiveData<>();
    private MutableLiveData<String> clubChange = new MutableLiveData<>();
    private ExecutorService executor;
    private ArrayList<Drink> datas = new ArrayList<>();
    private String club;
    private List<Drink> listen;
    private List<Drink> listen2;
    private List<Drink> listen3;




    public static DrinkRepository getGetInstance(){
        if(instance==null){

            instance = new DrinkRepository();
        }

        return instance;
    }



    public MutableLiveData<String> getClub(){
        return clubChange;
    }

    public void setClub(String clubId){
        clubChange.setValue(clubId);
    }

    public void setData(String clubId){


        switch (clubId){
            case "Chads Cocktails":

                listen = new ArrayList<>();
                listen.add(new Drink("Bloody Mary","48 kr.",R.mipmap.bloody_mary_round,48,clubId));
                listen.add(new Drink("Cosmopolitan","38 kr.",R.mipmap.cosmopolita_round,38,clubId));
                listen.add(new Drink("Daiquiri","45 kr.",R.mipmap.daiq_round,45,clubId));
                listen.add(new Drink("Sex on the Beach","45 kr.",R.mipmap.sex_on_the_beach_round,45,clubId));
                listen.add(new Drink("Mojito","68 kr.",R.mipmap.mojito_round,68,clubId));
                listen.add(new Drink("Sidecar","35 kr.",R.mipmap.side_car_round,35,clubId));


                data.setValue(listen);

                break;
            case "Café Mojo":

                listen2 = new ArrayList<>();

                listen2.add(new Drink("Piña Colada","50 kr.",R.mipmap.pina_round,50,clubId));
                listen2.add(new Drink("Frozen Margharita","70 kr.",R.mipmap.frozen_margarita_round,70,clubId));
                listen2.add(new Drink("Tequila Sunrise","65 kr.",R.mipmap.tequila_sunrise_round,65,clubId));
                listen2.add(new Drink("Manhattan","53 kr.",R.mipmap.manhattan_round,53,clubId));
                listen2.add(new Drink("Bay Breeze","70 kr.",R.mipmap.bay_breeze_round,70,clubId));
                listen2.add(new Drink("Brazilian Buck","45 kr.",R.mipmap.brazilian_buck_round,45,clubId));



                data.setValue(listen2);
                break;
            case "Club Zenzyg":


                listen3= new ArrayList<>();
                listen3.add(new Drink("John Daly","50 kr.",R.mipmap.john_daly_round,50,clubId));
                listen3.add(new Drink("Pot of Gold","67 kr.",R.mipmap.pot_of_gold_round,67,clubId));
                listen3.add(new Drink("Raggae Rum","53 kr.",R.mipmap.raggae_rum_round,53,clubId));
                listen3.add(new Drink("Switchel","75 kr.",R.mipmap.switchel_round,75,clubId));
                listen3.add(new Drink("Pumpkin Buck","45 kr.",R.mipmap.pumpkin_buck_round,45,clubId));
                listen3.add(new Drink("Tart'n'Sand","50 kr.",R.mipmap.tart_round,50,clubId));


                data.setValue(listen3);
                break;

        }

    }
    public MutableLiveData<List<Drink>> fetchData(){

        return data;

    }





}
