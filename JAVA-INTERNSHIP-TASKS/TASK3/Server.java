import java.io.*;
import java.net.*;
import java.util.*;

// Main server class
public class Server {

    // List to store connected clients
    private static final List<ClientHandler> clients =
            new ArrayList<>();

    public static void main(String[] args) {

        int port = 1234;

        try {

            // Create server socket
            ServerSocket serverSocket =
                    new ServerSocket(port);

            System.out.println("Server started...");
            System.out.println("Waiting for clients...\n");

            while (true) {

                // Accept client
                Socket socket =
                        serverSocket.accept();

                System.out.println(
                        "New client connected.");

                // Create handler
                ClientHandler clientHandler =
                        new ClientHandler(socket);

                // Add client
                clients.add(clientHandler);

                // Start thread
                new Thread(clientHandler).start();
                serverSocket.close();
            }

        } catch (IOException e) {

            System.out.println(
                    "Server error: " + e.getMessage());
                    
        }
    }
   

    // Send message to all clients
    public static void broadcastMessage(
            String message) {

        for (ClientHandler client : clients) {

            client.sendMessage(message);
        }
    }
}

// =========================================
// CLIENT HANDLER CLASS
// =========================================

class ClientHandler implements Runnable {

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    // Constructor
    public ClientHandler(Socket socket) {

        this.socket = socket;
    }

    @Override
    public void run() {

        try {

            // Input stream
            in = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()));

            // Output stream
            out = new PrintWriter(
                    socket.getOutputStream(),
                    true);

            String message;

            // Read messages
            while ((message = in.readLine())
                    != null) {

                System.out.println(
                        "Message received: "
                                + message);

                // Broadcast message
                Server.broadcastMessage(message);
            }

        } catch (IOException e) {

            System.out.println(
                    "Client disconnected.");
        }
    }

    // Send message to client
    public void sendMessage(String message) {

        out.println(message);
        
    }
}