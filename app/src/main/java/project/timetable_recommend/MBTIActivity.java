package project.timetable_recommend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import Model.MbtiType;

public class MBTIActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    LinearLayoutManager layoutManager;
    RecyclerView               recycleView;
    MBTIAdapter                adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbtiactivity);

        recycleView = (RecyclerView)findViewById(R.id.mbti_recyclerView);
        layoutManager = new LinearLayoutManager(this);

        adapter       = new MBTIAdapter();

        //여기에 이제 mbti별 특징? 클래스 만들어서 너줘야함
        String str[][]                           = {
                {"양승현","001-3943-583"},
                {"홍길동", "903-384-4824"},
                { "하하","394-4279-8532"},
                {"김범수","239-4935-2940"},
                {"나얼", "123-2387-7537"},
                {"갓 박효신", "394-2850-5847"}
        };

        MbtiType mbtiFeautre[]                           = new MbtiType[str.length];
        //for (int i = 0; i< str.length; i ++){
          //  mbtiFeautre[i] = new MbtiType(str[i][0],str[i][1]);
        //}

        for (int i = 0; i < mbtiFeautre.length; i++){
            adapter.addItem(new MbtiType(str[i][0],str[i][1]));
        }
        recycleView.setLayoutManager(layoutManager);
        recycleView.setAdapter(adapter);


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
                        Toast.makeText(getApplicationContext(),"시간표에서 startresultfor...호출했으니까 이걸 반환해줘야함", Toast.LENGTH_LONG).show();
                        System.out.println("시간표에서 startresultfor...호출했으니까 이걸 반환해줘야함");
                        return true;
                    case R.id.tab_MBTI:

                        Toast.makeText(getApplicationContext(),"현재화면 누르는중", Toast.LENGTH_LONG).show();
                        System.out.println("현재화면 누르는중");

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