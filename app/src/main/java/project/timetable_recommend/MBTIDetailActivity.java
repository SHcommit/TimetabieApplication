package project.timetable_recommend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import Model.MbtiType;

public class MBTIDetailActivity extends AppCompatActivity {

    /**
     * @param img_name : 이미지 id값
     * @param mbti_type : 텍스트 mbti 종류 문자열
     * @param Content : 현재 화면 인스턴스 얻어오는 변수
     * @param btn_back: 뒤로가기 객체
     * @param img_thumbnail : mbti 이미지 객체
     * @param mbti_text_type : 텍스트 mbti 객체
     * @param mbti_text_introduce : mbti detail한 설명
     */
    private int       img_name;
    private String    mbti_type;
    private Context   mContext;
    private ImageView btn_back;
    private ImageView img_thumbnail;
    private TextView  mbti_text_type;
    private TextView  mbti_text_introduce;

    /**
     * 이 Activity 출력 될 때 mContent에 현재 화면 객체 얻어냄
     * getData()를 통해 intent에서 값 빼옴
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbtidetail);
        mContext = this;
        getData();

    }

    /**
     * .makeSceneTransitionAnimation func 를 통해 이 화면에 들어 왔을 때
     * setInit을 통해 위젯 변수들 객체 얻어옴
     */
    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
        setInit();
    }

    /**
     * 인텐트를 통해 이전 화면에서 키값을 통해 value 받아옴.
     */
    public void getData() {
        Intent intent = getIntent();
        img_name = (int) intent.getSerializableExtra("mbtiImage");
        mbti_type = (String) intent.getSerializableExtra("mbtiType");
    }

    /**
     * 에니메이션 작동에 의해 이 화면이 로딩 됬을 때
     * 이 클래스의 위젯멤버변수 객체 인스턴스 얻어옴
     */
    public void setInit() {
        btn_back = (ImageView) findViewById(R.id.btn_back);
        img_thumbnail = (ImageView) findViewById(R.id.mbti_image);
        mbti_text_type = (TextView) findViewById(R.id.text_mbti_title);
        mbti_text_introduce = (TextView) findViewById(R.id.text_mbti_introduce);

        img_thumbnail.setImageResource(img_name);
        mbti_text_type.setText(mbti_type);
        mbti_text_introduce.setText("mbti 더 자세한 설명!?");

        //뒤로가기 이벤트 헨들러
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_back:
                        supportFinishAfterTransition();
                        break;
                }
            }
        });
    }
}