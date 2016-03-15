package com.seeksoul.flughafens;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class OkecieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okecie);
    }

    public void LocationOKE(View view) {
        Intent location = new Intent(Intent.ACTION_VIEW);
        location.setData(Uri.parse("geo: 52.165833, 20.967222"));

        if (location.resolveActivity(getPackageManager()) != null)
        {
           startActivity(location);
        }
    }
}
