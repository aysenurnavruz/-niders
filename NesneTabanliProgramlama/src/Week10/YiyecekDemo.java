package Week10;

import java.time.LocalDate;

public class YiyecekDemo {
    public static void main(String[] args) {
        LocalDate bugun = LocalDate.now();
        LocalDate uretim= LocalDate.parse("2022-06-10");
        LocalDate uretim2= LocalDate.parse("2022-06-15");
        Meyve meyve1= new Meyve("Kiraz",15,2);
        Sebze sebze1= new Sebze("Roka",10,3,14);
        sebze1.setUretimTarihi(uretim);
        Sebze sebze2= new Sebze("Ispanak",8,1,20);
        sebze2.setUretimTarihi(uretim2);
        System.out.println("ÜRETİM TÜRÜ: ");
        meyve1.production();
        sebze1.production();
        System.out.println("Bugün: " + bugun);
        System.out.println("*"+ sebze1.getAd()+"* Üretim tarihi: " + uretim);
        System.out.println("*"+sebze2.getAd()+"* Üretim tarihi: " + uretim2);

        double borc= meyve1.fiyatHesapla();
        System.out.println("Güncel tutar: " + borc +" Tl");

        if (!sebze1.isFresh(bugun)){
            System.out.println("Tarihi geçmiş *"+sebze1.getAd()+"* iade edildi.");
        }
        else
            borc= borc+ sebze1.fiyatHesapla();

        if (!sebze2.isFresh(bugun)){
            System.out.println("Tarihi geçmiş *"+sebze2.getAd()+"* iade edildi.");
        }else
            borc=borc+ sebze2.fiyatHesapla();

        System.out.println("Güncel tutar: " + borc+" TL");
    }
}
