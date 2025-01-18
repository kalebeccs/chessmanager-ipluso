package src.main.java.models;

/**
 * The Tournament class represents a tournament in the chess application.
 * It includes information about the tournament's id, name, and type.
 */
public abstract class Tournament {
    private int id;
    private String name;
    private String type;

    /**
     * Constructs a Tournament with the specified id, name, and type.
     *
     * @param id   The id of the tournament.
     * @param name The name of the tournament.
     * @param type The type of the tournament.
     */
    public Tournament(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    /**
     * Returns the id of the tournament.
     *
     * @return The id of the tournament.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id of the tournament.
     *
     * @param id The id of the tournament.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the name of the tournament.
     *
     * @return The name of the tournament.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the tournament.
     *
     * @param name The name of the tournament.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the type of the tournament.
     *
     * @return The type of the tournament.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the tournament.
     *
     * @param type The type of the tournament.
     */
    public void setType(String type) {
        this.type = type;
    }
}