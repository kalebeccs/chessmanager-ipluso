package src.main.java.views.tournaments;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import src.main.java.controllers.TournamentController;
import src.main.java.models.SingleMatch;
import src.main.java.models.DoubleMatch;
import src.main.java.views.base.BaseView;

public class ViewMatchesView extends BaseView {
    private JComboBox<String> tournamentComboBox;
    private JList<Object> matchList;
    private JButton btnBack;
    private TournamentController tournamentController;

    public ViewMatchesView(JPanel mainPanel, CardLayout cardLayout, TournamentController tournamentController) {
        super(mainPanel, cardLayout);
        this.tournamentController = tournamentController;
        addTitle("View Matches in Tournament");

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

        matchList = new JList<>();
        matchList.setAlignmentX(Component.CENTER_ALIGNMENT);
        JScrollPane scrollPane = new JScrollPane(matchList);
        scrollPane.setPreferredSize(new Dimension(300, 200));

        btnBack = new JButton("Back");
        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalGlue());
        panel.add(tournamentLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(tournamentComboBox);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(scrollPane);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(btnBack);
        panel.add(Box.createVerticalGlue());

        btnBack.addActionListener(e -> cardLayout.show(mainPanel, "TournamentView"));
    }

    private void loadMatches() {
        matchList.setListData(new Object[0]);
        String selectedTournament = (String) tournamentComboBox.getSelectedItem();
        int tournamentId = Integer.parseInt(selectedTournament.split(" - ")[0]);
        if (selectedTournament != null) {
            DefaultListModel<Object> listModel = new DefaultListModel<>();
            if (tournamentId == 5) {
                ArrayList<DoubleMatch> matches = tournamentController.getDoubleTournament().getMatches();
                for (DoubleMatch match : matches) {
                    listModel.addElement(match.getId() + " - " + match.getTeam1().getName() + " vs "
                            + match.getTeam2().getName());
                }
            } else {
                ArrayList<SingleMatch> matches = tournamentController.getSingleTournamentbyId(tournamentId)
                        .getMatches();
                for (SingleMatch match : matches) {
                    listModel.addElement(match.getId() + " - " + match.getPlayer1().getName() + " vs "
                            + match.getPlayer2().getName());
                }
            }
            matchList.setModel(listModel);
        }
    }

}
