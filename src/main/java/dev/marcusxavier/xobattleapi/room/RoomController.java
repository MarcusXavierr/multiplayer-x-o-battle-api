package dev.marcusxavier.xobattleapi.room;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin
public class RoomController {
  private final RoomRepository repository;

    public RoomController(RoomRepository repository) {
        this.repository = repository;
    }
  
    @GetMapping("/{id}")
    private Room getRoom(@PathVariable String id) { 
      return repository
              .findByRoomId(id)
              .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Room not found"));
    }
  
    @PostMapping("")
    private Room createRoom(@RequestBody Room room) {
       return repository.save(room);
    }
  
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) 
    private void deleteRoom(@PathVariable String id) {
      if (repository.findByRoomId(id).isEmpty()) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Room not found");
      }

      repository.deleteByRoomId(id);
    }
}
