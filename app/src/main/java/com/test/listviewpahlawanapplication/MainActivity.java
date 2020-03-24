package com.test.listviewpahlawanapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private PahlawanAdapter adapter;
    //private HeroAdapter adapter;
    //private String [] dataName = {"Cut Nyak Dien","Ki Hajar Dewantara","Moh Yamin","Patimura","R A Kartini","Sukarno"};
    private String [] dataName;
    private String [] dataDescription;
    private TypedArray dataPhoto;
    //private ArrayList<Hero> hero;
    private ArrayList<Pahlawan> pahlawans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lv_list);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, dataName);
        adapter = new PahlawanAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, pahlawans.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void prepare () {
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

    private void addItem () {
        pahlawans = new ArrayList<>();

        for (int i=0; i < dataName.length; i++) {
            Pahlawan pahlawan = new Pahlawan();
            pahlawan.setPhoto(dataPhoto.getResourceId(i, -1));
            pahlawan.setName(dataName[i]);
            pahlawan.setDescription(dataDescription[i]);
            pahlawans.add(pahlawan);
        }
        adapter.setPahlawans(pahlawans);
        }

}
