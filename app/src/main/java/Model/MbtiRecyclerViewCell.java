package Model;

import android.widget.TextView;

import project.timetable_recommend.R;

public class MbtiRecyclerViewCell {

    public final int textID[] = {R.id.mbti_info, R.id.mbti_type};

    public TextView mbtiType , mbtiInfo;

    public int mbti_info_num ;
    public int mbti_type_num ;

    public MbtiRecyclerViewCell(){
        mbti_info_num = 0;
        mbti_type_num = 1;
    }



}

