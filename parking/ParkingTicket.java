package parking;

public class ParkingTicket {
    private String ticketNumber;
    private int slotNumber;
    private boolean paid;

    public ParkingTicket(String ticketNumber, int slotNumber) {
        this.ticketNumber = ticketNumber;
        this.slotNumber = slotNumber;
        this.paid = false;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {
        return "білітік #" + ticketNumber + " для місця " + slotNumber + " оплата=" + paid;
    }
}
