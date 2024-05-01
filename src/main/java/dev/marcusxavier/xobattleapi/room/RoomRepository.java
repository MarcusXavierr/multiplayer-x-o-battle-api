package dev.marcusxavier.xobattleapi.room;

import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface RoomRepository extends ListCrudRepository<Room, String> {
  public Room getRoomByRoomId(String roomId);

  public Optional<Room> findByRoomId(String roomId);
}
