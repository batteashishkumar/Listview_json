package com.example.listview_json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    String json;
    ArrayList<String> mylist;
    List<Obj> mylist_obj;
    TextView t;
    ListView listView;
    int i=999;
    List_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylist = new ArrayList<String>();
        mylist_obj = new ArrayList<Obj>();
        t=findViewById(R.id.empty);
        editText=findViewById(R.id.edit);
        listView = (ListView) findViewById(R.id.mobile_list);

        json = "{\n" +
                "        \"0\": {\n" +
                "        \"id\": \"0\",\n" +
                "        \"title\": \"you will never die\"\n" +
                "        },\n" +
                "        \"1\": {\n" +
                "        \"id\": \"1\",\n" +
                "        \"title\": \"Baseball\"\n" +
                "        },\n" +
                "        \"2\": {\n" +
                "        \"id\": \"2\",\n" +
                "        \"title\": \"Two basketball team players earn all state honors\"\n" +
                "        },\n" +
                "        \"3\": {\n" +
                "        \"id\": \"3\",\n" +
                "        \"title\": \"ashish is a good boy\"\n" +
                "        },\n" +
                "        \"4\": {\n" +
                "        \"id\": \"4\",\n" +
                "        \"title\": \"raju is a 90 boy\"\n" +
                "        },\n" +
                "        \"5\": {\n" +
                "        \"id\": \"5\",\n" +
                "        \"title\": \"rajsheaker is a tall boy\"\n" +
                "        },\n" +
                "        \"6\": {\n" +
                "        \"id\": \"6\",\n" +
                "        \"title\": \"srikanth is a smart boy\"\n" +
                "        },\n" +
                "        \"7\": {\n" +
                "        \"id\": \"7\",\n" +
                "        \"title\": \"prem is a bad boy\"\n" +
                "        },\n" +
                "        \"8\": {\n" +
                "        \"id\": \"8\",\n" +
                "        \"title\": \"again,ashish is a good boy\"\n" +
                "        }\n" +
                "\n" +
                "        }";
t.setText(json);
        t.setMovementMethod(new ScrollingMovementMethod());
        list_update();

    }


    @Override
    public void onStart() {
        super.onStart();
        try {
            JSONObject mainObject = new JSONObject(json);
            for (int i = 0; i < 9; i++) {
                JSONObject Object = mainObject.getJSONObject(String.valueOf(i));
                String name = Object.getString("id");
                String url = Object.getString("title");
                Obj x = new Obj(name, url);
                mylist_obj.add(x);
            }
        } catch (Exception e) {
        }
    }
    public void list_update() {
    adapter=new List_adapter(this,mylist_obj);
        listView.setAdapter(adapter);

    }
    public void search(View v){
        String a=editText.getText().toString();
        if(!a.isEmpty()){

            i=Integer.parseInt(a);
            adapter.seti( i);
            adapter.notifyDataSetChanged();

        }
        if(a.isEmpty()){
            adapter.seti( 999);
            adapter.notifyDataSetChanged();
        }



        }


}
//{
//        "0": {
//        "id": "0",
//        "title": "you will never die"
//        },
//        "1": {
//        "id": "1",
//        "title": "Baseball"
//        },
//        "2": {
//        "id": "2",
//        "title": "Two basketball team players earn all state honors"
//        },
//        "3": {
//        "id": "3",
//        "title": "ashish is a good boy"
//        },
//        "4": {
//        "id": "4",
//        "title": "raju is a 90 boy"
//        },
//        "5": {
//        "id": "5",
//        "title": "rajsheaker is a tall boy"
//        },
//        "6": {
//        "id": "6",
//        "title": "srikanth is a smart boy"
//        },
//        "7": {
//        "id": "7",
//        "title": "prem is a bad boy"
//        },
//        "8": {
//        "id": "8",
//        "title": "again,ashish is a good boy"
//        }
//
//        }