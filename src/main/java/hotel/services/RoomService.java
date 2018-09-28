package hotel.services;

import hotel.entities.Category;
import hotel.entities.Feature;
import hotel.entities.Room;
import hotel.entities.User;
import hotel.repositories.CategoryRepository;
import hotel.repositories.FeaturesRepository;
import hotel.repositories.RoomRepository;
import hotel.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final CategoryRepository categoryRepository;
    private final JournalService journalService;
    private final UserRepository userRepository;
    private final FeaturesRepository featuresRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository,
                       CategoryRepository categoryRepository, JournalService journalService,
                       UserRepository userRepository, FeaturesRepository featuresRepository) {
        this.roomRepository = roomRepository;
        this.categoryRepository = categoryRepository;
        this.journalService = journalService;
        this.userRepository = userRepository;
        this.featuresRepository = featuresRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public String findedAllRoom() {
        StringBuilder resultRoom = new StringBuilder(" ");
        for (Room roomResult : roomRepository.findAll()) {
            resultRoom.append(roomResult).append("</br>");
        }
        return resultRoom.toString();
    }

    public String findByName(@PathVariable String name) {
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
        for (Room room : avaibleRooms()) {
            stringBuilder.append(room).append("</br>");
        }
        return stringBuilder.toString();
    }

    public Room BookRoom(Room room, User user, Feature[] features, int year, int month, int dayOfMonth){
        LocalDate dateFrom = LocalDate.now();
        LocalDate dateTo = LocalDate.of(year, month, dayOfMonth);

        List<Feature> featuresList = Arrays.asList(features);

        return journalService.bookRoom(user, room, dateFrom, dateTo, featuresList);
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
