package Week3;

import java.sql.Time;

public class Time2 {
    private int hour;
    private int minute;
    private int second;

    public Time2(){
        //String name = ":";this burada olmalıdır
        this(0,0,0);
        //String name = ":"; buraya yazdığımda herhangi bir hata almam.
    }
    public Time2(int hour){
        //String name = ":"; bi constructorda ilk ifade this ifadesi olmalı ondan önce bir iafde olursa hata mesajı verir
        this(hour,0,0);
    }
    public Time2(int hour, int minute){
        this(hour,minute,0);
    }

    public Time2(int hour,int minute,int second){
        if (hour<0 ||hour >=24){
            throw new IllegalArgumentException("Hour must to be 0-23");
        }
        if (minute<0 || minute>= 60){
            throw new IllegalArgumentException("Minute must to be 0-59");
        }
        if (second<0 || second>=60){
            throw new IllegalArgumentException("Second must to be 0-59");
        }

        this.hour=hour;
        this.minute=minute;
        this.second=second;
    }

    public Time2(Time2 time){
        this(time.hour , time.minute , time.second);
    }

    public void setTime(int hour, int minute , int second){
        if (hour<0 ||hour >=24){
            throw new IllegalArgumentException("Hour must to be 0-23");
        }
        if (minute<0 || minute>= 60){
            throw new IllegalArgumentException("Minute must to be 0-59");
        }
        if (second<0 || second>=60){
            throw new IllegalArgumentException("Second must to be 0-59");
        }

        this.hour=hour;
        this.minute=minute;
        this.second=second;

    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if (hour<0 ||hour >=24){
            throw new IllegalArgumentException("Hour must to be 0-23");
        }
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        if (minute<0 || minute>= 60){
            throw new IllegalArgumentException("Minute must to be 0-59");
        }
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        if (second<0 || second>=60){
            throw new IllegalArgumentException("Second must to be 0-59");
        }
        this.second = second;
    }

    public String toUniversalString(){
        return String.format(
                "%02d:%02d:%02d" , getHour(),getMinute(),getSecond());
    }

    public String toString(){
        return String.format("%d:%02d:%02d %s",
                ((getHour()==0 || getHour()==12) ? 12 : getHour() % 12),
        getMinute(),getSecond(),(getHour()<12 ? "AM" : "PM"));
    }
}
