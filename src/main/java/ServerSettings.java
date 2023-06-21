import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class ServerSettings {
    public final static int PORT = 8989;
    public static final String HOST = "127.0.0.1";

    public String gson(List<PageEntry> pageEntry) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        return gson.toJson(pageEntry);
    }
}
