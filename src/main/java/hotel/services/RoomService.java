package hotel.services;

import hotel.entities.Category;
import hotel.entities.Room;
import hotel.repositories.CategoryRepository;
import hotel.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository,
                       CategoryRepository categoryRepository) {
        this.roomRepository = roomRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public String findByCategoryName(String name) {
        Category category = categoryRepository.getCategoryByCategoryName(name);
        List<Room> rooms = filterByCategory(category);

        StringBuilder sb = new StringBuilder();
        for (Room room : rooms) {
            sb.append(room).append("</br>");
        }
        return sb.toString();
    }

    public String getAvailableRooms() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Room room : availableRooms()) {
            stringBuilder.append(room).append("</br>");
        }
        return stringBuilder.toString();
    }

    public List<Room> filterByCategory(Category category) {
        List<Room> result = new ArrayList<>();
        for (Room room : roomRepository.findAll()) {
            if (room.getCategory().equals(category)) {
                result.add(room);
            }
        }
        return result;
    }

    public List<Room> availableRooms() {
        List<Room> result = new ArrayList<>();
        for (Room room : roomRepository.findAll()) {
            if (room.getAvailable() == 1) {
                result.add(room);
            }
        }
        return result;
    }
}