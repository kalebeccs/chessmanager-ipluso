package src.main.java.models;

/**
 * The Player class represents a player in the chess application.
 * It extends the Person class and includes additional information
 * about the player's ranking and matches played.
 */
public class Player extends Person {
    private int ranking;
    private int matchesPlayed;

    /**
     * Constructs a Player with the specified name, age, gender, ranking, and
     * matches played.
     *
     * @param name          The name of the player.
     * @param age           The age of the player.
     * @param gender        The gender of the player.
     * @param ranking       The ranking of the player.
     * @param matchesPlayed The number of matches played by the player.
     */
    public Player(String name, int age, char gender, int ranking, int matchesPlayed) {
        super(name, age, gender);
        this.ranking = ranking;
        this.matchesPlayed = matchesPlayed;
    }

    /**
     * Returns the ranking of the player.
     *
     * @return The ranking of the player.
     */
    public int getRanking() {
        return ranking;
    }

    /**
     * Sets the ranking of the player.
     *
     * @param ranking The new ranking of the player.
     */
    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    /**
     * Returns the number of matches played by the player.
     *
     * @return The number of matches played by the player.
     */
    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    /**
     * Sets the number of matches played by the player.
     *
     * @param matchesPlayed The new number of matches played by the player.
     */
    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    /**
     * Increments the number of matches played by the player.
     */
    public void playMatch() {
        matchesPlayed++;
    }

    /**
     * Increases the ranking of the player by the specified points.
     *
     * @param points The points to add to the player's ranking.
     */
    public void winMatch(int points) {
        ranking += points;
    }
}