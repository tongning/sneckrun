package me.sneckrun.sneckrun;

/**
 * Created by anthony on 3/11/2017.
 */
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView textView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        //textView = (TextView)findViewById(R.id.textView1);
        //textView.setText("Welcome to the Result Activity");
    }
}
