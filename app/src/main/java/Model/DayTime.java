package Model;

import android.os.Parcel;
import android.os.Parcelable;

public class DayTime implements Parcelable {
        public DayTime(int m_day, int m_time){
            day = m_day;
            time = m_time;
        }
        int day;
        int time;

    protected DayTime(Parcel in) {
        day = in.readInt();
        time = in.readInt();
    }

    public static final Creator<DayTime> CREATOR = new Creator<DayTime>() {
        @Override
        public DayTime createFromParcel(Parcel in) {
            return new DayTime(in);
        }

        @Override
        public DayTime[] newArray(int size) {
            return new DayTime[size];
        }
    };

    public int getDay() {
        return day;
    }
    public int getTime() {
        return time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(day);
        parcel.writeInt(time);
    }
}
