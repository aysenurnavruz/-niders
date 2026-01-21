import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //muhakkkak recursive fonk içinde bir bitiş değeri olması lazım yoksa fonksiyon sonsuz döngüye girer
        // ve bilgisayarı kitlayebilir bitiş değeri mutlaka yazmamn lazım.
        Scanner input = new Scanner(System.in);
        /*System.out.println("Bir sayı giriniz:");
        int sayi = input.nextInt();
        int sonuc= toplam(sayi);
        System.out.println("Toplam= " +sonuc);
        input.close();*/

        System.out.print("x^y--> x:");
        int taban= input.nextInt();
        System.out.print("x^y--> y:");
        int us= input.nextInt();
        int sonuc= usAlma(taban,us);
        System.out.println(taban+"^"+us+"= " + sonuc);
        input.close();


    }
    public static int toplam(int n){
        System.out.println("Giriş: n=" +n);
        if (n==1){
            System.out.println("Dönüş: 1");
            return 1;
        }else{
            int temp=n+toplam(n-1);
            System.out.println("Dönüş: " + temp);
            return temp;
        }
    }

    public static int usAlma(int taban, int us){
        if(us==0){
            return 1;
        }else return(taban*usAlma(taban,us-1));
    }
}