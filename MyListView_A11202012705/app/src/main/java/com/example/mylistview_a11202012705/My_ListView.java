package com.example.mylistview_a11202012705;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class MyListView extends AppCompatActivity {
    ListView listView;
    public String bhs_program[]={"Prolog", "C+", "Pascal", "Cobol", "Per1", "Algo1 L", "Java", "PHP", "Phyton" };

   Spinner combo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView) findViewById(R.id.listdata);
        combo=(Spinner) findViewById(R.id.combodata);

        ArrayAdapter adapter=new ArrayAdapter(MyListView.this, R.layout.support_simple_spinner_dropdown_item,bhs_program);
        listView.setAdapter(adapter);
        combo.setAdapter(adapter);
    }
}