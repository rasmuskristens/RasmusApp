package com.example.myapp.data.Drinks;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;
import com.example.myapp.UI.Fragments.OrderFragment;
import com.example.myapp.UI.ViewModels.AdapterViewModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {


    private List<Drink> items;


    AdapterViewModel viewModel;
    boolean isFav=false;

    View editpop;



    public RecyclerAdapter( List<Drink> drinks) {


        if(drinks.size()!=0) {
            if (drinks.get(0).getPopularity() == 0) {
                isFav = true;
            } else {
                isFav = false;
            }


            if(this.items!=null){
                this.items.clear();
            }

            this.items = drinks;
        }

    }


    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drink_item, null);

        editpop= view.findViewById(R.id.pop);

        if(isFav){
            editpop.setAlpha(0.0f);
        }


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {

        final Drink current = items.get(position);


        if(!isFav){


            holder.clubtag.setText(current.getClubId());


            switch (current.getClubId()){
                case "Chad's Cocktails":
                    holder.clubtag.setTextColor(Color.BLUE);
                    //holder.clubtag.setTyp
                    break;
                case "Café Mojo":

                    holder.clubtag.setTextColor(Color.RED);

                    break;
                case "Club Zenzyg":
                    holder.clubtag.setTextColor(Color.GREEN);
            }

        }



        holder.title.setText(current.getTitle());
        holder.price.setText(current.getPrice());
        holder.image.setImageResource(current.getImage());
        holder.pop.setAlpha((float)current.getPopularity()/10);



    }

    @Override
    public int getItemCount() {
        if(items!=null){
            return items.size();
        }
        return 0;

    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView title, price;
        private ImageView image;
        private TextView pop;
        private TextView clubtag;


        public ViewHolder(final View view) {
            super(view);

            title = view.findViewById(R.id.titles);
            price = view.findViewById(R.id.prices);
            image = view.findViewById(R.id.imageView);
            pop = view.findViewById(R.id.pop);

            clubtag = view.findViewById(R.id.clubtag);
            image.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {

            viewModel =new AdapterViewModel();

            viewModel.setBundle1(items.get(getBindingAdapterPosition()).getTitle(),items.get(getBindingAdapterPosition()).getPrice(),items.get(getBindingAdapterPosition()).getImage(),items.get(getBindingAdapterPosition()).getPricetag(),items.get(getBindingAdapterPosition()).getClubId());


        }


    }
}
