package dev.marcusxavier.xobattleapi.onlinegame;

public record MoveRecord(Integer position, Integer piece, Boolean belongsToWinnerPath, String userId) {
}
