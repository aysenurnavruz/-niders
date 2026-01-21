
public class Main {
    public static void main(String[] args) {
       Tree theTree = new Tree();
       theTree.insert(50);
       theTree.insert(25);
       theTree.insert(75);
       theTree.insert(12);
       theTree.insert(37);
       theTree.insert(43);
       theTree.insert(30);
       theTree.insert(33);
       theTree.insert(87);
       theTree.insert(93);
       theTree.insert(97);
        System.out.print("Minimum değer=");
        theTree.minumum().displayNode();
        System.out.print("\n Maksimum değer=");
        theTree.maximum().displayNode();

        while(true){
            System.out.println(" ");
            System.out.println("İşlem seçiniz:");
            System.out.println("Göster(g),Ekle(e),Bul(b),Sil(s),Dolaş(d),Kapat(k)");
            System.out.print("Seçiminiz:");
            int choice= getChar();
            switch (choice){
                case 'e':
                    System.out.print("Eklenecek değer:");
                    long value= getLong();
                    theTree.insert(value);
                    break;
                case 'b':
                    System.out.print("Aranacak değer:");
                    value = getLong();
                    Node found = theTree.find(value);
                    if(found != null)
            }
        }


    }
}