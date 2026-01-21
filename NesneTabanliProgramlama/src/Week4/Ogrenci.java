package Week4;

public class Ogrenci {
    private String ad;
    private String bolum;
    private String girisYili;
    private String ogrNo;
    private double gano;
    private int bolumKodu;

    private static int count;

    private  Ders[] dersler;

    public Ogrenci(String ad, String girisYili, double gano, String bolum,int bolumKodu) {
        if (gano<0 || gano>4)
            throw new IllegalArgumentException("Gano 0 ile 4 arasında olmalıdır.");
        this.ad = ad;
        this.bolum = bolum;
        this.gano = gano;
        this.girisYili=girisYili;
        this.bolumKodu=bolumKodu;


    }
    public Ogrenci(){
        this(null,"2020",0,null,123);
    }

    public Ogrenci(String ad, String bolum){
        this(ad,"2020",0,bolum,123);
    }
    public Ogrenci(Ogrenci ogrenci){
        this(ogrenci.ad, ogrenci.girisYili, ogrenci.gano, ogrenci.bolum, ogrenci.bolumKodu);
    }


    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public String getGirisYili() {
        return girisYili;
    }

    public void setGirisYili(String girisYili) {
        this.girisYili = girisYili;
    }

    public String getOgrNo() {
        return ogrNo;
    }

    public void setOgrNo(String ogrNo) {
        this.ogrNo = ogrNo;
    }

    public double getGano() {
        return gano;
    }

    public void setGano(double gano) {
        this.gano = gano;
    }

    public int getBolumKodu() {
        return bolumKodu;
    }

    public void setBolumKodu(int bolumKodu) {
        this.bolumKodu = bolumKodu;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Ogrenci.count = count;
    }

    public Ders[] getDersler() {
        return dersler;
    }

    public void setDersler(Ders[] dersler) {
        this.dersler = dersler;
    }

    public String ogrenciNoOlustur(){
        count++;//count 1
        if (count<10)
            return (girisYili+bolumKodu+"00"+count);
        else if (count<100)
            return (girisYili+bolumKodu+"0"+count);
        else return (girisYili+bolumKodu+count);
    }

    public double harcHesapla(int dersSayisi){
        return dersSayisi*120;
    }

    public double harcHesapla(int dersSayisi, int uzatmaYili){
        return dersSayisi*uzatmaYili*120;
    }

    public double harcHesapla(){
        if (bolumKodu ==123)
            return 0;
        else return 1000;
    }
}
