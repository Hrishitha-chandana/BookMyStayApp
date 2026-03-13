public class UseCase4RoomSearch {

    public static void main(String[] args) {

        System.out.println("Room Search\n");

        RoomInventory inventory = new RoomInventory();

        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        int singleAvailable = inventory.getAvailableRooms("Single");
        int doubleAvailable = inventory.getAvailableRooms("Double");
        int suiteAvailable = inventory.getAvailableRooms("Suite");

        if (singleAvailable > 0) {
            single.displayDetails();
            System.out.println("Available: " + singleAvailable + "\n");
        }

        if (doubleAvailable > 0) {
            doubleRoom.displayDetails();
            System.out.println("Available: " + doubleAvailable + "\n");
        }

        if (suiteAvailable > 0) {
            suite.displayDetails();
            System.out.println("Available: " + suiteAvailable);
        }
    }
}