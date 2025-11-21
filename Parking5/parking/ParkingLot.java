package parking;

import transport.Transport;

public class ParkingLot {
    private ParkingSlot[] slots;
    private int nextTicketId = 1;

    public ParkingLot(int numberOfSlots) {
        if (numberOfSlots <= 0) numberOfSlots = 10;
        slots = new ParkingSlot[numberOfSlots];
        for (int i = 0; i < numberOfSlots; i++) {
            slots[i] = new ParkingSlot(i + 1);
        }
    }

    public ParkingTicket parkVehicle(Transport vehicle) {
        ParkingSlot free = findFreeSlot();
        if (free == null) {
            System.out.println("No free slots.");
            return null;
        }
        free.parkVehicle(vehicle);
        String ticketNumber = String.format("T%04d", nextTicketId++);
        ParkingTicket ticket = new ParkingTicket(ticketNumber, free.getSlotNumber());
        System.out.println("Припарковали " + vehicle.getInfo() + " місце " + free.getSlotNumber() +
                ". Білітік: " + ticketNumber + ". свібідін: " + vehicle.calculateParkingFee(1));
        return ticket;
    }

    public void unparkVehicle(ParkingTicket ticket, boolean paymentConfirmed) {
        if (ticket == null) {
            System.out.println("No ticket все.кіна небуде.");
            return;
        }
        if (!paymentConfirmed) {
            System.out.println("без оплати нононо ");
            return;
        }
        ParkingSlot slot = findByNumber(ticket.getSlotNumber());
        if (slot != null && slot.isOccupied()) {
            slot.removeVehicle();
            System.out.println("уехали с місця " + ticket.getSlotNumber());
        } else {
            System.out.println("нє понялі чи вільне чи шо");
        }
    }

    public ParkingSlot findByNumber(int slotNumber) {
        for (ParkingSlot s : slots) {
            if (s.getSlotNumber() == slotNumber) return s;
        }
        return null;
    }

    private ParkingSlot findFreeSlot() {
        for (ParkingSlot s : slots) {
            if (!s.isOccupied()) return s;
        }
        return null;
    }

    public void showAllSlots() {
        for (ParkingSlot s : slots) {
            System.out.println(s);
        }
    }

    public boolean hasFreeSlot() {
        return findFreeSlot() != null;
    }
}
