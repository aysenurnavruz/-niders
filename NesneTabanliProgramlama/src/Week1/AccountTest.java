package Week1;

import java.util.Scanner;

public class AccountTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Account myAccount = new Account();

        System.out.println("İlk değer:" + myAccount.getName());
        System.out.println("İlk değer:" + myAccount.getId());

        System.out.print("İsim ve Id giriniz:");
        String theName = input.nextLine();//nextline-->\n karakterş arar next() " " boşluk arar
        myAccount.setName(theName);
        //System.out.print("Id giriniz:");
        int theId = input.nextInt();
        myAccount.setId(theId);

        System.out.println();

        System.out.println("İsim değeri:" + myAccount.getName());
        System.out.println("Id değeri:" + myAccount.getId());
    }
}


