package src.main.java.views.matches.doubles;

import javax.swing.*;
import java.awt.*;
import src.main.java.views.base.BaseView;
import src.main.java.controllers.DoubleMatchController;
import src.main.java.controllers.PlayerController;
import src.main.java.controllers.ArbiterController;
import src.main.java.models.Player;
import src.main.java.models.Arbiter;
import src.main.java.models.DoubleMatch;
import src.main.java.models.Team;
import java.util.ArrayList;

public class AddDoubleMatchView extends BaseView {
    private DoubleMatchController doubleMatchController;
    private PlayerController playerController;
    private ArbiterController arbiterController;
    private ArrayList<Player> players;
    private ArrayList<Arbiter> arbiters;
    private JComboBox<String> cbTeam1Player1;
    private JComboBox<String> cbTeam1Player2;
    private JComboBox<String> cbTeam2Player1;
    private JComboBox<String> cbTeam2Player2;
    private JComboBox<String> cbArbiter;
    private JTextField txtMoves;
    private JTextField txtTime;
    private JTextField txtResult;
    private JComboBox<String> cbWinner;

    private Team team1;
    private Team team2;

    public AddDoubleMatchView(JPanel mainPanel, CardLayout cardLayout, DoubleMatchController doubleMatchController,
            PlayerController playerController, ArbiterController arbiterController) {
        super(mainPanel, cardLayout);
        this.doubleMatchController = doubleMatchController;
        this.playerController = playerController;
        this.arbiterController = arbiterController;
        addTitle("Add Double Match");

        // Load players and arbiters
        players = playerController.getAllPlayers();
        arbiters = arbiterController.getAllArbiters();

        // Create combo boxes with player names
        JLabel lblTeam1Player1 = new JLabel("Team 1 - Player 1:");
        cbTeam1Player1 = new JComboBox<>();
        cbTeam1Player1.addItem("Select Player");
        players.forEach(player -> cbTeam1Player1.addItem(player.getName()));

        JLabel lblTeam1Player2 = new JLabel("Team 1 - Player 2:");
        cbTeam1Player2 = new JComboBox<>();
        cbTeam1Player2.addItem("Select Player");
        players.forEach(player -> cbTeam1Player2.addItem(player.getName()));

        JLabel lblTeam2Player1 = new JLabel("Team 2 - Player 1:");
        cbTeam2Player1 = new JComboBox<>();
        cbTeam2Player1.addItem("Select Player");
        players.forEach(player -> cbTeam2Player1.addItem(player.getName()));

        JLabel lblTeam2Player2 = new JLabel("Team 2 - Player 2:");
        cbTeam2Player2 = new JComboBox<>();
        cbTeam2Player2.addItem("Select Player");
        players.forEach(player -> cbTeam2Player2.addItem(player.getName()));

        JLabel lblArbiter = new JLabel("Arbiter:");
        cbArbiter = new JComboBox<>();
        cbArbiter.addItem("Select Arbiter");
        arbiters.forEach(arbiter -> cbArbiter.addItem(arbiter.getName()));

        JLabel lblMoves = new JLabel("Moves:");
        txtMoves = new JTextField(20);
        JLabel lblTime = new JLabel("Time:");
        txtTime = new JTextField(20);
        JLabel lblResult = new JLabel("Result:");
        txtResult = new JTextField(20);
        JLabel lblWinner = new JLabel("Winner:");
        cbWinner = new JComboBox<>();
        cbWinner.setEnabled(false);

        JButton btnSave = new JButton("Save");
        JButton btnBack = new JButton("Back");

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(lblTeam1Player1);
        panel.add(cbTeam1Player1);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(lblTeam1Player2);
        panel.add(cbTeam1Player2);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(lblTeam2Player1);
        panel.add(cbTeam2Player1);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(lblTeam2Player2);
        panel.add(cbTeam2Player2);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(lblArbiter);
        panel.add(cbArbiter);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(lblMoves);
        panel.add(txtMoves);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(lblTime);
        panel.add(txtTime);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(lblResult);
        panel.add(txtResult);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(lblWinner);
        panel.add(cbWinner);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnSave);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnBack);

        cbTeam1Player1.addActionListener(e -> updateWinnerComboBox());
        cbTeam1Player2.addActionListener(e -> updateWinnerComboBox());
        cbTeam2Player1.addActionListener(e -> updateWinnerComboBox());
        cbTeam2Player2.addActionListener(e -> updateWinnerComboBox());

        btnSave.addActionListener(e -> saveMatch());
        btnBack.addActionListener(e -> {
            resetFields();
            cardLayout.show(mainPanel, "DoubleMatchView");
        });
    }

    private void saveMatch() {
        String team1Player1Name = (String) cbTeam1Player1.getSelectedItem();
        String team1Player2Name = (String) cbTeam1Player2.getSelectedItem();
        String team2Player1Name = (String) cbTeam2Player1.getSelectedItem();
        String team2Player2Name = (String) cbTeam2Player2.getSelectedItem();
        String arbiterName = (String) cbArbiter.getSelectedItem();
        String moves = txtMoves.getText();
        String time = txtTime.getText();
        String result = txtResult.getText();
        String winnerName = (String) cbWinner.getSelectedItem();

        if (team1Player1Name.equals("Select Player") || team1Player2Name.equals("Select Player") ||
                team2Player1Name.equals("Select Player") || team2Player2Name.equals("Select Player") ||
                arbiterName.equals("Select Arbiter") || moves.isEmpty() || time.isEmpty() ||
                result.isEmpty() || winnerName == null) {
            JOptionPane.showMessageDialog(panel, "Please fill in all fields.");
            return;
        }

        Player team1Player1 = players.stream().filter(p -> p.getName().equals(team1Player1Name)).findFirst()
                .orElse(null);
        Player team1Player2 = players.stream().filter(p -> p.getName().equals(team1Player2Name)).findFirst()
                .orElse(null);
        Player team2Player1 = players.stream().filter(p -> p.getName().equals(team2Player1Name)).findFirst()
                .orElse(null);
        Player team2Player2 = players.stream().filter(p -> p.getName().equals(team2Player2Name)).findFirst()
                .orElse(null);
        Arbiter arbiter = arbiters.stream().filter(a -> a.getName().equals(arbiterName)).findFirst().orElse(null);
        Team winner = winnerName.equals(team1.getName()) ? team1 : team2;

        if (team1 != null)
            team1.playMatch();
        if (team2 != null)
            team2.playMatch();
        if (winner != null)
            winner.winMatch(3);
        if (Integer.parseInt(time) < 20)
            winner.winMatch(1);

        DoubleMatch match = new DoubleMatch(team1, team2, arbiter, moves, result, time, winner, "Double");
        doubleMatchController.addMatch(match);

        JOptionPane.showMessageDialog(panel, "Match added successfully!");
        resetFields();
    }

    private void updateWinnerComboBox() {
        String team1Player1Name = (String) cbTeam1Player1.getSelectedItem();
        String team1Player2Name = (String) cbTeam1Player2.getSelectedItem();
        String team2Player1Name = (String) cbTeam2Player1.getSelectedItem();
        String team2Player2Name = (String) cbTeam2Player2.getSelectedItem();

        if (team1Player1Name != null && team1Player2Name != null && team2Player1Name != null && team2Player2Name != null
                &&
                !team1Player1Name.equals("Select Player") && !team1Player2Name.equals("Select Player") &&
                !team2Player1Name.equals("Select Player") && !team2Player2Name.equals("Select Player")) {
            Player team1Player1 = players.stream().filter(p -> p.getName().equals(team1Player1Name)).findFirst()
                    .orElse(null);
            Player team1Player2 = players.stream().filter(p -> p.getName().equals(team1Player2Name)).findFirst()
                    .orElse(null);
            Player team2Player1 = players.stream().filter(p -> p.getName().equals(team2Player1Name)).findFirst()
                    .orElse(null);
            Player team2Player2 = players.stream().filter(p -> p.getName().equals(team2Player2Name)).findFirst()
                    .orElse(null);

            team1 = new Team(team1Player1, team1Player2, createTeamName(team1Player1, team1Player2));
            team2 = new Team(team2Player1, team2Player2, createTeamName(team2Player1, team2Player2));

            cbWinner.removeAllItems();
            cbWinner.addItem(team1.getName());
            cbWinner.addItem(team2.getName());
            cbWinner.setEnabled(true);
        } else {
            team1 = null;
            team2 = null;
            cbWinner.removeAllItems();
            cbWinner.setEnabled(false);
        }
    }

    private String createTeamName(Player player1, Player player2) {
        return player1.getName() + " & " + player2.getName();
    }

    private void resetFields() {
        cbTeam1Player1.setSelectedIndex(0);
        cbTeam1Player2.setSelectedIndex(0);
        cbTeam2Player1.setSelectedIndex(0);
        cbTeam2Player2.setSelectedIndex(0);
        cbArbiter.setSelectedIndex(0);
        txtMoves.setText("");
        txtTime.setText("");
        txtResult.setText("");
        cbWinner.removeAllItems();
        cbWinner.setEnabled(false);
    }
}