package src.main.java.views.matches.doubles;

import javax.swing.*;
import java.awt.*;
import src.main.java.views.base.BaseView;
import src.main.java.controllers.DoubleMatchController;

public class DeleteDoubleMatchView extends BaseView {
    private JTextField idField;
    private DoubleMatchController doubleMatchController;

    public DeleteDoubleMatchView(JPanel mainPanel, CardLayout cardLayout, DoubleMatchController doubleMatchController) {
        super(mainPanel, cardLayout);
        this.doubleMatchController = doubleMatchController;
        addTitle("Delete Double Match");

        JLabel idLabel = new JLabel("Match ID:");
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

        btnDelete.addActionListener(e -> deleteMatch());
        btnBack.addActionListener(e -> {
            resetFields();
            cardLayout.show(mainPanel, "DoubleMatchView");
        });
    }

    private void deleteMatch() {
        try {
            int id = Integer.parseInt(idField.getText());
            boolean success = doubleMatchController.deleteMatch(id);
            if (success) {
                JOptionPane.showMessageDialog(panel, "Match deleted successfully!");
                resetFields();
            } else {
                JOptionPane.showMessageDialog(panel, "Match not found!");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(panel, "Invalid Match ID!");
        }
    }

    private void resetFields() {
        idField.setText("");
    }
}