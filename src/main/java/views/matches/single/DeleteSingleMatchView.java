package src.main.java.views.matches.single;

import javax.swing.*;
import java.awt.*;
import src.main.java.views.base.BaseView;
import src.main.java.controllers.SingleMatchController;

public class DeleteSingleMatchView extends BaseView {
    private JTextField idField;
    private SingleMatchController singleMatchController;

    public DeleteSingleMatchView(JPanel mainPanel, CardLayout cardLayout, SingleMatchController singleMatchController) {
        super(mainPanel, cardLayout);
        this.singleMatchController = singleMatchController;
        addTitle("Delete Single Match");

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
            cardLayout.show(mainPanel, "SingleMatchView");
        });
    }

    private void deleteMatch() {
        try {
            int id = Integer.parseInt(idField.getText());
            boolean success = singleMatchController.deleteMatch(id);
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