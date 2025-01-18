package src.main.java.views.tournaments;

import javax.swing.*;
import java.awt.*;
import src.main.java.views.base.BaseView;

public class TournamentView extends BaseView {

    public TournamentView(JPanel mainPanel, CardLayout cardLayout) {
        super(mainPanel, cardLayout);
        addTitle("Manage Tournaments");

        JButton btnAddMatch = new JButton("Add Match to Tournament");
        btnAddMatch.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnViewMatches = new JButton("View Matches in Tournament");
        btnViewMatches.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnRemoveMatch = new JButton("Remove Match from Tournament");
        btnRemoveMatch.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnBack = new JButton("Back");
        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalGlue());
        panel.add(btnAddMatch);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnViewMatches);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnRemoveMatch);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(btnBack);
        panel.add(Box.createVerticalGlue());

        btnAddMatch.addActionListener(e -> cardLayout.show(mainPanel, "AddMatchView"));
        btnViewMatches.addActionListener(e -> cardLayout.show(mainPanel, "ViewMatchesView"));
        btnRemoveMatch.addActionListener(e -> cardLayout.show(mainPanel, "RemoveMatchView"));
        btnBack.addActionListener(e -> cardLayout.show(mainPanel, "InitialView"));
    }
}
