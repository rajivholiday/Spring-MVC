package pro6_5.dto;

import pro6_5.entity.Userr;

import java.util.Set;

public record GameRequest(String name, String type, Userr user, Set<Userr> userrs) {
}
