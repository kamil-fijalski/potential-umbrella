package com.seeksoul.flughafens;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FrankfurtActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frankfurt);
    }

    public void LocationFNM(View view) {
        Intent location = new Intent(Intent.ACTION_VIEW);
        location.setData(Uri.parse("geo: 50.026422, 8.543125"));

        if (location.resolveActivity(getPackageManager()) != null) {
            startActivity(location);
        }
    }
}
