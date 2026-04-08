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

    public String getReservationId() {
        return reservationId;
    }
}

// Service Class
class AddOnService {
    private String serviceName;
    private double cost;

    public AddOnService(String serviceName, double cost) {
        this.serviceName = serviceName;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return serviceName + " (₹" + cost + ")";
    }
}

// Add-On Service Manager
class AddOnServiceManager {
    private Map<String, List<AddOnService>> serviceMap = new HashMap<>();

    public void addService(String reservationId, AddOnService service) {
        serviceMap.computeIfAbsent(reservationId, k -> new ArrayList<>()).add(service);
    }

    public List<AddOnService> getServices(String reservationId) {
        return serviceMap.getOrDefault(reservationId, new ArrayList<>());
    }

    public double calculateTotalCost(String reservationId) {
        return getServices(reservationId)
                .stream()
                .mapToDouble(AddOnService::getCost)
                .sum();
    }
}

// Main Class
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("=====================================");
        System.out.println(" Book My Stay App ");
        System.out.println("=====================================");

        Reservation reservation = new Reservation("RES123", "John", "Deluxe", 3000);

        AddOnServiceManager manager = new AddOnServiceManager();

        // Add services
        manager.addService("RES123", new AddOnService("Breakfast", 500));
        manager.addService("RES123", new AddOnService("Airport Pickup", 1200));
        manager.addService("RES123", new AddOnService("Spa Access", 1500));

        // Display services
        System.out.println("\nServices for Reservation: " + reservation.getReservationId());

        for (AddOnService service : manager.getServices("RES123")) {
            System.out.println(service);
        }

        System.out.println("\nTotal Add-On Cost: ₹" + manager.calculateTotalCost("RES123"));

        System.out.println("\nBooking remains unchanged. Add-ons applied successfully.");
    }
}