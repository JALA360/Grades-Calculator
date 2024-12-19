import java.util.Scanner;

public class SentenceOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter a sentence: ");
        String originalSentence = scanner.nextLine();

        // 1. Convert the sentence to all uppercase letters
        String upperCaseSentence = originalSentence.toUpperCase();
        System.out.println("Uppercase: " + upperCaseSentence);

        // 2. Count the number of words in the sentence
        String[] words = originalSentence.split(" ");
        int wordCount = words.length;
        System.out.println("Number of words: " + wordCount);

        // 3. Reverse the sentence
        String reversedSentence = new StringBuilder(originalSentence).reverse().toString();
        System.out.println("Reversed: " + reversedSentence);

        // 4. Check if the sentence contains the word "Java"
        boolean containsJava = originalSentence.toLowerCase().contains("java");
        System.out.println("Contains 'Java': " + containsJava);

        // 5. Replace all spaces in the sentence with underscores
        String modifiedSentence = originalSentence.replace(" ", "_");
        System.out.println("Modified (spaces replaced with underscores): " + modifiedSentence);

        // Display the final result
        System.out.println("\nOriginal Sentence: " + originalSentence);
        System.out.println("Final Result after operations:");
        System.out.println("Uppercase: " + upperCaseSentence);
        System.out.println("Word Count: " + wordCount);
        System.out.println("Reversed: " + reversedSentence);
        System.out.println("Contains 'Java': " + containsJava);
        System.out.println("Modified: " + modifiedSentence);
        
        // Close the scanner
        scanner.close();
    }
}
