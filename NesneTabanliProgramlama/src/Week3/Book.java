package Week3;

public class Book {
    private double price;
    private String author;
    private int publishYear;
    private String name;

    public Book(String name, String author){
        this.author=author;
        this.name=name;
    }

    public Book(String name , String author, int publishYear,double price){
        this.name=name;
        this.author=author;
        this.price=price;
        this.publishYear=publishYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
