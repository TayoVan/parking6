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
    public void performDuty(Object context) {
        if (context instanceof ParkingTicket) {
            ParkingTicket ticket = (ParkingTicket) context;
            ticket.setPaid(true);
            System.out.println("Cashier перевіряє оплату " + ticket.getTicketNumber());
        } else {
            System.out.println("Cashier на сіоїй мусії.");
        }
    }

    @Override
    public double getSalary() {
        return salary;
    }

    public boolean checkPayment(ParkingTicket ticket) {
        if (ticket == null) return false;
        this.performDuty(ticket);
        return ticket.isPaid();
    }
}
