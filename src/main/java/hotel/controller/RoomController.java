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
    public RoomController(
            RoomRepository roomRepository,
            RoomService roomService,
            CategoryRepository categoryRepository,
            JournalService journalService,
            UserRepository userRepository,
            FeaturesRepository featuresRepository
    ) {
        this.roomRepository = roomRepository;
        this.roomService = roomService;
        this.categoryRepository = categoryRepository;
        this.journalService = journalService;
        this.userRepository = userRepository;
        this.featuresRepository = featuresRepository;
    }

    // CategoryServices categoryServices

    //TODO refactor this ffs
    //@ResponseBody
    //@RequestMapping("/saveRoom/")
    public String addRoom() {
        //creating a new room
        Room room = new Room();
        room.setAvailable(0);
        room.setNumber("12");
        room.setPrice(12.50);

        Category cat = new Category();
        cat.setCategoryName("elux");
        room.setCategory(cat);

        categoryRepository.save(cat);
        roomRepository.save(room);

        Room room1 = new Room();
        room1.setAvailable(1);
        room1.setNumber("13");
        room1.setPrice(1.50);

        Category catLux = new Category();
        catLux.setCategoryName("lux");
        room1.setCategory(catLux);

        categoryRepository.save(catLux);
        roomRepository.save(room1);

        Room room2 = new Room();
        room2.setAvailable(1);
        room2.setNumber("14");
        room2.setPrice(122.50);

        Category catnotLux = new Category();
        catnotLux.setCategoryName("notlux");
        room2.setCategory(catnotLux);

        categoryRepository.save(catnotLux);
        roomRepository.save(room2);

/////////////////////////////////////////////////////

        Room room3 = new Room();
        room3.setAvailable(0);
        room3.setNumber("12");
        room3.setPrice(12.50);

        Category cat3 = new Category();
        cat3.setCategoryName("elux");
        room3.setCategory(cat3);

        categoryRepository.save(cat3);
        roomRepository.save(room3);
///////////////////////////////////////////////////////
        Room room4 = new Room();
        room4.setAvailable(1);
        room4.setNumber("13");
        room4.setPrice(1.50);

        Category cat4 = new Category();
        cat4.setCategoryName("lux");
        room4.setCategory(cat4);

        categoryRepository.save(cat4);
        roomRepository.save(room4);
//////////////////////////////////////////////////
        Room room5 = new Room();
        room5.setAvailable(1);
        room5.setNumber("14");
        room5.setPrice(122.50);

        Category cat5 = new Category();
        cat5.setCategoryName("notlux");
        room5.setCategory(cat5);

        categoryRepository.save(cat5);
        roomRepository.save(room5);
///////////////////////////////////////////////////

        return "200 saveRoom!";
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
            stringBuilder.append(room).append(":");
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
