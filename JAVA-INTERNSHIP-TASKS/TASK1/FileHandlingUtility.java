import java.io.*;

// Main class
public class FileHandlingUtility {

    // Main method
    public static void main(String[] args) {

        // File name
        String fileName = "sample.txt";

        try {

            // =========================================
            // WRITING DATA TO FILE
            // =========================================

            // FileWriter writes data into file
            FileWriter writer = new FileWriter(fileName);

            writer.write("Welcome to CODTECH Internship Task 1.\n");
            writer.write("This program demonstrates file handling.\n");
            writer.write("Java file handling is easy to learn.\n");

            // Close writer
            writer.close();

            System.out.println("Data written successfully.\n");

            // =========================================
            // READING DATA FROM FILE
            // =========================================

            System.out.println("Reading file content:\n");

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(fileName));

            String line;

            // Read each line
            while ((line = reader.readLine()) != null) {

                System.out.println(line);
            }

            // Close reader
            reader.close();

            // =========================================
            // APPENDING/MODIFYING FILE
            // =========================================

            FileWriter modifier =
                    new FileWriter(fileName, true);

            modifier.write("\nThis line is added later.");
            modifier.write("\nTask 1 completed successfully.");

            modifier.close();

            System.out.println("\nNew content added.\n");

            // =========================================
            // DISPLAY UPDATED FILE
            // =========================================

            System.out.println("Updated file content:\n");

            BufferedReader updatedReader =
                    new BufferedReader(
                            new FileReader(fileName));

            while ((line = updatedReader.readLine()) != null) {

                System.out.println(line);
            }

            updatedReader.close();

        } catch (IOException e) {

            // Error handling
            System.out.println("Error: " + e.getMessage());
        }
    }
}