package hotel.controller;

import hotel.entities.Category;
import hotel.entities.Feature;
import hotel.entities.Room;
import hotel.entities.User;
import hotel.repositories.CategoryRepository;
import hotel.repositories.FeaturesRepository;
import hotel.repositories.RoomRepository;
import hotel.repositories.UserRepository;
import hotel.services.JournalService;
import hotel.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RoomController {
    RoomRepository roomRepository;
    RoomService roomService;
    CategoryRepository categoryRepository;
    JournalService journalService;
    UserRepository userRepository;
    FeaturesRepository featuresRepository;

    @Autowired
    public RoomController(RoomRepository roomRepository, RoomService roomService, CategoryRepository categoryRepository,
                          JournalService journalService, UserRepository userRepository, FeaturesRepository featuresRepository) {
        this.roomRepository = roomRepository;
        this.roomService = roomService;
        this.categoryRepository = categoryRepository;
        this.journalService = journalService;
        this.userRepository = userRepository;
        this.featuresRepository = featuresRepository;
    }

    @ResponseBody
    @RequestMapping("/findAllRooms")
    public String findedAllRoom() {
        StringBuilder resultRoom = new StringBuilder(" ");
        for (Room roomResult : roomRepository.findAll()) {
            resultRoom.append(roomResult).append("</br>");
        }
        return resultRoom.toString();
    }

    @ResponseBody
    @RequestMapping("find/category/{name}")
    public String findByName(@PathVariable String name) {
        Category category = categoryRepository.getCategoryByCategoryName(name);
        List<Room> rooms = roomService.filterByCategory(category);

        StringBuilder sb = new StringBuilder();

        for (Room room : rooms) {
            sb.append(room).append("</br>");
        }

        return sb.toString();
    }

    @ResponseBody
    @RequestMapping("room/available")
    public String getAvailableRooms() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Room room : roomService.avaibleRooms()) {
            stringBuilder.append(room).append("</br>");
        }

        return stringBuilder.toString();
    }

    @ResponseBody
    @RequestMapping("room/book/{roomId}")
    public boolean bookRoom(@PathVariable Long roomId) {

        User user = userRepository.getUserById(1L);
        Room room = roomRepository.getById(roomId);
        LocalDate dateFrom = LocalDate.now();
        LocalDate dateTo = LocalDate.of(2018, 8, 14);
        List<Feature> features = new ArrayList<>();

        features.add(featuresRepository.getById(1L));

        journalService.bookRoom(user, room, dateFrom, dateTo, features);

        //TODO test
        return true;
    }
}
