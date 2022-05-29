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

import com.google.android.material.bottomnavigation.BottomNavigationView;

import Controller.bottomNavigationListenerInFirstActivity;
import Model.GsonThread;
import Model.TableCell;


public class SettingActivity extends AppCompatActivity {
    String MBTI;
    StudentInfoFragment studentInfoFragment;
    InputMBTIFragment inputMBTIFragment;
    RecommendSubjectFragment recommendSubjectFragment;
    TextView textView;
    EditText editText;
    Button button;
    static final int REQUEST_SETTING_TO_QUESTION = 1; //requestCode of SettnigActivity -> MBTIQuestionActivity
    Bundle bundle;
    Button button5;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        GsonThread gsonThread = new GsonThread(getApplicationContext());
        gsonThread.start();
        bundle = new Bundle();
        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        textView = findViewById(R.id.textViewFIM_text);
        editText = findViewById(R.id.editTextFIM_input);
        button = findViewById(R.id.buttonFIM_OK);

        //액티비티 위에 돌아갈 프래그먼트 객체 생성
        studentInfoFragment = new StudentInfoFragment();
        inputMBTIFragment = new InputMBTIFragment();
        recommendSubjectFragment = new RecommendSubjectFragment();

        //시작화면 다이얼로그
        /*
        * 어플 시작 시 MBTI 검사 여부 체크하기 위해 다이얼로그 띄움
        * OK: MBTI 검사 시작 (MBTIQuestionActivity로 화면 전환)
        * Cancel: 사용자의 MBTI 요구 (INVISIBLE 되어있던 위젯들을 VISIBLE로 전환)
        *
        *
        * */
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("MBTI 검사 하시겠습니까?").setMessage("");
        //OK 클릭 시 MBTIQuestionActivity로 화면 전환
        dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(getApplicationContext(), MBTIQuestionActivity.class);
                startActivityForResult(intent, REQUEST_SETTING_TO_QUESTION);
            }
        });

        //cancel 클릭 시 위젯보이게 하기(INVISIBLE -> VISIBLE)
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {

                //숨겼던 위젯 보이게 하기
                textView.setVisibility(View.VISIBLE);
                editText.setVisibility(View.VISIBLE);
                button.setVisibility(View.VISIBLE);
            }
        });
        dialogBuilder.show();


        //ENTER 버튼 눌렀을 시
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MBTI = editText.getText().toString();
                    MBTI = MBTI.toUpperCase(); //예외(소문자로 MBTI 기입한 경우)처리를 위해 사용자가 입력한 문자열을 대문자로 처리
                //정상적으로 MBTI 기입한 경우
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



                     // 프래그먼트 화면 전환(0),

                    onFragmentChanged(0, bundle); // index 0 호출(flag의 개념)
                }
                else { //MBTI 정확하게 기입하지 않은 경우
                    Toast.makeText(getApplicationContext(),
                            "MBTI를 정확히 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void onFragmentChanged(int index, Bundle bundle) {

        if (index == 0) { //12개 질문지 선택하고 MBTI값 정확하게 받은 경우, studentInfoFragment로 이동

            //MBTI 값을 받고, 그 값을 StudentInfoFragment로 전환하면서 넘기기
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            //MBTI값 담을 Bundle 객체 생성
            bundle.putString("MBTI", MBTI); //번들에 저장

            // 변경될 프래그먼트로 번들을(데이터) 보냄
            // setArguments() 메소드를 사용하지 않으면, 받는 쪽에서 null 값으로 받음.
            studentInfoFragment.setArguments(bundle);

            //프레임 레이아웃(첫 번째 인자)에서 프래그먼트(두 번째 인자)로 변경(replace)
            transaction.replace(R.id.container, studentInfoFragment);
            transaction.commit(); //저장
        }
        //학생 정보(StudentInfoFragment에서 넘어옴) 기입 받은 경우, recommendSubjectFragment 이동

        if(index == 1) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            recommendSubjectFragment.setArguments(bundle);
            transaction.replace(R.id.container, recommendSubjectFragment);
            transaction.commit();
        }
    }


    //넘긴 액티비티에서 다시 원래로 넘어온 경우 호출되는 메소드

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_SETTING_TO_QUESTION) { //MBTIQuestionActivity에서 넘어왔을 경우
                MBTI = data.getStringExtra("MBTI"); //Intent에 담겨져 있는 MBTI 꺼냄
                onFragmentChanged(0, bundle); //Fragment 전환 메소드 호출(index == 0, StudentInfoFragment)

            }
        }
    }

}