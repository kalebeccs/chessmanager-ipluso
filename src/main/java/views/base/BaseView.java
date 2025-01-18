package src.main.java.views.base;

import javax.swing.*;
import java.awt.*;

public abstract class BaseView {
    protected JPanel panel;
    protected CardLayout cardLayout;
    protected JPanel mainPanel;

    public BaseView(JPanel mainPanel, CardLayout cardLayout) {
        this.mainPanel = mainPanel;
        this.cardLayout = cardLayout;
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    }

    protected void addTitle(String title) {
        JLabel lblTitle = new JLabel(title, SwingConstants.CENTER);
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(Box.createVerticalGlue());
        panel.add(lblTitle);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
    }

    protected void addBackButton(String previousView) {
        JButton btnBack = new JButton("Back");
        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(btnBack);
        panel.add(Box.createVerticalGlue());
        btnBack.addActionListener(e -> cardLayout.show(mainPanel, previousView));
    }

    public JPanel getPanel() {
        return panel;
    }
}