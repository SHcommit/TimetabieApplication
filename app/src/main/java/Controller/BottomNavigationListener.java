package Controller;

import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import project.timetable_recommend.MbtiActivity;
import project.timetable_recommend.MainActivity;
import project.timetable_recommend.PreviousActivity;
import project.timetable_recommend.R;
import project.timetable_recommend.SettingActivity;


/**
 * firstScene에서 navigation bar 를 누를 경우 이동할 화면 전환 작성하자.
 * 이벤트 헨들러임
 */
public class BottomNavigationListener implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.tab_timetable:
                Intent intent1 = new Intent(MainActivity.context_main.getApplicationContext(), MainActivity.class);
                Toast.makeText(MainActivity.context_main.getApplicationContext(),"여기에 앰비티아이 설명과 관련된 액티비티 호출", Toast.LENGTH_LONG).show();
                intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                System.out.println("여기에 앰비티아이 설명과 관련된 액티비티 호출");
                MainActivity.context_main.startActivity(intent1);
                return true;
            case R.id.tab_MBTI:
                Intent intent2 = new Intent(MainActivity.context_main.getApplicationContext(), MbtiActivity.class);
                Toast.makeText(MainActivity.context_main.getApplicationContext(),"여기에 앰비티아이 설명과 관련된 액티비티 호출", Toast.LENGTH_LONG).show();
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent2.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                System.out.println("여기에 앰비티아이 설명과 관련된 액티비티 호출");
                MainActivity.context_main.startActivity(intent2);
                return true;
            case R.id.tab_setting:
                Intent intent3 = new Intent(MainActivity.context_main.getApplicationContext(), SettingActivity.class);
                Toast.makeText(MainActivity.context_main.getApplicationContext(),"여기에 앰비티아이 설명과 관련된 액티비티 호출", Toast.LENGTH_LONG).show();
                System.out.println("여기에 앰비티아이 설명과 관련된 액티비티 호출");
                intent3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent3.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                MainActivity.context_main.startActivity(intent3);
                return true;
            case R.id.tab_previous:
                System.out.println("현재 재작중인 이전 시간표 추가하는 엑티비티입니다.");
                Intent intent4= new Intent(MainActivity.context_main.getApplicationContext(), PreviousActivity.class);
                Toast.makeText(MainActivity.context_main.getApplicationContext(),"이전 시간표 제작중", Toast.LENGTH_LONG).show();
                intent4.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent4.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                System.out.println("이전 시간표 제작중");
                MainActivity.context_main.startActivity(intent4);
                return true;
        }
        return false;
    }
}
