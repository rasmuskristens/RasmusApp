package com.example.myapp.data.Repository;

import android.app.Application;
import android.content.Intent;
import android.view.View;

import androidx.lifecycle.LiveData;

import com.example.myapp.R;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginRepository {
    private final LiveDataLogin currentUser;
    private final Application app;
    private static LoginRepository instance;

    private LoginRepository(Application app) {
        this.app = app;
        currentUser = new LiveDataLogin();
    }

    public static synchronized LoginRepository getInstance(Application app) {
        if(instance == null)
            instance = new LoginRepository(app);
        return instance;
    }

    public LiveData<FirebaseUser> getCurrentUser() {

        return currentUser;
    }



    public void signOut() {
        AuthUI.getInstance()
                .signOut(app.getApplicationContext());
    }
}
