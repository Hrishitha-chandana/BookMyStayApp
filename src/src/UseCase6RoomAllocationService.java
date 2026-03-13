import java.util.*;

public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        System.out.println("Room Allocation Processing");

        Queue<Reservation> bookingQueue = new LinkedList<>();

        bookingQueue.add(new Reservation("Abhi", "Single"));
        bookingQueue.add(new Reservation("Subha", "Single"));
        bookingQueue.add(new Reservation("Vannathi", "Suite"));

        HashMap<String, Integer> inventory = new HashMap<>();
        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);

        HashMap<String, Set<String>> allocatedRooms = new HashMap<>();
        allocatedRooms.put("Single", new HashSet<>());
        allocatedRooms.put("Double", new HashSet<>());
        allocatedRooms.put("Suite", new HashSet<>());

        while (!bookingQueue.isEmpty()) {

            Reservation request = bookingQueue.poll();
            String roomType = request.getRoomType();

            if (inventory.get(roomType) > 0) {

                int roomNumber = allocatedRooms.get(roomType).size() + 1;
                String roomId = roomType + "-" + roomNumber;

                allocatedRooms.get(roomType).add(roomId);

                inventory.put(roomType, inventory.get(roomType) - 1);

                System.out.println("Booking confirmed for Guest: "
                        + request.getGuestName()
                        + ", Room ID: "
                        + roomId);

            } else {
                System.out.println("No rooms available for " + request.getGuestName());
            }
        }
    }
}