package Week9;

public class Motorcycle extends Vehicle{
    public Motorcycle(String make, int speed, int maxSpeed) {
        super(make, speed, maxSpeed);
    }

    public void speedUp(){
        super.speedUp(10);
    }

    public void speedDown(){
        super.speedDown(10);
    }

    //motorsikletin ön kaldırma davranışı
    public void frontlift(){
        System.out.println(make+"marka motosiklet ön tekeri kaldırınca devrildi!");
        //speed superclass içerisinde private oalrak tanımlandığı için speed= 0 şeklinde erişemeyiz.
        setSpeed(0);//motor devrildiği için aracın hızı 0 oldu
    }
}
