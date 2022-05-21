package Model;

import android.widget.TextView;

/**
 * type로 mbti 알아내고
 * feature에 특징 써줌.
 */
public class MbtiType {
    public String type;
    public String feautre;

    public MbtiType(String type , String feautre){
        this.type = type;
        this.feautre = feautre;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFeautre() {
        return feautre;
    }

    public void setFeautre(String feautre) {
        this.feautre = feautre;
    }
}
