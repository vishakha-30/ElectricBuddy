package com.example.electricbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class Report extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        /*here i have just done initialization of the textviews*/
        TextView unitstext= (TextView) findViewById(R.id.UnitTextNumber);
        TextView amounttext= (TextView) findViewById(R.id.AmountText);
        TextView discounttext= (TextView) findViewById(R.id.DiscountText);
        TextView categorytext= (TextView) findViewById(R.id.CategoryTypeText);
        TextView Mainheading=(TextView) findViewById(R.id.MainText);

        /*here getting values from mainActivity using Intent function*/
        String username=getIntent().getStringExtra("username");
        String units=getIntent().getStringExtra("units");
        String amount=getIntent().getStringExtra("amount");
        String discount=getIntent().getStringExtra("discount");
        String billcheck=getIntent().getStringExtra("billcheck");
        char check=billcheck.charAt(0);

        /*here i have set the calculated values in textview*/
        Mainheading.setText("Hey "+username);
        unitstext.setText("Units : "+units);
        amounttext.setText("Final Amount : "+amount);
        discounttext.setText("Discount : "+discount);

        if(check=='c'||check=='C')
        {
            categorytext.setText("Category : City");
        }
        else if(check=='v'||check=='V')
        {
            categorytext.setText("Category : Village");
        }
        else
        {
            categorytext.setText("Category : Invalid");
        }
    }

    @Override
    public void finish() {
        super.finish();
        //overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }
}