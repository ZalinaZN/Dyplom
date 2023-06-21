import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static final String PDF_FOLDER = "./Dyplom./pdfs";
    public static void main(String[] args) {

        BooleanSearchEngine engine = null;
        try (ServerSocket serverSocket = new ServerSocket(ServerSettings.PORT)) {
            System.out.println("Сервер запущен!");
            File folder = new File(PDF_FOLDER);
            SearchEngineMap searchEngineMap = new SearchEngineMap();
            for (final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
                engine = new BooleanSearchEngine(new File(fileEntry.getPath()), searchEngineMap);
            }

            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter out = new PrintWriter(socket.getOutputStream())
                ) {
                    out.println("Произведено подключение!");
                    out.flush();

                    String request = in.readLine().toLowerCase();
                    if (request.isEmpty()) {
                        continue;
                    }
                    String[] requestArray = request.split(" ");
                    out.print(new ServerSettings().gson(Objects.requireNonNull(engine).search(requestArray)));
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}