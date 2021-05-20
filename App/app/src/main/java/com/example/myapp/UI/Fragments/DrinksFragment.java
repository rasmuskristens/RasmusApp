package com.example.myapp.UI.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapp.UI.ViewModels.DrinkViewModel;
import com.example.myapp.R;
import com.example.myapp.data.Drinks.RecyclerAdapter;
import com.example.myapp.UI.Activity.MainActivity;


public class DrinksFragment extends Fragment {


    RecyclerView drinksList;
    Class<MainActivity> activity = MainActivity.class;
    private DrinkViewModel viewModel;
    private RecyclerAdapter adapter;
    private TextView clubId,clickLocation;
    private ImageView arrow1,arrow2,arrow3;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_drinks, container, false);
        clubId = rootView.findViewById(R.id.clubid);
        drinksList = rootView.findViewById(R.id.recycler);
        drinksList.setHasFixedSize(true);
        arrow1 = rootView.findViewById(R.id.arrow1);
        arrow2 = rootView.findViewById(R.id.arrow2);
        arrow3 = rootView.findViewById(R.id.arrow3);
        clickLocation = rootView.findViewById(R.id.click_location);

        arrow1.setRotation((float)90.0);
        arrow2.setRotation((float)135.0);
        arrow3.setRotation((float)170.0);



        drinksList.setLayoutManager(new GridLayoutManager(getActivity(),2));


        viewModel = ViewModelProviders.of(this).get(DrinkViewModel.class);



         viewModel.getData().observe(getViewLifecycleOwner(), drinks -> {

             arrow1.setVisibility(View.INVISIBLE);
             arrow2.setVisibility(View.INVISIBLE);
             arrow3.setVisibility(View.INVISIBLE);
             clickLocation.setVisibility(View.INVISIBLE);


             if(drinks.get(0).getClubId()!=null){

                 clubId.setText(drinks.get(0).getClubId());
             }

             RecyclerAdapter adapter  = new RecyclerAdapter(drinks);

             drinksList.setAdapter(adapter);
             drinksList.setItemAnimator(new DefaultItemAnimator());
         });


        return rootView;

    }






}