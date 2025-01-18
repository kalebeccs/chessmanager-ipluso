package src.main.java.views.matches.single;

import javax.swing.*;
import java.awt.*;
import src.main.java.views.base.BaseView;
import src.main.java.controllers.SingleMatchController;
import src.main.java.models.SingleMatch;

public class ViewSingleMatchView extends BaseView {
    private JTextField idField;
    private JLabel player1Label;
    private JLabel player2Label;
    private JLabel arbiterLabel;
    private JLabel movesLabel;
    private JLabel timeLabel;
    private JLabel resultLabel;
    private JLabel winnerLabel;
    private SingleMatchController singleMatchController;

    public ViewSingleMatchView(JPanel mainPanel, CardLayout cardLayout, SingleMatchController singleMatchController) {
        super(mainPanel, cardLayout);
        this.singleMatchController = singleMatchController;
        addTitle("View Single Match");

        JLabel idLabel = new JLabel("Match ID:");
        idLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        idField = new JTextField(20);
        idField.setMaximumSize(new Dimension(Integer.MAX_VALUE, idField.getPreferredSize().height));

        player1Label = new JLabel("Player 1: ");
        player1Label.setAlignmentX(Component.CENTER_ALIGNMENT);
        player2Label = new JLabel("Player 2: ");
        player2Label.setAlignmentX(Component.CENTER_ALIGNMENT);
        arbiterLabel = new JLabel("Arbiter: ");
        arbiterLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        movesLabel = new JLabel("Moves: ");
        movesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        timeLabel = new JLabel("Time: ");
        timeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultLabel = new JLabel("Result: ");
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        winnerLabel = new JLabel("Winner: ");
        winnerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btnConsult = new JButton("Consult");
        btnConsult.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnBack = new JButton("Back");
        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalGlue());
        panel.add(idLabel);
        panel.add(idField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnConsult);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(player1Label);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(player2Label);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(arbiterLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(movesLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(timeLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(resultLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(winnerLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(btnBack);
        panel.add(Box.createVerticalGlue());

        btnConsult.addActionListener(e -> consultMatch());
        btnBack.addActionListener(e -> {
            resetFields();
            cardLayout.show(mainPanel, "SingleMatchView");
        });
    }

    private void consultMatch() {
        try {
            int id = Integer.parseInt(idField.getText());
            SingleMatch match = singleMatchController.getMatchById(id);
            if (match != null) {
                player1Label.setText("Player 1: " + match.getPlayer1().getName());
                player2Label.setText("Player 2: " + match.getPlayer2().getName());
                arbiterLabel.setText("Arbiter: " + match.getArbiter().getName());
                movesLabel.setText("Moves: " + match.getMoves());
                timeLabel.setText("Time: " + match.getTime());
                resultLabel.setText("Result: " + match.getResult());
                winnerLabel.setText("Winner: " + match.getWinner().getName());
            } else {
                JOptionPane.showMessageDialog(panel, "Match not found!");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(panel, "Invalid Match ID!");
        }
    }

    private void resetFields() {
        idField.setText("");
        player1Label.setText("Player 1: ");
        player2Label.setText("Player 2: ");
        arbiterLabel.setText("Arbiter: ");
        movesLabel.setText("Moves: ");
        timeLabel.setText("Time: ");
        resultLabel.setText("Result: ");
        winnerLabel.setText("Winner: ");
    }
}