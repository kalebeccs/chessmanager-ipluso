package src.main.java.views.player;

import javax.swing.*;
import java.awt.*;
import src.main.java.views.base.BaseView;
import src.main.java.controllers.PlayerController;
import src.main.java.models.Player;

public class PlayerConsultView extends BaseView {
    private JTextField idField;
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel genderLabel;
    private JLabel rankingLabel;
    private JLabel matchesPlayedLabel;
    private PlayerController playerController;

    public PlayerConsultView(JPanel mainPanel, CardLayout cardLayout, PlayerController playerController) {
        super(mainPanel, cardLayout);
        this.playerController = playerController;
        addTitle("Consult Player");

        JLabel idLabel = new JLabel("ID:");
        idLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        idField = new JTextField(20);
        idField.setMaximumSize(new Dimension(Integer.MAX_VALUE, idField.getPreferredSize().height));

        nameLabel = new JLabel("Name: ");
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        ageLabel = new JLabel("Age: ");
        ageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        genderLabel = new JLabel("Gender: ");
        genderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        rankingLabel = new JLabel("Ranking: ");
        rankingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        matchesPlayedLabel = new JLabel("Matches Played: ");
        matchesPlayedLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

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
        panel.add(nameLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(ageLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(genderLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(rankingLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(matchesPlayedLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(btnBack);
        panel.add(Box.createVerticalGlue());

        btnConsult.addActionListener(e -> consultPlayer());
        btnBack.addActionListener(e -> cardLayout.show(mainPanel, "PlayerView"));
    }

    private void consultPlayer() {
        int id = Integer.parseInt(idField.getText());
        Player player = playerController.getPlayer(id);
        if (player != null) {
            nameLabel.setText("Name: " + player.getName());
            ageLabel.setText("Age: " + player.getAge());
            genderLabel.setText("Gender: " + player.getGender());
            rankingLabel.setText("Ranking: " + player.getRanking());
            matchesPlayedLabel.setText("Matches Played: " + player.getMatchesPlayed());
        } else {
            JOptionPane.showMessageDialog(panel, "Player not found!");
        }
    }
}