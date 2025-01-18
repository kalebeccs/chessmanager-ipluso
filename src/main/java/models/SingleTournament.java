package src.main.java.models;

import java.util.ArrayList;

/**
 * The SingleTournament class represents a single tournament in the chess
 * application.
 * It extends the Tournament class and includes a list of single matches.
 */
public class SingleTournament extends Tournament {
    private ArrayList<SingleMatch> matches;

    /**
     * Constructs a SingleTournament with the specified id, name, and type.
     *
     * @param id   The id of the tournament.
     * @param name The name of the tournament.
     * @param type The type of the tournament.
     */
    public SingleTournament(int id, String name, String type) {
        super(id, name, type);
        this.matches = new ArrayList<SingleMatch>();
    }

    /**
     * Returns the list of single matches in the tournament.
     *
     * @return The list of single matches.
     */
    public ArrayList<SingleMatch> getMatches() {
        return matches;
    }

    /**
     * Sets the list of single matches in the tournament.
     *
     * @param matches The new list of single matches.
     */
    public void setMatches(ArrayList<SingleMatch> matches) {
        this.matches = matches;
    }

    /**
     * Adds a single match to the tournament.
     *
     * @param match The single match to add.
     */
    public void addMatch(SingleMatch match) {
        this.matches.add(match);
    }

    /**
     * Removes a single match from the tournament.
     *
     * @param match The single match to remove.
     */
    public void removeMatch(SingleMatch match) {
        this.matches.remove(match);
    }
}