package project.timetable_recommend.Model;

public class PreviousSelectedColorVO {
    String[] color = {
            "#89216B", "#ad5389", "#a8c0ff", "#3f2b96", "#dd1818", "#333333",
            "#4e54c8", "#8f94fb", "#6C5B7B","#355C7D","#C06C84","#bc4e9c",
            "#40E0D0", "#FF8C00", "#FF0080","#3E5151","#DECBA4","#11998e",
            "#38ef7d", "#108dc7", "#ef8e38","#FC5C7D","#6A82FB","#FC466B",
            "#3F5EFB", "#c94b4b", "#4b134f","#cc5333","#23074d","#fffbd5",
            "#b20a2c", "#302b63", "#0f0c29","#00b09b","#D3CCE3","#3C3B3F",
            "#ffc0cb", "#800080", "#0575E6","#00F260","#f7b733","#F3F9A7"
    };
    public PreviousSelectedColorVO(){

    }
    public String getColor(){
        int random = (int) (Math.random() * 8);
        return color[random];
    }
}
