package Week4;

public class OgrenciTest {
    public static void main(String[] args) {
        System.out.println(Ogrenci.getCount());//nesne yok

        Ogrenci ogr1 = new Ogrenci(); //count 1
        Ogrenci ogr2 = new Ogrenci("Ahmet","Elektrik Mühendisliği"); //count 2
        Ogrenci ogr3 = new Ogrenci("Ayşe","Makine Mühendisliği");
        Ogrenci ogr4 = new Ogrenci("Elif","2019",1.98,"Bilgisayar Mühendisliği",
                123);
        Ogrenci ogr5= new Ogrenci(ogr4);

        System.out.println("Öğrenci bilgileri");
        System.out.println("ogr1 " + ogr1.getAd()+" "+ ogr1.getBolum()+" "
                + ogr1.ogrenciNoOlustur()+" " + ogr1.getGano());
        System.out.println("ogr2 " + ogr2.getAd() + " " + ogr2.getBolum() + " "
                + ogr2.ogrenciNoOlustur() + " " + ogr2.getGano() );
        System.out.println("ogr3 " + ogr3.getAd() + " " + ogr3.getBolum() + " "
                + ogr3.ogrenciNoOlustur() + " " + ogr3.getGano() );
        System.out.println("ogr4 " + ogr4.getAd() + " " + ogr4.getBolum() + " "
                + ogr4.ogrenciNoOlustur() + " " + ogr4.getGano() );

        System.out.println("Ogr4 harc:" +ogr4.harcHesapla());

        Ders ders1= new Ders("Matematik",101);
        Ders ders2= new Ders("Fizik",102);
        Ders ders3= new Ders("Matematik",103);
        Ders[] dersler={ders1,ders2, ders3};

        ogr2.setDersler(dersler);
        System.out.println("Ogr2 harc : "+ ogr2.harcHesapla(dersler.length,2));
        ogr4.setBolumKodu(141);
        System.out.println("Ogr4 harc: " + ogr4.harcHesapla());

        System.out.println("Ogr5 harc: " + ogr5.harcHesapla());


    }
}
