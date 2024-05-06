package dev.marcusxavier.xobattleapi.multiplayer;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin
public class GameController {
    // TODO: Delete this junk method
    @MessageMapping("/room-joined/{id}")
    @SendTo("/message-broker/room-messages/{id}")
    private boolean joinRoom(@DestinationVariable String id) {
        return true;
    }

    @MessageMapping("/rooms/{id}")
    @SendTo("/message-broker/rooms/{id}")
    private MoveRecord sendMove(@DestinationVariable String id, MoveRecord moveRecord) {
        return moveRecord;
    }
  
    @MessageMapping("/room-messages/{id}")
    @SendTo("/message-broker/room-messages/{id}")
    private RoomEvent sendMessage(@DestinationVariable String id, RoomEvent event) {
        return event;
    }
}
