package project.timetable_recommend;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class RecommendSubjectFragment extends Fragment {
    Button button1, button2, button3, button4, button5, buttonFinish;
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup recommendSubjectView = (ViewGroup) inflater.inflate(R.layout.fragment_recommend_subject, container, false);
        button1 = recommendSubjectView.findViewById(R.id.buttonFRS_1);
        button2 = recommendSubjectView.findViewById(R.id.buttonFRS_2);
        button3 = recommendSubjectView.findViewById(R.id.buttonFRS_3);
        button4 = recommendSubjectView.findViewById(R.id.buttonFRS_4);
        button5 = recommendSubjectView.findViewById(R.id.buttonFRS_5);
        buttonFinish = recommendSubjectView.findViewById(R.id.buttonFRS_Finish);
        textView = recommendSubjectView.findViewById(R.id.textViewFRS_MBTI);

        //settingActivity에 담겨있는 bundle객체 반환받음
        Bundle bundle = getArguments();
        String MBTI = bundle.getString("MBTI"); //번들에서 MBTI값 가져옴

        //bundle에 담아놓은 studentInfoDTO(객체)를 꺼냄
        StudentInfoDTO studentInfoDTO = (StudentInfoDTO) bundle.getSerializable("studentInfoDTO");

        return recommendSubjectView;
    }
}