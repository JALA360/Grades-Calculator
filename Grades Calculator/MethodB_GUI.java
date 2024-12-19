import javax.swing.*; // Importing the Swing library for creating the GUI components
import java.awt.*; // Importing the AWT library for layout and graphical features
import java.awt.event.ActionEvent; // Importing the ActionEvent class for handling button clicks
import java.awt.event.ActionListener; // Importing the ActionListener interface to define actions for buttons

// This class creates a graphical interface for Method B Calculation
public class MethodB_GUI {

    // This method is called automatically when an object of MethodB_GUI is created.
    public MethodB_GUI() {
        // Create the main frame for the GUI
        JFrame frame = new JFrame("Method B Calculation"); 
        // Set the title of the window

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        // The application will close completely when this window is closed

        frame.setSize(1300, 500); 
        // Set the width and height of the window

        frame.setResizable(false); 
        // Prevent the user from resizing the window

        // Create a label to display an image in the GUI
        JLabel imageLabel = new JLabel(); 

        // Load the image that will be displayed in the GUI
        ImageIcon originalIcon = new ImageIcon("MethodB.png"); 
        // Loading the image file named "MethodB.png"

        Image img = originalIcon.getImage(); 
        // Extract the actual image object from the ImageIcon for resizing purposes

        // Resize the image to fit within the GUI dimensions
        Image resizedImg = img.getScaledInstance(1268, 480, Image.SCALE_SMOOTH); 
        // Resize the image to 1268 pixels wide and 480 pixels tall, for better quality

        imageLabel.setIcon(new ImageIcon(resizedImg)); 
        // Set the image as the icon of the label, so it will display the image in the GUI

        // Create a button labeled "Back" to allow the user to return or close the window
        JButton backButton = new JButton("Back"); 
        // Creates a button with the text "Back" on it

        // Add an action listener to the Back button so it performs an action when clicked, which will return you to the Home_GUI
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action performed when the Back button is clicked
                frame.dispose(); 
                // Closes the current window
            }
        });

        // Create a panel to hold the Back button
        JPanel buttonPanel = new JPanel(); 

        buttonPanel.add(backButton); 
        // Add the Back button to the panel. The panel ensures that the button stays at the bottom of the window.

        // Add the image label to the center of the frame
        frame.add(imageLabel, BorderLayout.CENTER); 
        // BorderLayout.CENTER means the image will take up the central area of the frame.

        // Add the panel with the Back button to the bottom of the frame
        frame.add(buttonPanel, BorderLayout.SOUTH); 
        // BorderLayout.SOUTH means the button panel will be placed at the bottom of the window.

        frame.setVisible(true); 
        // Make the frame visible so the user can see the GUI
    }

    public static void main(String[] args) {
        new MethodB_GUI(); 
    }
}