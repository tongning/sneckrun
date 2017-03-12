package me.sneckrun.sneckrun;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.icu.text.RelativeDateTimeFormatter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.EditText;
import java.util.Date;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainScreen extends AppCompatActivity {
    private Button button;
    static SharedPreferences preference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseMessaging.getInstance().subscribeToTopic("aces-sneck-run");
        setContentView(R.layout.activity_main_screen);
        button = (Button) findViewById(R.id.needSneck);
        preference = this.getPreferences(Context.MODE_PRIVATE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), (preference.getString("NickName", "Someone") + " requested a sneck run!"),
                        Toast.LENGTH_SHORT).show();
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
        preference.edit().putString("NickName", valToSave).apply();
        //textBox.setText("");
    }
    public static SharedPreferences getNames() {
        return preference;
    }

}

