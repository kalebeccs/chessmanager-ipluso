package src.main.java.views.arbiter;

import javax.swing.*;
import java.awt.*;
import src.main.java.views.base.BaseView;
import src.main.java.controllers.ArbiterController;

public class ArbiterDeleteView extends BaseView {
    private JTextField idField;
    private ArbiterController arbiterController;

    public ArbiterDeleteView(JPanel mainPanel, CardLayout cardLayout, ArbiterController arbiterController) {
        super(mainPanel, cardLayout);
        this.arbiterController = arbiterController;
        addTitle("Delete Arbiter");

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

        btnDelete.addActionListener(e -> deleteArbiter());
        btnBack.addActionListener(e -> cardLayout.show(mainPanel, "ArbiterView"));
    }

    private void deleteArbiter() {
        int id = Integer.parseInt(idField.getText());
        arbiterController.deleteArbiter(id);
        JOptionPane.showMessageDialog(panel, "Arbiter deleted successfully!");
        cardLayout.show(mainPanel, "ArbiterView");
    }
}