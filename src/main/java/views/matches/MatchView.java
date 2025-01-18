package src.main.java.views.matches;

import javax.swing.*;
import java.awt.*;
import src.main.java.views.base.BaseView;

public class MatchView extends BaseView {

    public MatchView(JPanel mainPanel, CardLayout cardLayout) {
        super(mainPanel, cardLayout);
        addTitle("Manage Matches");

        JButton btnManageSingleMatches = new JButton("Manage Single Matches");
        btnManageSingleMatches.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnManageDoubleMatches = new JButton("Manage Double Matches");
        btnManageDoubleMatches.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnBack = new JButton("Back");
        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalGlue());
        panel.add(btnManageSingleMatches);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnManageDoubleMatches);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(btnBack);
        panel.add(Box.createVerticalGlue());

        btnManageSingleMatches.addActionListener(e -> cardLayout.show(mainPanel, "SingleMatchView"));
        btnManageDoubleMatches.addActionListener(e -> cardLayout.show(mainPanel, "DoubleMatchView"));
        btnBack.addActionListener(e -> cardLayout.show(mainPanel, "InitialView"));
    }
}