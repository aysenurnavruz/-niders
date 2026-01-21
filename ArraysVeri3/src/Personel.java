public class Personel {
    private String soyadi;
    private String adi;
    private int yasi;

    public Personel(String ad, String soyad,int yas) {
        soyadi=soyad;
        adi=ad;
        yasi=yas;
    }

    public void displayPersonel(){
        System.out.print("Ad:" + adi);
        System.out.print("Soyad:" + soyadi);
        System.out.println("Yaş:" + yasi);
    }


    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public int getYasi() {
        return yasi;
    }

    public void setYasi(int yasi) {
        this.yasi = yasi;
    }
}
