package hotel.tests.services;

import hotel.entities.Category;
import hotel.entities.Room;
import hotel.repositories.CategoryRepository;
import hotel.repositories.RoomRepository;
import hotel.services.RoomService;
import hotel.tests.services.stubs.CategoryRepositoryStub;
import hotel.tests.services.stubs.RoomRepositoryStub;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */

class RoomTests {
    private static RoomRepository roomRepository;
    private static CategoryRepository categoryRepository;
    private static List<Room> roomListExpected;
    private static List<Room> roomListExpectedNegative;
    private static RoomService roomService;

    @BeforeAll
    static void testAvaible() {

        categoryRepository = new CategoryRepositoryStub();
        roomRepository = new RoomRepositoryStub();

        roomService = new RoomService(roomRepository, categoryRepository);

        Category categoryBeforeTest0 = new Category(1, "Category0");
        Category categoryBeforeTest1 = new Category(2, "Category1");

        Room roomBeforeTest0 = new Room(1, categoryBeforeTest0, "A0", 369.20, 0);
        Room roomBeforeTest1 = new Room(2, categoryBeforeTest1, "A1", 369.21, 1);

        roomListExpected = new ArrayList<>();
        roomListExpected.add(roomBeforeTest1);

        roomListExpectedNegative = new ArrayList<>();
        roomListExpectedNegative.add(roomBeforeTest0);


        categoryRepository.save(categoryBeforeTest0);
        categoryRepository.save(categoryBeforeTest1);

        roomRepository.save(roomBeforeTest0);
        roomRepository.save(roomBeforeTest1);
    }

    @Test
    void availableRoomCorrect() {
        List<Room> actual = roomService.availableRooms();

        assertIterableEquals(roomListExpected, actual);
    }

    @Test
    void avaibleRoomNegative() {
        List<Room> actual = roomService.availableRooms();
        assertNotEquals(roomListExpectedNegative, actual);

    }


   /* @Test
    void findByCategoryNameCorrect() {

        List<Room> actualRoom ;


         assertEquals(, actual);
    }*/


   /* @Test
    void findByCategoryNameNegative() {

    }*/
}