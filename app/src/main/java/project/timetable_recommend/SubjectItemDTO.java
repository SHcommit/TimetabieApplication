package project.timetable_recommend;

public class SubjectItemDTO {
    int subjectId;
    int separatedClass;
    String subjectName;
    int credit;
    String division;
    String professor;
    String subjectTimetable;
    int grade;
    boolean checkSubject;

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getSeparatedClass() {
        return separatedClass;
    }

    public void setSeparatedClass(int separatedClass) {
        this.separatedClass = separatedClass;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getSubjectTimetable() {
        return subjectTimetable;
    }

    public void setSubjectTimetable(String subjectTimetable) {
        this.subjectTimetable = subjectTimetable;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public boolean isCheckSubject() {
        return checkSubject;
    }

    public void setCheckSubject(boolean checkSubject) {
        this.checkSubject = checkSubject;
    }
}
