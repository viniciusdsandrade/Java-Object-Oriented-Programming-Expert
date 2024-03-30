package src.employee;

import java.util.Objects;

public class SalaryEmployee extends Employee {

    private double weeklySalary;

    public SalaryEmployee(int id,
                          String firstName,
                          String lastName,
                          char gender,
                          double weeklySalary) {
        super(id, firstName, lastName, gender);

        if (weeklySalary < 0) throw new IllegalArgumentException("Weekly salary must be greater than or equal to 0.");
        this.weeklySalary = weeklySalary;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double calculateWeeklyPay() {
        return weeklySalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        SalaryEmployee that = (SalaryEmployee) o;

        return Objects.equals(this.getId(), that.getId()) &&
                Objects.equals(this.getFirstName(), that.getFirstName()) &&
                Objects.equals(this.getLastName(), that.getLastName()) &&
                Objects.equals(this.getGender(), that.getGender()) &&
                Objects.equals(this.weeklySalary, that.weeklySalary);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + this.getId();
        hash *= prime + this.getFirstName().hashCode();
        hash *= prime + this.getLastName().hashCode();
        hash *= prime + this.getGender();
        hash *= prime + Double.hashCode(this.weeklySalary);

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    public String toString() {
        return "SalaryEmployee[" + super.toString() + ", weeklySalary = " + weeklySalary + "]";
    }
}
