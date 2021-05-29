package com.example.praveshaadhaar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new Phone()).commit();
        }
        else{
//            getSupportFragmentManager().beginTransaction().replace(R.id.container, new RatingFragment()).commit();
            startActivity(new Intent(Home.this,Records.class));
        }

    }
}