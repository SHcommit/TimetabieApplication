package Model;

public class SubjectItemDTO {
    int subjectId; //학번
    int separatedClass; //분반
    String subjectName; //과목명
    int credit; //학점
    String division; //이수구분
    String professor; //대표교수
    String subjectTimetable; //시간표
    int grade; // 학년
    public void setDayTime(){
        
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
