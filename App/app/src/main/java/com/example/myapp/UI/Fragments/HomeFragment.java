package com.example.myapp.UI.Fragments;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapp.R;
import com.example.myapp.UI.ViewModels.HomeViewModel;
import com.example.myapp.data.Drinks.Drink;
import com.example.myapp.data.Drinks.RecyclerAdapter;
import com.example.myapp.data.database.DatabaseHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.referencecode.database.models.Post;

import java.util.List;


public class HomeFragment extends Fragment {
TextView placeholder;

    private DatabaseReference databaseReference;
    private DatabaseReference logReference;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    private HomeViewModel viewModel;
    private RecyclerView drinksList;
    private TextView clubId;
    private Animation rotateOpen;
    private Animation rotateClose;
    private Animation fromBottom;
    private Animation toBottom;
    private FloatingActionButton mainFAB;
    private FloatingActionButton deleteFAB;
    private Boolean clicked = false;
    Button buttonDeleteAll;
    Button buttonQuit;
    List<Drink> listen;
    ProgressDialog dialog;
    DatabaseHelper databaseHelper;
    String currentClub;



    private RecyclerAdapter adapter;


    View inflate;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        inflate = inflater.inflate(R.layout.fragment_home, container, false);

        rotateOpen = AnimationUtils.loadAnimation(getContext(),R.anim.rotate_open);
        rotateClose = AnimationUtils.loadAnimation(getContext(),R.anim.rotate_close);
        fromBottom = AnimationUtils.loadAnimation(getContext(),R.anim.from_bottom);
        toBottom = AnimationUtils.loadAnimation(getContext(),R.anim.to_bottom);

        mainFAB = inflate.findViewById(R.id.floatingActionButton);
        deleteFAB = inflate.findViewById(R.id.deleteFAB);

        buttonDeleteAll = inflate.findViewById(R.id.deleteItems);
        buttonQuit = inflate.findViewById(R.id.quit);

        viewModel= ViewModelProviders.of(this).get(HomeViewModel.class);
        viewModel.init(getContext());


        mainFAB.setOnClickListener(v -> clickedFAB());

        deleteFAB.setOnClickListener(v -> {

            viewModel.deleteAllPerClub(currentClub);
            Navigation.findNavController(getView()).navigate(R.id.home);
        });


        drinksList = inflate.findViewById(R.id.recycler_fave);


        drinksList.setHasFixedSize(true);

        drinksList.setLayoutManager(new GridLayoutManager(getActivity(),2));


        viewModel.getCurrentClub().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {

                currentClub = s;

                listen = viewModel.getAllPerClub(currentClub);
                RecyclerAdapter adapter  = new RecyclerAdapter(listen);

                drinksList.setAdapter(adapter);
                drinksList.setItemAnimator(new DefaultItemAnimator());
                }

        });


        return inflate;

    }



    public void clickedFAB(){
        setAnimation(clicked);
        setVisibility(clicked);

        if(!clicked){
            clicked=true;
        }
        else {
            clicked=false;
        }
    }

    private void setVisibility(Boolean clicked) {
        if(!clicked){
            deleteFAB.setVisibility(View.VISIBLE);
        }
        else {

            deleteFAB.setVisibility(View.INVISIBLE);
        }
    }

    private void setAnimation(Boolean clicked){

        if(!clicked){
            deleteFAB.startAnimation(fromBottom);
            mainFAB.startAnimation(rotateOpen);
        }
        else {
            deleteFAB.startAnimation(toBottom);

            mainFAB.startAnimation(rotateClose);
        }
    }


}