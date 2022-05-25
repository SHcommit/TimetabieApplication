package project.timetable_recommend;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        TextView textView = findViewById(R.id.textView);
        EditText editText = findViewById(R.id.MBTI);
        Button button = findViewById(R.id.button2);

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("MBTI 검사 하시겠습니까?").setMessage("");
        //OK클릭 시
        dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(getApplicationContext(), MBTIQuestionActivity.class);
                startActivity(intent);
            }
        });
        //cancel 클릭 시
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                textView.setVisibility(View.VISIBLE);
                editText.setVisibility(View.VISIBLE);
                button.setVisibility(View.VISIBLE);
            }
        });
        dialogBuilder.show();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MBTI = editText.getText().toString();
                if (Character.isLowerCase(MBTI.charAt(0)))
                    MBTI = MBTI.toUpperCase();
                while(true) {
                    if(
                    MBTI == "ISFP" ||
                    MBTI ==" ISFJ" ||
                    MBTI == "ISTP" ||
                    MBTI == "ISTJ" ||
                    MBTI == "INFP" ||
                    MBTI == "INFJ" ||
                    MBTI == "INTP" ||
                    MBTI == "INTJ" ||

                    MBTI == "ESFP" ||
                    MBTI ==" ESFJ" ||
                    MBTI == "ESTP" ||
                    MBTI == "ESTJ" ||
                    MBTI == "ENFP" ||
                    MBTI == "ENFJ" ||
                    MBTI == "ENTP" ||
                    MBTI == "ENTJ")
                    {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("MBTI", MBTI);
                        startActivity(intent);
                        break;
                    }
                    else {
                        Toast.makeText(getApplicationContext(),
                                "MBTI를 정확히 입력해주세요.", Toast.LENGTH_SHORT).show();
                    }





                }

            }
        });


    }
}