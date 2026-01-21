public class PersonelApp {
    public static void main(String[] args) {
       int maxSize=100;
       PersonelHareket dizi= new PersonelHareket(maxSize);
       dizi.insert("Ayşenur","Navruz",20);
       dizi.insert("Serhat","Güven",22);
       dizi.insert("Orkun","Karabay",23);
       dizi.insert("Emre","Delibaş",38);
       dizi.insert("Mert","Demir",40);
       dizi.insert("Hatice","Şahin",50);
       dizi.insert("Gökçe","Karakurt",10);
       dizi.insert("Elifsu","Kurt",61);
       dizi.insert("Ahuzar","Tönge",32);
       dizi.insert("Lavin","Alaşan",44);
       dizi.display();

       String search="Delibaş";
       Personel found= dizi.find(search);
       if (found!=null){
           System.out.print("Bulundu");
           found.displayPersonel();
       }
       else System.out.println("Bulunamadı...");

       System.out.println("Demir, Şahin ve Kurt Siliniyor...");
       dizi.delete("Demir");
       dizi.delete("Şahin");
       dizi.delete("Kurt");
       dizi.display();

    }
}
