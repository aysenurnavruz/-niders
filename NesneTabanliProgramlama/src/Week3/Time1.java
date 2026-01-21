package Week3;

public class Time1 {
    private int hour;
    private int minute;
    private int second;

    public void setTime(int hour, int minute, int second){
        if (hour <0 || hour >= 24 || minute <0 || minute >= 60 || second<0 || second >= 60){
            throw new IllegalArgumentException("Hour, minute and/or second was out of range");
        }//burada throw ile değilde hata mesajını sout ile verseydim hata esajını verip değişknelerini
        //alt satırda yinede setleyecekti throw ile verdiğimde hata mesajını verdi ve çalışmadı setlemedi.
        this.hour = hour;
        this.minute = minute;
        this.second = second;

    }

    public String toUniversalString(){//24 saatlik dilim için
        return String.format("%02d:%02d:%02d",hour,minute,second);
    }

    public String toString(){//12 saalik dilim için
        return String.format("%d:%02d:%02d %s",
                ((hour == 0 || hour ==12) ? 12 : hour % 12),
                //if(hour == 0 || hour == 12) hour=12; else hour%=12; yukarıdaki satırın yapmak istediği şey aslında
                minute,second,(hour<12? "AM":"PM"));

    }

}
