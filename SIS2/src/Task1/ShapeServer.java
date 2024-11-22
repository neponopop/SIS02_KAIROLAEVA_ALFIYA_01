package Task1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ShapeServer {
    public static void main(String[] args) {
        final int PORT = 1234;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
         System.out.println("Server is running on port " + PORT + "...");

        try (Socket clientSocket = serverSocket.accept();
         ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());
         ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream())) {
// SIS2_Kairolaeva_Alfiya_2301
        while (true) {
         GeometricShape shape = (GeometricShape) inputStream.readObject();

         if (shape == null) break;
         System.out.println("Received a " + shape.getShapeType());

         String response = "Area of " + shape.getShapeType() + ": " + shape.calculateArea ();
         outputStream.writeObject(response);
                }

                System.out.println("Connection closed by client.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
