package com.example.week5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONTutorial extends AppCompatActivity {
    private Button btnName, btnCourse, btnAge;
    private TextView tvdisplay;
    private String myJSONObjectString = "{\n" +
        "  \"studentName\": \"Nick\",\n" +
        "  \"courseName\": \"Computer Science\",\n" +
        "  \"age\": \"19\"\n" +
        "}";
    private JSONObject myJSONObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsontutorial);

        findViews();
        setListeners();
        prepareJSON();
    }

    private void findViews(){
        btnName = findViewById(R.id.btnGetName);
        btnCourse = findViewById(R.id.btnGetCourse);
        btnAge = findViewById(R.id.btnGetAge);
        tvdisplay = findViewById(R.id.tvText);
    }

    private void setListeners(){
        btnName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                try {
                    String name = myJSONObject.getString("studentName");
                    tvdisplay.setText(name);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        btnCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String age = null;
                try {
                    age = myJSONObject.getString("age");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                tvdisplay.setText(age);
            }
        });

        btnAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void prepareJSON() {
        try {
            myJSONObject = new JSONObject(myJSONObjectString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
