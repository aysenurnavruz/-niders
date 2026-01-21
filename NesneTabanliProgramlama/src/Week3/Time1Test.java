package Week3;



//tarih ve zaman bilgisi için sınıflar yaratmak yerine java API kullanılabilir javanın Time isimli halihazırda bir sınıfı var zaten
public class Time1Test {
    public static void main(String[] args) {
        Time1 time = new Time1();

        displayTime("After time object is created",time);
        System.out.println();

        time.setTime(13,27,6);
        displayTime("After calling set time" , time);
        System.out.println();

        try{
            time.setTime(99,99,99);
        }catch (IllegalArgumentException e){
            System.out.printf("Exception: %s%n%n", e.getMessage());
        }
        displayTime("After calling setTime with invalid values" , time);

    }

//normalde bu metodu public yapabilirdik ama bu metotda bu sınıf dışında ihtiyacımız olmadığından private yapıyoruz
    //private metotlara sadece o mettoların tanımlandığı sınıftaki metotlar erişebilir
    //bu yüzden bu metotlara diğer metotların bir işlevini gerçekleştirdikleri için"helper/utility method" denir.
    private static void displayTime(String header, Time1 t){
        System.out.printf("%s%nUniversal time: %s%nStandard Time: %s%n", header,t.toUniversalString(),t.toString());

    }



}
