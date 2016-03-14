package com.seeksoul.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity
{
    //simply the number of coffee
    int numberOfCoffees = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void decrement(View view)
    {
        numberOfCoffees -= 1;

        if(numberOfCoffees < 0)
        {
            numberOfCoffees = 0;
        }
        displayQuantity(numberOfCoffees);
    }

    public void increment(View view)
    {
        numberOfCoffees += 1;
        displayQuantity(numberOfCoffees);
    }

    //main price engine which compute prize of order
    private int calculatePrice(int quantity)
    {
        if (CheckCream() == true && CheckChoco() == true)
        {
            return quantity * 18;
        }
        else if (CheckCream() == false && CheckChoco()== true)
        {
            return quantity * 8;
        }
        else if (CheckCream() == true && CheckChoco() == false)
        {
            return quantity * 10;
        }
        else
        {
            return quantity * 5;
        }
    }

    //method used by Incr. and Decr. to display the number of coffee
    private void displayQuantity(int number)
    {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayMessage(String message)
    {
        TextView summaryOrder = (TextView) findViewById(R.id.price_text_view);
        summaryOrder.setText(message);
    }

    public void submitOrder(View view) {
        String priceMessage = summaryOrder(numberOfCoffees);
        displayMessage(priceMessage);

//        Intent location = new Intent(Intent.ACTION_VIEW);
//        location.setData(Uri.parse("geo: 52.25, 20.93"));
//        if (location.resolveActivity(getPackageManager()) != null)
//        {
//            startActivity(location);
//        }

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, "");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Order for " + InsertName());
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }
    }

    //display the final summary of order include quantity, prize and owner of order
    private String summaryOrder(int quantity)
    {

        String summary = "Name: " + InsertName() + "\nQuantity: " + quantity;
        if (CheckCream())
        {
            summary += "\nMmmmmm... with delicious cream!";
        }
        if (CheckChoco())
        {
            summary += "\nWith fantastic swiss chocolate!";
        }
        summary += "\nPrice: " + calculatePrice(quantity) + "zł";
        summary += "\nThank You!";

        return summary;
    }

    //describe the state of additional cream to coffee
    private boolean CheckCream()
    {
        CheckBox cream = (CheckBox) findViewById(R.id.state_of_cream);
        return cream.isChecked();
    }

    //describe the state of additional chocolate to coffee
    private boolean CheckChoco()
    {
        CheckBox choco = (CheckBox) findViewById(R.id.state_of_chocolate);
        return choco.isChecked();
    }

    //pass the information about owner of order
    private String InsertName()
    {
        EditText Name = (EditText) findViewById(R.id.name_field);
        return Name.getText().toString();
    }
}