package project.timetable_recommend;

import java.io.Serializable;

public class StudentInfoDTO implements Serializable {
    int grade; //학년
    int majorScore; //수강할 전공 학점 합계
    int cultureScore; //수강할 교양 학점 합계
    String subjectId; //학수번호, 학수번호를 문자열로 선언한 이유: 시작번호가 0으로 시작할 수도 있기 때문

    StudentInfoDTO() {
        grade = 0;
        majorScore = 0;
        cultureScore = 0;
        subjectId = null;
    }
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getMajorScore() {
        return majorScore;
    }

    public void setMajorScore(int majorScore) {
        this.majorScore = majorScore;
    }

    public int getCultureScore() {
        return cultureScore;
    }

    public void setCultureScore(int cultureScore) {
        this.cultureScore = cultureScore;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

}
