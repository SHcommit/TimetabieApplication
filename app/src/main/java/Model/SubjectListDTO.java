package Model;

import java.util.ArrayList;

//GSON으로 가져온 JSON을 파싱하기 위해 만든 클래스입니다. 이곳안에 있는 ArrayList로 설정한 subject에 저장합니다.
public class SubjectListDTO {
    public ArrayList<SubjectItemDTO> getSubjects() {
        return subject;
    }
    ArrayList<SubjectItemDTO> subject = new ArrayList<SubjectItemDTO>();

}
