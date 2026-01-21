package Sınav;

import java.time.LocalDate;

public class Yiyecek {
    private LocalDate uretimTarihi;
    private String ad;
    private double fiyat;
    private double miktar;

    public Yiyecek(double miktar, double fiyat, String ad){
        this.ad=ad;
        this.fiyat=fiyat;
        this.miktar=miktar;
    }
    public void setUretimTarihi(LocalDate uretimTarihi){
        this.uretimTarihi=uretimTarihi;
    }

    public LocalDate getUretimTarihi(){
        return uretimTarihi;
    }

    public void setAd(String ad){
        this.ad=ad;
    }

    public String getAd(){
        return ad;
    }

    public double fiyatHesapla(){
        return miktar*fiyat;
    }
}
