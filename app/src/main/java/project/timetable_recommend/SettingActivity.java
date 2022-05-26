package project.timetable_recommend;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class SettingActivity extends AppCompatActivity {
    String MBTI;
    StudentInfoFragment studentInfoFragment;
    InputMBTIFragment inputMBTIFragment;

    static final int REQUEST_SETTING_TO_QUESTION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        TextView textView = findViewById(R.id.textView);
        EditText editText = findViewById(R.id.MBTI);
        Button button = findViewById(R.id.button2);

        studentInfoFragment = new StudentInfoFragment();
        inputMBTIFragment = new InputMBTIFragment();


        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("MBTI 검사 하시겠습니까?").setMessage("");
        //OK클릭 시
        dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(getApplicationContext(), MBTIQuestionActivity.class);
                startActivityForResult(intent, REQUEST_SETTING_TO_QUESTION);
            }
        });



        //cancel 클릭 시
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        dialogBuilder.show();


        //ENTER 버튼 눌렀을 시
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MBTI = editText.getText().toString();
                if (Character.isLowerCase(MBTI.charAt(0)))
                    MBTI = MBTI.toUpperCase();


                if (MBTI.equals("ISFP") ||
                        MBTI.equals("ISFJ") ||
                        MBTI.equals("ISTP") ||
                        MBTI.equals("ISTJ") ||
                        MBTI.equals("INFP") ||
                        MBTI.equals("INFJ") ||
                        MBTI.equals("INTP") ||
                        MBTI.equals("INTJ") ||

                        MBTI.equals("ESFP") ||
                        MBTI.equals("ESFJ") ||
                        MBTI.equals("ESTP") ||
                        MBTI.equals("ESTJ") ||
                        MBTI.equals("ENFP") ||
                        MBTI.equals("ENFJ") ||
                        MBTI.equals("ENTP") ||
                        MBTI.equals("ENTJ")) {
                    onFragmentChanged(0); // index 0 호출

                } else {
                    Toast.makeText(getApplicationContext(),
                            "MBTI를 정확히 입력해주세요.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    public void onFragmentChanged(int index) {
        if (index == 0) { //12개 질문지 선택하고 MBTI값 받은 경우

            /*getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    studentInfoFragment).commit();*/

            //MBTI 데이터 받아서 그 데이터를 StudentInfoFragment로 전환하면서 넘기기
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            //프레그먼트끼리 rfgName넘기기 위한 bundle
            Bundle bundle = new Bundle();
            bundle.putString("MBTI", MBTI); //번들에 데이터 저장

            //변경될 프래그먼트로 번들(데이터) 보냄
            // 반드시 setArguments() 메소드를 사용하지 않으면, 받는 쪽에서 null 값으로 받음.
            studentInfoFragment.setArguments(bundle);

            //프레임 레이아웃에서 프레그먼트 studentInfoFragment로 변경(replace)해라
            transaction.replace(R.id.container, studentInfoFragment);
            transaction.commit(); //저장해라 commit
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_SETTING_TO_QUESTION) { //MBTIQuestionActivity에서 넘어왔을 경우
                MBTI = data.getStringExtra("MBTI"); //Intent에 담겨져 있는 MBTI 꺼냄
                onFragmentChanged(0); //Fragment 전환 메소드 호출(index == 0, StudentInfoFragment)
            }
        }
    }

}