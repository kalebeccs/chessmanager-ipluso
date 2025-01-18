package src.main.java.controllers;

import src.main.java.models.Arbiter;
import java.util.ArrayList;
import java.util.Optional;

/**
 * The ArbiterController class manages the arbiters in the chess application.
 * It provides methods to add, edit, retrieve, and delete arbiters.
 */
public class ArbiterController {
    private ArrayList<Arbiter> arbiters;
    private int idIncrementer;

    /**
     * Constructs an ArbiterController with an empty list of arbiters and an ID
     * incrementer.
     */
    public ArbiterController() {
        this.arbiters = new ArrayList<>();
        this.idIncrementer = 1;
    }

    /**
     * Adds an arbiter to the list and assigns a unique ID to the arbiter.
     *
     * @param arbiter The arbiter to add.
     */
    public void addArbiter(Arbiter arbiter) {
        arbiters.add(arbiter);
        arbiter.setId(idIncrementer++);
    }

    /**
     * Edits the details of an existing arbiter.
     *
     * @param id             The ID of the arbiter to edit.
     * @param updatedArbiter The updated arbiter details.
     */
    public void editArbiter(int id, Arbiter updatedArbiter) {
        Optional<Arbiter> arbiterOptional = arbiters.stream()
                .filter(arb -> arb.getId() == id)
                .findFirst();

        if (arbiterOptional.isPresent()) {
            Arbiter arbiter = arbiterOptional.get();
            arbiter.setName(updatedArbiter.getName());
            arbiter.setAge(updatedArbiter.getAge());
            arbiter.setGender(updatedArbiter.getGender());
            arbiter.setCertifications(updatedArbiter.getCertifications());
        }
    }

    /**
     * Retrieves an arbiter by their ID.
     *
     * @param id The ID of the arbiter to retrieve.
     * @return The arbiter with the specified ID, or null if not found.
     */
    public Arbiter getArbiter(int id) {
        return arbiters.stream()
                .filter(arb -> arb.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Deletes an arbiter by their ID.
     *
     * @param id The ID of the arbiter to delete.
     */
    public void deleteArbiter(int id) {
        arbiters.removeIf(arb -> arb.getId() == id);
    }

    /**
     * Returns a list of all arbiters.
     *
     * @return A list of all arbiters.
     */
    public ArrayList<Arbiter> getAllArbiters() {
        return new ArrayList<>(arbiters);
    }
}