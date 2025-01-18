package src.main.java.controllers;

import src.main.java.models.SingleMatch;
import java.util.ArrayList;

/**
 * The SingleMatchController class manages the single matches in the chess
 * application.
 * It provides methods to add, update, retrieve, and delete single matches.
 */
public class SingleMatchController {
    private ArrayList<SingleMatch> matches;
    private int nextId;

    /**
     * Constructs a SingleMatchController with an empty list of matches and an ID
     * incrementer.
     */
    public SingleMatchController() {
        this.matches = new ArrayList<>();
        this.nextId = 1;
    }

    /**
     * Adds a single match to the list and assigns a unique ID to the match.
     *
     * @param match The single match to add.
     */
    public void addMatch(SingleMatch match) {
        match.setId(nextId++);
        matches.add(match);
    }

    /**
     * Updates the details of an existing single match.
     *
     * @param id           The ID of the single match to update.
     * @param updatedMatch The updated single match details.
     */
    public void updateMatch(int id, SingleMatch updatedMatch) {
        for (SingleMatch match : matches) {
            if (match.getId() == id) {
                match.setPlayer1(updatedMatch.getPlayer1());
                match.setPlayer2(updatedMatch.getPlayer2());
                match.setArbiter(updatedMatch.getArbiter());
                match.setMoves(updatedMatch.getMoves());
                match.setTime(updatedMatch.getTime());
                match.setWinner(updatedMatch.getWinner());
                match.setType(updatedMatch.getType());
                match.setResult(updatedMatch.getResult());
                break;
            }
        }
    }

    /**
     * Retrieves a single match by its ID.
     *
     * @param id The ID of the single match to retrieve.
     * @return The single match with the specified ID, or null if not found.
     */
    public SingleMatch getMatchById(int id) {
        for (SingleMatch match : matches) {
            if (match.getId() == id) {
                return match;
            }
        }
        return null;
    }

    /**
     * Deletes a single match by its ID.
     *
     * @param id The ID of the single match to delete.
     * @return true if the match was deleted, false otherwise.
     */
    public boolean deleteMatch(int id) {
        return matches.removeIf(match -> match.getId() == id);
    }

    /**
     * Returns a list of all single matches.
     *
     * @return A list of all single matches.
     */
    public ArrayList<SingleMatch> getAllMatches() {
        return new ArrayList<>(matches);
    }

    /**
     * Returns a list of single matches by type.
     *
     * @param type The type of matches to retrieve.
     * @return A list of single matches of the specified type.
     */
    public ArrayList<SingleMatch> getMatchesByType(String type) {
        ArrayList<SingleMatch> matchesByType = new ArrayList<>();
        for (SingleMatch match : matches) {
            if (match.getType().equals(type)) {
                matchesByType.add(match);
            }
        }
        return matchesByType;
    }

    /**
     * Returns a list of male elimination matches.
     *
     * @return A list of male elimination matches.
     */
    public ArrayList<SingleMatch> getMaleEliminationMatches() {
        return getMatchesByType("MaleElimination");
    }

    /**
     * Returns a list of male points matches.
     *
     * @return A list of male points matches.
     */
    public ArrayList<SingleMatch> getMalePointsMatches() {
        return getMatchesByType("MalePoints");
    }

    /**
     * Returns a list of female elimination matches.
     *
     * @return A list of female elimination matches.
     */
    public ArrayList<SingleMatch> getFemaleEliminationMatches() {
        return getMatchesByType("FemaleElimination");
    }

    /**
     * Returns a list of female points matches.
     *
     * @return A list of female points matches.
     */
    public ArrayList<SingleMatch> getFemalePointsMatches() {
        return getMatchesByType("FemalePoints");
    }
}