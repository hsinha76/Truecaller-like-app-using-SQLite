package com.hsdroid.harish.truecallerusingsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Mod extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Model> modelArrayList;
    private CustomMod customMod;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_teacher);

        listView = (ListView) findViewById(R.id.teachers_lvi);

        databaseHelper = new DatabaseHelper(this);

        modelArrayList = databaseHelper.getAllTeachers();

        customMod = new CustomMod(this, modelArrayList);
        listView.setAdapter(customMod);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Mod.this, Modifycontact.class);
                intent.putExtra("teachers", modelArrayList.get(position));
                startActivity(intent);
            }
        });
    }
}
