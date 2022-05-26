package Controller;

import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import project.timetable_recommend.MBTIActivity;
import project.timetable_recommend.MainActivity;
import project.timetable_recommend.R;

/**
 * SecondScene에서 navigation bar 누를 경우 이동 할 수 있는 첫번째, 세번째 Activity로 전환하기 위해 만들어진 이벤트 헨들러.
 *
 */
public class bottomNavigationListenerInSecondActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.tab_timetable:
                //현재 화면(mbti)를 끄고 원래 화면으로 돌아간다.
                System.out.println("시간표 띄워주자");
                ((MBTIActivity)(MBTIActivity.context_mbtiActivity)).finish();
                return true;

            case R.id.tab_MBTI:
                System.out.println("이땐 현재 자기자신 화면 누르는중 따라서 변동 x");
                return true;

            case R.id.tab_setting:
                System.out.println("여기에 세팅과 관련된 액티비티 호출 이때 엠비티아이 검사하고)");
                return true;
        }
        return false;
    }
}

