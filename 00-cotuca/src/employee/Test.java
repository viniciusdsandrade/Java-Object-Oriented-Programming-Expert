package src.employee;

public class Test {
    public static void main(String[] args) {
        HourlyEmployee hourlyEmployee = new HourlyEmployee(1, "John", "Doe", 'M', 10.0, 40);
        System.out.println(hourlyEmployee);
        System.out.println("Weekly pay: " + hourlyEmployee.calculateWeeklyPay());

        SalaryEmployee salaryEmployee = new SalaryEmployee(2, "Jane", "Doe", 'F', 500.0);
        System.out.println(salaryEmployee);
        System.out.println("Weekly pay: " + salaryEmployee.calculateWeeklyPay());
    }
}
