package com.example.projekmysql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.listdata);

        tampilkanbarang("https://192.168.1.4:8080/service_data.php");
    }
    private void tampilkanbarang( String s) {
        class tampilkanbarang extends AsyncTask<Void,Void,String>
        {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                try {
                    bacadatakelist(s);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                try {

                    URL url=new URL(s);
                    HttpURLConnection urlConnection =(HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getErrorStream()));

                    String json;
                    while((json = bufferedReader.readLine()) !=null)
                    {
                        sb.append(json+"\n");
                    }
                    return sb.toString().trim();

                }catch (Exception e){
                    e.printStackTrace();
                }
                return null;
            }
        }
        tampilkanbarang tampil = new tampilkanbarang();
        tampil.execute();
    }

    private void bacadatakelist(String json) throws JSONException  {
        JSONArray jsonArray=new JSONArray(json);
        String Stok[]=new String[jsonArray.length()];
        for (int i = 0; i<jsonArray.length();i++)
        {
            JSONObject obj =jsonArray.getJSONObject(i);
            Stok[i]=obj.getString("Kode")+" "+
                    obj.getString("nama_barang")+" "+
                    obj.getString("harga");
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,Stok);
        listView.setAdapter(arrayAdapter);
    }
}