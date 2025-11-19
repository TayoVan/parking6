package Main;
//водила получает тикет и проверка оплат
import Company.Driver;
import parking.ParkingTicket;

public class CurrentDriverHolder {
    private static Driver driver;
    private static ParkingTicket ticket;
    private static Boolean paymentConfirmed;

    public static void setDriver(Driver d) {
        driver = d;
    }

    public static Driver getDriver() {
        return driver;
    }

    public static void setTicket(ParkingTicket t) {
        ticket = t;
    }

    public static ParkingTicket getTicket() {
        return ticket;
    }

    public static void setPaymentConfirmed(Boolean confirmed) {
        paymentConfirmed = confirmed;
    }

    public static Boolean getPaymentConfirmed() {
        return paymentConfirmed;
    }
}
