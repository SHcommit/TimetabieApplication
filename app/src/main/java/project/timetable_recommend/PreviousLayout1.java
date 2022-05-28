package project.timetable_recommend;

import static Model.GsonThread.subjectList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;

import Controller.PreviousAdapter;
import Model.AMPM;
import Model.DAY;
import Model.SubjectItemDTO;
import Model.TableCell;
import Model.DayTime;
/**
 * 이곳 부터 PreviousLayout4까지 각각 이전 시간표를 보여주는 레이아웃입니다.
 * 레이아웃의 구조는 시간표와 리사이클 뷰로 나누어져있습니다.
 * 리사이클 뷰에 사용되는 아이템은 layout/previous_item에 있습니다.
 */

public class PreviousLayout1 extends AppCompatActivity {
    PreviousAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    TableCell c;
    public static Context context_main;
    private ImageView btn_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_layout1);
        context_main = this;
        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        c = new TableCell();
        findTextViewById(c);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapter = new PreviousAdapter();
        ArrayList<SubjectItemDTO> insertSubject = new ArrayList<SubjectItemDTO>();
        ////////////////////
        adapter.setOnItemClickListener(
                new PreviousAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int pos) {
                        insertSubject.add(subjectList.getSubjects().get(pos));
                        int r = 0;
                        int g = 0;
                        int b = 0;
                        r = (int)(Math.random()*255);
                        g = (int)(Math.random()*255);
                        b = (int)(Math.random()*255);
                        int tmp_day = 0;
                        int tmp_time = 0;
                        for(int i = 0; i<subjectList.getSubjects().get(pos).getSubject_day().size(); i++) {
                            tmp_day = subjectList.getSubjects().get(pos).getSubject_day().get(i).getDay();
                            tmp_time = subjectList.getSubjects().get(pos).getSubject_day().get(i).getTime();
                            if(i==0&&tmp_day!=0&&tmp_time!=0) {
                                c.cell[tmp_time][tmp_day].setText(subjectList.getSubjects().get(pos).getSubjectName()); // 시간표에 추가되는 부분
                            }
                            c.cell[tmp_time][tmp_day].setBackgroundColor(Color.rgb(r,g,b));
                        }
                    }
                }
        );
        ////////////////////
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        setInit();
    }
    /*@Override
    protected void onPause() {
        super.onPause();
        saveState();
    }
    //지금까지 정한 시간표가 저장됩니다.
    protected void saveState(){
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        for(int i = 1; i<(c.getHeight()-1); i++){
            for(int j = 1; j<(c.getWidth()-1); j++){
                System.out.println(j + " , " +  j + "  : " + c.cell[i][j].getText());
                editor.putString(i + " , " + j, c.cell[i][j].getText().toString());
            }
        }
        editor.commit();
    }
    @Override
    protected void onResume() {
        super.onResume();
        restoreState();
    }
    //불러옵니다.
    protected void restoreState(){
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if(pref!=null){
            for(int i = 1; i<c.getHeight()-1; i++){
                for(int j = 1; j<c.getWidth()-1; j++){
                    System.out.println("지금이니  : "+ j);
                    if(pref.contains(i + " , " + j)) {
                        System.out.println("되냐  : "+ i + " , " + j + "   : " + pref.getString(i + " , " + j, ""));
                        c.cell[i][j].setText(pref.getString(i + " , " + j, ""));
                    }
                }
            }
        }
    }
    */
    public void findTextViewById(TableCell tCell) {
        for (int y = 0; y < tCell.getHeight(); y++) {
            final int curY = y;
            for (int x = 0; x < tCell.getWidth(); x++) {
                final int curX = x;
                tCell.cell[curY][curX] = findViewById(tCell.cellID[curY][curX]);
            }
        }
    }
    public void setInit() {
        btn_back            = (ImageView) findViewById(R.id.btn_back);
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