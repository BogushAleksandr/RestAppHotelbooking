package hotel.services;

import hotel.entities.Category;
import hotel.entities.Room;
import hotel.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {
    RoomRepository roomRepository;
    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
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
    public List<Room> avaibleRooms() {
        List<Room> result = new ArrayList<>();
        for (Room room : roomRepository.findAll()) {
            if (room.getAvailable() == 1) {
                result.add(room);
            }
        }
        return result;
    }

}
