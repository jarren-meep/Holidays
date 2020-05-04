package com.myapplicationdev.android.holidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ListView lv;
    TextView tv1;
    ArrayList<Holiday> SecHoliday, EthHoliday ;
    ArrayAdapter aa;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i = getIntent();
        String type = i.getStringExtra("type");
        lv = (ListView) this.findViewById(R.id.lv2);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setText(type);

        SecHoliday = new ArrayList<Holiday>();
        SecHoliday.add(new Holiday("Labour Day", "5/1/2020", R.drawable.labour));
        SecHoliday.add(new Holiday("New Years", "1/1/2020", R.drawable.ny));
        SecHoliday.add(new Holiday("New Years", "1/1/2020", R.drawable.cny));

        EthHoliday = new ArrayList<Holiday>();
        EthHoliday.add(new Holiday("National Day", "5/1/2020", R.drawable.cny));

        // Link this Activity object, the row.xml layout for
        //  each row and the food String array together

        if (type.equals("Secular")) {
            aa = new Holidapter(this, R.layout.row, SecHoliday);
        } else if (type.equals("Ethnic")){
            aa = new Holidapter(this, R.layout.row, EthHoliday);
        }
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Intent i = getIntent();
            String type = i.getStringExtra("type");
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (type.equals("Secular")) {
                    Holiday selected = SecHoliday.get(position);
                    Toast.makeText(Main2Activity.this, SecHoliday.get(position).getDay()
                                    + " Day: " + SecHoliday.get(position).getDate(),
                            Toast.LENGTH_LONG).show();
                } else {
                    Holiday selected = EthHoliday.get(position);
                    Toast.makeText(Main2Activity.this, EthHoliday.get(position).getDay()
                                    + " Day: " + EthHoliday.get(position).getDate(),
                            Toast.LENGTH_LONG).show();
                }



            }
        });
    }
}
