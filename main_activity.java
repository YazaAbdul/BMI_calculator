package com.abdul.a07_jan_23;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtResult;
        EditText edtweight,editheightFt,editheightIn;
        Button btnbmi;
        LinearLayout llm;

        edtweight=findViewById(R.id.edtWeight);
        editheightFt=findViewById(R.id.edtheight);
        editheightIn=findViewById(R.id.edtHeight_in);

        txtResult=findViewById(R.id.txtResult);
        btnbmi=findViewById(R.id.btn_bmi);
        llm=findViewById(R.id.llmain);

        btnbmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int weight=Integer.parseInt( edtweight.getText().toString());
               int hFt=Integer.parseInt(editheightFt.getText().toString());
               int hIn=Integer.parseInt(editheightIn.getText().toString());

               int totalIN=hFt*12+hIn;
               double centemeter=totalIN*2.53;

               double totalM=centemeter/100;

               double bmi=weight/(totalM*totalM);
               if(bmi>25){
                   txtResult.setText("Your are overweight");
                   llm.setBackgroundColor(getResources().getColor(R.color.overweight));
               }else if(bmi < 18){
                   txtResult.setText("your are underweight");
                   llm.setBackgroundColor(getResources().getColor(R.color.underweight));
               }else{
                   txtResult.setText("your are healthy");
                   llm.setBackgroundColor(getResources().getColor(R.color.healthy));
               }
            }
        });

    }
}
