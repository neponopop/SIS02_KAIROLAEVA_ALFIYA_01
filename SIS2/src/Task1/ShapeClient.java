package Task1;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ShapeClient {
    public static void main(String[] args) {
        final String HOST = "localhost";
        final int PORT = 1234;

        try (Socket socket = new Socket(HOST, PORT);
             ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
             Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.println("Enter shape type (Circle/Rectangle) or 'Q' to quit:");
                String input = scanner.nextLine().trim();

                if (input.equalsIgnoreCase("Q")) {
                    outputStream.writeObject(null);
                    break;   // SIS2_Kairolaeva_Alfiya_2301
                }

                GeometricShape shape = null;
                if (input.equalsIgnoreCase("Circle")) {
                    System.out.print("Enter radius: ");
                    double radius = scanner.nextDouble();
                    scanner.nextLine(); // SIS2_Kairolaeva_Alfiya_2301
                    shape = new Circle(radius);
                } else if (input.equalsIgnoreCase("Rectangle")) {
                    System.out.print("Enter width and height (separated by space): ");
                    double width = scanner.nextDouble();
                    double height = scanner.nextDouble();
                    scanner.nextLine();
                    shape = new Rectangle(width, height);
                } else {
                    System.out.println("Invalid shape type. Try again.");
                    continue;
                }
                outputStream.writeObject(shape);
                String response = (String) inputStream.readObject();
                System.out.println("Server response: " + response);
            }

            System.out.println("Client terminated.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
