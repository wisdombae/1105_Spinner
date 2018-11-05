package com.bjh.www.a1105_spinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int count=0;    // 처음 실행 시, 바로 apple.class 뜨는 걸 막기 위해 설정

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        List<String> list = new ArrayList<String>();
        list.add("Apple");  list.add("Banana");     list.add("Mango");
        ArrayAdapter<String> dataAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> a, View v, int position, long id) {
        String text = a.getItemAtPosition(position).toString() + "," + id + "," + position;
        Toast.makeText(v.getContext(), text, Toast.LENGTH_SHORT).show();

        Intent intent = null;

        if(count!=0) {
            switch (position) {
                case 0:
                    intent = new Intent(this, apple.class);
                    startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(this, banana.class);
                    startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(this, mango.class);
                    startActivity(intent);
                    break;
                default:
                    break;
            }
        }
        count = 1;
    }

    @Override
    public void onNothingSelected(AdapterView<?> a) {

    }
}
