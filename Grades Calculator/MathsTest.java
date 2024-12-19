import static org.junit.Assert.*;  // Correct import for static assertions
import org.junit.Test;            // Correct import for JUnit's @Test annotation
import javax.swing.JTextField;   // Correct import for JTextField

public class MathsTest {

    // Helper function to create JTextField arrays with specified values
    private JTextField[][] createFields(int[] credits, double[] grades) {
        JTextField[][] fields = new JTextField[credits.length][2];
        for (int i = 0; i < credits.length; i++) {
            fields[i][0] = new JTextField(String.valueOf(credits[i])); // credit
            fields[i][1] = new JTextField(String.valueOf(grades[i]));   // grade
        }
        return fields;
    }

    // Test Method A
    @Test
public void testCalculateMethodA() {
    // Example input
    JTextField[][] level5 = createFields(new int[]{10, 20}, new double[]{60, 70});
    JTextField[][] level6 = createFields(new int[]{10, 20}, new double[]{80, 90});
    
    // Call the method to test
    double result = Maths.calculateMethodA(level5, level6);
    
    // Round the result to 1 decimal place
    double roundedResult = Math.round(result * 10.0) / 10.0;
    
    // Check if the result is within an acceptable margin (0.1)
    assertEquals(76.7, roundedResult, 0.1); // Expected average of (65 + 85) / 2
}

    // Test Method B
    @Test
    public void testCalculateMethodB() {
        // Example input
        JTextField[][] level5 = createFields(new int[]{10, 20}, new double[]{60, 70});
        JTextField[][] level6 = createFields(new int[]{10, 20}, new double[]{80, 90});
        
        double result = Maths.calculateMethodB(level5, level6);
        assertEquals(80, result, 0.1); // Expected weighted average of (65 + 85 + 85) / 3
    }

    // Test Method C
    @Test
    public void testCalculateMethodC() {
        // Example input (module with credits and grades)
        JTextField[][] level6 = createFields(new int[]{10, 20}, new double[]{60, 70});
        
        double result = Maths.calculateMethodC(level6);
        assertEquals(66.67, result, 0.01); // Weighted average calculation: (10*60 + 20*70) / (10 + 20)
    }

    // Test Method D
    @Test
    public void testCalculateMethodD() {
        // Example input
        JTextField[][] level5 = createFields(new int[]{10, 20}, new double[]{60, 70});
        JTextField[][] level6 = createFields(new int[]{10, 20}, new double[]{80, 90});
        
        String result = Maths.calculateMethodD(level5, level6);
        assertEquals("1st", result); // Expected classification for average grade
    }

    // Test Method D Level 6
    @Test
    public void testCalculateMethodDLevel6() {
        // Example input
        JTextField[][] level6 = createFields(new int[]{10, 20}, new double[]{80, 90});
        
        String result = Maths.calculateMethodDLevel6(level6);
        assertEquals("1st", result); // Classification based on Level 6 grade
    }

    // Test Level Grade Calculation
    @Test
    public void testCalculateLevelGrade() {
        // Example input
        JTextField[][] fields = createFields(new int[]{10, 20}, new double[]{60, 70});
        
        double result = Maths.calculateLevelGrade(fields);
        assertEquals(66.67, result, 0.01); // Weighted average calculation
    }

    // Test parseIntOrZero
    @Test
    public void testParseIntOrZero() {
        assertEquals(10, Maths.parseIntOrZero("10"));
        assertEquals(0, Maths.parseIntOrZero("abc"));
        assertEquals(0, Maths.parseIntOrZero(""));
    }

    // Test parseDoubleOrZero
    @Test
    public void testParseDoubleOrZero() {
        assertEquals(10.5, Maths.parseDoubleOrZero("10.5"), 0.01);
        assertEquals(0.0, Maths.parseDoubleOrZero("abc"), 0.01);
        assertEquals(0.0, Maths.parseDoubleOrZero(""), 0.01);
    }

    // Test classifyGrade
    @Test
    public void testClassifyGrade() {
        assertEquals("1st", Maths.classifyGrade(70.0));
        assertEquals("2:1", Maths.classifyGrade(65.0));
        assertEquals("2:2", Maths.classifyGrade(55.0));
        assertEquals("3rd", Maths.classifyGrade(45.0));
        assertEquals("Fail", Maths.classifyGrade(35.0));
    }
}