package Company;

public abstract class Employee {
    protected String name;
    protected String position;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public abstract String getName();
    public abstract String getPosition();
    public abstract String getInfo();

    public abstract void performDuty();

    public abstract double getSalary();
}
