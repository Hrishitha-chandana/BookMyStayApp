import java.util.*;

/**
 * UC7: Add-On Service Selection
 */
public class BookMyStayApp {

    // Service class (Add-On)
    static class Service {
        String name;
        double cost;

        Service(String name, double cost) {
            this.name = name;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return name + " (₹" + cost + ")";
        }
    }

    // Add-On Service Manager
    static class AddOnServiceManager {

        // Map: Reservation ID -> List of Services
        private Map<String, List<Service>> reservationServices = new HashMap<>();

        // Add service to reservation
        public void addService(String reservationId, Service service) {
            reservationServices
                    .computeIfAbsent(reservationId, k -> new ArrayList<>())
                    .add(service);
        }

        // Get services for a reservation
        public List<Service> getServices(String reservationId) {
            return reservationServices.getOrDefault(reservationId, new ArrayList<>());
        }

        // Calculate total add-on cost
        public double calculateTotalCost(String reservationId) {
            List<Service> services = getServices(reservationId);

            double total = 0;
            for (Service s : services) {
                total += s.cost;
            }
            return total;
        }
    }

    public static void main(String[] args) {

        System.out.println("=====================================");
        System.out.println(" Book My Stay App ");
        System.out.println("=====================================");

        // ================= UC7 =================

        AddOnServiceManager manager = new AddOnServiceManager();

        String reservationId = "RES123";

        // Guest selects services
        manager.addService(reservationId, new Service("Breakfast", 500));
        manager.addService(reservationId, new Service("Airport Pickup", 1200));
        manager.addService(reservationId, new Service("Spa Access", 1500));

        // Display selected services
        System.out.println("\nServices for Reservation: " + reservationId);

        List<Service> services = manager.getServices(reservationId);
        for (Service s : services) {
            System.out.println(s);
        }

        // Calculate total cost
        double totalCost = manager.calculateTotalCost(reservationId);
        System.out.println("\nTotal Add-On Cost: ₹" + totalCost);

        // ================= END =================
        System.out.println("\nBooking remains unchanged. Add-ons applied successfully.");
    }
}