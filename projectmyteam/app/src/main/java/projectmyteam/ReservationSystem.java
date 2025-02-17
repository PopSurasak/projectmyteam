import java.util.ArrayList;
import java.util.List;

public class ReservationSystem {
    private List<Table> tables;

    public ReservationSystem(int numberOfTables) {
        tables = new ArrayList<>();
        for (int i = 1; i <= numberOfTables; i++) {
            tables.add(new Table(i));
        }
    }

    public void reserveTable(int tableNumber) {
        if (tableNumber > 0 && tableNumber <= tables.size()) {
            tables.get(tableNumber - 1).reserve();
        } else {
            System.out.println("Invalid table number.");
        }
    }

    public void cancelReservation(int tableNumber) {
        if (tableNumber > 0 && tableNumber <= tables.size()) {
            tables.get(tableNumber - 1).cancelReservation();
        } else {
            System.out.println("Invalid table number.");
        }
    }

    public void displayAvailableTables() {
        System.out.println("Available Tables:");
        for (Table table : tables) {
            if (!table.isReserved()) {
                System.out.println("Table " + table.getTableNumber());
            }
        }
    }
    public Table getTable(int tableNumber) {
        if (tableNumber > 0 && tableNumber <= tables.size()) {
            return tables.get(tableNumber - 1);
        }
        return null;
    }
    
}

