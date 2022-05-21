package project.timetable_recommend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.security.auth.Subject;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    SubjectAdapter       adapter;
    RecyclerView         recycleView;
    GridLayoutManager    layoutManager;
    static final int     numberOfColumns = 6;
    ArrayList<SubjectAdapter.test> myList =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (Integer i = 0; i< 50; i++){
            SubjectAdapter.test t = new SubjectAdapter.test(i);
            myList.add(t);
        }

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        /**
         * bottomNavigationView함수는 bottom_navigation_menu.xml에서 정의한 메뉴 네비게이션을 통해 정의한 네비게이션 바의 객체입니다.
         * 이 객체에 이벤트 헨들러를 통해 어떤 네비게이션 바의 아이콘이 클릭 됬는지 찾는 메서드 입니다.
         */
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


        recycleView          = (RecyclerView) findViewById(R.id.grid_recyclerView);
        layoutManager        = new GridLayoutManager(this,numberOfColumns);
        adapter              = new SubjectAdapter(this,myList);


        recycleView.setLayoutManager(layoutManager);
        recycleView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }


}