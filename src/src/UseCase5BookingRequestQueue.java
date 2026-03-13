import java.util.LinkedList;
import java.util.Queue;

public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        System.out.println("Booking Request Queue");

        Queue<Reservation> bookingQueue = new LinkedList<>();

        bookingQueue.add(new Reservation("Abhi", "Single"));
        bookingQueue.add(new Reservation("Subha", "Double"));
        bookingQueue.add(new Reservation("Vannathi", "Suite"));

        while (!bookingQueue.isEmpty()) {

            Reservation request = bookingQueue.poll();

            System.out.println("Processing booking for Guest: "
                    + request.getGuestName()
                    + ", Room Type: "
                    + request.getRoomType());
        }
    }
}