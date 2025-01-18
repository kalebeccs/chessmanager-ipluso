package src.main.java.models;

/**
 * The Match interface represents a match in the chess application.
 * It provides methods to get and set the match details such as id, moves,
 * result, time, and type.
 */
public interface Match {
    /**
     * Returns the id of the match.
     *
     * @return The id of the match.
     */
    int getId();

    /**
     * Sets the id of the match.
     *
     * @param id The id of the match.
     */
    void setId(int id);

    /**
     * Returns the moves made during the match.
     *
     * @return The moves made during the match.
     */
    String getMoves();

    /**
     * Sets the moves made during the match.
     *
     * @param moves The moves made during the match.
     */
    void setMoves(String moves);

    /**
     * Returns the result of the match.
     *
     * @return The result of the match.
     */
    String getResult();

    /**
     * Sets the result of the match.
     *
     * @param result The result of the match.
     */
    void setResult(String result);

    /**
     * Returns the time of the match.
     *
     * @return The time of the match.
     */
    String getTime();

    /**
     * Sets the time of the match.
     *
     * @param time The time of the match.
     */
    void setTime(String time);

    /**
     * Returns the type of the match.
     *
     * @return The type of the match.
     */
    String getType();

    /**
     * Sets the type of the match.
     *
     * @param type The type of the match.
     */
    void setType(String type);
}