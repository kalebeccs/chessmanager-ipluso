package src.main.java.application;

import javax.swing.*;
import java.awt.*;
import src.main.java.controllers.*;
import src.main.java.views.*;
import src.main.java.views.arbiter.*;
import src.main.java.views.player.*;
import src.main.java.views.matches.*;
import src.main.java.views.matches.single.*;
import src.main.java.views.matches.doubles.*;
import src.main.java.views.tournaments.*;

/**
 * The ViewManager class manages the different views in the chess application.
 * It initializes the controllers and loads the initial data.
 */
public class ViewManager {
        private JPanel mainPanel;
        private CardLayout cardLayout;
        private ArbiterController arbiterController;
        private PlayerController playerController;
        private TeamController teamController;
        private SingleMatchController singleMatchController;
        private DoubleMatchController doubleMatchController;
        private TournamentController tournamentController;

        /**
         * Constructs a ViewManager with the specified main panel and card layout.
         *
         * @param mainPanel  The main panel to hold the views.
         * @param cardLayout The card layout to manage the views.
         */
        public ViewManager(JPanel mainPanel, CardLayout cardLayout) {
                this.mainPanel = mainPanel;
                this.cardLayout = cardLayout;

                // Instantiate controllers
                arbiterController = new ArbiterController();
                playerController = new PlayerController();
                teamController = new TeamController();
                singleMatchController = new SingleMatchController();
                doubleMatchController = new DoubleMatchController(teamController);
                tournamentController = new TournamentController();

                // Load initial data
                InitialDataLoader.loadInitialData(playerController,
                                arbiterController,
                                teamController,
                                singleMatchController,
                                doubleMatchController,
                                tournamentController);

                // Instantiate views
                RankingView rankingView = new RankingView(mainPanel, cardLayout, playerController);
                InitialView initialView = new InitialView(mainPanel, cardLayout, rankingView);
                PrizeView prizeView = new PrizeView(mainPanel, cardLayout);

                // Player views
                PlayerView playerView = new PlayerView(mainPanel, cardLayout);
                PlayerRegistrationView playerRegistrationView = new PlayerRegistrationView(mainPanel, cardLayout,
                                playerController, rankingView);
                PlayerEditView playerEditView = new PlayerEditView(mainPanel, cardLayout, playerController);
                PlayerConsultView playerConsultView = new PlayerConsultView(mainPanel, cardLayout, playerController);
                PlayerDeleteView playerDeleteView = new PlayerDeleteView(mainPanel, cardLayout, playerController);

                // Arbiter views
                ArbiterView arbiterView = new ArbiterView(mainPanel, cardLayout);
                ArbiterRegistrationView arbiterRegistrationView = new ArbiterRegistrationView(mainPanel, cardLayout,
                                arbiterController);
                ArbiterEditView arbiterEditView = new ArbiterEditView(mainPanel, cardLayout, arbiterController);
                ArbiterConsultView arbiterConsultView = new ArbiterConsultView(mainPanel, cardLayout,
                                arbiterController);
                ArbiterDeleteView arbiterDeleteView = new ArbiterDeleteView(mainPanel, cardLayout, arbiterController);

                // Match views
                MatchView matchView = new MatchView(mainPanel, cardLayout);

                // Single match views
                SingleMatchView singleMatchView = new SingleMatchView(mainPanel, cardLayout);
                AddSingleMatchView addSingleMatchView = new AddSingleMatchView(mainPanel, cardLayout,
                                singleMatchController,
                                playerController, arbiterController);
                EditSingleMatchView editSingleMatchView = new EditSingleMatchView(mainPanel, cardLayout,
                                singleMatchController,
                                playerController, arbiterController);
                ViewSingleMatchView viewSingleMatchView = new ViewSingleMatchView(mainPanel, cardLayout,
                                singleMatchController);
                DeleteSingleMatchView deleteSingleMatchView = new DeleteSingleMatchView(mainPanel, cardLayout,
                                singleMatchController);

                // Double match views
                DoubleMatchView doubleMatchView = new DoubleMatchView(mainPanel, cardLayout);
                AddDoubleMatchView addDoubleMatchView = new AddDoubleMatchView(mainPanel, cardLayout,
                                doubleMatchController, playerController, arbiterController);
                EditDoubleMatchView editDoubleMatchView = new EditDoubleMatchView(mainPanel, cardLayout,
                                doubleMatchController, playerController, arbiterController);
                ViewDoubleMatchView viewDoubleMatchView = new ViewDoubleMatchView(mainPanel, cardLayout,
                                doubleMatchController);
                DeleteDoubleMatchView deleteDoubleMatchView = new DeleteDoubleMatchView(mainPanel, cardLayout,
                                doubleMatchController);

                // Tournament views

                TournamentView tournamentView = new TournamentView(mainPanel, cardLayout);
                AddMatchView addMatchView = new AddMatchView(mainPanel, cardLayout, singleMatchController,
                                doubleMatchController, tournamentController);
                ViewMatchesView viewMatchesView = new ViewMatchesView(mainPanel, cardLayout,
                                tournamentController);
                RemoveMatchView removeMatchView = new RemoveMatchView(mainPanel, cardLayout, singleMatchController,
                                doubleMatchController, tournamentController);

                // Add views to the main panel
                mainPanel.add(initialView.getPanel(), "InitialView");
                mainPanel.add(prizeView.getPanel(), "PrizeView");
                mainPanel.add(rankingView.getPanel(), "RankingView");

                // Player views
                mainPanel.add(playerView.getPanel(), "PlayerView");
                mainPanel.add(playerRegistrationView.getPanel(), "PlayerRegistrationView");
                mainPanel.add(playerEditView.getPanel(), "PlayerEditView");
                mainPanel.add(playerConsultView.getPanel(), "PlayerConsultView");
                mainPanel.add(playerDeleteView.getPanel(), "PlayerDeleteView");

                // Arbiter views
                mainPanel.add(arbiterView.getPanel(), "ArbiterView");
                mainPanel.add(arbiterRegistrationView.getPanel(), "ArbiterRegistrationView");
                mainPanel.add(arbiterEditView.getPanel(), "ArbiterEditView");
                mainPanel.add(arbiterConsultView.getPanel(), "ArbiterConsultView");
                mainPanel.add(arbiterDeleteView.getPanel(), "ArbiterDeleteView");

                // Match views
                mainPanel.add(matchView.getPanel(), "MatchView");

                // Single match views
                mainPanel.add(singleMatchView.getPanel(), "SingleMatchView");
                mainPanel.add(addSingleMatchView.getPanel(), "AddSingleMatchView");
                mainPanel.add(editSingleMatchView.getPanel(), "EditSingleMatchView");
                mainPanel.add(viewSingleMatchView.getPanel(), "ViewSingleMatchView");
                mainPanel.add(deleteSingleMatchView.getPanel(), "DeleteSingleMatchView");

                // Double match views
                mainPanel.add(doubleMatchView.getPanel(), "DoubleMatchView");
                mainPanel.add(addDoubleMatchView.getPanel(), "AddDoubleMatchView");
                mainPanel.add(editDoubleMatchView.getPanel(), "EditDoubleMatchView");
                mainPanel.add(viewDoubleMatchView.getPanel(), "ViewDoubleMatchView");
                mainPanel.add(deleteDoubleMatchView.getPanel(), "DeleteDoubleMatchView");

                // Tournament views
                mainPanel.add(tournamentView.getPanel(), "TournamentView");
                mainPanel.add(addMatchView.getPanel(), "AddMatchView");
                mainPanel.add(viewMatchesView.getPanel(), "ViewMatchesView");
                mainPanel.add(removeMatchView.getPanel(), "RemoveMatchView");
        }

        /**
         * Shows the view with the specified name.
         *
         * @param viewName The name of the view to show.
         */
        public void showView(String viewName) {
                cardLayout.show(mainPanel, viewName);
        }
}