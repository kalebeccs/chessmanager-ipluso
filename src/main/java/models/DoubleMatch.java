package src.main.java.models;

/**
 * The DoubleMatch class represents a double match in the chess application.
 * It implements the Match interface and includes information about the teams,
 * arbiter, moves, result, time, winner, and type of the match.
 */
public class DoubleMatch implements Match {
    private int id;
    private Team team1;
    private Team team2;
    private Arbiter arbiter;
    private String moves;
    private String result;
    private String time;
    private Team winner;
    private String type;

    /**
     * Constructs a DoubleMatch with the specified teams, arbiter, moves, result,
     * time, winner, and type.
     *
     * @param team1   The first team.
     * @param team2   The second team.
     * @param arbiter The arbiter of the match.
     * @param moves   The moves made during the match.
     * @param result  The result of the match.
     * @param time    The time of the match.
     * @param winner  The winning team.
     * @param type    The type of the match.
     */
    public DoubleMatch(Team team1, Team team2, Arbiter arbiter, String moves, String result, String time, Team winner,
            String type) {
        this.team1 = team1;
        this.team2 = team2;
        this.arbiter = arbiter;
        this.moves = moves;
        this.result = result;
        this.time = time;
        this.winner = winner;
        this.type = type;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
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

    public Team getWinner() {
        return winner;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}