package dev.marcusxavier.xobattleapi.multiplayer;

public record MoveRecord(Integer position, Integer piece, Boolean belongsToWinnerPath, String userId) {
}
