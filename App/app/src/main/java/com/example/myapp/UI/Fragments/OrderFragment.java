package com.example.myapp.UI.Fragments;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapp.R;
import com.example.myapp.UI.ViewModels.OrderViewModel;
import com.example.myapp.data.Drinks.Drink;

import java.io.Serializable;
import java.util.ArrayList;

public class OrderFragment extends Fragment implements Serializable {
    private static final long serialVersionUID = -2163051469151804394L;


    private OrderViewModel viewModel;
    TextView name;
    TextView price;
    ImageView image;
    TextView grandTotal;
    Drink drink1;
    Drink drink2;
    Drink drink3;

    ArrayList<Drink> drinksTO = new ArrayList<>();

    TextView name2;
    TextView price2;

    TextView name3;
    TextView price3;



    int total=0;
    String navn;
    String prisen;
    String navn2;
    String prisen2;
    String navn3;
    String prisen3;
    int billed;
    int billed2;
    int billed3;
    Button enterButton;
    Button deleteButton1;
    Button deleteButton2;
    Button deleteButton3;
    int theCount;

    ProgressDialog dialog;
    TextView errorMessage;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_order, container, false);


        grandTotal = view.findViewById(R.id.total_price);
        name = view.findViewById(R.id.drink_name);
        image = view.findViewById(R.id.app_bar_image);
        price = view.findViewById(R.id.price);
        name2 = view.findViewById(R.id.drink_name2);
        price2=view.findViewById(R.id.price2);
        name3 = view.findViewById(R.id.drink_name3);
        price3=view.findViewById(R.id.price3);




        enterButton= view.findViewById(R.id.sendDrink);
        deleteButton1 = view.findViewById(R.id.delete);
        deleteButton2= view.findViewById(R.id.delete2);
        deleteButton3 = view.findViewById(R.id.delete3);


        viewModel = ViewModelProviders.of(this).get(OrderViewModel.class);
        viewModel.init(getContext());


            viewModel.getClickedItem().observe(getViewLifecycleOwner(), drinkModels -> {


                switch (drinkModels.size()){
                    case 1:

                        theCount=drinkModels.get(0).getPricetag();
                        grandTotal.setText(theCount+"");
                        break;
                    case 2:
                        theCount = (drinkModels.get(0).getPricetag()+drinkModels.get(1).getPricetag());
                        grandTotal.setText(theCount+"");
                        break;
                    case 3:
                        theCount = (drinkModels.get(0).getPricetag()+drinkModels.get(1).getPricetag()+drinkModels.get(2).getPricetag());
                        grandTotal.setText(theCount+"");
                        break;
                }


                if(drinkModels.size()>0) {


                    drink1= drinkModels.get(0);

                    navn = drinkModels.get(0).getTitle();
                    billed = drinkModels.get(0).getImage();
                    prisen = drinkModels.get(0).getPrice();

                    name.setText(navn);
                    image.setImageResource(billed);
                    price.setText(prisen);

                }



                if(drinkModels.size()>1) {

                            drink2=drinkModels.get(1);
                            navn2 = drinkModels.get(1).getTitle();
                            billed2 = drinkModels.get(1).getImage();
                            prisen2 = drinkModels.get(1).getPrice();

                            name2.setText(navn2);
                            image.setImageResource(billed2);
                            price2.setText(prisen2);


                }

                if(drinkModels.size()>2) {
                    drink3=drinkModels.get(2);
                    navn3 = drinkModels.get(2).getTitle();
                    billed3 = drinkModels.get(2).getImage();
                    prisen3 = drinkModels.get(2).getPrice();

                    name3.setText(navn3);
                    image.setImageResource(billed3);
                    price3.setText(prisen3);


                }


            });


            deleteButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Navigation.findNavController(getView()).navigate(R.id.order);
                    viewModel.removeOneItem(drink1);
                   // grandTotal.setText((theCount-drink1.getPricetag())+"");
                }
            });
            deleteButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Navigation.findNavController(getView()).navigate(R.id.order);
                    viewModel.removeOneItem(drink2);
                   // grandTotal.setText((theCount-drink2.getPricetag())+"");
                }
            });
            deleteButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Navigation.findNavController(getView()).navigate(R.id.order);
                    viewModel.removeOneItem(drink3);
                   // grandTotal.setText((theCount-drink3.getPricetag())+"");
                }
            });

        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewModel.clearDrinks();
                grandTotal.setText("");
                name.setText("");
                price.setText("");
                price2.setText("");
                name2.setText("");
                price3.setText("");
                name3.setText("");

                dialog = new ProgressDialog(getActivity());
                dialog.show();
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

                if(drink1==null){


                    dialog.setContentView(R.layout.error);


                }
                else {


                    dialog.setContentView(R.layout.progress);



                    final Handler handler = new Handler(Looper.getMainLooper());
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                           dialog.dismiss();

                        }
                    },2000);



                    try  {

                        viewModel.setDrinkInDB(drink1);
                        viewModel.setDrinkInDB(drink2);
                        viewModel.setDrinkInDB(drink3);




                    }
                    catch(Exception e){

                        Toast.makeText(getContext(),"something is wrong",Toast.LENGTH_SHORT);
                    }
                    Navigation.findNavController(getView()).navigate(R.id.order);



                }


            }
        });






        // Inflate the layout for this fragment
        return view;


    }




}


