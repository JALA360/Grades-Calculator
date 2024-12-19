import javax.swing.*; // Importing Swing components for creating GUI
import javax.swing.border.Border; // Importing Border class for styling components
import java.awt.*; // Importing AWT package for layout and components
import java.awt.event.*; // Importing AWT events for handling user actions
import java.io.*; // Importing IO classes for file handling and saving/loading
import java.util.Scanner; // Importing Scanner class for reading input
import javax.swing.event.*; // Importing event handling classes for Swing components

public class Level6_GUI {
    // Declaring arrays for Level 6 fields to store credits, grade, and module code
    private JTextField[][] l6Fields = new JTextField[10][3]; // Level 6 fields (credits, grade, module code)
    private JTextArea methodAResultArea, methodBResultArea; // Areas to display the results of methods
    private JTextField l6TotalCreditsField, l6TotalGradesField; // Fields for total Level 6 credits and grades
    private final int MAX_CREDITS = 120; // Maximum credits allowed

    // Constructor for initializing the Level 6 GUI
    public Level6_GUI() {
        // Creating the main frame
        JFrame frame = new JFrame("Level 6 Grades"); // Creating a new JFrame with the title Level 6 Grades
        frame.setSize(1000, 600); // Setting the window size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the window is closed
        frame.setResizable(false); // Making the window non-resizable
        frame.setLayout(new BorderLayout());

        // Creating main panel to hold Level 6 input section
        JPanel l6Panel = createLevel6Panel(); // Creating Level 6 panel with text fields

        // Adding Level 6 panel to the center of the frame
        frame.add(l6Panel, BorderLayout.CENTER);

        // Creating a top panel to hold back, save, and load buttons
        JPanel buttonPanel = new JPanel(new GridBagLayout()); // Creating panel with GridBagLayout for button arrangement
        buttonPanel.setBackground(new Color(254, 79, 74));

        Font buttonFont = new Font("Arial", Font.BOLD, 15);
        Border thickBlackBorder = BorderFactory.createLineBorder(Color.BLACK, 3);

        JButton backButton = new JButton("Back"); // Creating Back button
        backButton.setBackground(new Color(254, 79, 74));
        backButton.setForeground(Color.BLACK);
        backButton.setFont(buttonFont);
        backButton.setBorder(thickBlackBorder);
        backButton.setFocusPainted(false); 
        backButton.setPreferredSize(new Dimension(60, 30));

        JButton saveButton = new JButton("Save"); // Creating Save button
        saveButton.setBackground(new Color(254, 79, 74)); 
        saveButton.setForeground(Color.BLACK); 
        saveButton.setFont(buttonFont); 
        saveButton.setBorder(thickBlackBorder); 
        saveButton.setFocusPainted(false);

        JButton loadButton = new JButton("Load"); // Creating Load button
        loadButton.setBackground(new Color(254, 79, 74)); 
        loadButton.setForeground(Color.BLACK); 
        loadButton.setFont(buttonFont);
        loadButton.setBorder(thickBlackBorder); 
        loadButton.setFocusPainted(false); 

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Adding buttons to the top panel
        gbc.gridwidth = 3; // Span the Back button across 3 columns
        gbc.gridx = 0; // Setting the grid position for "Back" button (x)
        gbc.gridy = 0; // Setting the grid position for "Back" button(Y)
        buttonPanel.add(backButton, gbc); // Adding Back button to the panel

        gbc.gridwidth = 1; // Setting grid width to 1
        gbc.gridx = 0; // Setting the grid position for Save button (X)
        gbc.gridy = 1; // Setting the grid position for "Save" button (Y)
        buttonPanel.add(saveButton, gbc); // Adding Save button to the panel

        gbc.gridx = 1; // Setting grid position for Load button
        buttonPanel.add(loadButton, gbc); // Adding Load button to the panel

        frame.add(buttonPanel, BorderLayout.NORTH); // Adding button panel to the top of the frame

        // Creating a right panel to hold the method buttons
        JPanel rightPanel = new JPanel(new GridLayout(2, 1, 10, 10)); // 2 rows for 2 method buttons
        rightPanel.setBackground(new Color(254, 79, 74)); // Matching the panel background to the frame

        JButton methodCButton = new JButton("Method C Calculation"); // Creating Method C button
        methodCButton.setBackground(new Color(254, 79, 74));
        methodCButton.setForeground(Color.BLACK);
        methodCButton.setFont(buttonFont);
        methodCButton.setBorder(thickBlackBorder);
        methodCButton.setFocusPainted(false);

        JButton methodD6Button = new JButton("Method D Calculation"); // Creating Method D button
        methodD6Button.setBackground(new Color(254, 79, 74));
        methodD6Button.setForeground(Color.BLACK);
        methodD6Button.setFont(buttonFont);
        methodD6Button.setBorder(thickBlackBorder);
        methodD6Button.setFocusPainted(false);

        rightPanel.add(methodCButton); // Addingethod C button to right panel
        rightPanel.add(methodD6Button); // Adding Method D button to right panel

        frame.add(rightPanel, BorderLayout.EAST); // Adding right panel to the right of the frame

        // Creating a bottom panel to hold method result output areas
        JPanel bottomPanel = new JPanel(new BorderLayout()); // Creating bottom panel with BorderLayout

        // Creating panel for method outputs with 2 sections for Method C and Method D
        JPanel outputPanel = new JPanel(new GridLayout(1, 2, 10, 10)); // 1 row, 2 columns for methods C and D

        JLabel methodALabel = new JLabel("Method C: "); // Creatimg label for Method C result
        JLabel methodBLabel = new JLabel("Method D: "); // Creating label for Method D result

        methodAResultArea = new JTextArea(3, 20); // Creating text area for Method C result
        methodBResultArea = new JTextArea(3, 20); // Creating text area for Method D result

        methodAResultArea.setEditable(false); // Making Method C text area non-editable
        methodBResultArea.setEditable(false); // Making Method D text area non-editable

        methodAResultArea.setLineWrap(true); // Enabling line wrap for Method C text area
        methodBResultArea.setLineWrap(true); // Enabling line wrap for Method D text area

        JPanel methodABox = new JPanel(new BorderLayout()); // Creating panel for Method C result
        methodABox.add(methodALabel, BorderLayout.NORTH); // Adding Method C label to the top
        methodABox.add(methodAResultArea, BorderLayout.CENTER); // Adding Method C result area to the center

        JPanel methodBBox = new JPanel(new BorderLayout()); // Creating panel for Method D result
        methodBBox.add(methodBLabel, BorderLayout.NORTH); // Adding Method D label to the top
        methodBBox.add(methodBResultArea, BorderLayout.CENTER); // Adding Method D result area to the center

        outputPanel.add(methodABox); // Adding Method C panel to the output panel
        outputPanel.add(methodBBox); // Adding Method D panel to the output panel

        bottomPanel.add(outputPanel, BorderLayout.SOUTH); // Adding output panel to the bottom of the bottom panel
        frame.add(bottomPanel, BorderLayout.SOUTH); // Adding bottom panel to the bottom of the frame

        frame.setVisible(true);

        // Action listener for back button to return to the home GUI
        backButton.addActionListener(e -> {
            frame.dispose(); // Close current Level 6 window
            new Home_GUI(); // Open the home screen GUI (make sure you have Home_GUI class)
        });

        // Action listeners for method buttons to open corresponding calculation GUIs
        methodCButton.addActionListener(e -> {
            new MethodC_GUI(); // Open Method C GUI page
        });

        methodD6Button.addActionListener(e -> {
            new MethodD6_GUI(); // Open Method D6 GUI page
        });

        // Save and Load Button Actions
        saveButton.addActionListener(e -> openSaveGUI()); // Action for Save button
        loadButton.addActionListener(e -> openLoadGUI()); // Action for Load button
    }

    // Creating a panel for Level 6 fields (credits, grade, module code)
    private JPanel createLevel6Panel() {
        JPanel panel = new JPanel(new GridLayout(11, 3, 5, 5)); // 10 modules + 1 row for totals
        panel.setBorder(BorderFactory.createTitledBorder("Level 6 Modules")); // Set title border for panel

        panel.setBackground(new Color(254, 79, 74));

        // Creating 10 modules with fields for credits, grades, and module code
        for (int i = 0; i < 10; i++) { // Iteration loop that goes through every module
            JLabel moduleLabel = new JLabel("Module " + (i + 1)); // Creating label for each module
            moduleLabel.setForeground(Color.BLACK);
            panel.add(moduleLabel); // Add label to panel

            l6Fields[i][0] = new JTextField("Enter Credits"); // Creating text field for credits
            l6Fields[i][1] = new JTextField("Enter Grade"); // Creating text field for grade
            l6Fields[i][2] = new JTextField("Module Code"); // Creating text field for module code

            addPlaceholderClear(l6Fields[i][0], "Enter Credits"); // Adding placeholder to credit field
            addPlaceholderClear(l6Fields[i][1], "Enter Grade"); // Adding placeholder to grade field
            addPlaceholderClear(l6Fields[i][2], "Module Code"); // Adding placeholder to module code field

            addDocumentListenerToFields(i); // Adding listener for updating dynamically

            panel.add(l6Fields[i][0]); // Adding credit field to panel
            panel.add(l6Fields[i][1]); // Adding grade field to panel
            panel.add(l6Fields[i][2]); // Adding module code field to panel
        }

        l6TotalCreditsField = new JTextField("Total Credits"); // Creating text field for total credits
        l6TotalCreditsField.setEditable(false); // Make total credits field non-editable

        l6TotalGradesField = new JTextField("Total Grades"); // Create text field for total grades
        l6TotalGradesField.setEditable(false); // Make total grades field non-editable

        panel.add(new JLabel("")); // Empty placeholder for layout alignment
        panel.add(l6TotalCreditsField); // Adding total credits field to panel
        panel.add(l6TotalGradesField); // Adding total grades field to panel

        return panel; // Return the constructed panel
    }

    // Adding document listener for fields to update output dynamically
private void addDocumentListenerToFields(int index) {
    // Creating a DocumentListener to listen for changes in text fields
    DocumentListener documentListener = new DocumentListener() {
        public void insertUpdate(DocumentEvent e) { updateOutputs(); } // When text is inserted
        public void removeUpdate(DocumentEvent e) { updateOutputs(); } // When text is removed
        public void changedUpdate(DocumentEvent e) { updateOutputs(); } // When text is changed
    };

    // Attaching the document listener to each of the three fields (credits, grade, module code) for the specified index
    l6Fields[index][0].getDocument().addDocumentListener(documentListener);
    l6Fields[index][1].getDocument().addDocumentListener(documentListener);
    l6Fields[index][2].getDocument().addDocumentListener(documentListener);
}

// Update the grades dynamically as the user types
private void updateOutputs() {
    int totalCredits = 0; // Initialize variable to hold total credits

    // Calculate Level 6 total credits by iterating through each module
    for (int i = 0; i < 10; i++) {
        try {
            totalCredits += Integer.parseInt(l6Fields[i][0].getText()); // Add the credit value from the text field
        } catch (NumberFormatException e) {
            // Skip invalid entries (if non-numeric values are entered)
        }
    }

    // Check if total credits exceed the maximum allowed
    if (totalCredits > MAX_CREDITS) {
        // Show an error message if total credits exceed the maximum
        JOptionPane.showMessageDialog(null, "Total credits cannot exceed " + MAX_CREDITS + "!");
        return; // Exit the method to prevent updating the output
    }

    // Setting the total credits field with the calculated total credits
    l6TotalCreditsField.setText("Total Credits: " + totalCredits);

    // Calculate and display the results for Method C and Method D
    double level6Grade = Maths.calculateLevelGrade(l6Fields); // Calculate Level 6 grade using Method C
    String level6Classification = Maths.calculateMethodDLevel6(l6Fields); // Calculate classification using Method D

    // Update the result areas with the calculated values for Method C and Method D
    methodAResultArea.setText("Method C Result: " + level6Grade); // Set Method C result
    methodBResultArea.setText("Method D Result: " + level6Classification); // Set Method D result
}

// Method to add placeholder text and clear it when user starts typing
private void addPlaceholderClear(JTextField textField, String placeholder) {
    textField.setText(placeholder); // Set the initial placeholder text
    textField.setForeground(Color.BLACK);

    // Add focus listener to clear the placeholder text when the field gains focus
    textField.addFocusListener(new FocusListener() {
        public void focusGained(FocusEvent e) {
            if (textField.getText().equals(placeholder)) {
                textField.setText(""); // Clear the placeholder text
                textField.setForeground(Color.BLACK); // Set the text color to black
            }
        }

        public void focusLost(FocusEvent e) {
            if (textField.getText().isEmpty()) {
                textField.setText(placeholder); // Restore the placeholder text if the field is empty
                textField.setForeground(Color.BLACK);
            }
        }
    });
}

// Method to prompt user for student number and save data
private void openSaveGUI() {
    String studentNumber = JOptionPane.showInputDialog("Enter Student Number: "); // Show input dialog for student number
    if (studentNumber != null && !studentNumber.isEmpty()) {
        saveGradesToFile(studentNumber); // Save the grades to file if student number is provided
    }
}

// Method to save grades to file
private void saveGradesToFile(String studentNumber) {
    try {
        // Creating a BufferedWriter to write to the grades6.txt file
        BufferedWriter writer = new BufferedWriter(new FileWriter("grades6.txt", true));
        writer.write("Student Number: " + studentNumber + "\n"); // Write student number to file
        // Iterate through the fields and write each module's data (credits, grade, module code)
        for (int i = 0; i < 10; i++) {
            writer.write(l6Fields[i][0].getText() + ":" + l6Fields[i][1].getText() + ":" + l6Fields[i][2].getText() + "\n");
        }
        writer.close(); // Close the writer after saving data
    } catch (IOException e) {
        // Show an error message if there is an issue saving the file
        JOptionPane.showMessageDialog(null, "Error saving data.");
    }
}

// Method to prompt user for student number and load data
private void openLoadGUI() {
    String studentNumber = JOptionPane.showInputDialog("Enter Student Number to Load: "); // Prompt user for student number to load
    if (studentNumber != null && !studentNumber.isEmpty()) {
        loadGradesFromFile(studentNumber); // Load the grades from the file if student number is provided
    }
}

// Method to load grades from file
private void loadGradesFromFile(String studentNumber) {
    try {
        // Creating a Scanner to read from the grades6.txt file
        Scanner scanner = new Scanner(new File("grades6.txt"));
        // Iterate through the file and check for the matching student number
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine(); // Read the current line
            // If the line starts with the student number, load the corresponding grades
            if (line.startsWith("Student Number: " + studentNumber)) {
                // Iterate through the next 10 lines and set the values in the text fields
                for (int i = 0; i < 10; i++) {
                    line = scanner.nextLine(); // Read the next line containing module data
                    String[] data = line.split(":"); // Spliting the line by colon (":") to get credits, grade, and module code
                    l6Fields[i][0].setText(data[0]); // Set credits
                    l6Fields[i][1].setText(data[1]); // Set grade
                    l6Fields[i][2].setText(data[2]); // Set module code
                }
                break; // Stop after finding and loading the grades for the student (after 10 iterations)
            }
        }
        scanner.close(); // Close the scanner after reading the file
    } catch (FileNotFoundException e) {
        // Show an error message if the file is not found
        JOptionPane.showMessageDialog(null, "Error loading data.");
    }
}

public static void main(String[] args) {
    new Level6_GUI(); // Create and display the Level 6 Grades GUI
}

}