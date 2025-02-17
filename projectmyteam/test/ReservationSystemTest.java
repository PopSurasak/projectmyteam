import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReservationSystemTest {
    private ReservationSystem reservationSystem;

    @BeforeEach
    void setUp() {
        reservationSystem = new ReservationSystem(5); // สร้างระบบจองโต๊ะที่มี 5 โต๊ะ
    }

    @Test
    void testReserveTable() {
        reservationSystem.reserveTable(2);
        assertTrue(reservationSystem.getTable(2).isReserved(), "โต๊ะที่ 2 ควรถูกจองแล้ว");
    }

    @Test
    void testCancelReservation() {
        reservationSystem.reserveTable(3);
        reservationSystem.cancelReservation(3);
        assertFalse(reservationSystem.getTable(3).isReserved(), "โต๊ะที่ 3 ควรจะถูกยกเลิกการจอง");
    }

    @Test
    void testDoubleReservation() {
        reservationSystem.reserveTable(4);
        reservationSystem.reserveTable(4);
        assertTrue(reservationSystem.getTable(4).isReserved(), "โต๊ะที่ 4 ควรจะถูกจองแค่ครั้งเดียว");
    }

    @Test
    void testInvalidTableNumber() {
        reservationSystem.reserveTable(10);
        assertNull(reservationSystem.getTable(10), "โต๊ะที่ 10 ไม่ควรมีอยู่ในระบบ");
    }
}


