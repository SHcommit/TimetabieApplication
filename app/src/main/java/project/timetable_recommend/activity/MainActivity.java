package project.timetable_recommend.activity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import project.timetable_recommend.model.dataTransferObject.AmpmDTO;
import project.timetable_recommend.model.dataTransferObject.DayDTO;
import project.timetable_recommend.model.valueObejct.TableCellVO;
import project.timetable_recommend.activity.controller.BottomNavigationListener;
import project.timetable_recommend.R;


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

    BottomNavigationView bottomNavigationView;
    AmpmDTO ampm;
    DayDTO day; ////
    TableCellVO c;
    public static Context context_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //변수 초기화
        context_main = this;
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        c = new TableCellVO();
        findTextViewById(c);
        /**
         * bottomNavigationView함수는 bottom_navigation_menu.xml에서 정의한 메뉴 네비게이션을 통해 정의한 네비게이션 바의 객체입니다.
         * 이 객체에 이벤트 헨들러를 통해 어떤 네비게이션 바의 아이콘이 클릭 됬는지 찾는 메서드 입니다.
         */
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationListener());

        //test
        c.cell[ampm.NINE.ordinal()][day.FRIDYA.ordinal()].setText("c++\n융합과학관(24호관)-24405 ");
        c.cell[ampm.NINE.ordinal()][day.FRIDYA.ordinal()].setBackgroundColor(Color.parseColor("#da4453"));
        c.cell[ampm.TEN.ordinal()][day.FRIDYA.ordinal()].setBackgroundColor(Color.parseColor("#da4453"));
        c.cell[ampm.ELEVEN.ordinal()][day.FRIDYA.ordinal()].setBackgroundColor(Color.parseColor("#da4453"));
        c.addNeonMovingEffectInTextView(c.cell[ampm.NINE.ordinal()][day.FRIDYA.ordinal()]);
    }

    //이 함수는 tableCell의 textView의 아이디를 찾아 객체화 시켜주는 함수입니다.
    public void findTextViewById(TableCellVO tCell) {
        for (int y = 0; y < tCell.getHeight(); y++) {
            final int curY = y;
            for (int x = 0; x < tCell.getWidth(); x++) {
                final int curX = x;
                tCell.cell[curY][curX] = findViewById(tCell.cellID[curY][curX]);
            }
        }
    }
}
