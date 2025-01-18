package src.main.java.controllers;

import src.main.java.models.Player;
import java.util.ArrayList;
import java.util.Optional;

/**
 * The PlayerController class manages the players in the chess application.
 * It provides methods to add, edit, retrieve, and delete players.
 */
public class PlayerController {
    private ArrayList<Player> players;
    private int idIncrementer;

    /**
     * Constructs a PlayerController with an empty list of players and an ID
     * incrementer.
     */
    public PlayerController() {
        this.players = new ArrayList<>();
        this.idIncrementer = 1;
    }

    /**
     * Adds a player to the list and assigns a unique ID to the player.
     *
     * @param player The player to add.
     */
    public void addPlayer(Player player) {
        players.add(player);
        player.setId(idIncrementer++);
    }

    /**
     * Edits the details of an existing player.
     *
     * @param id            The ID of the player to edit.
     * @param updatedPlayer The updated player details.
     */
    public void editPlayer(int id, Player updatedPlayer) {
        Optional<Player> playerOptional = players.stream()
                .filter(p -> p.getId() == id)
                .findFirst();

        if (playerOptional.isPresent()) {
            Player player = playerOptional.get();
            player.setName(updatedPlayer.getName());
            player.setAge(updatedPlayer.getAge());
            player.setGender(updatedPlayer.getGender());
            player.setRanking(updatedPlayer.getRanking());
            player.setMatchesPlayed(updatedPlayer.getMatchesPlayed());
        }
    }

    /**
     * Retrieves a player by their ID.
     *
     * @param id The ID of the player to retrieve.
     * @return The player with the specified ID, or null if not found.
     */
    public Player getPlayer(int id) {
        return players.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Deletes a player by their ID.
     *
     * @param id The ID of the player to delete.
     */
    public void deletePlayer(int id) {
        players.removeIf(p -> p.getId() == id);
    }

    /**
     * Returns a list of all players.
     *
     * @return A list of all players.
     */
    public ArrayList<Player> getAllPlayers() {
        return new ArrayList<>(players);
    }
}