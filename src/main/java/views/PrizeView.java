package src.main.java.views;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import src.main.java.models.Prize;
import src.main.java.views.base.BaseView;

/**
 * The PrizeView class represents the view that displays the prizes for the top
 * 3 players.
 */
public class PrizeView extends BaseView {

    /**
     * Constructs a PrizeView with the specified main panel and card layout.
     *
     * @param mainPanel  The main panel to hold the views.
     * @param cardLayout The card layout to manage the views.
     */
    public PrizeView(JPanel mainPanel, CardLayout cardLayout) {
        super(mainPanel, cardLayout);
        addTitle("Prizes for Top 3 Players");

        ArrayList<Prize> prizes = new ArrayList<>(Arrays.asList(
                new Prize("1st Place: Single", 30000.0),
                new Prize("2nd Place: Single", 10000.0),
                new Prize("3rd Place: Single", 5000.0),
                new Prize("1th Place: Double", 40000.0),
                new Prize("2th Place: Double", 15000.0),
                new Prize("3th Place: Double", 6000.0)));

        for (Prize prize : prizes) {
            JLabel prizeLabel = new JLabel(prize.getType() + " + €" + prize.getValue());
            prizeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(prizeLabel);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        JButton btnBack = new JButton("Back");
        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalGlue());
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(btnBack);
        panel.add(Box.createVerticalGlue());

        btnBack.addActionListener(e -> cardLayout.show(mainPanel, "InitialView"));
    }
}