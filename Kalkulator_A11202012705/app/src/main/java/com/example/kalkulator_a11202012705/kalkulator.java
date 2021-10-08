package com.example.kalkulator_a11202012705;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class kalkulator extends AppCompatActivity {

    EditText angka1, angka2;
    TextView hasilnya;
    Button TombolTambah

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        angka1=(EditText) findViewById(R.id.angka1);
        angka2=(EditText) findViewById(R.id.angka2);
        TombolTambah=(Button) findViewById(R.id.TombolHitung);

        TombolTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a1=Integer.parseInt(angka1.getText().toString());
                int a2=Integer.parseInt(angka2.getText().toString());
                Integer hasil=a1+a2;

                hasilnya.setText(hasil.toString());
            }
        });
    }

    }

}