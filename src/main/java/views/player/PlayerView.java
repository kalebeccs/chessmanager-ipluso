package src.main.java.views.player;

import javax.swing.*;
import java.awt.*;
import src.main.java.views.base.BaseView;

public class PlayerView extends BaseView {

    public PlayerView(JPanel mainPanel, CardLayout cardLayout) {
        super(mainPanel, cardLayout);
        addTitle("Player Management");

        JButton btnRegisterPlayer = new JButton("Register Player");
        btnRegisterPlayer.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnEditPlayer = new JButton("Edit Player");
        btnEditPlayer.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnConsultPlayer = new JButton("Consult Player");
        btnConsultPlayer.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnDeletePlayer = new JButton("Delete Player");
        btnDeletePlayer.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnBack = new JButton("Back");
        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalGlue());
        panel.add(btnRegisterPlayer);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnEditPlayer);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnConsultPlayer);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnDeletePlayer);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(btnBack);
        panel.add(Box.createVerticalGlue());

        btnRegisterPlayer.addActionListener(e -> cardLayout.show(mainPanel, "PlayerRegistrationView"));
        btnEditPlayer.addActionListener(e -> cardLayout.show(mainPanel, "PlayerEditView"));
        btnConsultPlayer.addActionListener(e -> cardLayout.show(mainPanel, "PlayerConsultView"));
        btnDeletePlayer.addActionListener(e -> cardLayout.show(mainPanel, "PlayerDeleteView"));
        btnBack.addActionListener(e -> cardLayout.show(mainPanel, "InitialView"));
    }
}