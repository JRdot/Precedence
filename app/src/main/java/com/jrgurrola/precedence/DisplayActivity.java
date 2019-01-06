package com.jrgurrola.precedence;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class DisplayActivity extends Activity {
    public static final String LIST_OF_TASKS = "tasklist";
    //Note to self: not "final" since arrays aren't static
    public static ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        //Get intent that started this activity
        Intent sentIntent = getIntent();
        //If list was previously created...
        if(savedInstanceState != null){
            list = savedInstanceState.getStringArrayList("list");
        } else {//List not created, get from intent
            list = sentIntent.getStringArrayListExtra(LIST_OF_TASKS);
        }
        ListView lv = findViewById(R.id.show_list);
        //Create array adapter to diplay "list" onto "lv"
        ArrayAdapter<String> taskList = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_activated_1, list);
        lv.setAdapter(taskList);
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putStringArrayList("list", list);

    }

}
