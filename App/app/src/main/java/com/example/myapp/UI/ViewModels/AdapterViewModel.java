package com.example.myapp.UI.ViewModels;

import com.example.myapp.data.Repository.ClickedDrinkRepository;

public class AdapterViewModel {

    private String name;
    private String price;
    private int image;
    private ClickedDrinkRepository repo;



    public void setBundle(String title,String price,int image,int pricetag){
       repo = ClickedDrinkRepository.getGetInstance();
       repo.setArray(price,title,image,pricetag);
    }

    public void setBundle1(String title,String price,int image,int pricetag,String clubId){
        repo = ClickedDrinkRepository.getGetInstance();
        repo.setArray1(price,title,image,pricetag,clubId);
    }

}
