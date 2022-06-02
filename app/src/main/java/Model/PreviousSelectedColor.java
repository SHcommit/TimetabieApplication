package Model;

public class PreviousSelectedColor {
    String[] color = {
            "#F08676","#A7C970", "#7AA5E9", "#9E86FF", "#D497EE",
            "#ECC369","#7CD1C1", "#FCAA67" , "#77CA88"
    };
    int count;
    public PreviousSelectedColor(){
        count = -1;
    }
    public String getColor(){
        count++;
        if(count==9)count=0;
        return color[count];
    }
}
