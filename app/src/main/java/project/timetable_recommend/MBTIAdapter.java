package project.timetable_recommend;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.security.DomainCombiner;
import java.util.ArrayList;

import Model.MbtiType;

public class MBTIAdapter extends RecyclerView.Adapter<MBTIAdapter.ViewHolder> {
    private ArrayList<MbtiType> mbtiList = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType){
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.mbti_item,viewGroup,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position){
        MbtiType mbti = mbtiList.get(position);
        viewHolder.setItem(mbti);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView mbtiType , mbtiInfo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mbtiInfo = itemView.findViewById(R.id.mbti_info);
            mbtiType = itemView.findViewById(R.id.mbti_type);
        }
        public void setItem(MbtiType mbti){
            mbtiType.setText(mbti.getType());
            mbtiInfo.setText(mbti.getFeautre());
        }
    }

    public void addItem(MbtiType mbti ){
        mbtiList.add(mbti);
    }
    public void setItems(ArrayList<MbtiType> list){
        this.mbtiList = list;
    }

    public MbtiType getItem(int position){
        return mbtiList.get(position);
    }
    public void setItem(int position, MbtiType item){
        mbtiList.set(position,item);
    }

}
