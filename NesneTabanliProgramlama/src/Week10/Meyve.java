package Week10;

import java.time.LocalDate;

public class Meyve  extends Yiyecek implements Productable{
    public Meyve(String ad, double fiyat, double miktar) {
        super( ad, fiyat, miktar);
    }
    @Override
    public void production(){
        System.out.println("Meyve ağaçta yetişir.");
    }

}
