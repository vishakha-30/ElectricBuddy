package com.example.electricbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void calculateFunction(View view)
    {
        EditText Usernametext=(EditText) findViewById(R.id.TextPersonName);
        EditText Billtext=(EditText) findViewById(R.id.TextBillNumber);
        EditText Unitstext=(EditText) findViewById(R.id.TextUnitsNumber);
        Context context=getApplicationContext();
        CharSequence error="Some value is missing";
        int duration = Toast.LENGTH_SHORT;
        if(Usernametext.getText().toString().matches(""))
        {
            Toast toast=Toast.makeText(context,"Username missing",duration);
            toast.show();
            return;
        }
        else if(Billtext.getText().toString().matches(""))
        {
            Toast toast=Toast.makeText(context,"Bill Number missing",duration);
            toast.show();
            return;
        }
        else if(Unitstext.getText().toString().matches(""))
        {
            Toast toast=Toast.makeText(context,"Units missing",duration);
            toast.show();
            return;
        }
        else
        {
            int unit=Integer.parseInt(Unitstext.getText().toString());
            float amount = electric(unit);
            String billcheck = Billtext.getText().toString();
            char firstcheck = billcheck.charAt(0);
            String category;
            String discount = "no";
            if (firstcheck == 'c' || firstcheck == 'C') {
                category = "city";
                if ((amount > 1000) && (amount < 2000)) {
                    discount = "yes";
                    amount = (float) (amount - (amount * 2.5 / 100));
                } else if (amount > 5000) {
                    discount = "no";
                    amount = (float) (amount + (amount * 10.2 / 100));
                } else {
                    discount = "no";
                }
            } else if (firstcheck == 'v' || firstcheck == 'V') {
                category = "village";
                if ((amount >= 500) && (amount < 5000)) {
                    discount = "yes";
                    amount = (float) (amount - (amount * 2.5 / 100));
                } else if (amount > 5000) {
                    discount = "no";
                    amount = (float) (amount + (amount * 10.2 / 100));
                } else {
                    discount = "no";
                }
            } else {
                category = "invalid";
            }
            String billamt = String.valueOf(amount);
            //Toast toast = Toast.makeText(context, billamt, duration);
            //toast.show();
            Intent intent = new Intent(MainActivity.this,Report.class);
            intent.putExtra("username",Usernametext.getText().toString());
            intent.putExtra("units",Unitstext.getText().toString());
            intent.putExtra("amount",billamt);
            intent.putExtra("billcheck",billcheck);
            intent.putExtra("discount",discount);
            startActivity(intent);
            //overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
        }
    }

    public float electric(int units)
    {
        float amt=0;
        int min=100;
        if(units==0)
        {
            amt=min;
        }
        else if((units>0)&&(units<=150))
        {
            amt=min+(units*50);
        }
        else if((units>150)&&(units<=350))
        {
            amt=min+(150*50)+(units-150)*60;
        }
        else if((units>350)&&(units<=450))
        {
            amt=min+(150*50)+(199*60)+(units-350)*65;
        }
        else if((units>450)&&(units<=750))
        {
            amt=min+(150*50)+(199*60)+(99*65)+(units-450)*70;
        }
        else if(units>750)
        {
            amt= (float) (min+(150*50)+(199*60)+(99*65)+(299*70)+(units-750)*75.25);
        }
        return amt;
    }

    public void developerFunction(View view)
    {
        Intent intent=new Intent(MainActivity.this,Developer.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}