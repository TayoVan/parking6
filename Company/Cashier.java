package Company;

import parking.ParkingTicket;

public class Cashier extends Employee {
    private double salary;

    public Cashier(String name, double salary) {
        super(name, "Cashier");
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
        return String.format("Cashier: %s, salary=%.2f", name, salary);
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void performDuty(Object context) {
        System.out.println("Cashier на сіоїй мусії.");
    }

    public void performDuty(ParkingTicket ticket) {
        ticket.setPaid(true);
        System.out.println("Cashier перевіряє оплату " + ticket.getTicketNumber());
    }

    public boolean checkPayment(ParkingTicket ticket) {
        if (ticket == null) return false;
        this.performDuty(ticket);  
        return ticket.isPaid();
    }
}