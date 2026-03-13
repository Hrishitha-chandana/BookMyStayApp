class SingleRoom extends Room {

    public SingleRoom() {
        super(1, 250, 1500.0);
    }

    public void displayDetails() {
        System.out.println("Single Room:");
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size + " sqft");
        System.out.println("Price per night: " + price);
    }
}