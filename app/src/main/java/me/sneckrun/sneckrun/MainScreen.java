package me.sneckrun.sneckrun;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.icu.text.RelativeDateTimeFormatter;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.EditText;
import java.util.*;
import org.json.*;
import java.io.*;
import okhttp3.*;
import android.util.Log;

//import android.widget.Context;

import com.google.firebase.messaging.FirebaseMessaging;


public class MainScreen extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseMessaging.getInstance().subscribeToTopic("aces-sneck-run");

        final Handler mHandler = new Handler(getMainLooper());

        setContentView(R.layout.activity_main_screen);
        button = (Button) findViewById(R.id.needSneck);
        //SharedPreferences = getActivi
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MediaType JSON = MediaType.parse("application/json; charset=utf-8");
                Map<String, String> params = new HashMap<String, String>();
                params.put("name", "some name");

                JSONObject parameter = new JSONObject(params);
                OkHttpClient client = new OkHttpClient();

                RequestBody body = RequestBody.create(JSON, parameter.toString());
                Request request = new Request.Builder()
                        .url("http://snackrun.herokuapp.com/message")
                        .post(body)
                        .addHeader("content-type", "application/json; charset=utf-8")
                        .build();

                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), "Request failed.", Toast.LENGTH_SHORT).show();
                            }
                        });


                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), "You requested a sneck run!", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }


                });
            }
        });

    }

    public void initiateSneckRun(View view){
        /**
         * Nothing here works :(
         */
        LayoutInflater inflater = getLayoutInflater();
        RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.activity_main_screen,null);
        layout.setBackgroundColor(Color.BLACK);
    }

    public void saveBox(View view) {
        EditText textBox= (EditText) findViewById(R.id.editText4);
        String valToSave = textBox.getText().toString();

        textBox.setText("");
    }

}

