package src.main.java.views;

import javax.swing.*;
import java.awt.*;
import src.main.java.views.base.BaseView;

/**
 * The InitialView class represents the initial view of the chess application.
 * It provides buttons to navigate to different sections of the application.
 */
public class InitialView extends BaseView {
    private RankingView rankingView;

    /**
     * Constructs an InitialView with the specified main panel, card layout, and
     * ranking view.
     *
     * @param mainPanel   The main panel to hold the views.
     * @param cardLayout  The card layout to manage the views.
     * @param rankingView The ranking view to display player rankings.
     */
    public InitialView(JPanel mainPanel, CardLayout cardLayout, RankingView rankingView) {
        super(mainPanel, cardLayout);
        this.rankingView = rankingView;
        addTitle("Welcome to the Chess Management System");

        JButton btnManageMatches = new JButton("Manage Matches");
        btnManageMatches.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnManageTournaments = new JButton("Manage Tournaments");
        btnManageTournaments.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnViewRanking = new JButton("View Ranking");
        btnViewRanking.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnViewPrizes = new JButton("View Prizes");
        btnViewPrizes.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalGlue());
        panel.add(btnManageMatches);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnManageTournaments);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnViewRanking);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnViewPrizes);
        panel.add(Box.createVerticalGlue());

        btnManageMatches.addActionListener(e -> cardLayout.show(mainPanel, "MatchView"));
        btnManageTournaments.addActionListener(e -> cardLayout.show(mainPanel, "TournamentView"));
        btnViewRanking.addActionListener(e -> {
            rankingView.loadRankings();
            cardLayout.show(mainPanel, "RankingView");
        });
        btnViewPrizes.addActionListener(e -> cardLayout.show(mainPanel, "PrizeView"));
    }
}