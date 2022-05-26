package Model;

public class SubjectItem {
    int subjectId;
    int separatedClass;
    String subjectName;
    int credit;
    String division;
    String professor;
    String subjectTimetable;
    int grade;

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
