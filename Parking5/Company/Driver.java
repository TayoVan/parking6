package Company;

import transport.Transport;

public class Driver extends Employee {
    private Transport vehicle;

    public Driver(String name, Transport vehicle) {
        super(name, "Driver");
        this.vehicle = vehicle;
    }

    public Transport getVehicle() {
        return vehicle;
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
        return String.format("Driver: %s, vehicle=%s", name, vehicle.getInfo());
    }

    @Override
    public void performDuty(Object context) {
        System.out.println("Driver " + name + " заїджає");
    }

    @Override
    public double getSalary() {
        return 0;
    }
}
