package Sınav;

import java.time.LocalDate;

public class YiyecekDemo {
    public static void main(String[] args) {
        LocalDate bugun=LocalDate.now();
        LocalDate uretim1=LocalDate.parse("2022-06-10");
        LocalDate uretim2=LocalDate.parse("2022-06-15");
        Meyve meyve=new Meyve(2,20,"Kiraz");
        Sebze sebze1= new Sebze(3,10,"Roka",14);
        sebze1.setUretimTarihi(uretim1);
        Sebze sebze2= new Sebze(1,8,"Ispamak",20);
        sebze2.setUretimTarihi(uretim2);
        System.out.println("Üretim Türü:");
        meyve.production();
        sebze1.production();

        System.out.println("*"+ sebze1.getAd()+"*" +"Üretim Tarihi: "+ sebze1.getUretimTarihi());
        System.out.println("*"+ sebze2.getAd()+"*"+ "Üretim Tarihi: " + sebze2.getUretimTarihi());

        double odenecek= meyve.fiyatHesapla();
        System.out.println("Güncel Tutar:"+ odenecek+" TL");

        if (!sebze1.isFresh(bugun)){
            System.out.println("Tarihi geçmiş *"+ sebze1.getAd()+"* iade edildi.");
        }else
            odenecek=odenecek+ sebze1.fiyatHesapla();
        if (!sebze2.isFresh(bugun))
            System.out.println("Tarihi geçmiş *"+sebze2.getAd()+"* iade edildi.");
        else
            odenecek= odenecek+sebze2.fiyatHesapla();

        System.out.println("Güncel tutar:" + odenecek+ "TL");

    }
}
