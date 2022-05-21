package project.timetable_recommend;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MBTIQuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbtiquestion);

        //간결성을 위해 위젯의 id를 배열로 생성, id는 final int형
        final int[] TextViewId = {R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4, R.id.textView5,
                R.id.textView6, R.id.textView7, R.id.textView8, R.id.textView9, R.id.textView10, R.id.textView11,
                R.id.textView12};
        final int[] yButtonId = {R.id.Y1, R.id.Y2, R.id.Y3, R.id.Y4, R.id.Y5, R.id.Y6, R.id.Y7, R.id.Y8, R.id.Y9,
                R.id.Y10, R.id.Y11, R.id.Y12};
        final int[] nButtonId = {R.id.N1, R.id.N2, R.id.N3, R.id.N4, R.id.N5, R.id.N6, R.id.N7, R.id.N8, R.id.N9,
                R.id.N10, R.id.N11, R.id.N12};
        final int[] groupId = {R.id.group1, R.id.group2, R.id.group3, R.id.group4, R.id.group5, R.id.group6, R.id.group7, R.id.group8,
                R.id.group9, R.id.group10, R.id.group11, R.id.group12};

        //배열로 위젯 생성
        TextView[] textViews = new TextView[12]; //질문 배열
        RadioButton[] yButtons = new RadioButton[12]; //yes 배열
        RadioButton[] nButtons = new RadioButton[12]; //no 배열
        RadioGroup[] groups = new RadioGroup[12]; //라디오그룹 배열

        //for문을 이용해 MBTI질문 textView12개, Yes RadioButton 12개, No RadioButton 12개 초기화
        for (int i = 0; i < 12; i++) {
            textViews[i] = findViewById(TextViewId[i]);
            yButtons[i] = findViewById(yButtonId[i]);
            nButtons[i] = findViewById(nButtonId[i]);
            groups[i] = findViewById(groupId[i]);
        }

        for (int i = 0; i < 12; i++) {
            groups[i].setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    if(checkedId == yButtonId[i] || checkedId == nButtonId[i]) {

                    }
                }
            });
        }


    }
}