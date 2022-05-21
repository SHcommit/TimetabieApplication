package project.timetable_recommend;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.security.auth.Subject;

import Model.AMPM;
import Model.DAY;
import Model.TableCell;

public class MainActivity extends AppCompatActivity {
    /**
     * apam      : 몇시인지 호출 할 수 있는 enum
     * day       : 요일
     * TableCell : 테이블셀 객체
     */
    AMPM ampm;
    DAY day;
    TableCell c;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //변수 인스턴스 생성
        c = new TableCell();
        findTextViewById(c);


        /**
         * bottomNavigationView함수는 bottom_navigation_menu.xml에서 정의한 메뉴 네비게이션을 통해 정의한 네비게이션 바의 객체입니다.
         * 이 객체에 이벤트 헨들러를 통해 어떤 네비게이션 바의 아이콘이 클릭 됬는지 찾는 메서드 입니다.
         */

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.tab_timetable:
                        Toast.makeText(getApplicationContext(),"여기에 시간표와 관련된 액티비티 호출", Toast.LENGTH_LONG).show();
                        System.out.println("여기에 시간표와 관련된 액티비티 호출");
                        return true;
                    case R.id.tab_MBTI:
                        Intent i = new Intent(getApplicationContext(),MBTIActivity.class);
                        Toast.makeText(getApplicationContext(),"여기에 앰비티아이 설명과 관련된 액티비티 호출", Toast.LENGTH_LONG).show();
                        System.out.println("여기에 앰비티아이 설명과 관련된 액티비티 호출");
                        startActivityForResult(i,1001);
                        return true;
                    case R.id.tab_setting:
                        Toast.makeText(getApplicationContext(),"여기에 세팅과 관련된 액티비티 호출 이때 엠비티아이 검사하고", Toast.LENGTH_LONG).show();
                        System.out.println("여기에 세팅과 관련된 액티비티 호출 이때 엠비티아이 검사하고)");
                        return true;
                }
                return false;
            }
        });



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