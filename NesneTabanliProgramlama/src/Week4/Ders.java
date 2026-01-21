package Week4;

public class Ders {
    private String dersAdi;
    private int dersKodu;

    public Ders(String dersAdi, int dersKodu) {
        this.dersAdi = dersAdi;
        this.dersKodu = dersKodu;
    }

    public String getDersAdi() {

        return dersAdi;
    }

    public void setDersAdi(String dersAdi) {
        this.dersAdi = dersAdi;
    }

    public int getDersKodu() {
        return dersKodu;
    }

    public void setDersKodu(int dersKodu) {
        this.dersKodu = dersKodu;
    }
}
