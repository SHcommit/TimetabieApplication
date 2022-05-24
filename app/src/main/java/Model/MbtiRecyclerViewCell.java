package Model;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;



import project.timetable_recommend.R;

public class MbtiListCell {
    private TextView mbtiType , mbtiInfo;
    public enum textType{mbti_info, mbti_type};
    public MbtiListCell(){ }

    public final int textID[] = {R.id.mbti_info, R.id.mbti_type};

    public void setTextViewID(@NonNull View itemView){
        mbtiInfo = (TextView) itemView.findViewById(textID[textType.mbti_info.ordinal()]);
        mbtiType = (TextView) itemView.findViewById(textID[textType.mbti_type.ordinal()]);
    }


    public TextView getMbtiType() {
        return mbtiType;
    }

    public void setMbtiType(TextView mbtiType) {
        this.mbtiType = mbtiType;
    }

    public TextView getMbtiInfo() {
        return mbtiInfo;
    }

    public void setMbtiInfo(TextView mbtiInfo) {
        this.mbtiInfo = mbtiInfo;
    }
}
