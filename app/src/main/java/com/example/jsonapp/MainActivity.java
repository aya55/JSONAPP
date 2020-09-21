package com.example.jsonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
MediaPlayer player;
Button btn_showstudents;
ListView lv_showstudents;
ArrayList<String> students=new ArrayList<>();
static  String jsonString ="{\"univertsity\":\"Benha\",\"faculty\":\"BFCAI\"," +
        "\"students\":[{\"id\":1,\"name\":\"Aya Shrief\",\"email\":\"aya.shrief@mail.com\",\"age\":20,\"phone\":\"01116360192\"}," +
        "{\"id\":2,\"name\":\"Hekmat Gamal\",\"email\":\"hekmat.gamal@mail.com\",\"age\":20,\"phone\":\"01116360192\"}," +
        "{\"id\":3,\"name\":\"Dalia Rageh\",\"email\":\"dalia.rageh@mail.com\",\"age\":19,\"phone\":\"01116360192\"}," +
        "{\"id\":4,\"name\":\"Asmaa shawky\",\"email\":\"asmaa.shawky@mail.com\",\"age\":19,\"phone\":\"01116360192\"}]}";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      btn_showstudents=findViewById(R.id.btn_showstudents);
      lv_showstudents=findViewById(R.id.lv_showStudents);
        final ArrayAdapter<String> studentsAdapter=new ArrayAdapter<>(getApplicationContext(),R.layout.list_item,students);
        lv_showstudents.setAdapter(studentsAdapter);
        btn_showstudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                students.clear();

                try {
                    JSONObject jsonRoot=new JSONObject(jsonString);

                    JSONArray jsonArray=jsonRoot.getJSONArray("students");
                    for (int i=0; i<jsonArray.length(); i++){
                      JSONObject student=jsonArray.getJSONObject(i);
                      int id=student.getInt("id");
                      String name=student.getString("name");
                      String email=student.getString("email");
                      int age=student.getInt("age");
                      String phone=student.getString("phone");
                      students.add("Id: "+id+"\n Name: "+name+"\nEmail: "+email+"\nAge: "+age+"\nPhone: "+phone);


                    }
                    studentsAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });


        Toast.makeText(getApplicationContext(),"OnCreate started",Toast.LENGTH_SHORT).show();
       player= MediaPlayer.create(MainActivity.this, R.raw.loveu);
       player.start();
    }

    @Override
    protected void onStart() {
        Toast.makeText(getApplicationContext(),"OnStart started",Toast.LENGTH_SHORT).show();
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"OnResume started",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"OnPause started",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),"OnStop started",Toast.LENGTH_SHORT).show();
        player.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"OnDestroy started",Toast.LENGTH_SHORT).show();

    }
}
