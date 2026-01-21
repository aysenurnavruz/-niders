package Week9;
//bir hatam var anlamadım ama çözmedimde bu hata hız asla artımıyor ve sanırım sonsuz döngğye giriyor
public class Vehicle {
    protected String make;
    private double speed;
    protected int maxSpeed;
    private double distance;

    public Vehicle(String make, double speed, int maxSpeed, double distance) {
        this.make = make;
        this.speed = speed;
        this.maxSpeed = maxSpeed;
        this.distance = distance;
    }
    public Vehicle(String make, double speed, int maxSpeed) {
        this(make,speed,maxSpeed,0);
    }

    public void speedUp(int amount){
        double oldSpeed=getSpeed();
        setSpeed(oldSpeed+amount);
        double newSpeed = getSpeed();
        double nesDistance= (oldSpeed+newSpeed)/2;
        setDistance(getDistance()+nesDistance);
    }

    public void speedDown(int amount){
        double oldSpeed=getSpeed();
        setSpeed(oldSpeed-amount);
        double newSpeed = getSpeed();
        double nesDistance= (oldSpeed+newSpeed)/2;
        setDistance(getDistance()+nesDistance);


    }

    public void showSpeed(){
        System.out.println(make+"marka aracın hızı:" + getSpeed()+
                " aracın kat ettiği mesafe:"+getDistance());
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        if (speed<0){
            this.speed=0;
        }
        if (speed>maxSpeed){
           this.speed=maxSpeed;
        }

    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        if (distance<0){
            this.distance=0;
        }
        this.distance = distance;
    }
}
