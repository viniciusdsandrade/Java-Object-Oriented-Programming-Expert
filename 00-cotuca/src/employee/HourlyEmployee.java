package src.employee;

public class HourlyEmployee extends Employee {

    private double hourlySalary;
    private int hoursWorked = 0;

    public HourlyEmployee(int id,
                          String firstName,
                          String lastName,
                          char gender,
                          double hourlySalary) {
        super(id, firstName, lastName, gender);
        this.hourlySalary = hourlySalary;
    }

    public HourlyEmployee(int id,
                          String firstName,
                          String lastName,
                          char gender,
                          double hourlySalary,
                          int hoursWorked) {
        super(id, firstName, lastName, gender);
        this.hourlySalary = hourlySalary;
        this.hoursWorked = hoursWorked;
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }


    @Override
    public double calculateWeeklyPay() {
        return hourlySalary * hoursWorked;
    }

    @Override
    public String toString() {
        return "HourlyEmployee[" + super.toString() + ", hourlySalary = " + hourlySalary + ", hoursWorked = " + hoursWorked + "]";
    }
}
