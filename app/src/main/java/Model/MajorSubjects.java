package Model;

import java.util.ArrayList;

public class MajorSubjects{
public ArrayList<SubjectItemDTO> getEssential_Subject() {
        return essential_Subject;
        }
public ArrayList<SubjectItemDTO> getSelect_Subject() {
        return select_Subject;
        }
        ArrayList<SubjectItemDTO> essential_Subject = new ArrayList<SubjectItemDTO>();
        ArrayList<SubjectItemDTO> select_Subject = new ArrayList<SubjectItemDTO>();
        }