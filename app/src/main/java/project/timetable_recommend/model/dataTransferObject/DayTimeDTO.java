package project.timetable_recommend.Model;

public class DayTimeDTO {
        public DayTimeDTO(int m_day, int m_time){
            day = m_day;
            time = m_time;
        }
        int day;
        int time;

    public int getDay() {
        return day;
    }
    public int getTime() {
        return time;
    }
}
