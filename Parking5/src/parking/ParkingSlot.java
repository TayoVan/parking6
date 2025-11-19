package parking;

import transport.Transport;

public class ParkingSlot {
    private int slotNumber;
    private boolean isOccupied;
    private Transport vehicle;

    public ParkingSlot(int slotNumber) {
        this.slotNumber = slotNumber;
        this.isOccupied = false;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Transport getVehicle() {
        return vehicle;
    }

    public void parkVehicle(Transport vehicle) {
        this.vehicle = vehicle;
        this.isOccupied = true;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.isOccupied = false;
    }
}
//устала перечитать