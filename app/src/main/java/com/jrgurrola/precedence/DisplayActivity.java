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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        //Get intent that started this activity
        Intent sentIntent = getIntent();

        //Get list of strings

        //Note to self: In 1st activity, we put an arraylist with name "tasklist"
        //Here, we retrieve using the same name a la final String.
        ArrayList<String> list = sentIntent.getStringArrayListExtra(LIST_OF_TASKS);

        ListView lv = (ListView) findViewById(R.id.show_list);

        //Create array adapter to diplay "list" onto "lv"
        ArrayAdapter<String> taskList = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_activated_1, list);

        lv.setAdapter(taskList);

    }

}
