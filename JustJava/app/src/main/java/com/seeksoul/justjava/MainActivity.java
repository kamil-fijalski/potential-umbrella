package com.seeksoul.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity
{
    int numberOfCoffees = 0;

    CheckBox CheckCream = (CheckBox) findViewById(R.id.state_of_cream);
    boolean hasCream = CheckCream.isChecked();

    CheckBox CheckChoco = (CheckBox) findViewById(R.id.state_of_chocolate);
    boolean hasChoco =  CheckChoco.isChecked();

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

    private int calculatePrice(int quantity)
    {
        if (hasCream == true && hasChoco == true)
        {
            return quantity * 18;
        }
        else if (hasCream == false && hasChoco== true)
        {
            return quantity * 8;
        }
        else if (hasCream == true && hasChoco == false)
        {
            return quantity * 10;
        }
        else
        {
            return quantity * 5;
        }
    }

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

    public void submitOrder(View view)
    {
        String priceMessage = summaryOrder(numberOfCoffees);
        displayMessage(priceMessage);
    }

    private String summaryOrder(int quantity)
    {
        String summary = "Name: Captain Bear" + "\nQuantity: " + quantity;
        summary += "\nPrice: " + calculatePrice(quantity) + "zł";
        summary += "\nThank You!";

        return summary;
    }




}
