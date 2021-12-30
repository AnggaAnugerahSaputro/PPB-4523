package com.example.mylbs_a11202012705;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mylbs_a11202012705.databinding.ActivityMapsBinding;

import java.util.Map;

public class MapsActivity extends FragmentActivity implements AdapterView.onItemClickListener, AdapterView.OnItemSelectedListener, OnMapReadyCallback {

    private GoogleMap mMap;
    public static final String nama_pulau[] = {"PilihPulau", "Sumatra", "Jawa", "Kalimantan", "Sulawesi", "Bali", "NTB", "NTT", "Maluku", "Papua"};
    Spinner spinner;

    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        spinner=findViewById(R.id.pilihpulau);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,nama_pulau);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
       // LatLng sydney = new LatLng(-7.205965, 110.4162877);
       // mMap.addMarker(new MarkerOptions().position(sydney).title("Posisi Saya Sekarang"));
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        double lati, longi;

        switch (position)
        {
            case 0:
                mMap.clear();
                break;
            case 1:
                mMap.clear();
                LatLng aceh = new LatLng(-5.595062, 95.3833877);
                mMap.addMarker(new MarkerOptions().position(aceh).title("NAD"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(aceh));

                LatLng medan = new LatLng(-3.5730849, 98.6782503);
                mMap.addMarker(new MarkerOptions().position(medan).title("Medan"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(medan));

                LatLng padang = new LatLng(-0.9345808, 100.2511784);
                mMap.addMarker(new MarkerOptions().position(padang).title("Padang"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(padang));

                LatLng palembang = new LatLng(-2.9549663, 104.6929228);
                mMap.addMarker(new MarkerOptions().position(palembang).title("palembang"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(palembang));
                break;
            case 2:
            case 3:
            case 4:
            default: Toast.makeText(this, "Pilihan tidak ada lagi...!!!", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}