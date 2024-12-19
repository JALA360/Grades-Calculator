import javax.swing.JTextField; // Importing the JTextField class to allow input fields to be used in the program

public class Maths { // This is the class where all the math-related methods for calculating grades

    // This is Method A. It calculates the final grade by averaging the overall grades of Level 5 and Level 6
    // The formula it uses is (Level 5 Grade + Level 6 Grade) / 2.
    public static double calculateMethodA(JTextField[][] l5Fields, JTextField[][] l6Fields) {
        double level5Grade = calculateLevelGrade(l5Fields); // This calculates the total grade for Level 5
        double level6Grade = calculateLevelGrade(l6Fields); // This calculates the total grade for Level 6
        return (level5Grade + level6Grade) / 2; // The grades for Level 5 and Level 6 are added together and divided by 2 to find the average
    }

    // This method is called Method B. It calculates the final grade by giving more weight to Level 6
    // The formula it uses is: (Level 5 Grade + Level 6 Grade + Level 6 Grade) / 3
    // This means Level 6 is counted twice, making it more important in the final grade calculation
    public static double calculateMethodB(JTextField[][] l5Fields, JTextField[][] l6Fields) {
        double level5Grade = calculateLevelGrade(l5Fields); // This calculates the total grade for Level 5
        double level6Grade = calculateLevelGrade(l6Fields); // This calculates the total grade for Level 6
        return (level5Grade + level6Grade + level6Grade) / 3; // The Level 6 grade is added twice, and the result is divided by 3 to calculate the weighted average
    }

    // This method is called Method C. It calculates the grade for Level 6 using a weighted average formula
    // The formula is: (Sum of (Module Grade * Module Credits)) / Total Credits
    // This method looks at each module's grade and how many credits it is worth, giving more importance to modules with higher credits
    public static double calculateMethodC(JTextField[][] l6Fields) {
        double totalGrade = 0; // This variable will store the total of all the weighted grades (grade * credits) for Level 6
        int totalCredits = 0; // This variable will store the total number of credits for all modules in Level 6
        for (JTextField[] module : l6Fields) { // This loop goes through each module in the Level 6 input fields
            int credits = parseIntOrZero(module[0].getText()); // This tries to get the credits for the module. If it fails, it sets the value to 0
            double grade = parseDoubleOrZero(module[1].getText()); // This tries to get the grade for the module. If it fails, it sets the value to 0
            totalCredits += credits; // The credits for this module are added to the total credits
            totalGrade += grade * credits; // The grade for this module is multiplied by its credits and added to the total grade
        }
        return totalCredits == 0 ? 0 : totalGrade / totalCredits; // If the total credits are 0, return 0 to avoid division by zero. But if all works this divides the total grade by the total credits to find the average
    }

    // This method is called Method D. It calculates the overall grade for both Level 5 and Level 6 combined and then assigns it a classification
    // It uses the formula: (Level 5 Grade + Level 6 Grade) / 2 to calculate the average grade
    // The grade is then classified into categories like "1st", "2:1", "2:2", based on the thresholds
    public static String calculateMethodD(JTextField[][] l5Fields, JTextField[][] l6Fields) {
        double overallGrade = (calculateLevelGrade(l5Fields) + calculateLevelGrade(l6Fields)) / 2; // Calculate the average grade for Level 5 and Level 6 combined
        return classifyGrade(overallGrade); // Pass the grade to the classifyGrade method to get the classification
    }

    // This method is a simpler version of Method D, but it only considers Level 6 grades
    // It calculates the overall Level 6 grade and then classifies it
    public static String calculateMethodDLevel6(JTextField[][] l6Fields) {
        double overallGrade = calculateLevelGrade(l6Fields); // Calculates the overall grade for Level 6
        return classifyGrade(overallGrade); // Pass the grade to the classifyGrade method to get the classification.
    }

    // This method is used to calculate the total grade for a given level
    // It uses the formula: (Sum of (Module Grade * Module Credits)) / Total Credits
    // It goes through all the modules, calculates their weighted grades, and returns the average grade for the level
    public static double calculateLevelGrade(JTextField[][] fields) {
        double totalGrade = 0; // This variable stores the sum of all the grades
        int totalCredits = 0; // This variable stores the total number of credits
        for (JTextField[] module : fields) { // This loop goes through each module in the level
            int credits = parseIntOrZero(module[0].getText()); // Parse the credits for the module. If the input is invalid it sets the value as 0
            double grade = parseDoubleOrZero(module[1].getText()); // Parse the grade for the module. If the input is invalid it sets the value as 0
            totalCredits += credits; // Add the module credits to the total credits
            totalGrade += grade * credits; // Add the weighted grade (grade * credits) to the total grade
        }
        return totalCredits == 0 ? 0 : totalGrade / totalCredits; // If totalCredits is 0, return 0.
    }

    // This method tries to convert a string into an integer
    // If the string is invalid, either empty or contains letters, it returns 0
    public static int parseIntOrZero(String text) {
        try {
            return Integer.parseInt(text.trim()); // Trys to convert the string to an integer
        } catch (NumberFormatException e) {
            return 0; // Return 0 as a default value.
        }
    }

    // This method tries to convert a string into a double
    // If the string is invalid ,empty or contains letters, it returns 0.0
    public static double parseDoubleOrZero(String text) {
        try {
            return Double.parseDouble(text.trim()); // Try to convert the string to a double
        } catch (NumberFormatException e) {
            return 0.0; // Return 0.0 as a default value
        }
    }

    // This method takes a numeric grade and assigns it a classification based on defined thresholds
    // Grades >= 70 are classified as 1st, grades between 60 and 69 are 2:1, and so on
    public static String classifyGrade(double grade) {
        if (grade >= 70) return "1st"; // If the grade is 70 or higher, classify as1st
        if (grade >= 60) return "2:1"; // If the grade is between 60 and 69, classify as 2:1
        if (grade >= 50) return "2:2"; // If the grade is between 50 and 59, classify as 2:2
        if (grade >= 40) return "3rd"; // If the grade is between 40 and 49, classify as "rd
        return "Fail"; // If the grade is below 40, classify as Fail
    }
}