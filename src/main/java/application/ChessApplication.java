package src.main.java.application;

import javax.swing.*;
import java.awt.*;

/**
 * The ChessApplication class initializes and starts the Chess Management System
 * application.
 * It sets up the main frame, panels, and view manager.
 */
public class ChessApplication {
        private JFrame frame;
        private JPanel mainPanel;
        private CardLayout cardLayout;
        private ViewManager viewManager;

        /**
         * Constructs a ChessApplication and sets up the main frame, panels, and view
         * manager.
         */
        public ChessApplication() {
                frame = new JFrame("Chess Management System");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(1280, 720);
                frame.setLayout(new BorderLayout());

                // Load application icon using Toolkit
                Image icon = Toolkit.getDefaultToolkit().getImage("src/main/resources/images/logo.png");
                frame.setIconImage(icon);

                // Header with title and buttons
                JPanel headerPanel = new JPanel();
                headerPanel.setLayout(new BorderLayout());

                // Title on the left
                JLabel headerLabel = new JLabel("Chess Management System");
                headerLabel.setFont(new Font("Arial", Font.BOLD, 24));

                // Create a panel to hold the title with vertical space
                JPanel titlePanel = new JPanel();
                titlePanel.setLayout(new BorderLayout());
                titlePanel.add(Box.createVerticalStrut(16), BorderLayout.NORTH);
                titlePanel.add(Box.createHorizontalStrut(48), BorderLayout.WEST);
                titlePanel.add(headerLabel, BorderLayout.CENTER);
                titlePanel.add(Box.createVerticalStrut(16), BorderLayout.SOUTH);

                headerPanel.add(titlePanel, BorderLayout.WEST);

                // Buttons on the right
                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 12, 0));

                JButton homeButton = new JButton("Home");
                homeButton.addActionListener(e -> viewManager.showView("InitialView"));
                buttonPanel.add(homeButton);

                JButton playerButton = new JButton("Manage Players");
                playerButton.addActionListener(e -> viewManager.showView("PlayerView"));
                JButton arbiterButton = new JButton("Manage Arbiters");
                arbiterButton.addActionListener(e -> viewManager.showView("ArbiterView"));

                buttonPanel.add(playerButton);
                buttonPanel.add(arbiterButton);

                // Add vertical and horizontal space
                JPanel buttonContainer = new JPanel();
                buttonContainer.setLayout(new BorderLayout());
                buttonContainer.add(Box.createVerticalStrut(16), BorderLayout.NORTH);
                buttonContainer.add(Box.createVerticalStrut(16), BorderLayout.SOUTH);
                buttonContainer.add(Box.createHorizontalStrut(48), BorderLayout.EAST);
                buttonContainer.add(buttonPanel, BorderLayout.CENTER);

                headerPanel.add(buttonContainer, BorderLayout.EAST);

                frame.add(headerPanel, BorderLayout.NORTH);

                // Footer
                JPanel footerPanel = new JPanel();
                footerPanel.setLayout(new BorderLayout());
                JPanel footerContentPanel = new JPanel();
                footerContentPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
                JLabel footerLabel = new JLabel("© 2025 Chess Management System");
                footerLabel.setForeground(Color.GRAY);
                footerContentPanel.add(Box.createVerticalStrut(32));
                footerContentPanel.add(footerLabel);
                footerContentPanel.add(Box.createVerticalStrut(32));
                footerPanel.add(footerContentPanel, BorderLayout.CENTER);

                frame.add(footerPanel, BorderLayout.SOUTH);

                // Main panel with card layout
                cardLayout = new CardLayout();
                mainPanel = new JPanel(cardLayout);

                // Initialize ViewManager
                viewManager = new ViewManager(mainPanel, cardLayout);

                // Add border around the main panel
                JPanel borderedMainPanel = new JPanel(new BorderLayout());
                borderedMainPanel.setBorder(BorderFactory.createEmptyBorder(0, 48, 0, 48));
                borderedMainPanel.add(mainPanel, BorderLayout.CENTER);

                frame.add(borderedMainPanel, BorderLayout.CENTER);

                // Center the frame on the screen
                frame.setLocationRelativeTo(null);

                frame.setVisible(true);
        }
}