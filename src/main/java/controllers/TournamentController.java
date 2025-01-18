package src.main.java.controllers;

import src.main.java.models.SingleTournament;
import src.main.java.models.DoubleMatch;
import src.main.java.models.DoubleTournament;
import src.main.java.models.SingleMatch;

/**
 * The TournamentController class manages various types of tournaments,
 * including:
 * <ul>
 * <li>Male Elimination Tournament</li>
 * <li>Male Points Tournament</li>
 * <li>Female Elimination Tournament</li>
 * <li>Female Points Tournament</li>
 * <li>Double Mixed Tournament</li>
 * </ul>
 * It provides methods to add, remove, retrieve, and update matches and
 * tournaments.
 */
public class TournamentController {
    private SingleTournament maleEliminationTournament;
    private SingleTournament malePointsTournament;
    private SingleTournament femaleEliminationTournament;
    private SingleTournament femalePointsTournament;
    private DoubleTournament doubleMixedTournament;

    /**
     * Constructs a new TournamentController and initializes the tournaments.
     * The tournaments include:
     * <ul>
     * <li>Male Elimination Tournament</li>
     * <li>Male Points Tournament</li>
     * <li>Female Elimination Tournament</li>
     * <li>Female Points Tournament</li>
     * <li>Double Mixed Tournament</li>
     * </ul>
     */
    public TournamentController() {
        this.maleEliminationTournament = new SingleTournament(1, "Male Elimination Tournament",
                "SingleMaleElimination");
        this.malePointsTournament = new SingleTournament(2, "Male Points Tournament", "SingleMalePoints");
        this.femaleEliminationTournament = new SingleTournament(3, "Female Elimination Tournament",
                "SingleFemaleElimination");
        this.femalePointsTournament = new SingleTournament(4, "Female Pointes Tournament", "SingleFemalePoints");
        this.doubleMixedTournament = new DoubleTournament(5, "Double Mixed Tournament", "DoubleMixedPoints");
    }

    /**
     * Adds a match to the specified single tournament based on the tournament ID.
     *
     * @param tournamentId the ID of the tournament to which the match will be added
     *                     (1 for male elimination, 2 for male points, 3 for female
     *                     elimination, 4 for female points)
     * @param match        the SingleMatch object to be added to the tournament
     */
    public void addMatchToSingleTournament(int tournamentId, SingleMatch match) {
        switch (tournamentId) {
            case 1:
                maleEliminationTournament.addMatch(match);
                break;
            case 2:
                malePointsTournament.addMatch(match);
                break;
            case 3:
                femaleEliminationTournament.addMatch(match);
                break;
            case 4:
                femalePointsTournament.addMatch(match);
                break;
            default:
                System.out.println("Invalid tournament id");
        }

    }

    /**
     * Adds a match to the double mixed tournament.
     *
     * @param match the match to be added to the tournament
     */
    public void addMatchToDoubleTournament(DoubleMatch match) {
        doubleMixedTournament.addMatch(match);
    }

    /**
     * Removes a match from a specific single tournament based on the tournament ID.
     *
     * @param tournamentId the ID of the tournament from which the match will be
     *                     removed
     *                     (1 for male elimination, 2 for male points, 3 for female
     *                     elimination, 4 for female points)
     * @param match        the match to be removed from the specified tournament
     */
    public void removeMatchFromSingleTournament(int tournamentId, SingleMatch match) {
        switch (tournamentId) {
            case 1:
                maleEliminationTournament.removeMatch(match);
                break;
            case 2:
                malePointsTournament.removeMatch(match);
                break;
            case 3:
                femaleEliminationTournament.removeMatch(match);
                break;
            case 4:
                femalePointsTournament.removeMatch(match);
                break;
            default:
                System.out.println("Invalid tournament id");
        }
    }

    /**
     * Removes a match from the double mixed tournament.
     *
     * @param match the match to be removed from the tournament
     */
    public void removeMatchFromDoubleTournament(DoubleMatch match) {
        doubleMixedTournament.removeMatch(match);
    }

    /**
     * Retrieves a single tournament based on the specified type.
     *
     * @param type the type of the tournament to retrieve. Valid values are:
     *             "SingleMaleElimination", "SingleMalePoints",
     *             "SingleFemaleElimination", "SingleFemalePoints".
     * @return the corresponding SingleTournament object, or null if the type is
     *         invalid.
     */
    public SingleTournament getSingleTournamentbyType(String type) {
        switch (type) {
            case "SingleMaleElimination":
                return maleEliminationTournament;
            case "SingleMalePoints":
                return malePointsTournament;
            case "SingleFemaleElimination":
                return femaleEliminationTournament;
            case "SingleFemalePoints":
                return femalePointsTournament;
            default:
                System.out.println("Invalid tournament type");
                return null;
        }
    }

    /**
     * Retrieves a SingleTournament instance based on the provided tournament ID.
     *
     * @param tournamentId the ID of the tournament to retrieve
     * @return the SingleTournament instance corresponding to the given ID, or null
     *         if the ID is invalid
     */
    public SingleTournament getSingleTournamentbyId(int tournamentId) {
        switch (tournamentId) {
            case 1:
                return maleEliminationTournament;
            case 2:
                return malePointsTournament;
            case 3:
                return femaleEliminationTournament;
            case 4:
                return femalePointsTournament;
            default:
                System.out.println("Invalid tournament id");
                return null;
        }
    }

    /**
     * Retrieves the double mixed tournament.
     *
     * @return the double mixed tournament
     */
    public DoubleTournament getDoubleTournament() {
        return doubleMixedTournament;
    }

    /**
     * Updates the specified single tournament based on the tournament ID.
     *
     * @param tournamentId the ID of the tournament to update
     *                     (1 for male elimination, 2 for male points,
     *                     3 for female elimination, 4 for female points)
     * @param tournament   the SingleTournament object to update
     */
    public void updateSingleTournament(int tournamentId, SingleTournament tournament) {
        switch (tournamentId) {
            case 1:
                maleEliminationTournament = tournament;
                break;
            case 2:
                malePointsTournament = tournament;
                break;
            case 3:
                femaleEliminationTournament = tournament;
                break;
            case 4:
                femalePointsTournament = tournament;
                break;
            default:
                System.out.println("Invalid tournament id");
        }
    }

}
