package src.main.java.views.arbiter;

import javax.swing.*;
import java.awt.*;
import src.main.java.views.base.BaseView;

public class ArbiterView extends BaseView {

    public ArbiterView(JPanel mainPanel, CardLayout cardLayout) {
        super(mainPanel, cardLayout);
        addTitle("Arbiter Management");

        JButton btnRegisterArbiter = new JButton("Register Arbiter");
        btnRegisterArbiter.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnEditArbiter = new JButton("Edit Arbiter");
        btnEditArbiter.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnConsultArbiter = new JButton("Consult Arbiter");
        btnConsultArbiter.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnDeleteArbiter = new JButton("Delete Arbiter");
        btnDeleteArbiter.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton btnBack = new JButton("Back");
        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalGlue());
        panel.add(btnRegisterArbiter);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnEditArbiter);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnConsultArbiter);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnDeleteArbiter);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(btnBack);
        panel.add(Box.createVerticalGlue());

        btnRegisterArbiter.addActionListener(e -> cardLayout.show(mainPanel, "ArbiterRegistrationView"));
        btnEditArbiter.addActionListener(e -> cardLayout.show(mainPanel, "ArbiterEditView"));
        btnConsultArbiter.addActionListener(e -> cardLayout.show(mainPanel, "ArbiterConsultView"));
        btnDeleteArbiter.addActionListener(e -> cardLayout.show(mainPanel, "ArbiterDeleteView"));
        btnBack.addActionListener(e -> cardLayout.show(mainPanel, "InitialView"));
    }
}
