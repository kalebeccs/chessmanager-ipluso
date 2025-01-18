package src.main.java.views.tournaments;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import src.main.java.controllers.SingleMatchController;
import src.main.java.controllers.DoubleMatchController;
import src.main.java.controllers.TournamentController;
import src.main.java.models.SingleMatch;
import src.main.java.models.DoubleMatch;
import src.main.java.views.base.BaseView;

public class RemoveMatchView extends BaseView {
    private JComboBox<String> tournamentComboBox;
    private JComboBox<Object> matchComboBox;
    private JButton btnRemoveMatch;
    private JButton btnBack;
    private SingleMatchController singleMatchController;
    private DoubleMatchController doubleMatchController;
    private TournamentController tournamentController;

    public RemoveMatchView(JPanel mainPanel, CardLayout cardLayout, SingleMatchController singleMatchController,
            DoubleMatchController doubleMatchController, TournamentController tournamentController) {
        super(mainPanel, cardLayout);
        this.singleMatchController = singleMatchController;
        this.doubleMatchController = doubleMatchController;
        this.tournamentController = tournamentController;
        addTitle("Remove Match from Tournament");

        JLabel tournamentLabel = new JLabel("Select Tournament:");
        tournamentLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        tournamentComboBox = new JComboBox<>(new String[] {
                "Select Tournament",
                "1 - Male Single Elimination",
                "2 - Male Single Points",
                "3 - Female Single Elimination",
                "4 - Female Single Points",
                "5 - Mixed Double Points"
        });
        tournamentComboBox.setMaximumSize(new Dimension(200, 30));
        tournamentComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        tournamentComboBox.addActionListener(e -> {
            if (!"Select Tournament".equals(tournamentComboBox.getSelectedItem())) {
                loadMatches();
            }
        });

        matchComboBox = new JComboBox<>();
        matchComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnRemoveMatch = new JButton("Remove Match");
        btnRemoveMatch.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnBack = new JButton("Back");
        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalGlue());
        panel.add(tournamentLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(tournamentComboBox);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(matchComboBox);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnRemoveMatch);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(btnBack);
        panel.add(Box.createVerticalGlue());

        btnRemoveMatch.addActionListener(e -> {
            String selectedMatch = (String) matchComboBox.getSelectedItem();
            String selectedMatchType = selectedMatch.split(" ")[0];
            String selectedTournament = (String) tournamentComboBox.getSelectedItem();

            if (selectedMatch != null && selectedTournament != null
                    && !selectedTournament.equals("Select Tournament")) {
                try {
                    int tournamentId = Integer.parseInt(selectedTournament.split(" - ")[0]);
                    int selectedMatchId = Integer.parseInt(selectedMatch.split(" ")[1]);
                    if (selectedMatchType.equals("Single")) {
                        SingleMatch match = singleMatchController.getMatchById(selectedMatchId);
                        tournamentController.removeMatchFromSingleTournament(tournamentId, match);
                    } else if (selectedMatchType.equals("Double")) {
                        DoubleMatch match = doubleMatchController.getMatchById(selectedMatchId);
                        tournamentController.removeMatchFromDoubleTournament(match);
                    }
                    loadMatches();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(mainPanel, "Error removing match from tournament", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(mainPanel, "Please select a match and a tournament", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        btnBack.addActionListener(e -> cardLayout.show(mainPanel, "TournamentView"));
    }

    private void loadMatches() {
        matchComboBox.removeAllItems();
        String selectedTournament = (String) tournamentComboBox.getSelectedItem();
        int tournamentId = Integer.parseInt(selectedTournament.split(" - ")[0]);
        if (tournamentId == 5) {
            ArrayList<DoubleMatch> matches = tournamentController.getDoubleTournament().getMatches();
            for (DoubleMatch match : matches) {
                matchComboBox.addItem("Double " + match.getId() + " - " + match.getTeam1().getName() + " vs "
                        + match.getTeam2().getName());
            }
        } else {
            ArrayList<SingleMatch> matches = tournamentController.getSingleTournamentbyId(tournamentId).getMatches();
            for (SingleMatch match : matches) {
                matchComboBox.addItem("Single " + match.getId() + " - " + match.getPlayer1().getName() + " vs "
                        + match.getPlayer2().getName());
            }
        }
    }
}