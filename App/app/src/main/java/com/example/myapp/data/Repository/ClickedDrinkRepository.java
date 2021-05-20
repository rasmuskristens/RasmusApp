package com.example.myapp.data.Repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

import com.example.myapp.data.Drinks.Drink;
import com.example.myapp.data.models.DrinkModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ClickedDrinkRepository {

    private static ClickedDrinkRepository instance;

    MutableLiveData<List<Drink>> data = new MutableLiveData<>();
    private int count = 0;
    private Drink drinken1;
    private Drink drinken2;
    private Drink drinken3;

    private ArrayList<Drink> drinks = new ArrayList<>();



    public static ClickedDrinkRepository getGetInstance() {
        if (instance == null) {
            instance = new ClickedDrinkRepository();
        }

        return instance;
    }


    public MutableLiveData<List<Drink>> getOnClickedItem() {
        return data;
    }

    public void deleteOneItem(Drink drink){
        count = count-1;

        drinks.remove(drink);


        data.setValue(drinks);


    }

    public void clearDrinks(){
        count=0;
        drinks.clear();
        data.setValue(new List<Drink>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(@Nullable Object o) {
                return false;
            }

            @NonNull
            @Override
            public Iterator<Drink> iterator() {
                return null;
            }

            @NonNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @NonNull
            @Override
            public <T> T[] toArray(@NonNull T[] a) {
                return null;
            }

            @Override
            public boolean add(Drink drink) {
                return false;
            }

            @Override
            public boolean remove(@Nullable Object o) {
                return false;
            }

            @Override
            public boolean containsAll(@NonNull Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(@NonNull Collection<? extends Drink> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, @NonNull Collection<? extends Drink> c) {
                return false;
            }

            @Override
            public boolean removeAll(@NonNull Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(@NonNull Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Drink get(int index) {
                return null;
            }

            @Override
            public Drink set(int index, Drink element) {
                return null;
            }

            @Override
            public void add(int index, Drink element) {

            }

            @Override
            public Drink remove(int index) {
                return null;
            }

            @Override
            public int indexOf(@Nullable Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(@Nullable Object o) {
                return 0;
            }

            @NonNull
            @Override
            public ListIterator<Drink> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<Drink> listIterator(int index) {
                return null;
            }

            @NonNull
            @Override
            public List<Drink> subList(int fromIndex, int toIndex) {
                return null;
            }
        });

    }

    public void setArray(String price, String title, int img,int pricetag) {

        switch (count){
            case 0:
                drinken1 = new Drink(title,price,img,pricetag);

                drinks.add(drinken1);

                data.setValue(drinks);

                break;
            case 1:

                drinken2 = new Drink(title,price,img,pricetag);

                drinks.add(drinken2);

                data.setValue(drinks);

                break;
            case 2:

                drinken3 = new Drink(title,price,img,pricetag);

                drinks.add(drinken3);

                data.setValue(drinks);
                break;

        }

        count++;

    }


    public void setArray1(String price, String title, int img,int pricetag,String clubId) {

        switch (count){
            case 0:

                drinken1 = new Drink(title,price,img,pricetag,clubId);
                List<Drink> drink1 = new ArrayList<>();

                drink1.add(drinken1);
                data.setValue(drink1);

                break;
            case 1:

                drinken2 = new Drink(title,price,img,pricetag,clubId);
                List<Drink> drink2 = new ArrayList<>();
                drink2.add(drinken1);
                drink2.add(drinken2);
                data.setValue(drink2);

                break;
            case 2:

                drinken3 = new Drink(title,price,img,pricetag,clubId);
                List<Drink> drink3 = new ArrayList<>();
                drink3.add(drinken1);
                drink3.add(drinken2);
                drink3.add(drinken3);
                data.setValue(drink3);
                break;

        }

        count++;


    }

}






