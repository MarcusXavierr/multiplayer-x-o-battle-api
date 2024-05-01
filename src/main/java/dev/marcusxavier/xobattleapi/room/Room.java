package dev.marcusxavier.xobattleapi.room;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.lang.NonNull;

/**
 * @param creatorPiece 0 for O or 1 for X
 */
public record Room(@Id Integer id, @NotBlank String roomId, @NotBlank String creatorId, @NonNull Integer creatorPiece) {
}
