package Main;

import Company.Driver;
import parking.ParkingTicket;


public class CurrentDriverHolder {
    private static Driver driver = null;
    private static ParkingTicket ticket = null;
    private static Boolean paymentConfirmed = null;

    public static void setDriver(Driver d) { driver = d; }
    public static Driver getDriver() { return driver; }

    public static void setTicket(ParkingTicket t) { ticket = t; }
    public static ParkingTicket getTicket() { return ticket; }

    public static void setPaymentConfirmed(Boolean b) { paymentConfirmed = b; }
    public static Boolean getPaymentConfirmed() { return paymentConfirmed; }
}
