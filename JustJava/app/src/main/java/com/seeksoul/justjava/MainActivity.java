package com.seeksoul.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity
{
    int numberOfCoffees = 0;

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

        String summary = "Name: " + InsertName() + "\nQuantity: " + quantity;
        summary += "\nPrice: " + calculatePrice(quantity) + "zł";
        summary += "\nThank You!";

        return summary;
    }

    private boolean CheckCream()
    {
        CheckBox cream = (CheckBox) findViewById(R.id.state_of_cream);
        return cream.isChecked();
    }

    private boolean CheckChoco()
    {
        CheckBox choco = (CheckBox) findViewById(R.id.state_of_chocolate);
        return choco.isChecked();
    }

    private String InsertName()
    {
        EditText Name = (EditText) findViewById(R.id.name_field);
        return Name.getText().toString();
    }
}