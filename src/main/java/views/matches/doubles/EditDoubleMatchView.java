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
import java.util.List;

public class EditDoubleMatchView extends BaseView {
    private DoubleMatchController doubleMatchController;
    private PlayerController playerController;
    private ArbiterController arbiterController;
    private List<Player> players;
    private List<Arbiter> arbiters;
    private JComboBox<String> cbTeam1Player1;
    private JComboBox<String> cbTeam1Player2;
    private JComboBox<String> cbTeam2Player1;
    private JComboBox<String> cbTeam2Player2;
    private JComboBox<String> cbArbiter;
    private JTextField txtMoves;
    private JTextField txtTime;
    private JTextField txtResult;
    private JComboBox<String> cbWinner;
    private JTextField txtMatchId;

    private Team team1;
    private Team team2;

    public EditDoubleMatchView(JPanel mainPanel, CardLayout cardLayout, DoubleMatchController doubleMatchController,
            PlayerController playerController, ArbiterController arbiterController) {
        super(mainPanel, cardLayout);
        this.doubleMatchController = doubleMatchController;
        this.playerController = playerController;
        this.arbiterController = arbiterController;
        addTitle("Edit Double Match");

        // Load players and arbiters
        players = playerController.getAllPlayers();
        arbiters = arbiterController.getAllArbiters();

        // Create combo boxes with player names
        JLabel lblMatchId = new JLabel("Match ID:");
        txtMatchId = new JTextField(20);
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
        JButton btnLoad = new JButton("Load Match");

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(lblMatchId);
        panel.add(txtMatchId);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnLoad);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
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

        btnLoad.addActionListener(e -> loadMatch());
        btnSave.addActionListener(e -> saveMatch());
        btnBack.addActionListener(e -> {
            resetFields();
            cardLayout.show(mainPanel, "DoubleMatchView");
        });
    }

    private void loadMatch() {
        try {
            int matchId = Integer.parseInt(txtMatchId.getText());
            DoubleMatch match = doubleMatchController.getMatchById(matchId);
            if (match != null) {
                cbTeam1Player1.setSelectedItem(match.getTeam1().getPlayer1().getName());
                cbTeam1Player2.setSelectedItem(match.getTeam1().getPlayer2().getName());
                cbTeam2Player1.setSelectedItem(match.getTeam2().getPlayer1().getName());
                cbTeam2Player2.setSelectedItem(match.getTeam2().getPlayer2().getName());
                cbArbiter.setSelectedItem(match.getArbiter().getName());
                txtMoves.setText(match.getMoves());
                txtTime.setText(match.getTime());
                txtResult.setText(match.getResult());
                cbWinner.setSelectedItem(match.getWinner().getName());
                cbWinner.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(panel, "Match not found!");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(panel, "Invalid Match ID!");
        }
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

        try {
            int matchId = Integer.parseInt(txtMatchId.getText());
            DoubleMatch match = new DoubleMatch(team1, team2, arbiter, moves, result, time, winner, "Double Match");
            match.setId(matchId);
            doubleMatchController.updateMatch(match);

            JOptionPane.showMessageDialog(panel, "Match updated successfully!");
            cardLayout.show(mainPanel, "DoubleMatchView");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(panel, "Invalid Match ID!");
        }
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
            cbWinner.removeAllItems();
            cbWinner.setEnabled(false);
        }
    }

    private String createTeamName(Player player1, Player player2) {
        return player1.getName() + " & " + player2.getName();
    }

    private void resetFields() {
        txtMatchId.setText("");
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