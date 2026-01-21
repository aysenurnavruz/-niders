package Week8;

public class CommissionEmployeeTest {
    public static void main(String[] args) {
        CommissionEmployee commissionEmployee =new CommissionEmployee(
                "Ayse","Navruz","222-22-2222",10000,.06
        );
        System.out.println("Employee information obtained by get methods:");
        System.out.printf("%n%s %s%n", "First name is",
                commissionEmployee.getFirstName());
        System.out.printf("%s %s%n", "Last name is",
                commissionEmployee.getLastName());
        System.out.printf("%s %s%n", "Social security number is",
                commissionEmployee.getSocialSecurityNumber());
        System.out.printf("%s %.2f%n", "Gross sales is",
                commissionEmployee.getGrossSales());
        System.out.printf("%s %.2f%n", "Commission rate is",
                commissionEmployee.getComissonRate());
        System.out.println("earning of employee:" + commissionEmployee.earnings());

        commissionEmployee.setGrossSales(5000);
        commissionEmployee.setComissonRate(.1);

        System.out.printf("%n%s:%n%n%s%n", " Updated employee information obtained by toString",
                commissionEmployee.toString());//burada tostring gri olma sebebi bunun kullanılmasına gerek olmadığı
        //yani sen burad atostring çağırmasan da ben bunu yazdırım ekrana demke istiyor ide gerek yok diyor yani

        System.out.println("earning of employee:" + commissionEmployee.earnings());

    }
}
