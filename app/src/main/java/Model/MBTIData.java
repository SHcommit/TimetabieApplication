package Model;

import Model.MbtiType;
import project.timetable_recommend.R;

public class MBTIData {

    MbtiType mbti_type[];

    public int imageID[] = {R.drawable.intj,R.drawable.intp,R.drawable.entj,R.drawable.entp,
            R.drawable.infj,R.drawable.infp,R.drawable.enfj,R.drawable.enfp,
            R.drawable.istj,R.drawable.isfj,R.drawable.estj,R.drawable.esfj,
            R.drawable.istp,R.drawable.isfp,R.drawable.estp,R.drawable.esfp};

    String mbti_type_data[][] =
            {
                {"INTJ", "용의주도한 전략가"," 디테일한 특징"},
                {"INTP", "논리적인 사색가", " 디테일한 특징"},
                {"ENTJ", "대담한 통솔자", "ㅁ"},
                {"ENTP", "뜨거운 논쟁을 즐기는 변론가", "ㅁ"},
                {"INFJ", "선의의 옹호자", "ㅁ"},
                {"INFP", "열정적인 중재자", "ㅁ"},
                {"ENFJ", "정의로운 사회 운동가", "ㅁ"},
                {"ENFP", "재기발랄한 활동가", "ㅁ"},
                {"ISTJ", "청렴결백한 논리주의자", "ㅁ"},
                {"ISFJ", "용감한 수호자", "ㅁ"},
                {"ESTJ", "엄격한 관리자", "ㅁ"},
                {"ESFJ", "사교적인 외교관", "ㅁ"},
                {"ISTP", "만능 재주꾼", "ㅁ"},
                {"ISFP", "호기심 많은 예술가", "ㅁ"},
                {"ESTP", "모험을 즐기는 사업가", "ㅁ"},
                {"ESFP", "자유로운 영혼의 연예인", "ㅁ"},
            };

    /**
     * 생성자 함수
     * 여기에 inputMbtiData() func 를 통해 mbti_type에 데이터를 집어 넣는다.
     */
    public MBTIData(){
        mbti_type = new MbtiType[mbti_type_data.length];
        this.inputMbtiData();
    }

    /**
     * mbti_type에 데이터를 저장하는 func
     */
    public void inputMbtiData(){
        for (int i = 0; i< this.mbti_type_data.length; i ++){
            mbti_type[i] = new MbtiType(this.mbti_type_data[i][0],this.mbti_type_data[i][1],this.mbti_type_data[i][2], this.imageID[i]);
        }
    }

    /******************************************** 멤버변수 호출하는 함수들 ***************************************************/


    public MbtiType[] getMbti_type() {
        return mbti_type;
    }

    public void setMbti_type(MbtiType[] mbti_type) {
        this.mbti_type = mbti_type;
    }

    public String[][] getMbti_type_data() {
        return mbti_type_data;
    }

    public void setMbti_type_data(String[][] mbti_type_data) {
        this.mbti_type_data = mbti_type_data;
    }
}
