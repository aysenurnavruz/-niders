public class HighArrayApp {
    public static void main(String[] args) {
        int maxSize=100;
        HighArray dizi=new HighArray(maxSize);
        dizi.insert(77);
        dizi.insert(99);
        dizi.insert(44);
        dizi.insert(55);
        dizi.insert(88);
        dizi.insert(22);
        dizi.insert(01);
        dizi.insert(11);
        dizi.insert(66);
        dizi.insert(33);

        dizi.display();

        int searchkey=35;
       if (dizi.find(searchkey))
           System.out.println(searchkey + " Bulundu");
       else
           System.out.println(searchkey + " Bulunamadı");

       dizi.delete(00);
       dizi.delete(66);
       dizi.delete(99);
       dizi.display();
    }
}
