import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.UUID;

public class ShortLinkService {
    private final ShortLinkStorage storage = new ShortLinkStorage();
    private final HashMap<String, String> userLinks = new HashMap<>();

    public String generateUserUuid() {
        return UUID.randomUUID().toString();
    }

    public ShortLink createShortLink(String originalUrl, String userUuid, int maxClicks, int expirationHours) {
        if (!userLinks.containsKey(userUuid)) {
            userLinks.put(userUuid, userUuid);
        }

        String shortUrl = generateShortUrl();
        LocalDateTime expirationDate = LocalDateTime.now().plusHours(expirationHours);
        ShortLink shortLink = new ShortLink(originalUrl, shortUrl, userUuid, maxClicks, expirationDate);
        storage.save(shortLink);
        return shortLink;
    }

    public String getOriginalUrl(String shortUrl) {
        ShortLink link = storage.get(shortUrl);

        if (link == null) {
            return "Link not found!";
        }

        if (link.isExpired()) {
            storage.remove(shortUrl);
            return "Link expired and removed!";
        }

        if (link.isLimitReached()) {
            return "Click limit reached!";
        }

        link.incrementClickCount();
        return link.getOriginalURL();
    }

    public String deleteShortLink(String shortUrl, String userUuid) {
        ShortLink link = storage.get(shortUrl);

        if (link == null) {
            return "Link not found!";
        }

        if (!link.getUserUUID().equals(userUuid)) {
            return "Access denied: You are not the owner of this link.";
        }

        storage.remove(shortUrl);
        return "Link deleted successfully.";
    }

    private String generateShortUrl() {
        return "clck.ru/" + UUID.randomUUID().toString().substring(0, 8);
    }
}