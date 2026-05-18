import java.io.*;
import java.net.*;
import java.util.Scanner;

// Main client class
public class Client {

    public static void main(String[] args) {

        String serverAddress = "localhost";
        int port = 1234;

        try {

            // Connect to server
            Socket socket =
                    new Socket(serverAddress, port);

            System.out.println(
                    "Connected to chat server.");

            // Input stream
            BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()));

            // Output stream
            PrintWriter out =
                    new PrintWriter(
                            socket.getOutputStream(),
                            true);

            // Scanner for user input
            Scanner scanner =
                    new Scanner(System.in);

            // =====================================
            // THREAD FOR RECEIVING MESSAGES
            // =====================================

            Thread receiveThread =
                    new Thread(() -> {

                try {

                    String serverMessage;

                    while ((serverMessage =
                            in.readLine()) != null) {

                        System.out.println(
                                serverMessage);
                                
        scanner.close();
                    }

                } catch (IOException e) {

                    System.out.println(
                            "Connection closed.");
                }
            });

            receiveThread.start();

            // =====================================
            // SEND MESSAGES
            // =====================================

            while (true) {

                String message =
                        scanner.nextLine();

                out.println(message);
                socket.close();
            }

        } catch (IOException e) {

            System.out.println(
                    "Client error: "
                            + e.getMessage());
        }
    }
}