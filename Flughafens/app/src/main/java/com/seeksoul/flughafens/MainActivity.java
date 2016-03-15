package com.seeksoul.flughafens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

   @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void GoOkecie(View view)
    {
        Intent intent  = new Intent(this, OkecieActivity.class);
        startActivity(intent);
    }

    public void GoFrankfurt(View view)
    {
        Intent intent = new Intent(this, FrankfurtActivity.class);
        startActivity(intent);
    }

    public void GoLondon(View view)
    {
        Intent intent = new Intent(this, LondonActivity.class);
        startActivity(intent);
    }

    public void GoDC(View view)
    {
        Intent intent = new Intent(this, DCActivity.class);
        startActivity(intent);
    }

    public void GoParis(View view)
    {
        Intent intent = new Intent(this, ParisActivity.class);
        startActivity(intent);
    }
}
