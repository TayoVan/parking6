package parking;

public class ParkingTicket {
    private String ticketNumber;
    private int slotNumber;

    public ParkingTicket(String ticketNumber, int slotNumber) {
        this.ticketNumber = ticketNumber;
        this.slotNumber = slotNumber;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public int getSlotNumber() {
        return slotNumber;
    }
}
