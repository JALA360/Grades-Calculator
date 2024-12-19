import javax.swing.*; // Importing Swing components for GUI creation
import javax.swing.border.Border; // Importing Border for customizing button borders
import java.awt.*; // Importing Layout managers and other AWT components (Abstract Window Toolkit components)
import java.awt.event.*; // Importing event handling classes
import java.io.*; // Importing I/O classes for saving/loading functionality
import java.util.Scanner; // Importing Scanner class for reading data

public class Level5And6_GUI {
    // Declaring arrays for Level 5 and Level 6 fields to store credits, grade, and module code
    private JTextField[][] l5Fields = new JTextField[10][3]; // Level 5 fields (credits, grade, module code)
    private JTextField[][] l6Fields = new JTextField[10][3]; // Level 6 fields (credits, grade, module code)
    private JTextArea methodAResultArea, methodBResultArea, methodDResultArea; // Areas to display the results of methods
    private JTextField l5TotalCreditsField, l5TotalGradesField; // Fields for total Level 5 credits and grades
    private JTextField l6TotalCreditsField, l6TotalGradesField; // Fields for total Level 6 credits and grades

    // Constructor for initializing the GUI
    public Level5And6_GUI() {
        // Creating the main frame
        JFrame frame = new JFrame("Level 5 & 6 Grades"); // Title of the window
        frame.setSize(1000, 600); // Setting the window size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the window is closed
        frame.setResizable(false); // Make the window non-resizable
        frame.setLayout(new BorderLayout()); // Setting the layout to BorderLayout

        // Creating main panel to hold Level 5 and Level 6 input sections
        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 10, 10)); // Two columns for Level 5 and Level 6 input
        JPanel l5Panel = createLevelPanel(l5Fields, "Level 5 Modules", true); // Creating Level 5 panel with labels
        JPanel l6Panel = createLevelPanel(l6Fields, "Level 6 Modules", false); // Creating Level 6 panel with labels

        // Adding Level 5 and Level 6 panels to the main panel
        mainPanel.add(l5Panel);
        mainPanel.add(l6Panel);
        frame.add(mainPanel, BorderLayout.CENTER); // Adding the main panel to the center of the frame

        // Creating a bottom panel to hold method result output areas
        JPanel bottomPanel = new JPanel(new BorderLayout()); 

        // Creating panel for method outputs with 3 sections for Method A, B, and D
        JPanel outputPanel = new JPanel(new GridLayout(1, 3, 10, 10)); // 1 row, 3 columns for methods A, B, and D

        // Creating labels for Method A, B, and D
        JLabel methodALabel = new JLabel("Method A: ");
        JLabel methodBLabel = new JLabel("Method B: ");
        JLabel methodDLabel = new JLabel("Method D: ");

        // Creating output text areas for each method, increasing their height for better display
        methodAResultArea = new JTextArea(3, 20);
        methodBResultArea = new JTextArea(3, 20);
        methodDResultArea = new JTextArea(3, 20);

        // Setting text areas to be non-editable
        methodAResultArea.setEditable(false);
        methodBResultArea.setEditable(false);
        methodDResultArea.setEditable(false);

        // Setting the text areas to automatically wrap text
        methodAResultArea.setLineWrap(true);
        methodBResultArea.setLineWrap(true);
        methodDResultArea.setLineWrap(true);

        // Creating boxes for each method label and result area
        JPanel methodABox = new JPanel(new BorderLayout());
        methodABox.add(methodALabel, BorderLayout.NORTH);
        methodABox.add(methodAResultArea, BorderLayout.CENTER);

        JPanel methodBBox = new JPanel(new BorderLayout());
        methodBBox.add(methodBLabel, BorderLayout.NORTH);
        methodBBox.add(methodBResultArea, BorderLayout.CENTER);

        JPanel methodDBox = new JPanel(new BorderLayout());
        methodDBox.add(methodDLabel, BorderLayout.NORTH);
        methodDBox.add(methodDResultArea, BorderLayout.CENTER);

        // Adding each method box to the output panel
        outputPanel.add(methodABox);
        outputPanel.add(methodBBox);
        outputPanel.add(methodDBox);

        bottomPanel.add(outputPanel, BorderLayout.SOUTH); // Adding output panel to bottom panel
        frame.add(bottomPanel, BorderLayout.SOUTH); // Adding bottom panel to the bottom of the frame

        // Creating a font for buttons
        Font buttonFont = new Font("Arial", Font.BOLD, 15);
        Border thickBlackBorder = BorderFactory.createLineBorder(Color.BLACK, 3);

        // Creating a back button to navigate to the home page
        JButton backButton = new JButton("Back");
        backButton.setBackground(new Color(254, 79, 74));
        backButton.setForeground(Color.BLACK);
        backButton.setFont(buttonFont);
        backButton.setBorder(thickBlackBorder);
        backButton.setFocusPainted(false);
        backButton.setPreferredSize(new Dimension(60, 30));
        backButton.addActionListener(e -> {
            new Home_GUI(); // Open the Home GUI
            frame.dispose(); // Close the current frame
        });

        // Create Save and Load buttons
        JButton saveButton = new JButton("Save");
        saveButton.setBackground(new Color(254, 79, 74)); 
        saveButton.setForeground(Color.BLACK);
        saveButton.setFont(buttonFont);
        saveButton.setBorder(thickBlackBorder);
        saveButton.setFocusPainted(false);

        JButton loadButton = new JButton("Load");
        loadButton.setBackground(new Color(254, 79, 74));
        loadButton.setForeground(Color.BLACK);
        loadButton.setFont(buttonFont);
        loadButton.setBorder(thickBlackBorder);
        loadButton.setFocusPainted(false);

        // Panel to hold the buttons with GridBagLayout for more precise control
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBackground(new Color(254, 79, 74));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; // Allow buttons to fill horizontally

        // Place the back button to span all three columns
        gbc.gridwidth = 3;
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanel.add(backButton, gbc);

        // Place the Save button in the left column
        gbc.gridwidth = 1; 
        gbc.gridx = 0;
        gbc.gridy = 1;
        buttonPanel.add(saveButton, gbc);

        // Place the Load button in the right column
        gbc.gridx = 1;
        buttonPanel.add(loadButton, gbc);

        // Adding the button panel to the frame's top section
        frame.add(buttonPanel, BorderLayout.NORTH);

        // Creating a right panel to hold the calculation buttons for each method
        JPanel rightPanel = new JPanel(new GridLayout(3, 1, 10, 10)); // 3 rows for 3 buttons
        rightPanel.setBackground(new Color(254, 79, 74)); // Match the panel background to the frame

        // Creating buttons for Method A, Method B, and Method D with action listeners to open corresponding GUIs
        JButton methodAButton = new JButton("Method A Calculation");
        methodAButton.setBackground(new Color(254, 79, 74));
        methodAButton.setForeground(Color.BLACK);
        methodAButton.setFont(buttonFont);
        methodAButton.setBorder(thickBlackBorder);
        methodAButton.setFocusPainted(false);
        methodAButton.addActionListener(e -> openMethodAGUI()); // Open Method A GUI

        JButton methodBButton = new JButton("Method B Calculation");
        methodBButton.setBackground(new Color(254, 79, 74));
        methodBButton.setForeground(Color.BLACK);
        methodBButton.setFont(buttonFont);
        methodBButton.setBorder(thickBlackBorder);
        methodBButton.setFocusPainted(false);
        methodBButton.addActionListener(e -> openMethodBGUI()); // Open Method B GUI

        JButton methodDButton = new JButton("Method D Calculation");
        methodDButton.setBackground(new Color(254, 79, 74));
        methodDButton.setForeground(Color.BLACK);
        methodDButton.setFont(buttonFont);
        methodDButton.setBorder(thickBlackBorder);
        methodDButton.setFocusPainted(false);
        methodDButton.addActionListener(e -> openMethodDGUI()); // Open Method D GUI

        // Adding the method buttons to the right panel
        rightPanel.add(methodAButton);
        rightPanel.add(methodBButton);
        rightPanel.add(methodDButton);

        // Adding the right panel to the frame's right section
        frame.add(rightPanel, BorderLayout.EAST);

        // Adding dynamic update functionality
addDynamicUpdate(); // Call the addDynamicUpdate method to enable real-time updates for the input fields

// Adding action listeners for save and load buttons
saveButton.addActionListener(e -> openSaveGUI()); // Add listener for save button to open the Save GUI
loadButton.addActionListener(e -> openLoadGUI()); // Add listener for load button to open the Load GUI

frame.setVisible(true); // Making the frame visible to the user
}

// Creating a panel for Level 5 or Level 6
private JPanel createLevelPanel(JTextField[][] fields, String title, boolean isLevel5) {
    // Creating a panel with a grid layout of 11 rows and 3 columns
    JPanel panel = new JPanel(new GridLayout(11, 3, 5, 5)); // 10 modules + 1 row for totals
    panel.setBorder(BorderFactory.createTitledBorder(title)); // Setting the title for the panel
    
    // Setting panel background color to red
    panel.setBackground(new Color(254, 79, 74)); // Use a light red color for the background
    
    // Iterate through the modules
    for (int i = 0; i < 10; i++) { // Loop to create 10 module rows
        JLabel moduleLabel = new JLabel("Module " + (i + 1)); // Creating a label for each module
        moduleLabel.setForeground(Color.BLACK); // Setting label text to black for readability
        panel.add(moduleLabel); // Adding module label to the panel

        // Creating text fields for credits, grade, and module code for each module
        fields[i][0] = new JTextField("Enter Credits"); // Credits field with placeholder
        fields[i][1] = new JTextField("Enter Grade"); // Grade field with placeholder
        fields[i][2] = new JTextField("Module Code"); // Module Code field with placeholder
        
        // Adding placeholder clearing functionality
        addPlaceholderClear(fields[i][0], "Enter Credits");
        addPlaceholderClear(fields[i][1], "Enter Grade");
        addPlaceholderClear(fields[i][2], "Module Code");
        
        // Adding the fields to the panel for each module
        panel.add(fields[i][0]); // Add credits text field
        panel.add(fields[i][1]); // Add grade text field
        panel.add(fields[i][2]); // Add module code text field
    }

    // Adding total credits and total grades text fields
    if (isLevel5) { // Check if it's Level 5
        // Create text fields to display total credits and total grades for Level 5
        l5TotalCreditsField = new JTextField("Total Credits");
        l5TotalCreditsField.setEditable(false); // Make total credits field non-editable

        l5TotalGradesField = new JTextField("Total Grades");
        l5TotalGradesField.setEditable(false); // Make total grades field non-editable
        
        // Adding labels and fields for total credits and total grades to the panel
        panel.add(new JLabel("Total Credits"));
        panel.add(l5TotalCreditsField);
        panel.add(new JLabel("Total Grades"));
        panel.add(l5TotalGradesField);
    } else { // For Level 6
        // Creating text fields to display total credits and total grades for Level 6
        l6TotalCreditsField = new JTextField("Total Credits");
        l6TotalCreditsField.setEditable(false); // Make total credits field non-editable

        l6TotalGradesField = new JTextField("Total Grades");
        l6TotalGradesField.setEditable(false); // Make total grades field non-editable
        
        // Adding labels and fields for total credits and total grades to the panel
        panel.add(new JLabel("Total Credits"));
        panel.add(l6TotalCreditsField);
        panel.add(new JLabel("Total Grades"));
        panel.add(l6TotalGradesField);
    }

    return panel; // Return the constructed panel
}

// Adding placeholder clearing functionality
private void addPlaceholderClear(JTextField field, String placeholder) {
    field.addFocusListener(new FocusAdapter() { // Adding focus listener to text fields for placeholder functionality
        public void focusGained(FocusEvent e) {
            // Clear the placeholder text when the field gains focus
            if (field.getText().equals(placeholder)) {
                field.setText(""); // Clear placeholder text on focus
            }
        }

        public void focusLost(FocusEvent e) {
            // Restore the placeholder if the field is left empty
            if (field.getText().isEmpty()) {
                field.setText(placeholder); // Restore placeholder if field is empty
            }
        }
    });
}

// Adding dynamic update functionality to update grades in real-time
private void addDynamicUpdate() {
    for (int i = 0; i < 10; i++) { // Loop through each module field
        for (int j = 0; j < 3; j++) { // Loop through each of the 3 fields (credits, grade, module code)
            // Adding caret listener to detect changes in the text field and update totals dynamically
            l5Fields[i][j].addCaretListener(e -> updateTotals()); // For Level 5 fields
            l6Fields[i][j].addCaretListener(e -> updateTotals()); // For Level 6 fields
        }
    }
}

// Update totals dynamically and grades in real-time
private void updateTotals() {
    try {
        // Update Level 5 totals
        int l5CreditsSum = 0; // Initialize variable for total credits for Level 5
        double l5GradesSum = 0; // Initialize variable for total grades for Level 5
        for (int i = 0; i < 10; i++) { // Loop through each of the 10 modules
            // Parse the credits and grades and accumulate the totals
            l5CreditsSum += Maths.parseIntOrZero(l5Fields[i][0].getText()); // Parse credits field
            l5GradesSum += Maths.parseDoubleOrZero(l5Fields[i][1].getText()); // Parse grade field
        }

        // Update Level 6 totals
        int l6CreditsSum = 0; // Initialize variable for total credits for Level 6
        double l6GradesSum = 0; // Initialize variable for total grades for Level 6
        for (int i = 0; i < 10; i++) { // Loop through each of the 10 modules
            // Parse the credits and grades and accumulate the totals
            l6CreditsSum += Maths.parseIntOrZero(l6Fields[i][0].getText()); // Parse credits field
            l6GradesSum += Maths.parseDoubleOrZero(l6Fields[i][1].getText()); // Parse grade field
        }

        // Update total fields with the calculated sums
        l5TotalCreditsField.setText(" " + l5CreditsSum); // Set total credits for Level 5
        l5TotalGradesField.setText(" " + l5GradesSum); // Set total grades for Level 5
        l6TotalCreditsField.setText(" " + l6CreditsSum); // Set total credits for Level 6
        l6TotalGradesField.setText(" " + l6GradesSum); // Set total grades for Level 6

        // Calculate and update results for Method A, Method B, and Method D
        double methodAResultValue = Maths.calculateMethodA(l5Fields, l6Fields); // Calculate Method A
        double methodBResultValue = Maths.calculateMethodB(l5Fields, l6Fields); // Calculate Method B
        String methodDResultValue = Maths.calculateMethodD(l5Fields, l6Fields); // Calculate Method D

        // Format and display results in the result areas for each method
        methodAResultArea.setText(String.format("Level 5: %.2f%%\nLevel 6: %.2f%%\nAverage: %.2f", methodAResultValue, methodBResultValue, (methodAResultValue + methodBResultValue) / 2));
        methodBResultArea.setText(String.format("Level 5: %.2f%%\nLevel 6: %.2f%%\nAverage: %.2f", methodAResultValue, methodBResultValue, (methodAResultValue + methodBResultValue) / 2));
        methodDResultArea.setText(methodDResultValue); // Set result for Method D
    } catch (Exception e) {
        // Display message if data is invalid
        methodAResultArea.setText("Invalid Input"); // Show error message for Method A
        methodBResultArea.setText("Invalid Input"); // Show error message for Method B
        methodDResultArea.setText("Invalid Input"); // Show error message for Method D
    }
}

    // Open Save GUI
private void openSaveGUI() {
    // Creating a new JFrame for the save operation, with title "Save Grades"
    JFrame saveFrame = new JFrame("Save Grades");
    saveFrame.setSize(400, 200);
    saveFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Ensure the frame closes without affecting the main application
    saveFrame.setLayout(new BorderLayout()); // Use BorderLayout to organize the components

    // Create a panel with a GridLayout to hold the input fields for student number
    JPanel savePanel = new JPanel(new GridLayout(2, 1)); // Layout with 2 rows and 1 column
    JLabel studentNumberLabel = new JLabel("Please enter student number:"); // Label prompting for student number
    JTextField studentNumberField = new JTextField(); // Text field for user input

    // Add the label and text field to the savePanel
    savePanel.add(studentNumberLabel);
    savePanel.add(studentNumberField);

    // Add Confirm button to save panel
    JButton confirmButton = new JButton("Confirm"); // Create the confirm button
    confirmButton.addActionListener(e -> {
        String studentNumber = studentNumberField.getText(); // Get the student number from the text field
        if (studentNumber.matches("\\d+")) { // Check if the input is a valid number (only digits)
            saveGrades(studentNumber); // Call the saveGrades method to save the grades
            JOptionPane.showMessageDialog(saveFrame, "Grades saved successfully."); // Show success message
            saveFrame.dispose(); // Close the save frame
        } else {
            JOptionPane.showMessageDialog(saveFrame, "Invalid student number. Please enter only numbers."); // Show error message if input is invalid
        }
    });

    // Adding the panel and the button to the frame
    saveFrame.add(savePanel, BorderLayout.CENTER); // Adding the input panel to the center of the frame
    saveFrame.add(confirmButton, BorderLayout.SOUTH); // Adding the confirm button to the bottom (south) of the frame
    saveFrame.setVisible(true); // Make the frame visible
}

// Save grades to a text file
private void saveGrades(String studentNumber) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("grades56.txt", true))) { // Open "grades.txt" file in append mode
        writer.write("Student Number: " + studentNumber); // Write the student number to the file
        writer.newLine(); // Move to the next line in the file

        // Write the Level 5 and Level 6 data to the file using the writeLevelData method
        writeLevelData(writer, l5Fields); // Save Level 5 data
        writeLevelData(writer, l6Fields); // Save Level 6 data

        writer.newLine(); // Add a blank line after the grades for this student
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error saving grades."); // Display an error message if there's an issue writing to the file
    }
}

// Write data for a level (Level 5 or Level 6)
private void writeLevelData(BufferedWriter writer, JTextField[][] fields) throws IOException {
    // Loop through each of the 10 modules for the given level (Level 5 or Level 6)
    for (int i = 0; i < 10; i++) {
        // Get the values from the text fields for the current module
        String credits = fields[i][0].getText(); // Credits for the module
        String grade = fields[i][1].getText(); // Grade for the module
        String moduleCode = fields[i][2].getText(); // Module code for the module

        // Write the module data to the file in the format "Module X: moduleCode, grade, credits"
        writer.write("Module " + (i + 1) + ": " + moduleCode + ", " + grade + ", " + credits);
        writer.newLine(); // Move to the next line after each module entry
    }
}

// Open Load GUI
private void openLoadGUI() {
    // Creating a new JFrame for the load operation, with title "Load Grades"
    JFrame loadFrame = new JFrame("Load Grades");
    loadFrame.setSize(400, 200); // Set the size of the frame
    loadFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Ensure the frame closes without affecting the main application
    loadFrame.setLayout(new BorderLayout()); // Use BorderLayout to organize the components

    // Creating a panel with a GridLayout to hold the input fields for student number
    JPanel loadPanel = new JPanel(new GridLayout(2, 1)); // Layout with 2 rows and 1 column
    JLabel studentNumberLabel = new JLabel("Please enter student number:"); // Label prompting for student number
    JTextField studentNumberField = new JTextField(); // Text field for user input

    // Adding the label and text field to the loadPanel
    loadPanel.add(studentNumberLabel);
    loadPanel.add(studentNumberField);

    // Adding Confirm button to load panel
    JButton confirmButton = new JButton("Confirm"); // Create the confirm button
    confirmButton.addActionListener(e -> {
        String studentNumber = studentNumberField.getText(); // Get the student number from the text field
        if (studentNumber.matches("\\d+")) { // Check if the input is a valid number (only digits)
            loadGrades(studentNumber); // Call the loadGrades method to load the grades
            loadFrame.dispose(); // Close the load frame
        } else {
            JOptionPane.showMessageDialog(loadFrame, "Invalid student number. Please enter only numbers."); // Show error message if input is invalid
        }
    });

    // Adding the panel and the button to the frame
    loadFrame.add(loadPanel, BorderLayout.CENTER); // Adding the input panel to the center of the frame
    loadFrame.add(confirmButton, BorderLayout.SOUTH); // Adding the confirm button to the bottom (south) of the frame
    loadFrame.setVisible(true); // Make the frame visible
}

// Load grades from the file
private void loadGrades(String studentNumber) {
    try (Scanner scanner = new Scanner(new File("grades56.txt"))) { // Open "grades.txt" file for reading
        while (scanner.hasNextLine()) { // Read through each line in the file
            String line = scanner.nextLine(); // Get the current line from the file
            if (line.contains("Student Number: " + studentNumber)) { // If the line contains the student number
                // Load Level 5 and Level 6 data by calling the loadLevelData method
                loadLevelData(scanner, l5Fields); // Load Level 5 data
                loadLevelData(scanner, l6Fields); // Load Level 6 data
                break; // Stop once the correct student is found and loaded
            }
        }
    } catch (FileNotFoundException e) {
        JOptionPane.showMessageDialog(null, "Error loading grades."); // Display an error message if the file is not found
    }
}

// Load data for a level (Level 5 or Level 6)
private void loadLevelData(Scanner scanner, JTextField[][] fields) {
    // Loop through each of the 10 modules for the given level (Level 5 or Level 6)
    for (int i = 0; i < 10; i++) {
        if (scanner.hasNextLine()) { // Check if there is another line in the file
            String line = scanner.nextLine(); // Get the current line from the file
            // Split the line into moduleCode, grade, and credits by splitting based on ": " and ", "
            String[] parts = line.split(": ")[1].split(", ");
            // Set the values from the file into the corresponding text fields
            fields[i][0].setText(parts[2]); // Set the credits for the module
            fields[i][1].setText(parts[1]); // Set the grade for the module
            fields[i][2].setText(parts[0]); // Set the module code for the module
        }
    }
}

    // Open Method A GUI
private void openMethodAGUI() {
    // Create an instance of the MethodA_GUI class, which initializes and displays the MethodA GUI
    new MethodA_GUI(); // Initialize and display MethodA GUI
}

// Open Method B GUI
private void openMethodBGUI() {
    // Create an instance of the MethodB_GUI class, which initializes and displays the MethodB GUI
    new MethodB_GUI(); // Initialize and display MethodB GUI
}

// Open Method D GUI
private void openMethodDGUI() {
    // Create an instance of the MethodD_GUI class, which initializes and displays the MethodD GUI
    new MethodD_GUI(); // Initialize and display MethodD GUI
}

// Main method to launch the application
public static void main(String[] args) {
    // Create an instance of the Level5And6_GUI class, which is presumably the main GUI for the application
    new Level5And6_GUI(); // Initialize and display the main Level 5 and 6 GUI
}

}