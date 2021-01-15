package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etID1;
    Button btnSubmit1;
    TextView tvResults1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etID1=findViewById(R.id.etID1);
        btnSubmit1=findViewById(R.id.btnSubmit1);
        tvResults1=findViewById(R.id.tvResults1);
        tvResults1.setVisibility((View.GONE));


        btnSubmit1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String idNumber=etID1.getText().toString().trim();

                String dob=idNumber.substring(0,6);

                int gen=Integer.parseInt(Character.toString(idNumber.charAt(6)));

                String sGender;
                if(gen<5)
                    sGender=getString(R.string.female);
                else
                    sGender=getString(R.string.male);
                int nationality=Integer.parseInt(Character.toString(idNumber.charAt(10)));

                String snationality;
                if(nationality==0)
                    snationality=getString(R.string.sacitizen);
                else
                    snationality=getString(R.string.permanentresidence);

                String text=getString(R.string.dob)+dob+"\n" +
                        getString(R.string.gender)+sGender+"\n" +
                        getString(R.string.nationality)+ snationality;

                tvResults1.setText(text);
                tvResults1.setVisibility(View.VISIBLE);


            }
        });

    }
}