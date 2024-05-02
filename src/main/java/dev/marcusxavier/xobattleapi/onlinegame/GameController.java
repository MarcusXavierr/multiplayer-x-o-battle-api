package dev.marcusxavier.xobattleapi.onlinegame;

import dev.marcusxavier.xobattleapi.room.Room;
import dev.marcusxavier.xobattleapi.room.RoomRepository;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@CrossOrigin
public class GameController {
    private final RoomRepository roomRepository;

    public GameController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @MessageMapping("/room-joined/{id}")
    @SendTo("/message-broker/room-joined/{id}")
    public boolean joinRoom(@DestinationVariable String id) {
        return true;
    }

    @MessageMapping("/rooms/{id}")
    @SendTo("/message-broker/rooms/{id}")
    public MoveRecord sendMove(@DestinationVariable String id, MoveRecord moveRecord) {
        return moveRecord;
    }
}
