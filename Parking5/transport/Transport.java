package transport;

public abstract class Transport {
    protected String registrationNumber;
    protected String model;
    protected String type;

    public Transport(String registrationNumber, String model, String type) {
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.type = type;
    }

    public abstract String getRegistrationNumber();
    public abstract String getModel();
    public abstract String getType();

    public abstract String getInfo();
    public abstract double calculateParkingFee(int hours); // розрахунок
    public abstract String getVehicleCategory();
}
