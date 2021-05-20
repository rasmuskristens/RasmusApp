package com.example.myapp.UI.ViewModels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapp.data.Repository.LoginRepository;
import com.google.firebase.auth.FirebaseUser;

public class MainActivityViewModel extends AndroidViewModel {
    private final LoginRepository userRepository;


    public MainActivityViewModel(Application app){
        super(app);
        userRepository = LoginRepository.getInstance(app);

    }




    public LiveData<FirebaseUser> getCurrentUser(){
        return userRepository.getCurrentUser();
    }


    public void signOut() {
        userRepository.signOut();
    }
}
