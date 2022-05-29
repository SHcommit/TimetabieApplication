package Model;

public class PreviousSelectedColor {
    String[] color = {"#65FFBA", "#B2CDFF", "#84799F", "#FFAAFF", "#FFAA28", "#9EF048", "#FF9DFF", "#3CFBFF"};
    public PreviousSelectedColor(){

    }
    public String getColor(){
        int random = (int) (Math.random() * 8);
        return color[random];
    }
}
