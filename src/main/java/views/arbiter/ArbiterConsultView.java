package src.main.java.views.arbiter;

import javax.swing.*;
import java.awt.*;
import src.main.java.views.base.BaseView;
import src.main.java.controllers.ArbiterController;
import src.main.java.models.Arbiter;

public class ArbiterConsultView extends BaseView {
    private JTextField idField;
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel genderLabel;
    private JLabel certificationsLabel;
    private ArbiterController arbiterController;

    public ArbiterConsultView(JPanel mainPanel, CardLayout cardLayout, ArbiterController arbiterController) {
        super(mainPanel, cardLayout);
        this.arbiterController = arbiterController;
        addTitle("Consult Arbiter");

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
        certificationsLabel = new JLabel("Certifications: ");
        certificationsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

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
        panel.add(certificationsLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(btnBack);
        panel.add(Box.createVerticalGlue());

        btnConsult.addActionListener(e -> consultArbiter());
        btnBack.addActionListener(e -> cardLayout.show(mainPanel, "ArbiterView"));
    }

    private void consultArbiter() {
        int id = Integer.parseInt(idField.getText());
        Arbiter arbiter = arbiterController.getArbiter(id);
        if (arbiter != null) {
            nameLabel.setText("Name: " + arbiter.getName());
            ageLabel.setText("Age: " + arbiter.getAge());
            genderLabel.setText("Gender: " + arbiter.getGender());
            certificationsLabel.setText("Certifications: " + String.join(", ", arbiter.getCertifications()));
        } else {
            JOptionPane.showMessageDialog(panel, "Arbiter not found!");
        }
    }
}