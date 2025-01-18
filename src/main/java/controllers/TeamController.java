package src.main.java.controllers;

import src.main.java.models.Team;
import java.util.ArrayList;

/**
 * The TeamController class manages the teams in the chess application.
 * It provides methods to add, edit, retrieve, and delete teams.
 */
public class TeamController {
    private ArrayList<Team> teams;
    private int nextId;

    /**
     * Constructs a TeamController with an empty list of teams and an ID
     * incrementer.
     */
    public TeamController() {
        this.teams = new ArrayList<>();
        this.nextId = 1;
    }

    /**
     * Adds a team to the list and assigns a unique ID to the team.
     *
     * @param team The team to add.
     */
    public void addTeam(Team team) {
        team.setId(nextId++);
        teams.add(team);
    }

    /**
     * Edits the details of an existing team.
     *
     * @param id          The ID of the team to edit.
     * @param updatedTeam The updated team details.
     */
    public void editTeam(int id, Team updatedTeam) {
        for (Team team : teams) {
            if (team.getId() == id) {
                team.setPlayer1(updatedTeam.getPlayer1());
                team.setPlayer2(updatedTeam.getPlayer2());
                team.setName(updatedTeam.getName());
                break;
            }
        }
    }

    /**
     * Retrieves a team by their ID.
     *
     * @param id The ID of the team to retrieve.
     * @return The team with the specified ID, or null if not found.
     */
    public Team getTeam(int id) {
        for (Team team : teams) {
            if (team.getId() == id) {
                return team;
            }
        }
        return null;
    }

    /**
     * Deletes a team by their ID.
     *
     * @param id The ID of the team to delete.
     */
    public void deleteTeam(int id) {
        teams.removeIf(team -> team.getId() == id);
    }

    /**
     * Returns a list of all teams.
     *
     * @return A list of all teams.
     */
    public ArrayList<Team> getAllTeams() {
        return new ArrayList<>(teams);
    }
}