package Main;

import Company.*;
import transport.*;
import parking.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Вводжу менеджера
        System.out.print("Введіть ім'я менеджера: ");
        String managerName = scanner.nextLine();
        System.out.print("Введіть зарплату менеджера: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        Employee manager = new Manager(managerName, salary);

        // Вводжу касира
        System.out.print("Введіть ім'я касира: ");
        String cashierName = scanner.nextLine();
        System.out.print("Введіть зарплату касира: ");
        salary = scanner.nextDouble();
        scanner.nextLine();
        Employee cashier = new Cashier(cashierName, salary);

        // виводжу крч кількість місць у паркінгу
        System.out.print("Введіть кількість місць у паркінгу: ");
        int numSlots = scanner.nextInt();
        scanner.nextLine();
        ParkingLot parkingLot = new ParkingLot(numSlots);

        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Меню Паркінгу ---");
            System.out.println("1. Додати водія та авто");
            System.out.println("2. Паркувати авто");
            System.out.println("3. Перевірка оплати");
            System.out.println("4. Виїзд з паркінгу");
            System.out.println("5. Вихід");
            System.out.print("Оберіть опцію: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введіть ім'я водія: ");
                    String driverName = scanner.nextLine();
                    System.out.print("Введіть номер авто: ");
                    String carNumber = scanner.nextLine();
                    System.out.print("Введіть модель авто: ");
                    String carColor = scanner.nextLine();

                    Transport car = new Car(carNumber, carColor);
                    Employee driver = new Driver(driverName, car);

                    CurrentDriverHolder.setDriver(driver);
                    break;
                case 2:
                    Employee currentDriver = CurrentDriverHolder.getDriver();
                    if (currentDriver != null) {
                        Transport vehicle = ((Driver) currentDriver).getVehicle();
                        ParkingTicket ticket = parkingLot.parkVehicle(vehicle);
                        CurrentDriverHolder.setTicket(ticket);
                    } else {
                        System.out.println("Спочатку додайте водія та авто!");
                    }
                    break;
                case 3:
                    ParkingTicket ticketToCheck = CurrentDriverHolder.getTicket();
                    if (ticketToCheck != null) {
                        boolean paymentConfirmed = ((Cashier) cashier).checkPayment(ticketToCheck);
                        CurrentDriverHolder.setPaymentConfirmed(paymentConfirmed);
                    } else {
                        System.out.println("Спочатку паркуйте авто!");
                    }
                    break;
                case 4:
                    ParkingTicket ticketToLeave = CurrentDriverHolder.getTicket();
                    Boolean paymentConfirmed = CurrentDriverHolder.getPaymentConfirmed();
                    if (ticketToLeave != null && paymentConfirmed != null) {
                        parkingLot.unparkVehicle(ticketToLeave, paymentConfirmed);
                    } else {
                        System.out.println("Спочатку паркуйте авто та перевірте оплату!");
                    }
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Невірна опція!");
            }
        }

        scanner.close();
        System.out.println("Роботу завершено.");
    }
}