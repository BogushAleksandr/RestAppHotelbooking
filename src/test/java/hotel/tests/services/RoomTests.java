package hotel.tests.services;

import hotel.entities.Category;
import hotel.entities.Room;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoomTests {
    private static Category category;
    private static Room room;
    private static List<Room> roomList;
    private static List<Room> roomListExpected;
    private static List<Room> roomListNegative;

    @BeforeAll
    static void testAvaible() {
        category = new Category();
        Category categoryBeforeTest0 = new Category(1, "Category0");
        Category categoryBeforeTest1 = new Category(2, "Category1");
        Category categoryBeforeTest2 = new Category(3, "Category2");
        Category categoryBeforeTest3 = new Category(4, "Category3");

        room = new Room();
        roomList = new ArrayList<>();
        Room roomBeforeTest0 = new Room(1, categoryBeforeTest0, "A0", 369.20, 0);
        Room roomBeforeTest1 = new Room(2, categoryBeforeTest1, "A1", 369.21, 1);
        Room roomBeforeTest2 = new Room(3, categoryBeforeTest2, "A2", 369.22, 1);
        Room roomBeforeTest3 = new Room(3, categoryBeforeTest3, "A3", 369.23, 0);
        roomList.add(roomBeforeTest0);
        roomList.add(roomBeforeTest1);
        roomList.add(roomBeforeTest2);
        roomList.add(roomBeforeTest3);

        roomListExpected = new ArrayList<>();
        roomListExpected.add(roomBeforeTest1);
        roomListExpected.add(roomBeforeTest2);

        roomListNegative = new ArrayList<>();
        roomListNegative.add(roomBeforeTest0);
        roomListNegative.add(roomBeforeTest3);

    }

    @Test
    void avaibleRoomsCorrect() {
        List<Room> result = new ArrayList<>();
        for (Room room : roomList) {
            if (room.getAvailable() == 1) {
                result.add(room);
            }
        }

        List<Room> actual = result;
        List<Room> expected = roomListExpected;

        assertEquals(expected, actual);
    }

    @Test
    void avaibleRoomsNegative() {

        List<Room> result = new ArrayList<>();
        for (Room room : roomList) {
            if (room.getAvailable() == 0) {
                result.add(room);
            }
        }

        List<Room> actual = result;
        List<Room> expected = roomListNegative;

        assertEquals(expected, actual);

    }

    @Test
    void filterByCategoryCorrect(){
        Category categoryCoorect0 = new Category(1, "Category0");
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(category);

        List<Room> roomListActual = new ArrayList<>();
        for (Room room : roomList) {
            if (room.getCategory().equals(categoryCoorect0)) {
                roomListActual.add(room);
            }
        }

        List<Room> resultExpected = new ArrayList<>();

        for (Room room : roomList) {
            if (room.getCategory().equals(categoryCoorect0)) {
                roomListExpected.add(room);
            }
        }
       assertEquals(resultExpected.hashCode(),roomListActual.hashCode());
    }

    @Test
    void filterByCategoryNegative(){
        Category categoryCoorect0 = new Category(1, "Category0");
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(category);

        List<Room> roomListActual = new ArrayList<>();
        List<Room> roomListNotActual = new ArrayList<>();
        for (Room room : roomList) {
            if (room.getCategory().equals(categoryCoorect0)) {
                roomListActual.add(room);
            } else roomListNotActual.add(room);
        }

        boolean actual;
        if (roomListActual.equals(roomListNotActual)){
            actual = true;
        } else actual = false;

        boolean expected = false;
        assertEquals(expected,actual);

    }
}
