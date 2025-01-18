package src.main.java.models;

/**
 * The Prize class represents a prize in the chess application.
 * It includes information about the prize's type and value.
 */
public class Prize {
    private int id;
    private String type;
    private Double value;

    /**
     * Constructs a Prize with the specified type and value.
     *
     * @param type  The type of the prize.
     * @param value The value of the prize.
     */
    public Prize(String type, Double value) {
        this.type = type;
        this.value = value;
    }

    /**
     * Returns the id of the prize.
     *
     * @return The id of the prize.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id of the prize.
     *
     * @param id The id of the prize.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the type of the prize.
     *
     * @return The type of the prize.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the prize.
     *
     * @param type The type of the prize.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns the value of the prize.
     *
     * @return The value of the prize.
     */
    public Double getValue() {
        return value;
    }

    /**
     * Sets the value of the prize.
     *
     * @param value The value of the prize.
     */
    public void setValue(Double value) {
        this.value = value;
    }
}