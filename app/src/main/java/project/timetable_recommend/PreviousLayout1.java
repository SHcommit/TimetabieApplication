package project.timetable_recommend;

import static Model.GsonThread.subjectList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import Controller.PreviousAdapter;

/**
 * 이곳 부터 PreviousLayout4까지 각각 이전 시간표를 보여주는 레이아웃입니다.
 * 레이아웃의 구조는 시간표와 리사이클 뷰로 나누어져있습니다.
 * 리사이클 뷰에 사용되는 아이템은 layout/previous_item에 있습니다.
 */
public class PreviousLayout1 extends AppCompatActivity {
    PreviousAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_layout1);
        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapter = new PreviousAdapter();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}