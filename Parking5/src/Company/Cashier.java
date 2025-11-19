package Company;

import parking.ParkingTicket;

public class Cashier extends Employee {
    private double salary;

    public Cashier (String name, double salary) {
        super(name, "Cashier");
        this.salary = salary;
    }

    public boolean checkPayment(ParkingTicket ticket) {
        System.out.println("Касир " + getName() + " перевіряє оплату квитка " + ticket.getTicketNumber());
        return true;
    }
}
//вспомнить