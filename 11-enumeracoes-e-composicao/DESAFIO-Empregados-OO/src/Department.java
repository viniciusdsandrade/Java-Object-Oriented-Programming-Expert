import java.util.List;

public class Department {

    private String name;
    private int payDay;
    private Address address;
    private List<Employee> employees;

    public Department(String name, int payDay, Address address, List<Employee> employees) {
        this.name = name;
        this.payDay = payDay;
        this.address = address;
        this.employees = employees;
    }

    public Department(){

    }


    private void addEmployee(Employee employee) {
        employees.add(employee);
    }

    private void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    double payroll() {
        double payroll = 0;
        for (Employee employee : employees) {
            payroll += employee.getSalary();
        }
        return payroll;
    }

    public String getName() {
        return name;
    }

    public int getPayDay() {
        return payDay;
    }

    public Address getAddress() {
        return address;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    private static void showReport(Department department) {
        System.out.println("Department: " + department.name);
        System.out.println("Payroll: " + department.payroll());
        System.out.println("Payday: " + department.payDay);
        System.out.println("Address: " + department.address);
        System.out.println("Employees: ");
        for (Employee employee : department.employees) {
            System.out.println(employee.getName() + " - " + employee.getSalary());
        }
        System.out.println("Para dúvidas favor entrar em contato: " + department.address);
    }
}