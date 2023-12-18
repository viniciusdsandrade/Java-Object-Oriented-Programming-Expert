import java.util.List;

public class Department {

    private final String name;
    private final int payDay;
    private final Address address;
    private final List<Employee> employees;

    public Department(String name, int payDay, Address address, List<Employee> employees) {
        this.name = name;
        this.payDay = payDay;
        this.address = address;
        this.employees = employees;
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

    static void showReport(Department department) {
        System.out.println("\nFOLHA DE PAGAMENTO:");
        System.out.println("Departamento " + department.getName() + " = R$ " + department.payroll());
        System.out.println("Pagamento realizado no dia " + department.getPayDay());
        System.out.println("Funcionários:");
        for (Employee employee : department.getEmployees()) {
            System.out.println(employee.getName());
        }
        System.out.println("Para dúvidas favor entrar em contato: \n" + department.getAddress());
    }
}