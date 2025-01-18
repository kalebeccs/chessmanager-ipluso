package src.main.java.views.arbiter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import src.main.java.views.base.BaseView;
import src.main.java.controllers.ArbiterController;
import src.main.java.models.Arbiter;

public class ArbiterEditView extends BaseView {
    private JTextField idField;
    private JTextField nameField;
    private JTextField ageField;
    private JTextField genderField;
    private JTextField certificationsField;
    private ArbiterController arbiterController;

    public ArbiterEditView(JPanel mainPanel, CardLayout cardLayout, ArbiterController arbiterController) {
        super(mainPanel, cardLayout);
        this.arbiterController = arbiterController;
        addTitle("Edit Arbiter");

        JLabel idLabel = new JLabel("ID:");
        idLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        idField = new JTextField(20);
        idField.setMaximumSize(new Dimension(Integer.MAX_VALUE, idField.getPreferredSize().height));

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

        JLabel certificationsLabel = new JLabel("Certifications (comma separated):");
        certificationsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        certificationsField = new JTextField(20);
        certificationsField
                .setMaximumSize(new Dimension(Integer.MAX_VALUE, certificationsField.getPreferredSize().height));

        JButton btnSave = new JButton("Save");
        btnSave.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnBack = new JButton("Back");
        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalGlue());
        panel.add(idLabel);
        panel.add(idField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(genderLabel);
        panel.add(genderField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(certificationsLabel);
        panel.add(certificationsField);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(btnSave);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnBack);
        panel.add(Box.createVerticalGlue());

        btnSave.addActionListener(e -> saveArbiter());
        btnBack.addActionListener(e -> cardLayout.show(mainPanel, "ArbiterView"));
    }

    private void saveArbiter() {
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        char gender = genderField.getText().charAt(0);
        String[] certificationsArray = certificationsField.getText().split(",");
        Arbiter updatedArbiter = new Arbiter(name, age, gender, new ArrayList<>(Arrays.asList(certificationsArray)));
        arbiterController.editArbiter(id, updatedArbiter);
        JOptionPane.showMessageDialog(panel, "Arbiter updated successfully!");
        cardLayout.show(mainPanel, "ArbiterView");
    }
}
