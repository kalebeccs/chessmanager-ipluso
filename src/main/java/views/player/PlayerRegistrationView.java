package src.main.java.views.player;

import javax.swing.*;
import java.awt.*;
import src.main.java.views.base.BaseView;
import src.main.java.controllers.PlayerController;
import src.main.java.models.Player;
import src.main.java.views.RankingView;

public class PlayerRegistrationView extends BaseView {
    private JTextField nameField;
    private JTextField ageField;
    private JTextField genderField;
    private JTextField rankingField;
    private JTextField matchesPlayedField;
    private PlayerController playerController;
    private RankingView rankingView;

    public PlayerRegistrationView(JPanel mainPanel, CardLayout cardLayout, PlayerController playerController,
            RankingView rankingView) {
        super(mainPanel, cardLayout);
        this.playerController = playerController;
        this.rankingView = rankingView;
        addTitle("Register Player");

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameField = new JTextField(20);
        nameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, nameField.getPreferredSize().height));

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        ageField = new JTextField(20);
        ageField.setMaximumSize(new Dimension(Integer.MAX_VALUE, ageField.getPreferredSize().height));

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        genderField = new JTextField(20);
        genderField.setMaximumSize(new Dimension(Integer.MAX_VALUE, genderField.getPreferredSize().height));

        JLabel rankingLabel = new JLabel("Ranking:");
        rankingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        rankingField = new JTextField(20);
        rankingField.setMaximumSize(new Dimension(Integer.MAX_VALUE, rankingField.getPreferredSize().height));

        JLabel matchesPlayedLabel = new JLabel("Matches Played:");
        matchesPlayedLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        matchesPlayedField = new JTextField(20);
        matchesPlayedField
                .setMaximumSize(new Dimension(Integer.MAX_VALUE, matchesPlayedField.getPreferredSize().height));

        JButton btnSave = new JButton("Save");
        btnSave.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnBack = new JButton("Back");
        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalGlue());
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(genderLabel);
        panel.add(genderField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(rankingLabel);
        panel.add(rankingField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(matchesPlayedLabel);
        panel.add(matchesPlayedField);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(btnSave);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnBack);
        panel.add(Box.createVerticalGlue());

        btnSave.addActionListener(e -> savePlayer());
        btnBack.addActionListener(e -> cardLayout.show(mainPanel, "PlayerView"));
    }

    private void savePlayer() {
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        char gender = genderField.getText().charAt(0);
        int ranking = Integer.parseInt(rankingField.getText());
        int matchesPlayed = Integer.parseInt(matchesPlayedField.getText());
        Player player = new Player(name, age, gender, ranking, matchesPlayed);
        playerController.addPlayer(player);
        rankingView.loadRankings();
        JOptionPane.showMessageDialog(panel, "Player registered successfully!");
        cardLayout.show(mainPanel, "PlayerView");

        nameField.setText("");
        ageField.setText("");
        genderField.setText("");
        rankingField.setText("");
        matchesPlayedField.setText("");
    }
}