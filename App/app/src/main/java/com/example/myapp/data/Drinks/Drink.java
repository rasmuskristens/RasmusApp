package com.example.myapp.data.Drinks;



public class Drink {

    private int pk;
    private String title;
    private String price;
    private int image;
    private int popularity;
    private int pricetag;
    private String clubId;


    @Override
    public String toString() {
        return "Drink{" +
                "pk=" + pk +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", image=" + image +
                ", popularity=" + popularity +
                ", pricetag=" + pricetag +
                ", clubId='" + clubId + '\'' +
                '}';
    }

    public Drink(String title, String price, int image, int pricetag){
        this.title=title;
        this.image=image;
        this.price=price;
        this.pricetag=pricetag;

    }
    public Drink(String title, String price, int image, int pricetag,String clubId){
        this.title=title;
        this.image=image;
        this.price=price;
        this.pricetag=pricetag;
        this.clubId=clubId;
    }


//when made in the db
    public Drink(int id,String title, String price, int image,int rank,int pricetag,String clubId){//when getting data out of the database I need more info than when putting in
        this.pk=id;
        this.title=title;
        this.price = price;
        this.image=image;
        this.popularity=rank;
        this.pricetag = pricetag;
        this.clubId=clubId;
    }

    public String getClubId() {
        return clubId;
    }

    public int getPricetag() {
        return pricetag;
    }

    public int getImage() {
        return image;
    }

    public String getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public int getPopularity() {
        return popularity;
    }

}
