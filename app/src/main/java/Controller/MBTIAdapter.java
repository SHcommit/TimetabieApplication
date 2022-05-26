package Controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import Model.MbtiRecyclerViewCell;
import Model.MbtiType;
import project.timetable_recommend.R;

public class MBTIAdapter extends RecyclerView.Adapter<MBTIAdapter.ViewHolder> {
    private ArrayList<MbtiType> mbtiList = new ArrayList<>();

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        MbtiRecyclerViewCell cellText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cellText = new MbtiRecyclerViewCell();
            findViewByTevtViewID(itemView, cellText);
        }

        /**
         * 외부에서 이 함수를 통해 mbtiList에 값을 집어넣음
         */
        public void setItem(MbtiType mbti){
            cellText.mbtiType.setText(mbti.getType());
            cellText.mbtiInfo.setText(mbti.getFeautre());
            cellText.mbtiImage.setImageResource(mbti.getImage());
        }
    }

    /**
     * inflater를 통해 뷰 홀더를 만든다.
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.mbti_item,parent,false);
        return new ViewHolder(itemView);
    }

    /**
     * position에 따라서 목록의 내용을 만든다.
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        MbtiType mbti = mbtiList.get(position);
        holder.setItem(mbti);
    }

    /**
     * getItemCount의 개수 만큼 목록이 생성된다.
     * 가장 중요함.
     */
    @Override
    public int getItemCount() {
        return mbtiList.size();
    }

    /**
     * mbtiCellText의 TextView mbtiType, mbtiInfo , ImageView mbtiImage 위젯의 아이디 값을 찾아 객체화 한다.
     */
    public static void findViewByTevtViewID(@NonNull View itemView, MbtiRecyclerViewCell mbtiCellText){
        mbtiCellText.mbtiType  = (TextView) itemView.findViewById(mbtiCellText.widgetID[mbtiCellText.mbti_type_num]);
        mbtiCellText.mbtiInfo = (TextView) itemView.findViewById(mbtiCellText.widgetID[mbtiCellText.mbti_info_num]);
        mbtiCellText.mbtiImage = (ImageView) itemView.findViewById(mbtiCellText.widgetID[mbtiCellText.mbti_image_num]);
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
