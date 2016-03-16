package com.seeksoul.flughafens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int id;
    Intent goToActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void GoOkecie(View view) {
        id = 1;
        goToActivity = new Intent(MainActivity.this, AirportActivity.class);
        goToActivity.putExtra("id", "" + id);

        Button b = (Button) view;
        String buttonText = b.getText().toString();

        Toast.makeText(MainActivity.this, buttonText, Toast.LENGTH_LONG).show();
        startActivity(goToActivity);
    }

    public void GoFrankfurt(View view) {
        id = 2;
        goToActivity = new Intent(MainActivity.this, AirportActivity.class);
        goToActivity.putExtra("id", "" + id);

        Button b = (Button) view;
        String buttonText = b.getText().toString();

        Toast.makeText(MainActivity.this, buttonText, Toast.LENGTH_LONG).show();
        startActivity(goToActivity);
    }

    public void GoLondon(View view) {
        id = 3;
        goToActivity = new Intent(MainActivity.this, AirportActivity.class);
        goToActivity.putExtra("id", "" + id);

        Button b = (Button) view;
        String buttonText = b.getText().toString();

        Toast.makeText(MainActivity.this, buttonText, Toast.LENGTH_LONG).show();
        startActivity(goToActivity);
    }

    public void GoDC(View view) {
        id = 4;
        goToActivity = new Intent(MainActivity.this, AirportActivity.class);
        goToActivity.putExtra("id", "" + id);

        Button b = (Button) view;
        String buttonText = b.getText().toString();

        Toast.makeText(MainActivity.this, buttonText, Toast.LENGTH_LONG).show();
        startActivity(goToActivity);
    }

    public void GoParis(View view) {
        id = 5;
        goToActivity = new Intent(MainActivity.this, AirportActivity.class);
        goToActivity.putExtra("id", "" + id);

        Button b = (Button) view;
        String buttonText = b.getText().toString();

        Toast.makeText(MainActivity.this, buttonText, Toast.LENGTH_LONG).show();
        startActivity(goToActivity);
    }
}
