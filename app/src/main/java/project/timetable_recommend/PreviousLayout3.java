package project.timetable_recommend;

import static Model.GsonThread.subjectList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import Controller.PreviousAdapter;
import Model.TableCell;

public class PreviousLayout3 extends AppCompatActivity {
    PreviousAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    TableCell c;
    private ImageView btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_layout3);
        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapter = new PreviousAdapter();
        c = new TableCell();
        findTextViewById(c);
        ////////////////////
        adapter.setOnItemClickListener(
                new PreviousAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int pos) {
                        System.out.println(""+subjectList.getSubjects().get(pos).getSubjectName());
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