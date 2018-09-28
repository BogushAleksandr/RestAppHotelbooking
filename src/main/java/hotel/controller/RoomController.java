package hotel.controller;

import hotel.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @RequestMapping("/findAllRooms")
    private String findAllRoom() {
        return roomService.findedAllRoom();
    }

    @RequestMapping("find/category/{name}")
    private String findByName(@PathVariable String name) {
        return roomService.findByName(name);
    }

    @RequestMapping("room/available")
    private String getAvailableRooms() {
        return roomService.getAvailableRooms();
    }

    @RequestMapping("room/book")
    private String bookRoom(Long roomId, Long userId, Long featureId, Integer year, Integer month, Integer dayOfMonth) {
        return roomService.bookRoom(1L, 1L, 2L, 2018, 10, 17);
    }
}
