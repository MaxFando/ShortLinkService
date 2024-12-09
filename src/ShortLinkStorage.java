import java.util.HashMap;
import java.util.Map;

public class ShortLinkStorage {
    private final Map<String, ShortLink> storage = new HashMap<>();

    public void save(ShortLink shortLink) {
        storage.put(shortLink.getShortURL(), shortLink);
    }

    public ShortLink get(String shortURL) {
        return storage.get(shortURL);
    }

    public void remove(String shortURL) {
        storage.remove(shortURL);
    }
}
