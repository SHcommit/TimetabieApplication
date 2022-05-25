package Model;

import android.widget.TextView;

/**
 * type로 mbti 알아내고
 * feature에 특징 써줌.
 */
public class MbtiType {
    public String type;
    public String feature;
    public String detailFeature;
    public int image;

    public MbtiType(String type , String feautre, String detailFeature, int image){
        this.type    = type;
        this.feature = feautre;
        this.detailFeature = detailFeature;
        this.image   = image;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFeautre() {
        return feature;
    }

    public void setFeautre(String feautre) {
        this.feature = feautre;
    }
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getDetailFeature() {
        return detailFeature;
    }

    public void setDetailFeature(String detailFeature) {
        this.detailFeature = detailFeature;
    }
}
