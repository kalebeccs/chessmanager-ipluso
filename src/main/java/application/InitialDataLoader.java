package src.main.java.application;

import src.main.java.controllers.*;
import src.main.java.models.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The InitialDataLoader class loads initial data into the chess application.
 * It provides methods to load arbiters, players, teams, matches, and
 * tournaments.
 */
public class InitialDataLoader {

        /**
         * Loads initial data into the provided controllers.
         *
         * @param playerController      The controller to manage players.
         * @param arbiterController     The controller to manage arbiters.
         * @param teamController        The controller to manage teams.
         * @param singleMatchController The controller to manage single matches.
         * @param doubleMatchController The controller to manage double matches.
         * @param tournamentController  The controller to manage tournaments.
         */
        public static void loadInitialData(PlayerController playerController,
                        ArbiterController arbiterController,
                        TeamController teamController,
                        SingleMatchController singleMatchController,
                        DoubleMatchController doubleMatchController,
                        TournamentController tournamentController) {

                // Arbiters
                loadArbiters(arbiterController);

                // Players
                loadMixedPlayersDoubles(playerController);
                loadMixedTeams(teamController, playerController);
                loadMalePlayersElimination(playerController);
                loadMalePlayersPoints(playerController);
                loadFemalePlayersElimination(playerController);
                loadFemalePlayersPoints(playerController);

                // Matches
                loadMaleSingleEliminationMatches(singleMatchController, playerController, arbiterController);
                loadMaleSinglePointsMatches(singleMatchController, playerController, arbiterController);
                loadFemaleSingleEliminationMatches(singleMatchController, playerController, arbiterController);
                loadFemaleSinglePointsMatches(singleMatchController, playerController, arbiterController);
                loadDoubleMatches(doubleMatchController, teamController, arbiterController);

                // Tournaments
                loadMaleEliminationTournament(tournamentController, singleMatchController);
                loadMalePointsTournament(tournamentController, singleMatchController);
                loadFemaleEliminationTournament(tournamentController, singleMatchController);
                loadFemalePointsTournament(tournamentController, singleMatchController);
                loadDoubleMixedTournament(tournamentController, doubleMatchController);
        }

        /**
         * Loads a predefined list of arbiters into the provided ArbiterController.
         * 
         * @param arbiterController the controller responsible for managing arbiters
         */
        private static void loadArbiters(ArbiterController arbiterController) {
                Arbiter arbiter1 = new Arbiter("Frank", 45, 'M',
                                new ArrayList<>(Arrays.asList("National", "International")));
                Arbiter arbiter2 = new Arbiter("Grace", 38, 'F',
                                new ArrayList<>(Arrays.asList("National")));
                Arbiter arbiter3 = new Arbiter("Hank", 50, 'M',
                                new ArrayList<>(Arrays.asList("International")));
                Arbiter arbiter4 = new Arbiter("Ivy", 42, 'F',
                                new ArrayList<>(Arrays.asList("National", "International")));
                Arbiter arbiter5 = new Arbiter("Jack", 35, 'M',
                                new ArrayList<>(Arrays.asList("National")));
                arbiterController.addArbiter(arbiter1);
                arbiterController.addArbiter(arbiter2);
                arbiterController.addArbiter(arbiter3);
                arbiterController.addArbiter(arbiter4);
                arbiterController.addArbiter(arbiter5);

                System.out.println("Arbiters loaded successfully.");
        }

        /**
         * Loads a predefined list of male players into the player controller for
         * elimination.
         * This method creates several Player objects with specific attributes and adds
         * them to the player controller.
         *
         * @param playerController the PlayerController instance to which the players
         *                         will be added
         */
        private static void loadMalePlayersElimination(PlayerController playerController) {
                Player player1 = new Player("John Doe", 25, 'M', 1500, 30);
                Player player2 = new Player("Michael Smith", 30, 'M', 1600, 40);
                Player player3 = new Player("Robert Brown", 22, 'M', 1400, 20);
                Player player4 = new Player("William Johnson", 28, 'M', 1550, 35);
                Player player5 = new Player("David Jones", 26, 'M', 1450, 25);
                Player player6 = new Player("Richard Davis", 27, 'M', 1350, 15);
                Player player7 = new Player("Joseph Wilson", 24, 'M', 1475, 22);
                Player player8 = new Player("Charles Miller", 29, 'M', 1525, 32);
                playerController.addPlayer(player1);
                playerController.addPlayer(player2);
                playerController.addPlayer(player3);
                playerController.addPlayer(player4);
                playerController.addPlayer(player5);
                playerController.addPlayer(player6);
                playerController.addPlayer(player7);
                playerController.addPlayer(player8);

                System.out.println("Male players for elimination loaded successfully.");
        }

        /**
         * Loads a predefined list of male players with their respective points into the
         * player controller.
         *
         * @param playerController the controller responsible for managing players
         */
        private static void loadMalePlayersPoints(PlayerController playerController) {
                Player player1 = new Player("James Moore", 24, 'M', 1500, 30);
                Player player2 = new Player("Thomas Taylor", 30, 'M', 1600, 40);
                Player player3 = new Player("Christopher Anderson", 22, 'M', 1400, 20);
                Player player4 = new Player("Daniel Thomas", 28, 'M', 1550, 35);
                Player player5 = new Player("Matthew Jackson", 26, 'M', 1450, 25);
                Player player6 = new Player("Anthony White", 27, 'M', 1350, 15);
                Player player7 = new Player("Mark Harris", 24, 'M', 1475, 22);
                Player player8 = new Player("Paul Martin", 29, 'M', 1525, 32);
                playerController.addPlayer(player1);
                playerController.addPlayer(player2);
                playerController.addPlayer(player3);
                playerController.addPlayer(player4);
                playerController.addPlayer(player5);
                playerController.addPlayer(player6);
                playerController.addPlayer(player7);
                playerController.addPlayer(player8);

                System.out.println("Male players for points loaded successfully.");
        }

        /**
         * Loads a predefined list of female players into the player controller for
         * elimination.
         *
         * @param playerController the controller responsible for managing players
         */
        private static void loadFemalePlayersElimination(PlayerController playerController) {
                Player player1 = new Player("Mary Lee", 25, 'F', 1500, 30);
                Player player2 = new Player("Patricia Walker", 28, 'F', 1550, 35);
                Player player3 = new Player("Linda Hall", 26, 'F', 1450, 25);
                Player player4 = new Player("Barbara Allen", 24, 'F', 1475, 22);
                Player player5 = new Player("Elizabeth Young", 23, 'F', 1425, 18);
                Player player6 = new Player("Jennifer King", 32, 'F', 1500, 28);
                Player player7 = new Player("Maria Wright", 24, 'F', 1450, 24);
                Player player8 = new Player("Susan Scott", 27, 'F', 1350, 20);
                playerController.addPlayer(player1);
                playerController.addPlayer(player2);
                playerController.addPlayer(player3);
                playerController.addPlayer(player4);
                playerController.addPlayer(player5);
                playerController.addPlayer(player6);
                playerController.addPlayer(player7);
                playerController.addPlayer(player8);

                System.out.println("Female players for elimination loaded successfully.");
        }

        /**
         * Loads a predefined list of female players with their respective points into
         * the player controller.
         *
         * @param playerController the controller responsible for managing players
         */
        private static void loadFemalePlayersPoints(PlayerController playerController) {
                Player player1 = new Player("Nancy Green", 25, 'F', 1500, 30);
                Player player2 = new Player("Karen Adams", 28, 'F', 1550, 35);
                Player player3 = new Player("Betty Nelson", 26, 'F', 1450, 25);
                Player player4 = new Player("Helen Carter", 24, 'F', 1475, 22);
                Player player5 = new Player("Sandra Mitchell", 23, 'F', 1425, 18);
                Player player6 = new Player("Donna Perez", 32, 'F', 1500, 28);
                Player player7 = new Player("Carol Roberts", 24, 'F', 1450, 24);
                Player player8 = new Player("Ruth Turner", 27, 'F', 1350, 20);
                playerController.addPlayer(player1);
                playerController.addPlayer(player2);
                playerController.addPlayer(player3);
                playerController.addPlayer(player4);
                playerController.addPlayer(player5);
                playerController.addPlayer(player6);
                playerController.addPlayer(player7);
                playerController.addPlayer(player8);

                System.out.println("Female players for points loaded successfully.");
        }

        /**
         * Loads a predefined set of mixed players for doubles into the provided
         * PlayerController.
         * This method creates 16 Player objects with various attributes and adds them
         * to the PlayerController.
         *
         * @param playerController the PlayerController to which the players will be
         *                         added
         */
        private static void loadMixedPlayersDoubles(PlayerController playerController) {
                Player player1 = new Player("Alice Johnson", 25, 'F', 1500, 30);
                Player player2 = new Player("Bob Smith", 30, 'M', 1600, 40);
                Player player3 = new Player("Charlie Brown", 22, 'M', 1400, 20);
                Player player4 = new Player("Diana White", 28, 'F', 1550, 35);
                Player player5 = new Player("Eve Black", 26, 'F', 1450, 25);
                Player player6 = new Player("Frank Green", 27, 'M', 1350, 15);
                Player player7 = new Player("Grace Harris", 24, 'F', 1475, 22);
                Player player8 = new Player("Hank Wilson", 29, 'M', 1525, 32);
                Player player9 = new Player("Ivy Clark", 23, 'F', 1425, 18);
                Player player10 = new Player("Jack Lewis", 31, 'M', 1575, 40);
                Player player11 = new Player("Karen Walker", 32, 'F', 1500, 28);
                Player player12 = new Player("Leo Hall", 26, 'M', 1600, 38);
                Player player13 = new Player("Mona Allen", 24, 'F', 1450, 24);
                Player player14 = new Player("Nate Young", 28, 'M', 1550, 34);
                Player player15 = new Player("Olivia King", 27, 'F', 1350, 20);
                Player player16 = new Player("Paul Wright", 29, 'M', 1525, 30);
                playerController.addPlayer(player1);
                playerController.addPlayer(player2);
                playerController.addPlayer(player3);
                playerController.addPlayer(player4);
                playerController.addPlayer(player5);
                playerController.addPlayer(player6);
                playerController.addPlayer(player7);
                playerController.addPlayer(player8);
                playerController.addPlayer(player9);
                playerController.addPlayer(player10);
                playerController.addPlayer(player11);
                playerController.addPlayer(player12);
                playerController.addPlayer(player13);
                playerController.addPlayer(player14);
                playerController.addPlayer(player15);
                playerController.addPlayer(player16);

                System.out.println("Mixed players for doubles loaded successfully.");
        }

        /**
         * Loads mixed teams into the team controller using players from the player
         * controller.
         * 
         * @param teamController   the controller responsible for managing teams
         * @param playerController the controller responsible for managing players
         * @throws IllegalArgumentException if there are not enough players to form 8
         *                                  teams
         */
        private static void loadMixedTeams(TeamController teamController, PlayerController playerController) {
                ArrayList<Player> players = playerController.getAllPlayers();

                if (players.size() < 16) {
                        throw new IllegalArgumentException("Not enough players to form 8 teams.");
                }

                Team team1 = new Team(players.get(0), players.get(1), "Team Alpha");
                Team team2 = new Team(players.get(2), players.get(3), "Team Bravo");
                Team team3 = new Team(players.get(4), players.get(5), "Team Charlie");
                Team team4 = new Team(players.get(6), players.get(7), "Team Delta");
                Team team5 = new Team(players.get(8), players.get(9), "Team Echo");
                Team team6 = new Team(players.get(10), players.get(11), "Team Foxtrot");
                Team team7 = new Team(players.get(12), players.get(13), "Team Golf");
                Team team8 = new Team(players.get(14), players.get(15), "Team Hotel");

                teamController.addTeam(team1);
                teamController.addTeam(team2);
                teamController.addTeam(team3);
                teamController.addTeam(team4);
                teamController.addTeam(team5);
                teamController.addTeam(team6);
                teamController.addTeam(team7);
                teamController.addTeam(team8);

                System.out.println("Mixed teams loaded successfully.");
        }

        private static void loadMaleSingleEliminationMatches(SingleMatchController singleMatchController,
                        PlayerController playerController, ArbiterController arbiterController) {
                ArrayList<Player> players = playerController.getAllPlayers();
                ArrayList<Arbiter> arbiters = arbiterController.getAllArbiters();

                if (players.size() < 20) { // Verifica se há jogadores suficientes
                        throw new IllegalArgumentException("Not enough players to form matches.");
                }

                if (arbiters.size() < 4) { // Verifica se há árbitros suficientes
                        throw new IllegalArgumentException("Not enough arbiters to oversee matches.");
                }

                SingleMatch match1 = new SingleMatch(players.get(16), players.get(17), arbiters.get(0), "e4 e5", "1:30",
                                players.get(16), "MaleElimination", "1-0");
                SingleMatch match2 = new SingleMatch(players.get(18), players.get(19), arbiters.get(1), "d4 d5", "1:45",
                                players.get(18), "MaleElimination", "1-0");
                SingleMatch match3 = new SingleMatch(players.get(20), players.get(21), arbiters.get(2), "c4 c5", "1:20",
                                players.get(20), "MaleElimination", "1-0");
                SingleMatch match4 = new SingleMatch(players.get(22), players.get(23), arbiters.get(3), "f4 f5", "1:50",
                                players.get(22), "MaleElimination", "1-0");

                singleMatchController.addMatch(match1);
                singleMatchController.addMatch(match2);
                singleMatchController.addMatch(match3);
                singleMatchController.addMatch(match4);

                System.out.println("Male single elimination matches loaded successfully.");
        }

        private static void loadMaleSinglePointsMatches(SingleMatchController singleMatchController,
                        PlayerController playerController, ArbiterController arbiterController) {
                ArrayList<Player> players = playerController.getAllPlayers();
                ArrayList<Arbiter> arbiters = arbiterController.getAllArbiters();

                if (players.size() < 28) { // Verifica se há jogadores suficientes
                        throw new IllegalArgumentException("Not enough players to form matches.");
                }

                if (arbiters.size() < 4) { // Verifica se há árbitros suficientes
                        throw new IllegalArgumentException("Not enough arbiters to oversee matches.");
                }

                SingleMatch match1 = new SingleMatch(players.get(24), players.get(25), arbiters.get(0), "g3 g6", "1:35",
                                players.get(24), "MalePoints", "1-0");
                SingleMatch match2 = new SingleMatch(players.get(26), players.get(27), arbiters.get(1), "b3 b6", "1:40",
                                players.get(26), "MalePoints", "1-0");
                SingleMatch match3 = new SingleMatch(players.get(28), players.get(29), arbiters.get(2), "Nc3 Nc6",
                                "1:25",
                                players.get(28), "MalePoints", "1-0");
                SingleMatch match4 = new SingleMatch(players.get(30), players.get(31), arbiters.get(3), "d3 d6", "1:55",
                                players.get(30), "MalePoints", "1-0");

                singleMatchController.addMatch(match1);
                singleMatchController.addMatch(match2);
                singleMatchController.addMatch(match3);
                singleMatchController.addMatch(match4);

                System.out.println("Male single points matches loaded successfully.");
        }

        private static void loadFemaleSingleEliminationMatches(SingleMatchController singleMatchController,
                        PlayerController playerController, ArbiterController arbiterController) {
                ArrayList<Player> players = playerController.getAllPlayers();
                ArrayList<Arbiter> arbiters = arbiterController.getAllArbiters();

                if (players.size() < 40) { // Verifica se há jogadores suficientes
                        throw new IllegalArgumentException("Not enough players to form matches.");
                }

                if (arbiters.size() < 4) { // Verifica se há árbitros suficientes
                        throw new IllegalArgumentException("Not enough arbiters to oversee matches.");
                }

                SingleMatch match1 = new SingleMatch(players.get(32), players.get(33), arbiters.get(0), "e4 e5", "1:30",
                                players.get(32), "FemaleElimination", "1-0");
                SingleMatch match2 = new SingleMatch(players.get(34), players.get(35), arbiters.get(1), "d4 d5", "1:45",
                                players.get(34), "FemaleElimination", "1-0");
                SingleMatch match3 = new SingleMatch(players.get(36), players.get(37), arbiters.get(2), "c4 c5", "1:20",
                                players.get(36), "FemaleElimination", "1-0");
                SingleMatch match4 = new SingleMatch(players.get(38), players.get(39), arbiters.get(3), "f4 f5", "1:50",
                                players.get(38), "FemaleElimination", "1-0");

                singleMatchController.addMatch(match1);
                singleMatchController.addMatch(match2);
                singleMatchController.addMatch(match3);
                singleMatchController.addMatch(match4);

                System.out.println("Female single elimination matches loaded successfully.");
        }

        private static void loadFemaleSinglePointsMatches(SingleMatchController singleMatchController,
                        PlayerController playerController, ArbiterController arbiterController) {
                ArrayList<Player> players = playerController.getAllPlayers();
                ArrayList<Arbiter> arbiters = arbiterController.getAllArbiters();

                if (players.size() < 48) { // Verifica se há jogadores suficientes
                        throw new IllegalArgumentException("Not enough players to form matches.");
                }

                if (arbiters.size() < 4) { // Verifica se há árbitros suficientes
                        throw new IllegalArgumentException("Not enough arbiters to oversee matches.");
                }

                SingleMatch match1 = new SingleMatch(players.get(40), players.get(41), arbiters.get(0), "g3 g6", "1:35",
                                players.get(40), "FemalePoints", "1-0");
                SingleMatch match2 = new SingleMatch(players.get(42), players.get(43), arbiters.get(1), "b3 b6", "1:40",
                                players.get(42), "FemalePoints", "1-0");
                SingleMatch match3 = new SingleMatch(players.get(44), players.get(45), arbiters.get(2), "Nc3 Nc6",
                                "1:25",
                                players.get(44), "FemalePoints", "1-0");
                SingleMatch match4 = new SingleMatch(players.get(46), players.get(47), arbiters.get(3), "d3 d6", "1:55",
                                players.get(46), "FemalePoints", "1-0");

                singleMatchController.addMatch(match1);
                singleMatchController.addMatch(match2);
                singleMatchController.addMatch(match3);
                singleMatchController.addMatch(match4);

                System.out.println("Female single points matches loaded successfully.");
        }

        private static void loadDoubleMatches(DoubleMatchController doubleMatchController,
                        TeamController teamController, ArbiterController arbiterController) {
                ArrayList<Team> teams = teamController.getAllTeams();
                ArrayList<Arbiter> arbiters = arbiterController.getAllArbiters();

                if (teams.size() < 8) { // Verifica se há equipes suficientes
                        throw new IllegalArgumentException("Not enough teams to form matches.");
                }

                if (arbiters.size() < 4) { // Verifica se há árbitros suficientes
                        throw new IllegalArgumentException("Not enough arbiters to oversee matches.");
                }

                DoubleMatch match1 = new DoubleMatch(teams.get(0), teams.get(1), arbiters.get(0), "e4 e5", "1-0",
                                "1:30",
                                teams.get(0), "Doubles");
                DoubleMatch match2 = new DoubleMatch(teams.get(2), teams.get(3), arbiters.get(1), "d4 d5", "1-0",
                                "1:45",
                                teams.get(2), "Doubles");
                DoubleMatch match3 = new DoubleMatch(teams.get(4), teams.get(5), arbiters.get(2), "c4 c5", "1-0",
                                "1:20",
                                teams.get(4), "Doubles");
                DoubleMatch match4 = new DoubleMatch(teams.get(6), teams.get(7), arbiters.get(3), "f4 f5", "1-0",
                                "1:50",
                                teams.get(6), "Doubles");

                doubleMatchController.addMatch(match1);
                doubleMatchController.addMatch(match2);
                doubleMatchController.addMatch(match3);
                doubleMatchController.addMatch(match4);

                System.out.println("Double matches loaded successfully.");
        }

        private static void loadMaleEliminationTournament(TournamentController tournamentController,
                        SingleMatchController singleMatchController) {
                tournamentController.addMatchToSingleTournament(1, singleMatchController.getMatchById(1));
                tournamentController.addMatchToSingleTournament(1, singleMatchController.getMatchById(2));
                tournamentController.addMatchToSingleTournament(1, singleMatchController.getMatchById(3));
                tournamentController.addMatchToSingleTournament(1, singleMatchController.getMatchById(4));
        }

        private static void loadMalePointsTournament(TournamentController tournamentController,
                        SingleMatchController singleMatchController) {
                tournamentController.addMatchToSingleTournament(2, singleMatchController.getMatchById(5));
                tournamentController.addMatchToSingleTournament(2, singleMatchController.getMatchById(6));
                tournamentController.addMatchToSingleTournament(2, singleMatchController.getMatchById(7));
                tournamentController.addMatchToSingleTournament(2, singleMatchController.getMatchById(8));
        }

        /**
         * Loads the female elimination tournament by adding matches to the single
         * tournament.
         *
         * @param tournamentController  the controller responsible for managing
         *                              tournaments
         * @param singleMatchController the controller responsible for managing single
         *                              matches
         */
        private static void loadFemaleEliminationTournament(TournamentController tournamentController,
                        SingleMatchController singleMatchController) {
                tournamentController.addMatchToSingleTournament(3, singleMatchController.getMatchById(9));
                tournamentController.addMatchToSingleTournament(3, singleMatchController.getMatchById(10));
                tournamentController.addMatchToSingleTournament(3, singleMatchController.getMatchById(11));
                tournamentController.addMatchToSingleTournament(3, singleMatchController.getMatchById(12));
        }

        /**
         * Loads female points tournament by adding matches to a single tournament.
         *
         * @param tournamentController  the controller responsible for managing
         *                              tournaments
         * @param singleMatchController the controller responsible for managing single
         *                              matches
         */
        private static void loadFemalePointsTournament(TournamentController tournamentController,
                        SingleMatchController singleMatchController) {
                tournamentController.addMatchToSingleTournament(4, singleMatchController.getMatchById(13));
                tournamentController.addMatchToSingleTournament(4, singleMatchController.getMatchById(14));
                tournamentController.addMatchToSingleTournament(4, singleMatchController.getMatchById(15));
                tournamentController.addMatchToSingleTournament(4, singleMatchController.getMatchById(16));
        }

        /**
         * Loads a double mixed tournament by adding matches to the tournament
         * controller.
         *
         * @param tournamentController  the controller responsible for managing the
         *                              tournament
         * @param doubleMatchController the controller responsible for managing double
         *                              matches
         */
        private static void loadDoubleMixedTournament(TournamentController tournamentController,
                        DoubleMatchController doubleMatchController) {
                tournamentController.addMatchToDoubleTournament(doubleMatchController.getMatchById(1));
                tournamentController.addMatchToDoubleTournament(doubleMatchController.getMatchById(2));
                tournamentController.addMatchToDoubleTournament(doubleMatchController.getMatchById(3));
                tournamentController.addMatchToDoubleTournament(doubleMatchController.getMatchById(4));
        }

}