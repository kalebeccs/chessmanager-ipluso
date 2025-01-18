package src.main.java.views.matches;

import javax.swing.*;
import java.awt.*;
import src.main.java.views.base.BaseView;

public class SingleMatchView extends BaseView {

    public SingleMatchView(JPanel mainPanel, CardLayout cardLayout) {
        super(mainPanel, cardLayout);
        addTitle("Manage Single Matches");

        JButton btnAddMatch = new JButton("Add Match");
        btnAddMatch.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnEditMatch = new JButton("Edit Match");
        btnEditMatch.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnViewMatch = new JButton("View Match");
        btnViewMatch.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnDeleteMatch = new JButton("Delete Match");
        btnDeleteMatch.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnBack = new JButton("Back");
        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalGlue());
        panel.add(btnAddMatch);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnEditMatch);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnViewMatch);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnDeleteMatch);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(btnBack);
        panel.add(Box.createVerticalGlue());

        btnAddMatch.addActionListener(e -> cardLayout.show(mainPanel, "AddSingleMatchView"));
        btnEditMatch.addActionListener(e -> cardLayout.show(mainPanel, "EditSingleMatchView"));
        btnViewMatch.addActionListener(e -> cardLayout.show(mainPanel, "ViewSingleMatchView"));
        btnDeleteMatch.addActionListener(e -> cardLayout.show(mainPanel, "DeleteSingleMatchView"));
        btnBack.addActionListener(e -> cardLayout.show(mainPanel, "MatchView"));
    }
}