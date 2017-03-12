package me.sneckrun.sneckrun;

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

public class MainScreen extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        button = (Button) findViewById(R.id.needSneck);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "You requested a sneck run!",
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

        textBox.setText("");
    }

}

