package com.example.customlistview;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    String fruitList[]={"Apple","Banana","Apricot","Orange","Water Melon"};
    int fruitImages []={R.drawable.applw,R.drawable.banana,R.drawable.apricot,R.drawable.orange,R.drawable.water};
    ListView listView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView) findViewById(R.id.customListView);
        CustomBaseAdapter customBaseAdapter=new CustomBaseAdapter(getApplicationContext(),fruitList,fruitImages);
        listView.setAdapter(customBaseAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int customListView = Log.i("CUSTOM LIST VIEW", "Item is clicked @ position :" + position);
            }
        });
    }
}