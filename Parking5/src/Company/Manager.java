package Company;

public class Manager extends Employee {
    private double salary;

    public Manager(String name, double salary) {
        super(name, "Manager");
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}
