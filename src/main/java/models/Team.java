package src.main.java.models;

/**
 * The Team class represents a team in the chess application.
 * It includes information about the players in the team and the team's name.
 */
public class Team {
    private int id;
    private Player player1;
    private Player player2;
    private String name;

    /**
     * Constructs a Team with the specified players and name.
     *
     * @param player1 The first player in the team.
     * @param player2 The second player in the team.
     * @param name    The name of the team.
     */
    public Team(Player player1, Player player2, String name) {
        this.player1 = player1;
        this.player2 = player2;
        this.name = name;
    }

    /**
     * Returns the id of the team.
     *
     * @return The id of the team.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id of the team.
     *
     * @param id The id of the team.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the first player in the team.
     *
     * @return The first player in the team.
     */
    public Player getPlayer1() {
        return player1;
    }

    /**
     * Sets the first player in the team.
     *
     * @param player1 The first player in the team.
     */
    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    /**
     * Returns the second player in the team.
     *
     * @return The second player in the team.
     */
    public Player getPlayer2() {
        return player2;
    }

    /**
     * Sets the second player in the team.
     *
     * @param player2 The second player in the team.
     */
    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    /**
     * Returns the name of the team.
     *
     * @return The name of the team.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the team.
     *
     * @param name The name of the team.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Increments the number of matches played by both players in the team.
     */
    public void playMatch() {
        player1.playMatch();
        player2.playMatch();
    }

    /**
     * Increases the ranking of both players in the team by the specified points.
     *
     * @param points The points to add to each player's ranking.
     */
    public void winMatch(int points) {
        player1.winMatch(points);
        player2.winMatch(points);
    }
}