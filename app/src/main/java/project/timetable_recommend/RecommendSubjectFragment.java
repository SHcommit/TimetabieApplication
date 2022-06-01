package project.timetable_recommend;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import Model.MBTISubject;

public class RecommendSubjectFragment extends Fragment {
    Button button1, button2, button3, button4, button5, buttonFinish;
    TextView textView;
    SettingActivity settingActivity;
    public int searchMBTI(String MBTI){
        switch(MBTI){
            case "ISFJ" :
                return 0;
            case "ESFJ":
                return 5;
            case "ESTJ":
                return 10;
            case "ISTJ":
                return 15;
            case "ESTP":
                return 20;
            case "ESFP":
                return 25;
            case "ISTP":
                return 30;
            case "ISFP":
                return 35;
            case "INTP":
                return 40;
            case "INTJ":
                return 45;
            case "ENTJ":
                return 50;
            case "ENTP":
                return 55;
            case "ENFP":
                return 60;
            case "ENFJ":
                return 65;
            case "INFJ":
                return 70;
            case "INFP":
                return 75;
        }
        return -1;
    }
    int count;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup recommendSubjectView = (ViewGroup) inflater.inflate(R.layout.fragment_recommend_subject, container, false);
        settingActivity = new SettingActivity();
        button1 = recommendSubjectView.findViewById(R.id.buttonFRS_1);
        button2 = recommendSubjectView.findViewById(R.id.buttonFRS_2);
        button3 = recommendSubjectView.findViewById(R.id.buttonFRS_3);
        button4 = recommendSubjectView.findViewById(R.id.buttonFRS_4);
        button5 = recommendSubjectView.findViewById(R.id.buttonFRS_5);
        buttonFinish = recommendSubjectView.findViewById(R.id.buttonFRS_Finish);
        textView = recommendSubjectView.findViewById(R.id.textViewFRS_MBTI);
        MBTISubject subject = new MBTISubject();
        //settingActivity에 담겨있는 bundle객체 반환받음
        Bundle bundle = getArguments();
        String MBTI = bundle.getString("MBTI"); //번들에서 MBTI값 가져옴
        count  = searchMBTI(MBTI);
        button1.setText(""+subject.getMBTI80subjects(count++).getSubjectName());
        button2.setText(""+subject.getMBTI80subjects(count++).getSubjectName());
        button3.setText(""+subject.getMBTI80subjects(count++).getSubjectName());
        button4.setText(""+subject.getMBTI80subjects(count++).getSubjectName());
        button5.setText(""+subject.getMBTI80subjects(count++).getSubjectName());
        textView.setText(MBTI);

        //bundle에 담아놓은 studentInfoDTO(객체)를 꺼냄
        StudentInfoDTO studentInfoDTO = (StudentInfoDTO) bundle.getSerializable("studentInfoDTO");
        /*
        * Button에
        * */
        //버튼 클릭시 과목 객체를 시간표액티비티로 넘기면서 시간표액티비티로 화면전환
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingActivity.setTimeTable(subject.getMBTI80subjects(count));
                button1.setText(""+subject.getMBTI80subjects(count++).getSubjectName());
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button2.setText(""+subject.getMBTI80subjects(count++).getSubjectName());
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button3.setText(""+subject.getMBTI80subjects(count++).getSubjectName());
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setText(""+subject.getMBTI80subjects(count++).getSubjectName());
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setText(""+subject.getMBTI80subjects(count++).getSubjectName());
            }
        });

        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return recommendSubjectView;
    }
}