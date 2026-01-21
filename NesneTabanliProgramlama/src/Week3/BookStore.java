package Week3;

public class BookStore {
    public static void main(String[] args) {
        Book[] books = {
                new Book("Clean Code","Robert C. Martin", 2008,600),
                new Book("Effective Java", "Joshua Bloch", 2017,1200),
                new Book("E-Kitap", "Gökhan Azizoğlu")};

        System.out.println("\nKitaplar başarıyla eklendi!");

        Customer[] customers= {
                new Customer("Gökhan Azizoğlu", "gazizoglu@cumhuriyet.edu.tr",1000),
                new Customer("Ayşenur Navruz","aysenurnavruz@gmail.com")
        };

        System.out.println("\nMüşteriler başarıyla eklendi!");
        customers[1].addBalance(3000);

        double bookStoreBalance =0;

        //müşteri arama
        String email = "gazizoglu@cumhuriyet.edu.tr";
        Customer foundCustomer = null;
        for (Customer c : customers){
            if (c.getEmail().equals(email)){
                foundCustomer = c;
                break;
            }
        }
        if (foundCustomer==null){
            throw new IllegalArgumentException("Müşteri bulunamadı!");
        }
        //kitap arama

        String bookName = "Clean Code";
        Book foundBook = null;
        for (Book b : books) {
            if (b.getName().equalsIgnoreCase(bookName)) {
                foundBook = b;
                break;
            }
        }
        if (foundBook ==null){
            throw new IllegalArgumentException("Kitap bulunamadı!");
        }


        try {
            foundCustomer.buyBook(foundBook.getPrice());
            bookStoreBalance+= foundBook.getPrice();
            System.out.printf("%n%s kişisi %.2f TL fiyatlık %s kitabını başarıyla satın aldı.",foundCustomer.getName(),foundBook.getPrice(),foundBook.getName());
        }catch (IllegalArgumentException e){
            System.out.println("\n"+e.getMessage());
        }
        System.out.println();
        System.out.println("Kitap Mağazası Bakiye:" + bookStoreBalance);



    }
}
