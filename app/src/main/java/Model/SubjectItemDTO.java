package Model;

import static Model.GsonThread.subjectList;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;
import java.sql.Time;
import java.util.ArrayList;

public class SubjectItemDTO{
    int subjectId; //학번
    int separatedClass; //분반
    String subjectName; //과목명
    int credit; //학점
    String division; //이수구분
    String professor; //대표교수
    String subjectTimetable; //시간표
    int grade; // 학년
    String subjectPlace; //장소
    ArrayList<DayTime> subject_day = new ArrayList<DayTime>(); //날짜 시간 분할된 정보 (시간표 삽입용)

    public ArrayList<DayTime> getSubject_day() {
        return subject_day;
    }
    public void DivideTimetable(){
        String[] tmp_divide1;
        tmp_divide1 = subjectTimetable.split(":");
        String tmpA = tmp_divide1[0];
        subjectPlace = tmpA;
        String tmpB = tmp_divide1[1];
        int i = 0;
        while(tmpB.charAt(i)!=')'){
            i++;
        }
        String firstTmp = tmpB.substring(0,i);
        checkedDay(firstTmp);
        String secondTmp;
        if(i+1 < tmpB.length() && tmpB.charAt(i+1)==',') {
            secondTmp = tmpB.substring(i + 2, tmpB.length());
            checkedDay(secondTmp);
        }

    }
    protected void checkedDay(String m_string){
        int tmp_day = 0;
        ArrayList<Integer> tmp_time = new ArrayList<Integer>();
        switch(m_string.charAt(0)){
            case '월':
                tmp_day = 1;
                break;
            case '화':
                tmp_day = 2;
                break;
            case '수':
                tmp_day = 3;
                break;
            case '목':
                tmp_day = 4;
                break;
            case '금':
                tmp_day = 5;
                break;
        }
        int index = 1;
         while(index<m_string.length()&&m_string.charAt(index)!=')'){
            if(m_string.charAt(index)=='('){index ++; continue;}
            else if(m_string.charAt(index)== ','){index ++; continue;}
             tmp_time.add(Character.getNumericValue(m_string.charAt(index)));
            index++;
        }
        for(int i = 0; i < tmp_time.size(); i++){
            int a = tmp_time.get(i);
            if(tmp_day != 0) {
                DayTime day = new DayTime(tmp_day, a);
                subject_day.add(day);
            }
        }
    }

    public boolean isCheckSubject() {
        return checkSubject;
    }
    public void setCheckSubject(boolean checkSubject) {
        this.checkSubject = checkSubject;
    }
    boolean checkSubject;
    public int getSubjectId() {
        return subjectId;
    }
    public int getSeparatedClass() {
        return separatedClass;
    }
    public String getSubjectName() {
        return subjectName;
    }
    public int getCredit() {
        return credit;
    }
    public String getDivision() {
        return division;
    }
    public String getProfessor() {
        return professor;
    }
    public String getSubjectTimetable() {
        return subjectTimetable;
    }
    public int getGrade() {
        return grade;
    }

}
