package project.timetable_recommend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import Controller.MBTIAdapter;
import Controller.bottomNavigationListenerInFirstActivity;
import Model.MBTIData;
import Model.MbtiType;
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;

public class MBTIActivity extends AppCompatActivity implements MBTIAdapter.OnItemClickListener{

    /**
     * @param bottomNavigationView : 바텀 네비게이션 바의 다음 화면을 전환하기 위해 필요한 변수
     * @param layoutManager        : 리싸이클러 뷰를 호출하기 위해 필요한 변수
     * @param adapter              : 이 변수를 통해 목록 데이터 저장, 실행
     * @param recyclerView         : 리싸이클러 뷰를 호출하기 위해 필요한 변수
     * @param mbtiData             : 성격 유형별 특징이 저장되어있는 변수
     * @param context_mbtiActivity : 현재 mbtiActivity 화면 객체를 얻을 수 있는 변수
     *
     * https://developer.android.com/training/transitions/start-activity?hl=ko#java
     * 내가 사용하려는 트렌지션 animation은 롤리팝버전이후로 지원됨...
     */
    BottomNavigationView       bottomNavigationView;
    RecyclerView.LayoutManager layoutManager;
    MBTIAdapter adapter;
    RecyclerView recyclerView;
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
        recyclerView         = (RecyclerView)findViewById(R.id.mbti_recyclerView);
        layoutManager        = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        adapter              = new MBTIAdapter();
        mbtiData             = new MBTIData();

        //adapter에 데이터 넣기.
        inputDataToAdapter();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new AlphaInAnimationAdapter(adapter));
        //add recycler view animation
        AlphaInAnimationAdapter alphaInAnimationAdapter = new AlphaInAnimationAdapter(adapter);
        alphaInAnimationAdapter.setDuration(1000);
        alphaInAnimationAdapter.setInterpolator(new OvershootInterpolator());
        alphaInAnimationAdapter.setFirstOnly(false);
        recyclerView.setAdapter(new ScaleInAnimationAdapter(alphaInAnimationAdapter));
        adapter.setOnItemClickListener(new MBTIAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position)  {
                Intent intent = new Intent(MBTIActivity.this, MBTIDetailActivity.class);
                MbtiType mbti = adapter.getItem(position);

                intent.putExtra("mbtiType", mbti.getType());
                intent.putExtra("mbtiImage",mbti.getImage());
                View mbtiView = v.findViewById(R.id.mbti_image);
                //View mbtiTextView = v.findViewById(R.id.mbti_type);
                //Pair<View, String> mbti_imag = Pair.create(mbtiView, mbtiView.getTransitionName());

        /*ActivityOptionsCompat option =
                ActivityOptionsCompat.makeSceneTransitionAnimation(this, mbtiView,
                        Pair.create(mbtiView, "mbtiImg"),
                        Pair.create(mbtiTextView, "mbtiType"));
           튜플 안먹힘
           우선 튜플 안먹히니까 nbtiType transtionName빼자 추후 되는거 알면 다시 xml에 추가
       */
                ActivityOptionsCompat option =
                        ActivityOptionsCompat.makeSceneTransitionAnimation(MBTIActivity.this, mbtiView, "mbtiImg");
                startActivity(intent, option.toBundle());
            }
        }) ;
        /**
         * bottomNavigationView함수는 bottom_navigation_menu.xml에서 정의한 메뉴 네비게이션을 통해 정의한 네비게이션 바의 객체입니다.
         * 이 객체에 이벤트 헨들러를 통해 어떤 네비게이션 바의 아이콘이 클릭 됬는지 찾는 메서드 입니다.
         */
        bottomNavigationView.setOnNavigationItemSelectedListener(new bottomNavigationListenerInFirstActivity());

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

    @Override
    public void onItemClick(View v, int position)  {
        Intent intent = new Intent(MBTIActivity.this, MBTIDetailActivity.class);
        MbtiType mbti = adapter.getItem(position);

        intent.putExtra("mbtiType", mbti.getType());
        intent.putExtra("mbtiImage",mbti.getImage());
        View mbtiView = v.findViewById(R.id.mbti_image);
        //View mbtiTextView = v.findViewById(R.id.mbti_type);
        //Pair<View, String> mbti_imag = Pair.create(mbtiView, mbtiView.getTransitionName());

        /*ActivityOptionsCompat option =
                ActivityOptionsCompat.makeSceneTransitionAnimation(this, mbtiView,
                        Pair.create(mbtiView, "mbtiImg"),
                        Pair.create(mbtiTextView, "mbtiType"));
           튜플 안먹힘
           우선 튜플 안먹히니까 nbtiType transtionName빼자 추후 되는거 알면 다시 xml에 추가
       */
        ActivityOptionsCompat option =
                ActivityOptionsCompat.makeSceneTransitionAnimation(this, mbtiView, "mbti_image_detail");
        startActivity(intent, option.toBundle());
    }

}


