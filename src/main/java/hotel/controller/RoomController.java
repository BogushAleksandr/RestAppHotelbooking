package hotel.controller;

import hotel.entities.Feature;
import hotel.entities.Room;
import hotel.entities.User;
import hotel.services.JournalService;
import hotel.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {
    private final RoomService roomService;
    private final JournalService journalService;

    @Autowired
    public RoomController(
            RoomService roomService,
            JournalService journalService
    ) {
        this.roomService = roomService;
        this.journalService = journalService;
    }

    @RequestMapping("/findAllRooms")
    private List<Room> findAllRoom() {
        return roomService.getAllRooms();
    }

    @RequestMapping("find/category/{name}")
    private String findByName(@PathVariable String name) {
        return roomService.findByName(name);
    }

    @RequestMapping("room/available")
    private String getAvailableRooms() {
        return roomService.getAvailableRooms();
    }

    @RequestMapping(value = "/room/book", method = RequestMethod.POST)
    public Room bookRoom(
            @RequestParam("roomId") Room room,
            @RequestParam("userId") User user,
            @RequestParam("featureId") Feature[] features,
            @RequestParam("year") int year,
            @RequestParam("month") int month,
            @RequestParam("dayOfMonth") int dayOfMonth
    ) {
        return journalService.bookRoom(room, user, features, year, month, dayOfMonth);
    }

}
