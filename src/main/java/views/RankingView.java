package src.main.java.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import src.main.java.views.base.BaseView;
import src.main.java.controllers.PlayerController;
import src.main.java.models.Player;

/**
 * The RankingView class represents the view that displays the player rankings.
 */
public class RankingView extends BaseView {
    private PlayerController playerController;
    private JTable rankingTable;
    private DefaultTableModel tableModel;

    /**
     * Constructs a RankingView with the specified main panel, card layout, and
     * player controller.
     *
     * @param mainPanel        The main panel to hold the views.
     * @param cardLayout       The card layout to manage the views.
     * @param playerController The player controller to manage player data.
     */
    public RankingView(JPanel mainPanel, CardLayout cardLayout, PlayerController playerController) {
        super(mainPanel, cardLayout);
        this.playerController = playerController;
        addTitle("Player Rankings");

        String[] columnNames = { "ID", "Name", "Ranking" };
        tableModel = new DefaultTableModel(columnNames, 0);

        rankingTable = new JTable(tableModel);
        rankingTable.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(rankingTable);

        JButton btnBack = new JButton("Back");
        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalGlue());
        panel.add(scrollPane);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(btnBack);
        panel.add(Box.createVerticalGlue());

        btnBack.addActionListener(e -> cardLayout.show(mainPanel, "InitialView"));

        loadRankings();
    }

    /**
     * Loads the player rankings into the table.
     */
    public void loadRankings() {
        tableModel.setRowCount(0);

        List<Player> players = playerController.getAllPlayers();
        players.sort((p1, p2) -> Integer.compare(p2.getRanking(), p1.getRanking()));

        for (Player player : players) {
            tableModel.addRow(new Object[] { player.getId(), player.getName(), player.getRanking() });
        }
    }
}