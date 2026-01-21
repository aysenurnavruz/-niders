package Week9;

public class Automobile extends Vehicle{
    public Automobile(String make, int speed, int maxSpeed) {
        super(make, speed, maxSpeed);
    }

    //hız artırma
    public void speedUp(){
        super.speedUp(15);
    }
    //hız azaltma
    public void speedDown(){
        super.speedDown(15);
    }

    //korna sesi
    public void horn(){
        System.out.println(make+ "marka otomobilin kornası çalıyor: DÜÜT DÜÜT");
    }
}
