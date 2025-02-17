public class Table {
    private int tableNumber;
    private boolean isReserved;

    public Table(int tableNumber) {
        this.tableNumber = tableNumber;
        this.isReserved = false;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void reserve() {
        if (!isReserved) {
            isReserved = true;
            System.out.println("Table " + tableNumber + " has been reserved.");
        } else {
            System.out.println("Table " + tableNumber + " is already reserved.");
        }
    }

    public void cancelReservation() {
        if (isReserved) {
            isReserved = false;
            System.out.println("Reservation for Table " + tableNumber + " has been canceled.");
        } else {
            System.out.println("Table " + tableNumber + " is not reserved.");
        }
    }
}

