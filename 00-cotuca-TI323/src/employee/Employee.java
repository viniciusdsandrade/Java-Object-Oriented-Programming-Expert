package src.employee;

import java.util.Objects;

public abstract class Employee {

    private final int id;
    private final String firstName;
    private final String lastName;
    private final char gender;

    public Employee(int id, String firstName, String lastName, char gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;

        if (gender != 'M' && gender != 'F' && gender != 'm' && gender != 'f')
            throw new IllegalArgumentException("Gênero inválido. O gênero deve ser 'M', 'm', 'F' ou 'f'.");

        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public char getGender() {
        return gender;
    }

    public abstract double calculateWeeklyPay();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        Employee that = (Employee) o;

        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.firstName, that.firstName) &&
                Objects.equals(this.lastName, that.lastName) &&
                Objects.equals(this.gender, that.gender);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + this.id;
        hash *= prime + this.firstName.hashCode();
        hash *= prime + this.lastName.hashCode();
        hash *= prime + Character.hashCode(this.gender);

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    public String toString() {
        return "Employee[id = " + id + ",name = " + getName() + ", gender = " + gender + "]";
    }
}
