package src.main.java.models;

/**
 * The SingleMatch class represents a single match in the chess application.
 * It implements the Match interface and includes information about the players,
 * arbiter, moves, result, time, winner, and type of the match.
 */
public class SingleMatch implements Match {
    private int id;
    private Player player1;
    private Player player2;
    private Arbiter arbiter;
    private String moves;
    private String result;
    private String time;
    private Player winner;
    private String type;

    /**
     * Constructs a SingleMatch with the specified players, arbiter, moves, time,
     * winner, type, and result.
     *
     * @param player1 The first player.
     * @param player2 The second player.
     * @param arbiter The arbiter of the match.
     * @param moves   The moves made during the match.
     * @param time    The time of the match.
     * @param winner  The winning player.
     * @param type    The type of the match.
     * @param result  The result of the match.
     */
    public SingleMatch(Player player1, Player player2, Arbiter arbiter, String moves, String time,
            Player winner, String type, String result) {
        this.player1 = player1;
        this.player2 = player2;
        this.arbiter = arbiter;
        this.moves = moves;
        this.time = time;
        this.winner = winner;
        this.type = type;
        this.result = result;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Arbiter getArbiter() {
        return arbiter;
    }

    public void setArbiter(Arbiter arbiter) {
        this.arbiter = arbiter;
    }

    public String getMoves() {
        return moves;
    }

    public void setMoves(String moves) {
        this.moves = moves;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}