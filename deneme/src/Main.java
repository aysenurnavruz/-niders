import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
       /* System.out.println("İlk sayıyı giriniz:");
        int sayi1= input.nextInt();
        System.out.println("İkinci sayıyı giriniz:");
        int sayi2= input.nextInt();*/

        int [] dizi={8,-5,4,3};
        String entoplam=enbuyuktoplam(dizi);
        System.out.println(entoplamn uzu);



        /*int sonuc2= ebob_v2(sayi1,sayi2);
        System.out.println("Ebobv2:" +sonuc2);*/


       /* int toplam=0;
        for (int i = 0; i < dizi.length; i++) {
            toplam+=dizi[i];
        }
        System.out.println(toplam);
        toplam=toplam+5;
        System.out.println(toplam);*/





    }

    public static String enbuyuktoplam(int[] dizi){
        int bas=0 , son=0;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < dizi.length-1 ; i++) {
            for (int j = i+1; j < dizi.length ; j++) {
                if ((dizi[i]+dizi[j])>max){
                    bas=i;
                    son=j;
                    max=dizi[i]+dizi[j];
                }
            }

        }
        String sonuc= bas +","+ son;
        return sonuc;
    }
    public static boolean binarySearch(int [] dizi, int aranan){
        int bas=0, son=dizi.length-1;
        while(bas<=son){
           int ortanca=(bas+son)/2;
            if(aranan== dizi[ortanca])
                return true;
            else if (aranan<dizi[ortanca]) {
                son=ortanca-1;

            }else
                bas=ortanca+1;

        }
        return false;


    }
    public static int lineerArama(int[] dizi, int sayi){
        int i=0;
        while(i< dizi.length && dizi[i]!=sayi){
            i+=1;
        }
        if (i< dizi.length)
            return i;
        else
            return -1;
    }
    public static boolean asal_mi(int sayi){
        boolean donus= true;
        for (int i = 2; i <sayi-1; i++) {
            if (sayi%i==0) {
                donus = false;
                break;
            }
        }
        return donus;


    }
    public static int ebob( int sayi1, int sayi2){
        int min;
        if( sayi1<sayi2)
            min=sayi1;
        else
            min=sayi2;
        while (min>0){
            if (sayi1%min == 0 && sayi2%min==0)
                return min;
            else
                min=min-1;

        }
        return 1;
    }
    public static int ebob_v2(int sayi1, int sayi2){
        int kalan;
        while(sayi2!=0){
            kalan= sayi1%sayi2;
            sayi1=sayi2;
            sayi2=kalan;
        }
        return sayi1;

    }
    public static int enkucukmesafe (int [] dizi){
        int enkucukfark=Integer.MAX_VALUE;
        for (int i = 0; i < dizi.length-1; i++) {
            for (int j = i+1; j < dizi.length ; j++) {
                int fark= dizi[i]-dizi[j];
                fark
                        = Math.abs(fark);
                if (fark<enkucukfark)
                    enkucukfark=fark;

            }

        }
        return enkucukfark;

    }



}