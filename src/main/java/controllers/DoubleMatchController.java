package src.main.java.controllers;

import java.util.ArrayList;
import src.main.java.models.DoubleMatch;

/**
 * The DoubleMatchController class manages the double matches in the chess
 * application.
 * It provides methods to add, update, retrieve, and delete double matches.
 */
public class DoubleMatchController {
    private ArrayList<DoubleMatch> doubleMatches;
    private TeamController teamController;
    private int nextId;

    /**
     * Constructs a DoubleMatchController with the specified TeamController.
     *
     * @param teamController The TeamController to manage teams.
     */
    public DoubleMatchController(TeamController teamController) {
        this.teamController = teamController;
        this.doubleMatches = new ArrayList<>();
        this.nextId = 1;
    }

    /**
     * Adds a double match to the list and assigns a unique ID to the match.
     *
     * @param match The double match to add.
     */
    public void addMatch(DoubleMatch match) {
        match.setId(nextId++);
        doubleMatches.add(match);
    }

    /**
     * Updates the details of an existing double match.
     *
     * @param match The double match with updated details.
     */
    public void updateMatch(DoubleMatch match) {
        for (int i = 0; i < doubleMatches.size(); i++) {
            if (doubleMatches.get(i).getId() == match.getId()) {
                doubleMatches.set(i, match);
                return;
            }
        }
    }

    /**
     * Deletes a double match by its ID.
     *
     * @param id The ID of the double match to delete.
     * @return true if the match was deleted, false otherwise.
     */
    public boolean deleteMatch(int id) {
        return doubleMatches.removeIf(match -> match.getId() == id);
    }

    /**
     * Retrieves a double match by its ID.
     *
     * @param id The ID of the double match to retrieve.
     * @return The double match with the specified ID, or null if not found.
     */
    public DoubleMatch getMatchById(int id) {
        for (DoubleMatch match : doubleMatches) {
            if (match.getId() == id) {
                return match;
            }
        }
        return null;
    }

    /**
     * Returns a list of all double matches.
     *
     * @return A list of all double matches.
     */
    public ArrayList<DoubleMatch> getAllMatches() {
        return new ArrayList<>(doubleMatches);
    }
}