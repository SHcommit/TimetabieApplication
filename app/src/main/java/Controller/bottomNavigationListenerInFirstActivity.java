package Controller;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import project.timetable_recommend.MBTIActivity;
import project.timetable_recommend.MainActivity;
import project.timetable_recommend.R;
import project.timetable_recommend.SettingActivity;


/**
 * firstScene에서 navigation bar 를 누를 경우 이동할 화면 전환 작성하자.
 * 이벤트 헨들러임
 */
public class bottomNavigationListenerInFirstActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch(item.getItemId()){
            case R.id.tab_timetable:
                System.out.println("이땐 현재 자기자신 화면 누르는중 따라서 변동 x");
                return true;
            case R.id.tab_MBTI:
                intent = new Intent(MainActivity.context_main.getApplicationContext(), MBTIActivity.class);
                Toast.makeText(MainActivity.context_main.getApplicationContext(),"여기에 앰비티아이 설명과 관련된 액티비티 호출", Toast.LENGTH_LONG).show();
                System.out.println("여기에 앰비티아이 설명과 관련된 액티비티 호출");
                MainActivity.context_main.startActivity(intent);
                return true;
            case R.id.tab_setting:
                intent = new Intent(MainActivity.context_main.getApplicationContext(), SettingActivity.class);
                Toast.makeText(MainActivity.context_main.getApplicationContext(),"여기에 앰비티아이 설명과 관련된 액티비티 호출", Toast.LENGTH_LONG).show();
                System.out.println("여기에 앰비티아이 설명과 관련된 액티비티 호출");
                MainActivity.context_main.startActivity(intent);
                return true;
        }
        return false;
    }
}
