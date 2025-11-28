package Company;

import parking.ParkingLot;

public class Manager extends Employee {
    private double salary;

    public Manager(String name, double salary) {
        super(name, "Manager");
        this.salary = salary;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPosition() {
        return position;
    }

    @Override
    public String getInfo() {
        return String.format("Manager: %s, salary=%.2f", name, salary);
    }

    @Override
    public double getSalary() {
        return salary;
    }


    public void performDuty(ParkingLot lot) {
        System.out.println("Manager провіряє паркінг чи всі на своїх:");
        lot.showAllSlots();
    }

    public void performDuty(Employee driver) {
        System.out.println("Manager прівіріє дрівера: " + driver.getInfo());
    }
}
