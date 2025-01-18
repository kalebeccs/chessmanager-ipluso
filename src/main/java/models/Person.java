package src.main.java.models;

/**
 * The Person class represents a person in the chess application.
 * It serves as a base class for other specific types of persons such as players
 * and arbiters.
 */
public abstract class Person {
    protected int id;
    protected String name;
    protected int age;
    protected char gender;

    /**
     * Constructs a Person with the specified name, age, and gender.
     *
     * @param name   The name of the person.
     * @param age    The age of the person.
     * @param gender The gender of the person.
     */
    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    /**
     * Returns the id of the person.
     *
     * @return The id of the person.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id of the person.
     *
     * @param id The id of the person.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the name of the person.
     *
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     *
     * @param name The name of the person.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the age of the person.
     *
     * @return The age of the person.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the person.
     *
     * @param age The age of the person.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns the gender of the person.
     *
     * @return The gender of the person.
     */
    public char getGender() {
        return gender;
    }

    /**
     * Sets the gender of the person.
     *
     * @param gender The gender of the person.
     */
    public void setGender(char gender) {
        this.gender = gender;
    }
}