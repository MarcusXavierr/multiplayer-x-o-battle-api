package dev.marcusxavier.xobattleapi.multiplayer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EventSubject {
  READY_TO_NEXT_ROUND("ready_to_next_round"),
  QUIT("quit"),
  JOINED("joined");

  private final String event;

  EventSubject(String event) {
    this.event = event;
  }

  @JsonValue
  public String getEvent() {
    return event;
  }

  @JsonCreator
  public static EventSubject forValue(String value) {
    for (EventSubject subject : values()) {
      if (subject.getEvent().equalsIgnoreCase(value)) {
        return subject;
      }
    }
    throw new IllegalArgumentException("Invalid event subject given: " + value);
  }
}
