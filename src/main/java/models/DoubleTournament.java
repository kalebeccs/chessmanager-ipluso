package src.main.java.models;

import java.util.ArrayList;

/**
 * The DoubleTournament class represents a double tournament in the chess
 * application.
 * It extends the Tournament class and includes a list of double matches.
 */
public class DoubleTournament extends Tournament {
    private ArrayList<DoubleMatch> matches;

    /**
     * Constructs a DoubleTournament with the specified id, name, and type.
     *
     * @param id   The id of the tournament.
     * @param name The name of the tournament.
     * @param type The type of the tournament.
     */
    public DoubleTournament(int id, String name, String type) {
        super(id, name, type);
        this.matches = new ArrayList<DoubleMatch>();
    }

    /**
     * Returns the list of double matches in the tournament.
     *
     * @return The list of double matches.
     */
    public ArrayList<DoubleMatch> getMatches() {
        return matches;
    }

    /**
     * Sets the list of double matches in the tournament.
     *
     * @param matches The new list of double matches.
     */
    public void setMatches(ArrayList<DoubleMatch> matches) {
        this.matches = matches;
    }

    /**
     * Adds a double match to the tournament.
     *
     * @param match The double match to add.
     */
    public void addMatch(DoubleMatch match) {
        this.matches.add(match);
    }

    /**
     * Removes a double match from the tournament.
     *
     * @param match The double match to remove.
     */
    public void removeMatch(DoubleMatch match) {
        this.matches.remove(match);
    }
}