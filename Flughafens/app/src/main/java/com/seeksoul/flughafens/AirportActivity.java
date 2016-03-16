package com.seeksoul.flughafens;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bluejamesbond.text.DocumentView;

public class AirportActivity extends AppCompatActivity {

    private static String ButtonID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airport);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                ButtonID = null;
            } else {
                ButtonID = extras.getString("id");
            }
        } else {
            ButtonID = (String) savedInstanceState.getSerializable("id");
        }
        Log.v("LOG", "button id: " + ButtonID);

        ImageView imageView = (ImageView) findViewById(R.id.arp_image);
        TextView name_View = (TextView) findViewById(R.id.arp_name);
        DocumentView info_1 = (DocumentView) findViewById(R.id.info_1);
        DocumentView info_2 = (DocumentView) findViewById(R.id.info_2);
        DocumentView info_3 = (DocumentView) findViewById(R.id.info_3);

        int resImageID = this.getResources().getIdentifier("image_" + ButtonID, "drawable", getPackageName());
        imageView.setImageResource(resImageID);

        int resArpName = this.getResources().getIdentifier("title_" + ButtonID, "string", getPackageName());
        name_View.setText(getString(resArpName));
        int resInfo1 = this.getResources().getIdentifier("info_1" + ButtonID, "string", getPackageName());
        info_1.setText(getString(resInfo1));
        int resInfo2 = this.getResources().getIdentifier("info_2" + ButtonID, "string", getPackageName());
        info_2.setText(getString(resInfo2));
        int resInfo3 = this.getResources().getIdentifier("info_3" + ButtonID, "string", getPackageName());
        info_3.setText(getString(resInfo3));

        LinearLayout.LayoutParams params_2 = (LinearLayout.LayoutParams) info_2.getLayoutParams();
        LinearLayout.LayoutParams params_3 = (LinearLayout.LayoutParams) info_3.getLayoutParams();

        Log.v("LOG", "string number 2: " + getString(resInfo2));

        if (getString(resInfo2) == "") {
            params_2.setMargins(0, 0, 0, 0);
            info_2.setLayoutParams(params_2);
        } else if (getString(resInfo3) == "") {
            params_3.setMargins(0, 0, 0, 0);
            info_3.setLayoutParams(params_3);
        }

    }

    public void location(View view) {
        int geoLoc = this.getResources().getIdentifier("loc_" + ButtonID, "string", getPackageName());
        Log.v("LOG on >>location<<", "button id: " + ButtonID);

        Intent location = new Intent(Intent.ACTION_VIEW);
        location.setData(Uri.parse("geo: " + getString(geoLoc)));

        if (location.resolveActivity(getPackageManager()) != null) {
            startActivity(location);
        }

    }
}

