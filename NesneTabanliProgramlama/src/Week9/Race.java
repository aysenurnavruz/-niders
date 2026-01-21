package Week9;

import java.util.Random;

public class Race {
    public static void main(String[] args) {

        //araçları tanımladık
        Vehicle tesla= new Automobile("Tesla",0,220);
        Vehicle togg= new Automobile("TOGG",0,250);
        Vehicle yamaha= new Motorcycle("Yamaha",0,200);
        //araçları diziye attık, piste aldık
        Vehicle[] raceCars = new Vehicle[3];
        raceCars[0]=tesla;
        raceCars[1]=togg;
        raceCars[2]=yamaha;

        //piste uzunluk tanımlayalım
        int runwayLength=1000;

        //yarış devam ediyor muyu takip edecek bir değişken tanımlayalım
        boolean isRaceContinue = true;
        Vehicle winner=null;

        //yarış devam ettiği sürece işlem yapmaya devam et
        while(isRaceContinue){
            for (Vehicle vehicle:raceCars) {
                //1-30 arası rastgele hız miktarı belirleyelim
                int randomSpeedAmount= (int) (Math.random()*30) +1;
                vehicle.speedUp(randomSpeedAmount);
                vehicle.showSpeed();

                //aracın kat ettiği mesafe pist uzunluğunu geçerse yarışı bitirmemiz lazım
                if (vehicle.getDistance()>runwayLength){
                    winner= vehicle;
                    isRaceContinue=false;
                    break;

                }

            }
        }
        System.out.println("----------------------------");

        //kazanan araç otomobilse korna çalsın
        if (winner instanceof Automobile){
            ((Automobile) winner).horn();

        }
        //kazanan araç motorsa ön kaldırsın
        if (winner instanceof Motorcycle){
            ((Motorcycle) winner).frontlift();

        }
        System.out.println("Kaznaan araç: "+ winner.make);
    }
}
