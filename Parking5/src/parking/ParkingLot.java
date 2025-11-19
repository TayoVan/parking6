package parking;

import transport.Transport;

public class ParkingLot {

    private ParkingSlot[] slots;

    public ParkingLot(int numberOfSlots) {
        slots = new ParkingSlot[numberOfSlots];
        for (int i = 0; i < numberOfSlots; i++) {
            slots[i] = new ParkingSlot(i + 1);
        }
    }

    // Паркування
    public ParkingTicket parkVehicle(Transport vehicle) {
        for (ParkingSlot slot : slots) {
            if (!slot.isOccupied()) {
                slot.parkVehicle(vehicle);
                System.out.println(vehicle.getType() + " " + vehicle.getRegistrationNumber()
                        + " припарковано на слоті " + slot.getSlotNumber());
                return new ParkingTicket("TICKET" + slot.getSlotNumber(), slot.getSlotNumber());
            }
        }
        System.out.println("Вільних місць немає!");
        return null;
    }

    //  Виїзд
    public boolean unparkVehicle(ParkingTicket ticket, boolean paymentConfirmed) {

        if (!paymentConfirmed) {
            System.out.println("Оплата не підтверджена! Виїзд заборонено.");
            return false;
        }

        for (ParkingSlot slot : slots) {
            if (slot.getSlotNumber() == ticket.getSlotNumber() && slot.isOccupied()) {
                slot.removeVehicle();
                System.out.println("Слот " + slot.getSlotNumber() + " звільнено.");
                return true;
            }
        }

        System.out.println("Квиток недійсний!");
        return false;
    }

    //Показати всі слоти
    public void showAllSlots() {
        System.out.println("\n--- Стан паркінгу ---");
        for (ParkingSlot slot : slots) {
            if (slot.isOccupied()) {
                System.out.println("Слот " + slot.getSlotNumber() + ": Зайнятий — "
                        + slot.getVehicle().getType() + " "
                        + slot.getVehicle().getRegistrationNumber());
            } else {
                System.out.println("Слот " + slot.getSlotNumber() + ": Вільний");
            }
        }
        System.out.println("----------------------\n");
    }

    // --- Перевірка чи є хоч одне вільне місце ---
    public boolean hasFreeSlot() {
        for (ParkingSlot slot : slots) {
            if (!slot.isOccupied()) {
                return true;
            }
        }
        return false;
    }

    // Пошук по номеру машини
    public ParkingSlot findByNumber(String regNumber) {
        for (ParkingSlot slot : slots) {
            if (slot.isOccupied() &&
                    slot.getVehicle().getRegistrationNumber().equalsIgnoreCase(regNumber)) {
                return slot;
            }
        }
        return null;
    }
}
