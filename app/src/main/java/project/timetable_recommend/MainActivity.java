package project.timetable_recommend;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import Model.AMPM;
import Model.DAY;
import Model.GsonThread;
import Model.TableCell;
import Controller.bottomNavigationListenerInFirstActivity;

public class MainActivity extends AppCompatActivity {
    /**
     * @param bottomNavigationView : 네비게이션 바 다룰 수있는 객체
     * @param apam                 : 몇시인지 호출 할 수 있는 enum
     * @param day                  : 요일
     * @param TableCell            : 테이블셀 객체
     * @param context_main         : 메인 액티비티 객체 얻어올 수 있다.
     * @param requestQueue         : Volley에서 다리역할을 하는 객체
     * @param subjectResult        : Json 파싱한 데이터가 저장되어있습니다.
     */
    BottomNavigationView  bottomNavigationView; //push
    AMPM                  ampm; //android
    DAY                   day;
    TableCell             c;
    public static Context context_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //변수 초기화
        context_main          = this;
        bottomNavigationView  = findViewById(R.id.bottom_navigation);
        GsonThread gsonThread = new GsonThread(getApplicationContext());
        c                     = new TableCell();
        findTextViewById(c);
        gsonThread.start();


        /**
         * bottomNavigationView함수는 bottom_navigation_menu.xml에서 정의한 메뉴 네비게이션을 통해 정의한 네비게이션 바의 객체입니다.
         * 이 객체에 이벤트 헨들러를 통해 어떤 네비게이션 바의 아이콘이 클릭 됬는지 찾는 메서드 입니다.
         */
        bottomNavigationView.setOnNavigationItemSelectedListener(new bottomNavigationListenerInFirstActivity());
        //test
        c.cell[ampm.TEN.ordinal()][day.TUESDAY.ordinal()].setText("c++");
        c.cell[ampm.NINE.ordinal()][day.TUESDAY.ordinal()].setBackgroundColor(Color.YELLOW);
        c.cell[ampm.TEN.ordinal()][day.TUESDAY.ordinal()].setBackgroundColor(Color.YELLOW);
        c.cell[ampm.ELEVEN.ordinal()][day.TUESDAY.ordinal()].setBackgroundColor(Color.YELLOW);
    }
    //이 함수는 tableCell의 textView의 아이디를 찾아 객체화 시켜주는 함수입니다.
    public void findTextViewById(TableCell tCell){
        for(int y = 0; y < tCell.getHeight(); y++){
            final int curY = y;
            for(int x = 0; x < tCell.getWidth(); x++){
                final int curX = x;
                tCell.cell[curY][curX] = findViewById(tCell.cellID[curY][curX]);
            }
        }
    }
}