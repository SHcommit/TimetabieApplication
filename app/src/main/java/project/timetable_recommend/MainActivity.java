package project.timetable_recommend;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.Subject;

import Model.AMPM;
import Model.DAY;
import Model.TableCell;

public class MainActivity extends AppCompatActivity {
    /**
     * apam      : 몇시인지 호출 할 수 있는 enum
     * day       : 요일
     * TableCell : 테이블셀 객체
     * requestQueue : Volley에서 다리역할을 하는 객체
     * subjectResult : Json 파싱한 데이터가 저장되어있습니다.
     */
    AMPM ampm;
    DAY day;
    TableCell c;
    static RequestQueue requestQueue;
    BottomNavigationView bottomNavigationView;
    SubjectList subjectList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        //변수 인스턴스 생성
        c = new TableCell();
        findTextViewById(c);
        GsonThread gsonThread = new GsonThread();
        gsonThread.start();
        /**
         * bottomNavigationView함수는 bottom_navigation_menu.xml에서 정의한 메뉴 네비게이션을 통해 정의한 네비게이션 바의 객체입니다.
         * 이 객체에 이벤트 헨들러를 통해 어떤 네비게이션 바의 아이콘이 클릭 됬는지 찾는 메서드 입니다.
         */

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.tab_timetable:
                        Toast.makeText(getApplicationContext(),"여기에 시간표와 관련된 액티비티 호출", Toast.LENGTH_LONG).show();
                        System.out.println("여기에 시간표와 관련된 액티비티 호출");
                        return true;
                    case R.id.tab_MBTI:
                        Intent i = new Intent(getApplicationContext(),MBTIActivity.class);
                        Toast.makeText(getApplicationContext(),"여기에 앰비티아이 설명과 관련된 액티비티 호출", Toast.LENGTH_LONG).show();
                        System.out.println("여기에 앰비티아이 설명과 관련된 액티비티 호출");
                        startActivityForResult(i,1001);
                        return true;
                    case R.id.tab_setting:
                        Toast.makeText(getApplicationContext(),"여기에 세팅과 관련된 액티비티 호출 이때 엠비티아이 검사하고", Toast.LENGTH_LONG).show();
                        System.out.println("여기에 세팅과 관련된 액티비티 호출 이때 엠비티아이 검사하고)");
                        return true;
                }
                return false;
            }
        });



        //test
        c.cell[ampm.TEN.ordinal()][day.TUESDAY.ordinal()].setText("c++");
        c.cell[ampm.NINE.ordinal()][day.TUESDAY.ordinal()].setBackgroundColor(Color.YELLOW);
        c.cell[ampm.TEN.ordinal()][day.TUESDAY.ordinal()].setBackgroundColor(Color.YELLOW);
        c.cell[ampm.ELEVEN.ordinal()][day.TUESDAY.ordinal()].setBackgroundColor(Color.YELLOW);

    }

    //이 함수는 tableCell의 textView의 아이디를 찾아 객체화 시켜주는 함수입니다.
    public void findTextViewById(TableCell tCell){
        for(int y = 0; y < tCell.getHeight(); y++){
            final int curY = y;
            for(int x = 0; x < tCell.getWidth(); x++){
                final int curX = x;
                tCell.cell[curY][curX] = findViewById(tCell.cellID[curY][curX]);
            }
        }
    }
    //이 함수는 Volley를 이용해서 url에 있는 정보를 가져옵니다.
    class GsonThread extends Thread {
        public void run() {
            makeRequest();
        }
    }
    public void makeRequest() {
        String url = "http://192.168.0.118:80/test/Android/android.jsp";

        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("" , response);
                        processResponse(response);
                    }
                }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                Log.i("에러 발생 : ", error.getMessage());
            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }
        };
        request.setShouldCache(false);
        requestQueue.add(request);
        Log.i("요청보냄","성공!");
    }
    //이 함수는 gson을 이용해서 json객체를 파싱합니다.
    public void processResponse(String response){
        Gson gson = new Gson();
        subjectList = gson.fromJson(response, SubjectList.class);
        subjectChecked(subjectList);
    }
    //이 함수는 새로 추가한 각 과목에 boolean 추가한 것을 false로 초기화
    public void subjectChecked(SubjectList subjectList){
        int size = subjectList.subject.size();
        for(int i = 0; i<size; i++ ){
            subjectList.subject.get(i).checkSubject = false;
        }
    }
}