package project.timetable_recommend;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

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
    static final int REQUEST_SETTING = 1;

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
                startActivityForResult(intent, REQUEST_SETTING);
            }
        });


        //cancel 클릭 시
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        dialogBuilder.show();

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
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("MBTI", MBTI);
                    startActivity(intent);

                } else {
                    Toast.makeText(getApplicationContext(),
                            "MBTI를 정확히 입력해주세요.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void onFragmentChanged(int index) {
        if (index == 0) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    inputMBTIFragment).commit();
        }

  /* @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK) {
            if(requestCode == REQUEST_SETTING) {

            }
        }
    }*/
    }
}