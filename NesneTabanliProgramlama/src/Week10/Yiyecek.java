package Week10;

import java.time.LocalDate;

public class Yiyecek {
    private LocalDate uretimTarihi;
    private String ad;
    private double fiyat;
    private double miktar;

    public Yiyecek(String ad, double fiyat, double miktar){
        this.ad=ad;
        this.fiyat=fiyat;
        this.miktar=miktar;
    }

    public LocalDate getUretimTarihi() {
        return uretimTarihi;
    }

    public void setUretimTarihi(LocalDate uretimTarihi) {
        this.uretimTarihi = uretimTarihi;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    public double getMiktar() {
        return miktar;
    }

    public void setMiktar(double miktar) {
        this.miktar = miktar;
    }

    public double fiyatHesapla(){
        return miktar*fiyat;

    }
}
