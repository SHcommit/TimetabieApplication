package Model;

import Model.MbtiType;

public class MBTIData {

    MbtiType mbti_type[];

    String mbti_type_data[][] =
            {
                {"ENTP","ENTP\n 뭐든 잘함\n 밥 좋아함\n 방학언제하지\n그렇다면 개학은?\n고민을 좀함\n"},
                {"홍길동", "903-384-4824"},
                {"하하","394-4279-8532"},
                {"김범수","239-4935-2940"},
                {"나얼", "123-2387-7537"},
                {"갓 박효신", "394-2850-5847"},
                {"ENTP","ENTP\n 뭐든 잘함\n 밥 좋아함\n 방학언제하지\n그렇다면 개학은?\n고민을 좀함\n"},
                {"홍길동", "903-384-4824"},
                {"하하","394-4279-8532"},
                {"김범수","239-4935-2940"},
                {"나얼", "123-2387-7537"},
                {"갓 박효신", "394-2850-5847"},
                {"ENTP","ENTP\n 뭐든 잘함\n 밥 좋아함\n 방학언제하지\n그렇다면 개학은?\n고민을 좀함\n"},
                {"홍길동", "903-384-4824"},
                {"하하","394-4279-8532"},
                {"김범수","239-4935-2940"},
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
            mbti_type[i] = new MbtiType(this.mbti_type_data[i][0],this.mbti_type_data[i][1]);
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
