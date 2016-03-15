package com.seeksoul.flughafens;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LondonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_london);
    }

    public void LocationLND(View view) {
        Intent location = new Intent(Intent.ACTION_VIEW);
        location.setData(Uri.parse("geo: 51.470833, -0.460556"));

        if (location.resolveActivity(getPackageManager()) != null) {
            startActivity(location);
        }
    }
}
