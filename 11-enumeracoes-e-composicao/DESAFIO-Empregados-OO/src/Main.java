import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do departamento: ");
        String departmentName = scanner.nextLine();

        System.out.print("Dia do pagamento: ");
        int paymentDay = scanner.nextInt();

        System.out.print("Email: ");
        String email = scanner.next();

        System.out.print("Telefone: ");
        String phoneNumber = scanner.next();

        System.out.print("Quantos funcionários tem o departamento? ");
        int numEmployees = scanner.nextInt();

        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < numEmployees; i++) {
            System.out.println("Dados do funcionário " + (i + 1) + ":");
            System.out.print("Nome: ");
            String name = scanner.next();

            System.out.print("Salário: ");
            double salary = scanner.nextDouble();

            Employee employee = new Employee(name, salary);
            employees.add(employee);
        }

        scanner.close();


        Address address = new Address(email, phoneNumber);

        Department department = new Department(departmentName, paymentDay, address, employees);

        System.out.println("FOLHA DE PAGAMENTO:");
        System.out.println("Departamento " + department.getName() + " = R$ " + department.payroll());
        System.out.println("Pagamento realizado no dia " + department.getPayDay());
        System.out.println("Funcionários:");
        for (Employee employee : department.getEmployees()) {
            System.out.println(employee.getName());
        }
        System.out.println("Para dúvidas favor entrar em contato: " + address);

        System.out.println("Relatório completo:");
        System.out.println(department);
    }
}