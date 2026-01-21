package Sınav;

import java.time.LocalDate;

public class Sebze extends Yiyecek implements Productable{
    private int tuketimGunu;
    public Sebze(double miktar, double fiyat, String ad, int tuketimGunu){
        super(miktar,fiyat,ad);
        if (tuketimGunu<0)
            System.out.println("Pozitif değer giriniz.");
        else
            this.tuketimGunu=tuketimGunu;
    }
    public int getTuketimGunu(){
        return tuketimGunu;
    }

    public void setTuketimGunu(int tuketimGunu){
        if(tuketimGunu<0){
            System.out.println("Pozitif değer giriniz.");
        }
        else this.tuketimGunu=tuketimGunu;
    }

    public boolean isFresh(LocalDate bugun){
        int temp= bugun.compareTo(getUretimTarihi());
        if (temp>tuketimGunu)
            return false;
        else return true;
    }

    @Override
    public void production(){
        System.out.println("Sebze toprakta yetişir.");
    }
}
