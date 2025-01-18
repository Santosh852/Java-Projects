import java.util.*;

class Room {
    String category;
    int roomNumber;
    boolean isAvailable;

    Room(String category, int roomNumber) {
        this.category = category;
        this.roomNumber = roomNumber;
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " (" + category + ")";
    }
}

class Reservation {
    int roomNumber;
    String customerName;
    double totalAmount;

    Reservation(int roomNumber, String customerName, double totalAmount) {
        this.roomNumber = roomNumber;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Reservation Details: \nCustomer: " + customerName + "\nRoom Number: " + roomNumber + "\nTotal Amount: $" + totalAmount;
    }
}

class HotelReservationSystem {
    private final List<Room> rooms = new ArrayList<>();
    private final List<Reservation> reservations = new ArrayList<>();

    HotelReservationSystem() {
        addRooms();
    }

    private void addRooms() {
        rooms.add(new Room("Standard", 101));
        rooms.add(new Room("Standard", 102));
        rooms.add(new Room("Deluxe", 201));
        rooms.add(new Room("Deluxe", 202));
        rooms.add(new Room("Suite", 301));
    }

    public void showAvailableRooms() {
        System.out.println("\nAvailable Rooms: ");
        boolean hasAvailableRooms = false;
        for (Room room : rooms) {
            if (room.isAvailable) {
                System.out.println(room);
                hasAvailableRooms = true;
            }
        }
        if (!hasAvailableRooms) {
            System.out.println("No available rooms at the moment.");
        }
    }

    public boolean makeReservation(String customerName, String roomCategory) {
        for (Room room : rooms) {
            if (room.isAvailable && room.category.equalsIgnoreCase(roomCategory)) {
                room.isAvailable = false;
                double price = getRoomPrice(room.category);
                Reservation reservation = new Reservation(room.roomNumber, customerName, price);
                reservations.add(reservation);
                System.out.println("\nReservation successful!");
                System.out.println(reservation);
                return true;
            }
        }
        System.out.println("No available rooms in this category.");
        return false;
    }

    private double getRoomPrice(String category) {
        return switch (category.toLowerCase()) {
            case "standard" -> 100.0;
            case "deluxe" -> 150.0;
            case "suite" -> 250.0;
            default -> 0.0;
        };
    }

    public void showReservationDetails() {
        if (reservations.isEmpty()) {
            System.out.println("\nNo reservations found.");
            return;
        }

        System.out.println("\nAll Reservations: ");
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }
}

public class HotelReservationApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HotelReservationSystem system = new HotelReservationSystem();

        while (true) {
            System.out.println("\n--- Hotel Reservation System ---");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Reservation Details");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid option.");
                scanner.nextLine(); // Clear the invalid input
                continue;
            }

            switch (choice) {
                case 1 -> system.showAvailableRooms();
                case 2 -> {
                    System.out.print("Enter your name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter room category (Standard/Deluxe/Suite): ");
                    String category = scanner.nextLine();
                    system.makeReservation(customerName, category);
                }
                case 3 -> system.showReservationDetails();
                case 4 -> {
                    System.out.println("Thank you for using the Hotel Reservation System. Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
