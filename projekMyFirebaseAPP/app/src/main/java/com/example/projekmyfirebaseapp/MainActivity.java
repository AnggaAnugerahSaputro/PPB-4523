package com.example.projekmyfirebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nimsiswa,namasiswa;
    Button btnSave, btnView;
    DatabaseReference reference;
    Mahasiswa mahasiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nimsiswa=findViewById(R.id.nim);
        namasiswa=findViewById(R.id.namaSiswa);
        btnSave=findViewById(R.id.TombolSave);
        //btnView=findViewById(R.id.TombolView);
        mahasiswa = new Mahasiswa();

        reference = FirebaseDatabase.getInstance().getRefrence().child("Siswa");

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mahasiswa.setNim(nimsiswa.getText().toString().trim());
                mahasiswa.setNama(namasiswa.getText().toString().trim());
                reference.push().setValue(mahasiswa);
                Toast.makeText(MainActivity.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,tampil_semua_data.class);
                startActivity(intent);
            }
        });


    }
}