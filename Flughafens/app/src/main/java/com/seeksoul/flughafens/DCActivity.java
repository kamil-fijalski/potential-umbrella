package com.seeksoul.flughafens;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DCActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dc);
    }

    public void LocationDC(View view) {
        Intent location = new Intent(Intent.ACTION_VIEW);
        location.setData(Uri.parse("geo: 38.852222, -77.037778"));

        if (location.resolveActivity(getPackageManager()) != null) {
            startActivity(location);
        }
    }
}
