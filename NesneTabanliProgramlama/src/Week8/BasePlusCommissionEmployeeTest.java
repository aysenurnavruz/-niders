package Week8;

public class BasePlusCommissionEmployeeTest {
    public static void main(String[] args) {
        BasePlusCommissionEmployee basePlusCommissionEmployee= new BasePlusCommissionEmployee( "Ayse","Navruz","222-22-2222",10000,.06,300);

        System.out.println("Employee information obtained by get methods:");
        System.out.printf("%n%s %s%n", "First name is",
                basePlusCommissionEmployee.getFirstName());
        System.out.printf("%s %s%n", "Last name is",
                basePlusCommissionEmployee.getLastName());
        System.out.printf("%s %s%n", "Social security number is",
                basePlusCommissionEmployee.getSocialSecurityNumber());
        System.out.printf("%s %.2f%n", "Gross sales is",
                basePlusCommissionEmployee.getGrossSales());
        System.out.printf("%s %.2f%n", "Commission rate is",
                basePlusCommissionEmployee.getComissonRate());
        System.out.printf("%s %.2f%n", "Base salary is",
                basePlusCommissionEmployee.getBaseSalary());
        System.out.println("earning of employee:" + basePlusCommissionEmployee.earnings());

        basePlusCommissionEmployee.setGrossSales(5000);
        basePlusCommissionEmployee.setComissonRate(.1);

        System.out.printf("%n%s:%n%n%s%n", " Updated employee information obtained by toString",
                basePlusCommissionEmployee.toString());//burada tostring gri olma sebebi bunun kullanılmasına gerek olmadığı
        //yani sen burad atostring çağırmasan da ben bunu yazdırım ekrana demke istiyor ide gerek yok diyor yani

        System.out.println("earning of employee:" + basePlusCommissionEmployee.earnings());
        basePlusCommissionEmployee.toString();
    }
}
