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
    private Context mContext;
    private ImageView btn_back;
    private ImageView img_thumbnail;
    private TextView mbti_text_type;
    private TextView mbti_text_introduce;
    private int      img_name;
    private String   mbti_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbtidetail);
        Toast.makeText(this,"상세 뷰 보여짐",Toast.LENGTH_SHORT).show();
        mContext = this;
        getData();

    }

    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
        setInit();
    }
    public void getData() {
        Intent intent = getIntent();
        img_name = (int) intent.getSerializableExtra("mbtiImage");
        mbti_type = (String) intent.getSerializableExtra("mbtiType");
    }
    public void setInit() {
        btn_back = (ImageView) findViewById(R.id.btn_back);
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
        img_thumbnail = (ImageView) findViewById(R.id.mbti_image);
        Glide.with(mContext)
                .load(img_name)
                .into(img_thumbnail);
        //여기서 문제있네
        //mbti_text_type = (TextView) findViewById(R.id.mbti_type);
        //mbti_text_type.setText(mbti_type);
       // mbti_text_introduce = (TextView) findViewById(R.id.text_mbti_introduce);
       // mbti_text_introduce.setText("mbti 더 자세한 설명!?");

    }
}