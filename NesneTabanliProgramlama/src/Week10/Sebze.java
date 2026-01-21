package Week10;

import java.time.LocalDate;

public class Sebze extends Yiyecek implements Productable{
    private int tuketimGunu;
    public Sebze(String ad, double fiyat, double miktar,int tuketimGunu) {
        super(ad, fiyat, miktar);
        this.tuketimGunu=tuketimGunu;
    }

    public int getTuketimGunu() {
        return tuketimGunu;
    }

    public void setTuketimGunu(int tuketimGunu) {
        this.tuketimGunu = tuketimGunu;
    }

    public boolean isFresh(LocalDate bugun){
        int temp= bugun.compareTo(getUretimTarihi());
        if (temp> tuketimGunu)
            return false;
        else return true;
    }

    @Override
    public void production(){
        System.out.println("Sebze toprakta yetişir.");
    }
}
