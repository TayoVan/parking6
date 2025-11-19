package transport;
//абстрактый класс для машин
public class Transport {
    private String registrationNumber;
    private String model;
    private String type;

    public Transport(String registrationNumber, String model, String type) {
        this.registrationNumber = registrationNumber;
        this.model = getModel();
        this.type = type;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }
}
