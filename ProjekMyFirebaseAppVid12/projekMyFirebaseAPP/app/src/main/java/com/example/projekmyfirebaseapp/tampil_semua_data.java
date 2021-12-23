package com.example.projekmyfirebaseapp;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class tampil_semua_data extends AppCompatActivity {
    ListView listView;
    ArrayAdapter arrayAdapter;

    ArrayList<String> arrayTampil=new ArrayList<>();
    ArrayList<String> arrayEdit=new ArrayList<>();
    ArrayList<String> arrayHapus=new ArrayList<>();

    DatabaseReference databaseReference;
    public String data1,data2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_semua_data);

        listView=findViewById(R.id.listdataku);
        databaseReference=FirebaseDatabase.getInstance().getReference().child("Maha");
        arrayAdapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,arrayTampil);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position , long id) {
                Intent intent=new Intent(tampil_semua_data.this,MainActivity.class);
                startActivity(intent);

            }
        });

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s){
                String hasil=dataSnapshot.getValue(Mahasiswa.class).toPrint();
                arrayTampil.add(hasil);
                String key=dataSnapshot.getKey();
                arrayEdit.add(key);
                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s){
                String hasil=dataSnapshot.getValue(Mahasiswa.class).toPrint();
                String key=dataSnapshot.getKey(hasil);
                int indek=arrayEdit.indexOf(key);
                arrayTampil.set(indek,hasil);
                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
            String hasil=dataSnapshot.getValue(Mahasiswa.class);
            String key=dataSnapshot.getKey();
            int indek=arrayHapus.indexOf(key);
            arrayTampil.remove(indek);
            arrayHapus.remove(indek);
            arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s){

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError){

            }
        }


    }
}