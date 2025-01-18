package src.main.java.views.player;

import javax.swing.*;
import java.awt.*;
import src.main.java.views.base.BaseView;
import src.main.java.controllers.PlayerController;

public class PlayerDeleteView extends BaseView {
    private JTextField idField;
    private PlayerController playerController;

    public PlayerDeleteView(JPanel mainPanel, CardLayout cardLayout, PlayerController playerController) {
        super(mainPanel, cardLayout);
        this.playerController = playerController;
        addTitle("Delete Player");

        JLabel idLabel = new JLabel("ID:");
        idLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        idField = new JTextField(20);
        idField.setMaximumSize(new Dimension(Integer.MAX_VALUE, idField.getPreferredSize().height));

        JButton btnDelete = new JButton("Delete");
        btnDelete.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnBack = new JButton("Back");
        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalGlue());
        panel.add(idLabel);
        panel.add(idField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnDelete);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(btnBack);
        panel.add(Box.createVerticalGlue());

        btnDelete.addActionListener(e -> deletePlayer());
        btnBack.addActionListener(e -> cardLayout.show(mainPanel, "PlayerView"));
    }

    private void deletePlayer() {
        int id = Integer.parseInt(idField.getText());
        playerController.deletePlayer(id);
        JOptionPane.showMessageDialog(panel, "Player deleted successfully!");
        cardLayout.show(mainPanel, "PlayerView");
    }
}