package Model;

import android.os.Parcel;
import android.os.Parcelable;
import Model.SubjectItemDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.security.auth.Subject;

public class MainActivitySubjectInfo implements Parcelable {
    ArrayList<SubjectItemDTO> subjectItemDTOS;
    public ArrayList<SubjectItemDTO> getSubjectItemDTOS() {
        return subjectItemDTOS;
    }

    public MainActivitySubjectInfo(ArrayList<SubjectItemDTO> subjectItemDTO){
        this.subjectItemDTOS = subjectItemDTO;
    }
    protected MainActivitySubjectInfo(Parcel in) {
        subjectItemDTOS = in.createTypedArrayList(SubjectItemDTO.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(subjectItemDTOS);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MainActivitySubjectInfo> CREATOR = new Creator<MainActivitySubjectInfo>() {
        @Override
        public MainActivitySubjectInfo createFromParcel(Parcel in) {
            return new MainActivitySubjectInfo(in);
        }

        @Override
        public MainActivitySubjectInfo[] newArray(int size) {
            return new MainActivitySubjectInfo[size];
        }
    };


}
