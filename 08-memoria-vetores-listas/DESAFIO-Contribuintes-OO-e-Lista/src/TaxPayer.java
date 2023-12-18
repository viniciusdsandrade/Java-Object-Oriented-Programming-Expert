import java.text.DecimalFormat;
import java.util.Objects;

public class TaxPayer {
    private final double salaryIncome;
    private final double servicesIncome;
    private final double capitalIncome;
    private final double healthSpending;
    private final double educationSpending;

    private static final double SALARY_TAX_RATE_1 = 0.1;
    private static final double SALARY_TAX_RATE_2 = 0.2;
    private static final double SERVICES_TAX_RATE = 0.15;
    private static final double CAPITAL_TAX_RATE = 0.2;
    private static final double MAX_DEDUCTION_RATE = 0.3;

    public TaxPayer(double salaryIncome,
                    double servicesIncome,
                    double capitalIncome,
                    double healthSpending,
                    double educationSpending) {
        this.salaryIncome = salaryIncome;
        this.servicesIncome = servicesIncome;
        this.capitalIncome = capitalIncome;
        this.healthSpending = healthSpending;
        this.educationSpending = educationSpending;
    }

    private double calculateSalaryTax() {
        if (salaryIncome < 36000) return 0;
        return salaryIncome < 60000 ? salaryIncome * SALARY_TAX_RATE_1 : salaryIncome * SALARY_TAX_RATE_2;
    }

    private double calculateServicesTax() {
        return servicesIncome * SERVICES_TAX_RATE;
    }

    private double calculateCapitalTax() {
        return capitalIncome * CAPITAL_TAX_RATE;
    }

    public double getGrossTax() {
        return formatDecimal(calculateSalaryTax() + calculateServicesTax() + calculateCapitalTax());
    }

    public double getNetTax() {
        double grossTax = getGrossTax();
        double maxDeduction = Math.min(grossTax * MAX_DEDUCTION_RATE, healthAndEducationSpending());
        return formatDecimal(grossTax - maxDeduction);
    }

    public double getTaxRebate() {
        double maxDeduction = Math.min(getGrossTax() * MAX_DEDUCTION_RATE, healthAndEducationSpending());
        return formatDecimal(maxDeduction);
    }

    private double healthAndEducationSpending() {
        return healthSpending + educationSpending;
    }

    static double formatDecimal(double value) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(value));
    }

    public double getSalaryIncome() {
        return salaryIncome;
    }
    public double getServicesIncome() {
        return servicesIncome;
    }
    public double getCapitalIncome() {
        return capitalIncome;
    }
    public double getHealthSpending() {
        return healthSpending;
    }
    public double getEducationSpending() {
        return educationSpending;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        TaxPayer that = (TaxPayer) o;

        return Double.compare(this.salaryIncome, that.salaryIncome) == 0 &&
                Double.compare(this.servicesIncome, that.servicesIncome) == 0 &&
                Double.compare(this.capitalIncome, that.capitalIncome) == 0 &&
                Double.compare(this.healthSpending, that.healthSpending) == 0 &&
                Double.compare(this.educationSpending, that.educationSpending) == 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + Objects.hashCode(this.salaryIncome);
        hash *= prime + Objects.hashCode(this.servicesIncome);
        hash *= prime + Objects.hashCode(this.capitalIncome);
        hash *= prime + Objects.hashCode(this.healthSpending);
        hash *= prime + Objects.hashCode(this.educationSpending);

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    public String toString() {
        return "{" +
                "\n  \"salaryIncome\": " + this.salaryIncome +
                ",\n  \"servicesIncome\": " + this.servicesIncome +
                ",\n  \"capitalIncome\": " + this.capitalIncome +
                ",\n  \"healthSpending\": " + this.healthSpending +
                ",\n  \"educationSpending\": " + this.educationSpending +
                "\n}";
    }
}