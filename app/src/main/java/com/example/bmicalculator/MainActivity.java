package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.*;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3;
    Button b1;
    float a,b,bmi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout ll=new LinearLayout(getApplicationContext());
        ll.setOrientation(LinearLayout.VERTICAL);
        e1=new EditText(this);
        e1.setHint("Height in cm");
        e2=new EditText(this);
        e2.setHint("Weight in kg");
        b1=new Button(this);
        b1.setText("Compute BMI");
        e3=new EditText(this);
        ll.addView(e1);
        ll.addView(e2);
        ll.addView(b1);
        ll.addView(e3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bmiResult="";
                a=Integer.parseInt(String.valueOf(e1.getText()));
                b=Integer.parseInt(String.valueOf(e2.getText()));
                a/=100;
                bmi=b/(a*a);
                if(bmi<=18.5){
                    bmiResult="UnderWeight - ";
                }
                else if(bmi>18.5&&bmi<25)
                {
                    bmiResult="Normal Weight - ";
                }
                else if(bmi>=25&&bmi<30)
                {
                    bmiResult="Over Weight - ";
                }
                else if(bmi>=30){
                    bmiResult="Obiesty - ";
                }
                e3.setText(bmiResult+Float.toString(bmi));
            }
        });
        setContentView(ll);
    }
}