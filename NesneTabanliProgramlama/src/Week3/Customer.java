package Week3;

public class Customer {
    private String email;
    private String name;
    private double balance;

    public Customer(String name, String email, double balance){
        this.balance=balance;
        this.email=email;
        this.name=name;
    }

    public Customer(String name, String email){
       this(name,email,0);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void buyBook(double price){
        if (balance<price){
            throw new IllegalArgumentException("Yetersiz bakiye.");
        }
        balance -= price;
    }

    public void addBalance(double amount){
        balance += amount;

    }
}
