package com.jolly.creations.pirateace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";


    EditText name;

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        name= findViewById(R.id.name);

    }

    public void play(View view) {

        SharedPreferences.Editor editor = sharedpreferences.edit();

        if(name.getText().toString().equals(""))
        {
            editor.putString(Name, "pirate");
        }else
        {
            editor.putString(Name, name.getText().toString());
        }

        editor.commit();

        startActivity(new Intent(MainActivity.this,level1.class));

    }
}
