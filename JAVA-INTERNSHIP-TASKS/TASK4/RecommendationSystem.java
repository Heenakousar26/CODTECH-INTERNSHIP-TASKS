import java.util.*;

// Main class
public class RecommendationSystem {

    // Main method
    public static void main(String[] args) {

        // =========================================
        // MOVIE DATABASE
        // =========================================

        // Movie names
        String[] movies = {

                "Inception",
                "Interstellar",
                "Avengers Endgame",
                "The Dark Knight",
                "Titanic",
                "Avatar",
                "Joker",
                "Doctor Strange"
        };

        // Movie ratings
        double[] ratings = {

                9.0,
                8.8,
                8.5,
                9.2,
                7.9,
                8.1,
                8.4,
                7.8
        };

        // =========================================
        // DISPLAY MOVIES
        // =========================================

        System.out.println(
                "========== MOVIE LIST ==========\n");

        for (int i = 0; i < movies.length; i++) {

            System.out.println(

                    (i + 1) + ". "
                            + movies[i]
                            + " | Rating: "
                            + ratings[i]);
        }

        // =========================================
        // USER INPUT
        // =========================================

        Scanner scanner =
                new Scanner(System.in);

        System.out.println(
                "\nEnter minimum rating:");

        double userRating =
                scanner.nextDouble();

        // =========================================
        // RECOMMENDATION LOGIC
        // =========================================

        System.out.println(
                "\n===== RECOMMENDED MOVIES =====\n");

        boolean found = false;

        // Recommend movies
        for (int i = 0; i < movies.length; i++) {

            if (ratings[i] >= userRating) {

                System.out.println(

                        movies[i]
                                + " | Rating: "
                                + ratings[i]);

                found = true;
            }
        }

        // =========================================
        // IF NO MOVIES FOUND
        // =========================================

        if (!found) {

            System.out.println(
                    "No movies found.");
        }

        // Close scanner
        scanner.close();

        System.out.println(
                "\nRecommendation system completed.");
    }
}