import java.time.LocalDateTime;

public class ShortLink {
    private String originalURL;
    private String shortURL;
    private String userUUID;
    private int maxClicks;
    private int clickCount;
    private LocalDateTime expirationDate;

    public ShortLink(String originalURL, String shortURL, String userUUID, int maxClicks, LocalDateTime expirationDate) {
        this.originalURL = originalURL;
        this.shortURL = shortURL;
        this.userUUID = userUUID;
        this.maxClicks = maxClicks;
        this.expirationDate = expirationDate;
        this.clickCount = 0;
    }

    public String getOriginalURL() {
        return originalURL;
    }

    public String getShortURL() {
        return shortURL;
    }

    public String getUserUUID() {
        return userUUID;
    }

    public int getMaxClicks() {
        return maxClicks;
    }

    public int getClickCount() {
        return clickCount;
    }

    public void incrementClickCount() {
        this.clickCount++;
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expirationDate);
    }

    public boolean isLimitReached() {
        return clickCount >= maxClicks;
    }

    @Override
    public String toString() {
        return String.format("ShortLink{original='%s', short='%s', user='%s', clicks=%d/%d, expires=%s}",
                originalURL, shortURL, userUUID, clickCount, maxClicks, expirationDate);
    }
}
