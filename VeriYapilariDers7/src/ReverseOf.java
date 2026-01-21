import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;
//genel olarak temel fonksiyonlarda substring(0,3) mesela 0 dahil 3 dahil değildir yani 0. indisi al 3.indisi alma şeklinde genelde böyle olur ilki dahil diğeri dahil değil olur.

public class ReverseOf {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Metin Giriniz:");
        String metin = input.nextLine();
        System.out.println(reverseof(metin));
    }
    public static String reverseof(String metin){
        if (metin.length()==0){
            return metin;
        }else{
            int n = metin.length();
            return metin.charAt(n-1)+reverseof(metin.substring(0,n-1));
        }

    }


}
