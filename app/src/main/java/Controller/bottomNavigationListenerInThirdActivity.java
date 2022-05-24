package Controller;

import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import project.timetable_recommend.R;

/**
 * 세번째 화면에서 navigation Bar 누를 경우 각 화면으로 이동하기 위해 만들어진 이벤트 헨들러
 */
public class bottomNavigationListenerInThirdActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.tab_timetable:
                System.out.println("시간표 띄워주자");
                return true;
            case R.id.tab_MBTI:
                System.out.println("이땐 mbti 띄워주자");
                return true;
            case R.id.tab_setting:
                System.out.println("이땐 현재 자기자신 화면 누르는중 따라서 변동 x");
                return true;
        }
        return false;
    }
}