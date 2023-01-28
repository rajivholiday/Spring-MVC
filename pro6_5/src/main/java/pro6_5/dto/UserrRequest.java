package pro6_5.dto;

import pro6_5.entity.Game;

import java.util.Set;

public record UserrRequest(String username, String password, String name, String surname, Set<Game> games) {
}
