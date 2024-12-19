import javax.swing.*; // Import the Swing library for GUI components
import java.awt.*; // Import the AWT library for layout and graphical components
import java.awt.event.*; // Import the AWT event package for handling user interactions
import java.net.URI; // Import the URI class for handling URLs

public class Home_GUI extends Level6_GUI { // Defining the class for the home page GUI

    // Constructor for the Home_GUI class, which initialises the window
    public Home_GUI() {
        // Create a new JFrame, this is the main window for the application
        JFrame frame = new JFrame("Leeds Trinity University Grades Calculator");
        
        // Setting the size of the JFrame
        frame.setSize(800, 600);

        // Define the close operation for the window (when the user exits the program the program closes)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Prevent resizing of the window
        frame.setResizable(false);

        // Setting the background colour of the window
        frame.getContentPane().setBackground(new Color(254, 79, 74));

        // Create a JPanel to hold the buttons on the left side of the window, without any gaps between them
        JPanel buttonPanel = new JPanel();
        
        // Creating a GridLayout with 2 rows, 1 column, and no gaps between the buttons
        buttonPanel.setLayout(new GridLayout(2, 1, 0, 0));
        
        // Setting the size of the button panel
        buttonPanel.setPreferredSize(new Dimension(150, 500));

        // Creating a "Level 5 & 6" button
        JButton level5Button = createStyledButton("Level 5 & 6");
        
        // Adding an ActionListener to the button to perform an action when it's clicked
        level5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // When clicked, create a new instance of Level5And6_GUI and close the current frame
                new Level5And6_GUI();
                frame.dispose();
            }
        });
        
        // Adding the Level 5 & 6 button to the button panel
        buttonPanel.add(level5Button);

        // Creating a "Level 6" button
        JButton level6Button = createStyledButton("Level 6");
        
        // Adding an ActionListener to the Level 6 button to perform an action when clicked
        level6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // When clicked, create a new instance of Level6_GUI and close the current frame
                new Level6_GUI();
                frame.dispose();
            }
        });
        
        // Adding the Level 6 button to the button panel
        buttonPanel.add(level6Button);

        // Add the button panel to the left side of the frame
        frame.add(buttonPanel, BorderLayout.WEST);

        // Create a JLabel to hold an image on the right side of the frame
        JLabel imageLabel = new JLabel();
        
        // Align the image to the center
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Load an image from a file
        ImageIcon imageIcon = new ImageIcon("logo.jpg");
        
        // Scaling the image to fit the label
        imageLabel.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(600, 500, Image.SCALE_SMOOTH)));
        
        // Add the image label to the center of the frame
        frame.add(imageLabel, BorderLayout.CENTER);

        // Creating a button labeled "MyLTU" for opening the MyLTU website
        JButton myLtuButton = createStyledButton("MyLTU");
        
        // Setting the size of the MyLTU button to span across the bottom of the frame
        myLtuButton.setPreferredSize(new Dimension(800, 40));

        // Adding a ActionListener to the MyLTU button to open the website when clicked
        myLtuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Opening the MyLTU website
                    Desktop.getDesktop().browse(new URI("https://myltu.leedstrinity.ac.uk/campusm/home"));
                } catch (Exception ex) {
                    // Displaying an error message if site cannot be found
                    JOptionPane.showMessageDialog(frame, "Unable to open the link: " + ex.getMessage());
                }
            }
        });

        // Adding the MyLTU button to the bottom of the frame
        frame.add(myLtuButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(new Color(254, 79, 74));
        button.setForeground(Color.BLACK);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        button.setFocusPainted(false);
        button.setOpaque(true);

        // Add a mouse listener to change the button's appearance when the mouse interacts with it
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(204, 55, 50));
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(254, 79, 74));
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(234, 54, 50));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(254, 79, 74));
            }
        });

        return button;
    }

    // Main method to run the Home_GUI class
    public static void main(String[] args) {
        new Home_GUI(); // Creating an instance of the home GUI
    }
}