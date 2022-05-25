package project.timetable_recommend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import Controller.MBTIAdapter;
import Controller.bottomNavigationListenerInSecondActivity;
import Model.MBTIData;

public class MBTIActivity extends AppCompatActivity {

    /**
     * @param bottomNavigationView : 바텀 네비게이션 바의 다음 화면을 전환하기 위해 필요한 변수
     * @param layoutManager        : 리싸이클러 뷰를 호출하기 위해 필요한 변수
     * @param adapter              : 이 변수를 통해 목록 데이터 저장, 실행
     * @param recyclerView         : 리싸이클러 뷰를 호출하기 위해 필요한 변수
     * @param mbtiData             : 성격 유형별 특징이 저장되어있는 변수
     * @param context_mbtiActivity : 현재 mbtiActivity 화면 객체를 얻을 수 있는 변수
     */
    BottomNavigationView       bottomNavigationView;
    RecyclerView.LayoutManager layoutManager;
    MBTIAdapter adapter;
    RecyclerView               recycleView;
    MBTIData                   mbtiData;
    public static Context      context_mbtiActivity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbtiactivity);

        /**
         * 변수들 초기화
         */
        context_mbtiActivity = this;
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        recycleView          = (RecyclerView)findViewById(R.id.mbti_recyclerView);
        layoutManager        = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        adapter              = new MBTIAdapter();
        mbtiData             = new MBTIData();

        //adapter에 데이터 넣기.
        inputDataToAdapter();
        recycleView.setLayoutManager(layoutManager);
        recycleView.setAdapter(adapter);

        /**
         * bottomNavigationView함수는 bottom_navigation_menu.xml에서 정의한 메뉴 네비게이션을 통해 정의한 네비게이션 바의 객체입니다.
         * 이 객체에 이벤트 헨들러를 통해 어떤 네비게이션 바의 아이콘이 클릭 됬는지 찾는 메서드 입니다.
         */
        bottomNavigationView.setOnNavigationItemSelectedListener(new bottomNavigationListenerInSecondActivity());

    }

    /**
     * 주어진 데이터를 adapter에 추가하는 func
     * 추후 recyclerView를 통해 이 데이터가 보여짐.
     */
    public void inputDataToAdapter(){
        for (int i = 0; i < this.mbtiData.getMbti_type().length; i++){
            this.adapter.addItem(this.mbtiData.getMbti_type()[i]);
        }
    }
}


