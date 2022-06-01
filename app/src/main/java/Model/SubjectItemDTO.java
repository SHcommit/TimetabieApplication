package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SubjectItemDTO {


    int subjectId; //학번
    int separatedClass; //분반
    String subjectName; //과목명
    int credit; //학점
    String division; //이수구분
    String professor; //대표교수
    String subjectTimetable; //시간표
    int grade; // 학년
    String subjectPlace; //장소
    ArrayList<Day> subject_day = new ArrayList<Day>(); //날짜 시간 분할된 정보 (시간표 삽입용)
    public SubjectItemDTO() {
        subjectId = 0;
        separatedClass = 0;
        subjectName = "";
        credit = 0;
        division = "";
        professor = "";
        subjectTimetable = "";
        grade = 0;
        checkSubject = false;
    }

    class Day{
        public Day(int m_day, int m_time){
            day = m_day;
            time = m_time;
        }
        int day;
        int time;
        public int getDay(){
            return day;
        }
        public int getTime(){
            return time;
        }
    }
    public void DivideTimetable(){
        String[] tmp_divide1;
        tmp_divide1 = subjectTimetable.split(":");
        String tmpA = tmp_divide1[0];
        subjectPlace = tmpA;
        String tmpB = tmp_divide1[1];
        String tmp_firstTime = tmpB.split(",")[0];
        checkedDay(tmp_firstTime);
        String tmp_SecondTime = tmpB.split(",")[1];
        checkedDay(tmp_SecondTime);
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
        int index = 0;
        while(m_string.charAt(index)!=')'&&m_string!=null){
            if(m_string.charAt(index)=='('){index ++; continue;}
            else if(m_string.charAt(index)== ','){index ++; continue;}
            tmp_time.add(Character.getNumericValue(m_string.charAt(index)));
            index++;
        }
        for(int i = 0; i < tmp_time.size(); i++){
            int a = tmp_time.get(i);
            if(tmp_day != 0) {
                Day day = new Day(tmp_day, a);
                System.out.println(" 지금이니 : " + tmp_day + " 아닌가? : " + a);
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
