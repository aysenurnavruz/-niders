package Sınav;

public class Meyve extends Yiyecek implements Productable{
    public Meyve(double miktar, double fiyat,String ad){
        super(miktar, fiyat, ad);
    }

    @Override
    public void production(){
        System.out.println("Meyve ağaçta yetişir.");
    }
}
