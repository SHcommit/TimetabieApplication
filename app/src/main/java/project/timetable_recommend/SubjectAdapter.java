package project.timetable_recommend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.ViewHolder>{
    //테스트를 위한 ㅡ클래스

    static class test {
        Integer i;
        test(Integer i){
            this.i = i;
        }

        public Integer getI() {
            return i;
        }
    }

    LayoutInflater layoutInflater;
    ArrayList<test> list = new ArrayList<>();

    SubjectAdapter(Context context, ArrayList<test> sequence){
        this.layoutInflater = LayoutInflater.from(context);
        list = sequence;
    }

    /**
     * Todo :
     * 이제 여기서 해야 할 것은 메인 activity에서 경완이가 파싱한 json데이터를 -> setting.java에서 사용자가 교양과목까지 선택을 할 경우
     * 해당 데이터를 intent로 받아들여와서 여기서 그 것들을 받는 객체를 생성하고 데이터를 집어넣으면 된다.
     */
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView subjectTextView;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            subjectTextView = itemView.findViewById(R.id.timetableCell);
        }
    }

    /**
     * layoutInflater를 통해 뷰 홀더 만듬
     * item에 객체화 시킴
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item                     = layoutInflater.inflate(R.layout.subject_item,parent,false);

        return new ViewHolder(item);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        test t = list.get(position);
        holder.subjectTextView.setText(t.getI().toString());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void addItem(test t ){
        //추가 정의 다른 .java파일에서 어뎁터를 통해 값 널 수 수 있도록
        list.add(t);
    }

}
