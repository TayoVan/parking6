package transport;


public class Car extends Transport {

    public Car(String registrationNumber, String model) {
        super(registrationNumber, model, "Car");
    }

    @Override
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getInfo() {
        return String.format("%s %s", registrationNumber, model);
    }

    @Override
    public double calculateParkingFee(int hours) {

        return 10.0 * Math.max(1, hours);
    }

    @Override
    public String getVehicleCategory() {
        return "Car";
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
