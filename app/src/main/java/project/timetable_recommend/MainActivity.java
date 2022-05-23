package project.timetable_recommend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String MBTI = intent.getStringExtra("MBTI");
        Toast.makeText(getApplicationContext(), "당신의 MBTI는 " + MBTI + "입니다.", Toast.LENGTH_SHORT)
                .show();

    }
}
