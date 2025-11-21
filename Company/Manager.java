package Company;

import parking.ParkingLot;
import Main.CurrentDriverHolder;

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
    public void performDuty(Object context) {
        if (context instanceof ParkingLot) {
            ParkingLot lot = (ParkingLot) context;
            System.out.println("Manager провіряє паркінг чи всі на своїх:");
            lot.showAllSlots();
        } else if (context instanceof CurrentDriverHolder) {
            CurrentDriverHolder holder = (CurrentDriverHolder) context;
            System.out.println("Manager прівіріє дрівера: " + holder.getDriver());
        } else {
            System.out.println("Manager на спец місії");
        }
    }

    @Override
    public double getSalary() {
        return salary;
    }
}
