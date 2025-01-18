package src.main.java.models;

import java.util.List;

/**
 * The Arbiter class represents an arbiter in the chess application.
 * It extends the Person class and includes additional information
 * about the arbiter's certifications.
 */
public class Arbiter extends Person {
    private List<String> certifications;

    /**
     * Constructs an Arbiter with the specified name, age, gender, and
     * certifications.
     *
     * @param name           The name of the arbiter.
     * @param age            The age of the arbiter.
     * @param gender         The gender of the arbiter.
     * @param certifications The list of certifications of the arbiter.
     */
    public Arbiter(String name, int age, char gender, List<String> certifications) {
        super(name, age, gender);
        this.certifications = certifications;
    }

    /**
     * Returns the list of certifications of the arbiter.
     *
     * @return The list of certifications.
     */
    public List<String> getCertifications() {
        return certifications;
    }

    /**
     * Sets the list of certifications of the arbiter.
     *
     * @param certifications The new list of certifications.
     */
    public void setCertifications(List<String> certifications) {
        this.certifications = certifications;
    }
}