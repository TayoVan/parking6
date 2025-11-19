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
}
