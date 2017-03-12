package me.sneckrun.sneckrun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

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
        //.setBackground( getResources().getDrawable(R.drawable.big_ib));
    }

}
