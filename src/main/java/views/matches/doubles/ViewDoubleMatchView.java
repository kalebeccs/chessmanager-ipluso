package src.main.java.views.matches.doubles;

import javax.swing.*;
import java.awt.*;
import src.main.java.views.base.BaseView;
import src.main.java.controllers.DoubleMatchController;
import src.main.java.models.DoubleMatch;

public class ViewDoubleMatchView extends BaseView {
    private JTextField idField;
    private JLabel team1Label;
    private JLabel team2Label;
    private JLabel arbiterLabel;
    private JLabel movesLabel;
    private JLabel timeLabel;
    private JLabel resultLabel;
    private JLabel winnerLabel;
    private DoubleMatchController doubleMatchController;

    public ViewDoubleMatchView(JPanel mainPanel, CardLayout cardLayout, DoubleMatchController doubleMatchController) {
        super(mainPanel, cardLayout);
        this.doubleMatchController = doubleMatchController;
        addTitle("View Double Match");

        JLabel idLabel = new JLabel("Match ID:");
        idLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        idField = new JTextField(20);
        idField.setMaximumSize(new Dimension(Integer.MAX_VALUE, idField.getPreferredSize().height));

        team1Label = new JLabel("Team 1: ");
        team1Label.setAlignmentX(Component.CENTER_ALIGNMENT);
        team2Label = new JLabel("Team 2: ");
        team2Label.setAlignmentX(Component.CENTER_ALIGNMENT);
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
        panel.add(team1Label);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(team2Label);
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
            cardLayout.show(mainPanel, "DoubleMatchView");
        });
    }

    private void consultMatch() {
        try {
            int id = Integer.parseInt(idField.getText());
            DoubleMatch match = doubleMatchController.getMatchById(id);
            if (match != null) {
                team1Label.setText("Team 1: " + match.getTeam1().getName());
                team2Label.setText("Team 2: " + match.getTeam2().getName());
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
        team1Label.setText("Team 1: ");
        team2Label.setText("Team 2: ");
        arbiterLabel.setText("Arbiter: ");
        movesLabel.setText("Moves: ");
        timeLabel.setText("Time: ");
        resultLabel.setText("Result: ");
        winnerLabel.setText("Winner: ");
    }
}