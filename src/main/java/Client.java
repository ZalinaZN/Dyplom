import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try (Socket socket = new Socket(ServerSettings.HOST, ServerSettings.PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            System.out.println(in.readLine());

            System.out.println("Введите слово для поиска:");
            out.println(scanner.nextLine());

            int character;
            StringBuilder jsonAnswer = new StringBuilder();
            while ((character = in.read()) != -1) {
                jsonAnswer.append((char) character);
            }
            System.out.println(jsonAnswer);

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
