package com.example.week5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main2Activity extends AppCompatActivity {
    private Button btnGetBooks;
    private TextView tvDisplay;
    private JSONObject myJsonObject;
    private String dataString="{\n" +
            "  \"name\": \"Lee Boom Kong\",\n" +
            "  \"studentID\": \"11003388\",\n" +
            "  \"course\": \"Computer Science\",\n" +
            "  \"libraryProfile\": {\n" +
            "    \"libraryID\": \"20202020\",\n" +
            "    \"numberOkBooksBorrowed\": \"3\",\n" +
            "    \"allowedAccess\": \"true\",\n" +
            "    \"borrowedBooks\": [\n" +
            "      \"Nicholas\",\n" +
            "      \"Akane\",\n" +
            "      \"Penguin\"\n" +
            "    ]\n" +
            "  }\n" +
            "}";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        findViews();
        setListener();
        preapareJson();

    }

    private void findViews(){
        btnGetBooks=findViewById(R.id.btnGB);
        tvDisplay=findViewById(R.id.tv);




    }

    private void setListener(){

        btnGetBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //JSONObject libraryObject=new JSONObject(myJsonObject.getString("libraryProfile"));

                    JSONObject libraryObject=myJsonObject.getJSONObject("libraryProfile");
                    JSONArray arrayBooks=libraryObject.getJSONArray("borrowedBooks");
                    String result="";

                    for (int i=0; i<arrayBooks.length(); i++){

                        String bookName=arrayBooks.getString(i);
                        result+=bookName + "\n";


                    }
                    tvDisplay.setText(result);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });


    }
    private void preapareJson(){

        try {
            myJsonObject=new JSONObject(dataString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
