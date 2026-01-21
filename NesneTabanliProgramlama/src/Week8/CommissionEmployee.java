package Week8;

public class CommissionEmployee extends Object{
    //burada başına extends object yazmak zorunda değiliz burad bu default olarak object clasını miras alacak.
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;
    private double grossSales;//gross weekly sales
    private double comissonRate;// comission percentage

    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber,
                              double grossSales, double comissonRate) {
        if (grossSales<0.0){
            throw new IllegalArgumentException("Gross sales must be >= 0.0");
        }
        if (comissonRate<=0.0 || comissonRate>=1.0){
            throw new IllegalArgumentException(
                    "Comission rate must be >0.0 and >1.0");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.grossSales = grossSales;
        this.comissonRate = comissonRate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(double grossSales) {
        if (grossSales<0.0){
            throw new IllegalArgumentException("Gross sales must be >=0.0");
        }
        this.grossSales = grossSales;
    }

    public double getComissonRate() {
        return comissonRate;
    }

    public void setComissonRate(double comissonRate) {
        if (comissonRate<=0.0 || comissonRate>=1.0){
            throw new IllegalArgumentException(
                    "Comission rate must be >0.0 and >1.0");
        }
        this.comissonRate = comissonRate;
    }

    public double earnings(){return getComissonRate() * getGrossSales();}//kazancı

    @Override//bunu yazma sebebim bunun bir superclass metodu olduğunu ama benim bununiçeriğini değiştirdiğimi burada ve
    // bu metodun kullanılması gerektiğini gçsteriyor.
    public String toString() {
        return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f",
                "commission employee", firstName,lastName,
                "social security number", socialSecurityNumber,
                "gross sales", grossSales,
                "commission rate", comissonRate);
    }
}
