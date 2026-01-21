package Week8;

public class BasePlusCommissionEmployee extends CommissionEmployee {


    private double baseSalary;//base salary per week

    public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber,
                                      double grossSales, double comissonRate, double baseSalary) {
        super(firstName, lastName, socialSecurityNumber, grossSales, comissonRate);

        if (baseSalary<0.0){
            throw new IllegalArgumentException(
                    "Base salary must be >=0.0"
            );
        }

        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary<0.0){
            throw new IllegalArgumentException(
                    "Base salary must be >=0.0"
            );
        }
        this.baseSalary = baseSalary;
    }
    public double earnings(){
        return baseSalary+super.earnings();
    }

    @Override
    public String toString() {
        return String.format(" %s %s%n%s: %.2f",
                "base-salaried",
                super.toString(),
                "baseSalary",
                baseSalary);


    }
}
