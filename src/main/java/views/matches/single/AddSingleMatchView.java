package src.main.java.views.matches.single;

import javax.swing.*;
import java.awt.*;
import src.main.java.views.base.BaseView;
import src.main.java.controllers.SingleMatchController;
import src.main.java.controllers.PlayerController;
import src.main.java.controllers.ArbiterController;
import src.main.java.models.Player;
import src.main.java.models.Arbiter;
import src.main.java.models.SingleMatch;
import java.util.List;

public class AddSingleMatchView extends BaseView {
    private SingleMatchController singleMatchController;
    private PlayerController playerController;
    private ArbiterController arbiterController;
    private List<Player> players;
    private List<Arbiter> arbiters;
    private JComboBox<String> cbPlayer1;
    private JComboBox<String> cbPlayer2;
    private JComboBox<String> cbArbiter;
    private JTextField txtMoves;
    private JTextField txtTime;
    private JTextField txtResult;
    private JComboBox<String> cbWinner;
    private JComboBox<String> cbType;

    public AddSingleMatchView(JPanel mainPanel, CardLayout cardLayout, SingleMatchController singleMatchController,
            PlayerController playerController, ArbiterController arbiterController) {
        super(mainPanel, cardLayout);
        this.singleMatchController = singleMatchController;
        this.playerController = playerController;
        this.arbiterController = arbiterController;
        addTitle("Add Single Match");

        // Load players and arbiters
        players = playerController.getAllPlayers();
        arbiters = arbiterController.getAllArbiters();

        // Create combo boxes with player names
        JLabel lblPlayer1 = new JLabel("Player 1:");
        cbPlayer1 = new JComboBox<>();
        cbPlayer1.addItem("Select Player 1");
        players.forEach(player -> cbPlayer1.addItem(player.getGender() + " - " + player.getName()));

        JLabel lblPlayer2 = new JLabel("Player 2:");
        cbPlayer2 = new JComboBox<>();
        cbPlayer2.addItem("Select Player 2");
        players.forEach(player -> cbPlayer2.addItem(player.getGender() + " - " + player.getName()));

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

        JLabel lblType = new JLabel("Type:");
        cbType = new JComboBox<>();
        cbType.addItem("Select Type");
        cbType.addItem("MaleElimination");
        cbType.addItem("MalePoints");
        cbType.addItem("FemaleElimination");
        cbType.addItem("FemalePoints");

        JButton btnSave = new JButton("Save");
        JButton btnBack = new JButton("Back");

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(lblPlayer1);
        panel.add(cbPlayer1);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(lblPlayer2);
        panel.add(cbPlayer2);
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
        panel.add(lblType);
        panel.add(cbType);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnSave);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnBack);

        cbPlayer1.addActionListener(e -> updateWinnerComboBox(cbPlayer1, cbPlayer2, cbWinner));
        cbPlayer2.addActionListener(e -> updateWinnerComboBox(cbPlayer1, cbPlayer2, cbWinner));

        btnSave.addActionListener(e -> saveMatch());
        btnBack.addActionListener(e -> {
            resetFields();
            cardLayout.show(mainPanel, "SingleMatchView");
        });
    }

    private void saveMatch() {
        String player1Name = (String) cbPlayer1.getSelectedItem();
        String player2Name = (String) cbPlayer2.getSelectedItem();
        String arbiterName = (String) cbArbiter.getSelectedItem();
        String moves = txtMoves.getText();
        String time = txtTime.getText();
        String result = txtResult.getText();
        String winnerName = (String) cbWinner.getSelectedItem();
        String type = (String) cbType.getSelectedItem();

        if (player1Name.equals("Select Player 1") || player2Name.equals("Select Player 2") ||
                arbiterName.equals("Select Arbiter") || moves.isEmpty() || time.isEmpty() ||
                result.isEmpty() || winnerName == null || type.equals("Select Type")) {
            JOptionPane.showMessageDialog(panel, "Please fill in all fields.");
            return;
        }

        Player player1 = players.stream().filter(p -> p.getName().equals(player1Name)).findFirst().orElse(null);
        Player player2 = players.stream().filter(p -> p.getName().equals(player2Name)).findFirst().orElse(null);
        Arbiter arbiter = arbiters.stream().filter(a -> a.getName().equals(arbiterName)).findFirst().orElse(null);
        Player winner = players.stream().filter(p -> p.getName().equals(winnerName)).findFirst().orElse(null);

        if (player1 != null) {
            player1.playMatch();
            playerController.editPlayer(player1.getId(), player1);
        }
        if (player2 != null) {
            player2.playMatch();
            playerController.editPlayer(player2.getId(), player2);
        }
        if (winner != null) {
            winner.winMatch(5);
            playerController.editPlayer(winner.getId(), winner);
        }

        SingleMatch match = new SingleMatch(player1, player2, arbiter, moves, time, winner, type, result);
        singleMatchController.addMatch(match);

        JOptionPane.showMessageDialog(panel, "Match added successfully!");

        resetFields();
    }

    private void resetFields() {
        cbPlayer1.setSelectedIndex(0);
        cbPlayer2.setSelectedIndex(0);
        cbArbiter.setSelectedIndex(0);
        txtMoves.setText("");
        txtTime.setText("");
        txtResult.setText("");
        cbWinner.removeAllItems();
        cbWinner.setEnabled(false);
        cbType.setSelectedIndex(0);
    }

    private void updateWinnerComboBox(JComboBox<String> cbPlayer1, JComboBox<String> cbPlayer2,
            JComboBox<String> cbWinner) {
        String player1Name = (String) cbPlayer1.getSelectedItem();
        String player2Name = (String) cbPlayer2.getSelectedItem();

        if (player1Name != null && player2Name != null && !player1Name.equals("Select Player 1")
                && !player2Name.equals("Select Player 2")) {
            cbWinner.removeAllItems();
            cbWinner.addItem(player1Name);
            cbWinner.addItem(player2Name);
            cbWinner.setEnabled(true);
        } else {
            cbWinner.removeAllItems();
            cbWinner.setEnabled(false);
        }
    }
}