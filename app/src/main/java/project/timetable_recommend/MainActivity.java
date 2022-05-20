package project.timetable_recommend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.tab_timetable:
                        Toast.makeText(getApplicationContext(),"여기에 시간표와 관련된 액티비티 호출", Toast.LENGTH_LONG).show();
                        System.out.println("여기에 시간표와 관련된 액티비티 호출");
                        return true;
                    case R.id.tab_MBTI:
                        Toast.makeText(getApplicationContext(),"여기에 앰비티아이 설명과 관련된 액티비티 호출", Toast.LENGTH_LONG).show();
                        System.out.println("여기에 앰비티아이 설명과 관련된 액티비티 호출");
                        return true;
                    case R.id.tab_setting:
                        Toast.makeText(getApplicationContext(),"여기에 세팅과 관련된 액티비티 호출 이때 엠비티아이 검사하고", Toast.LENGTH_LONG).show();
                        System.out.println("여기에 세팅과 관련된 액티비티 호출 이때 엠비티아이 검사하고)");
                        return true;
                }
                return false;
            }
        });
    }
}