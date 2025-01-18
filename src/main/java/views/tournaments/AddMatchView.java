package src.main.java.views.tournaments;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import src.main.java.controllers.SingleMatchController;
import src.main.java.controllers.DoubleMatchController;
import src.main.java.controllers.TournamentController;
import src.main.java.models.SingleMatch;
import src.main.java.models.DoubleMatch;
import src.main.java.views.base.BaseView;

public class AddMatchView extends BaseView {
    private JComboBox<String> matchTypeComboBox;
    private JComboBox<Object> matchComboBox;
    private JComboBox<String> tournamentComboBox;
    private JButton btnAddMatch;
    private JButton btnBack;
    private SingleMatchController singleMatchController;
    private DoubleMatchController doubleMatchController;
    private TournamentController tournamentController;

    public AddMatchView(JPanel mainPanel, CardLayout cardLayout, SingleMatchController singleMatchController,
            DoubleMatchController doubleMatchController, TournamentController tournamentController) {
        super(mainPanel, cardLayout);
        this.singleMatchController = singleMatchController;
        this.doubleMatchController = doubleMatchController;
        this.tournamentController = tournamentController;
        addTitle("Add Match to Tournament");

        matchTypeComboBox = new JComboBox<>(new String[] { "Single Matches", "Double Matches" });
        matchTypeComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        matchTypeComboBox.addActionListener(e -> loadMatchesandTournament());

        matchComboBox = new JComboBox<>();
        matchComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel tournamentLabel = new JLabel("Select Tournament:");
        tournamentLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        tournamentComboBox = new JComboBox<>();
        tournamentComboBox.setMaximumSize(new Dimension(200, 30));
        tournamentComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnAddMatch = new JButton("Add Match");
        btnAddMatch.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnBack = new JButton("Back");
        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalGlue());
        panel.add(matchTypeComboBox);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(matchComboBox);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(tournamentLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(tournamentComboBox);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnAddMatch);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(btnBack);
        panel.add(Box.createVerticalGlue());

        btnAddMatch.addActionListener(e -> {
            Object selectedMatch = matchComboBox.getSelectedItem();
            String selectedTournament = (String) tournamentComboBox.getSelectedItem();
            if (selectedMatch != null && selectedTournament != null
                    && !selectedTournament.equals("Select a tournament") && !selectedMatch.equals("Select a match")) {
                try {
                    int tournamentId = Integer.parseInt(selectedTournament.split(" - ")[0]);
                    if (selectedMatch instanceof SingleMatch) {
                        tournamentController.addMatchToSingleTournament(tournamentId, (SingleMatch) selectedMatch);
                    } else if (selectedMatch instanceof DoubleMatch) {
                        tournamentController.addMatchToDoubleTournament((DoubleMatch) selectedMatch);
                    }
                    System.out.println("Match added to tournament: " + selectedMatch);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(mainPanel, "Error adding match to tournament", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(mainPanel, "Please select a match and a tournament", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        btnBack.addActionListener(e -> cardLayout.show(mainPanel, "TournamentView"));

        loadMatchesandTournament();
    }

    private void loadMatchesandTournament() {
        matchComboBox.removeAllItems();
        matchComboBox.addItem("Select a match");
        tournamentComboBox.removeAllItems();
        tournamentComboBox.addItem("Select a tournament");
        String selectedType = (String) matchTypeComboBox.getSelectedItem();
        if ("Single Matches".equals(selectedType)) {
            List<SingleMatch> matches = singleMatchController.getAllMatches();
            for (SingleMatch match : matches) {
                String matchInfo = match.getId() + " - " + match.getPlayer1().getName() + " & "
                        + match.getPlayer2().getName() + " - " + match.getType();
                matchComboBox.addItem(matchInfo);
            }
            tournamentComboBox.addItem("1 - Male Single Elimination");
            tournamentComboBox.addItem("2 - Male Single Points");
            tournamentComboBox.addItem("3 - Female Single Elimination");
            tournamentComboBox.addItem("4 - Female Single Points");
        } else if ("Double Matches".equals(selectedType)) {
            List<DoubleMatch> matches = doubleMatchController.getAllMatches();
            for (DoubleMatch match : matches) {
                String matchInfo = match.getId() + " - " + match.getTeam1().getName() + " & "
                        + match.getTeam2().getName() + " - " + match.getType();
                matchComboBox.addItem(matchInfo);
            }
            tournamentComboBox.addItem("5 - Mixed Double Points");
        }
    }
}