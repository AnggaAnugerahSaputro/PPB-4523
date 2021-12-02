package com.example.tampillistview_a11202012705;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.style.UpdateAppearance;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class updateData extends AppCompatActivity {
    EditText idne, edbuah, nama_buah, kodehasil;
    private String nama,noid;
    Button saveEd,viewList;
    BantuDataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        db = new BantuDataBase(this);
        idne = (EditText) findViewById(R.id.nobuah);
        edbuah = (EditText) findViewById(R.id.editbuah);
        nama_buah = findViewById(R.id.hasileditbuah);
        kodehasil = findViewById(R.id.kodehasil);
        Bundle extras = getIntent().getExtras();
        idne.setText(extras.getString("data1"));
        edbuah.setText(extras.getString("data2"));

        saveEd=(Button) findViewById(R.id.tblsaveedit);
        viewList=(Button) findViewById(R.id.tblviewlist);
        viewList.setOnClickListener((v)-> {
             Intent intent = new Intent(updateData.this,TampilListview_A11202012705.class);
             startActivity(intent);
        });

        saveEd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kodehasil.setText(idne.getText().toString());
                nama_buah.setText(edbuah.getText().toString());

                boolean hasile=db.updateData(edbuah.getText().toString(),idne.getText().toString());
                if (hasile==true)
                {
                    Toast.makeText(updateData.this, "Update Berhasil", Toast.LENGTH_SHORT).show();
                }else 
                {
                    Toast.makeText(updateData.this, "Update Gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}