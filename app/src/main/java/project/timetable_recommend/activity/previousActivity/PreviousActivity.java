package project.timetable_recommend.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import Controller.BottomNavigationListener;
import project.timetable_recommend.PreviousLayout1;
import project.timetable_recommend.PreviousLayout2;
import project.timetable_recommend.PreviousLayout3;
import project.timetable_recommend.PreviousLayout4;
import project.timetable_recommend.R;

public class PreviousActivity extends AppCompatActivity {
    Button button1, button2, button3, button4;
    BottomNavigationView  bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous);
        bottomNavigationView  = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationListener());
        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        Button.OnClickListener onClickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button:
                        Intent intent1 = new Intent(getApplicationContext(), PreviousLayout1.class);
                        startActivity(intent1);
                        break ;
                    case R.id.button2:
                        Intent intent2 = new Intent(getApplicationContext(), PreviousLayout2.class);
                        startActivity(intent2);
                        break ;
                    case R.id.button3:
                        Intent intent3 = new Intent(getApplicationContext(), PreviousLayout3.class);
                        startActivity(intent3);
                        break ;
                    case R.id.button4:
                        Intent intent4 = new Intent(getApplicationContext(), PreviousLayout4.class);
                        startActivity(intent4);

                }
            }
        } ;
        
        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);

    }

}