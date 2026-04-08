import java.util.*;

// Reservation Class
class Reservation {
    private String reservationId;
    private String guestName;
    private String roomType;
    private double price;

    public Reservation(String reservationId, String guestName, String roomType, double price) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomType = roomType;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getReservationId() {
        return reservationId;
    }

    @Override
    public String toString() {
        return "Reservation ID: " + reservationId +
                ", Guest: " + guestName +
                ", Room: " + roomType +
                ", Price: ₹" + price;
    }
}

// Booking History Class
class BookingHistory {
    private List<Reservation> reservations = new ArrayList<>();

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservations;
    }
}

// Report Service Class
class BookingReportService {

    public void generateReport(List<Reservation> reservations) {

        System.out.println("\n===== BOOKING HISTORY REPORT =====");

        if (reservations.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        double totalRevenue = 0;

        for (Reservation r : reservations) {
            System.out.println(r);
            totalRevenue += r.getPrice();
        }

        System.out.println("----------------------------------");
        System.out.println("Total Bookings: " + reservations.size());
        System.out.println("Total Revenue: ₹" + totalRevenue);
    }
}

// Main Class
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("=====================================");
        System.out.println(" Book My Stay App ");
        System.out.println("=====================================");

        // Create Booking History
        BookingHistory history = new BookingHistory();

        // Simulate confirmed bookings
        Reservation r1 = new Reservation("RES101", "Alice", "Deluxe", 3000);
        Reservation r2 = new Reservation("RES102", "Bob", "Suite", 5000);
        Reservation r3 = new Reservation("RES103", "Charlie", "Standard", 2000);

        // Add to history
        history.addReservation(r1);
        history.addReservation(r2);
        history.addReservation(r3);

        // Generate report
        BookingReportService reportService = new BookingReportService();
        reportService.generateReport(history.getAllReservations());
    }
}