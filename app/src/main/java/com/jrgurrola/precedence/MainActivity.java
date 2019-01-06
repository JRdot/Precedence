package com.jrgurrola.precedence;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.PriorityQueue;

//Todo: implement button that will show new layout of a list
//Todo: Save priority queue on close and reopen

public class MainActivity extends Activity {
    //Set the values for NumberPicker
    NumberPicker precedenceVals;
    PriorityQueue<AbstractMap.SimpleEntry<Integer, String>> taskImportance =
            new PriorityQueue<>(20,new SimpleEntryComparator());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Set up NumberPicker View Object
        precedenceVals = findViewById(R.id.precedenceValuesPicker);
        precedenceVals.setMaxValue(25);
        precedenceVals.setMinValue(1);
        precedenceVals.setWrapSelectorWheel(false);
    }


    //Add a task to our heap
    public void addTask(View view) {
        EditText taskToDo = findViewById(R.id.inputToDo);
        NumberPicker precedenceInt = findViewById(R.id.precedenceValuesPicker);

        //Store the task
        String tasky = taskToDo.getText().toString();

        //Store the integer (precedence)
        Integer precedInt = precedenceInt.getValue();

        //Store info together
        AbstractMap.SimpleEntry<Integer, String> importantTask =
                new AbstractMap.SimpleEntry<>(precedInt, tasky);

        //Add to heap
        taskImportance.add(importantTask);

    }

    //Converts heap into list (preserving order) and displays it
    public void displayList(View view){
        Intent showList = new Intent(this, DisplayActivity.class);

        ArrayList<String> heapToList = convertHeapToList();
                        //(Name, Actual list)
        showList.putExtra(DisplayActivity.LIST_OF_TASKS, heapToList);

        startActivity(showList);

    }

    //Takes a heap of SimpleEntries and returns them as a list (in order)
    public ArrayList<String> convertHeapToList(){
        ArrayList<String> listOfTasks = new ArrayList<>();
        for (AbstractMap.SimpleEntry<Integer, String> se : taskImportance){
            //Todo: Test this *actually* gives the right order of strings
            listOfTasks.add(se.getValue());
        }
        return listOfTasks;
    }

}
