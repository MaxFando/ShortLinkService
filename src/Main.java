import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShortLinkService service = new ShortLinkService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your UUID (or press Enter to generate a new one):");
        String userUuid = scanner.nextLine();
        if (userUuid.isEmpty()) {
            userUuid = service.generateUserUuid();
            System.out.println("Generated UUID: " + userUuid);
        }

        while (true) {
            System.out.println("\n1. Create short link");
            System.out.println("2. Access short link");
            System.out.println("3. Delete short link");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter original URL: ");
                    String originalUrl = scanner.nextLine();
                    System.out.print("Enter max clicks: ");
                    int maxClicks = scanner.nextInt();
                    System.out.print("Enter expiration hours: ");
                    int expirationHours = scanner.nextInt();
                    ShortLink link = service.createShortLink(originalUrl, userUuid, maxClicks, expirationHours);
                    System.out.println("Short link created: " + link);
                }
                case 2 -> {
                    System.out.print("Enter short URL: ");
                    String shortUrl = scanner.nextLine();
                    String result = service.getOriginalUrl(shortUrl);
                    System.out.println("Result: " + result);
                }
                case 3 -> {
                    System.out.print("Enter short URL: ");
                    String shortUrl = scanner.nextLine();
                    String result = service.deleteShortLink(shortUrl, userUuid);
                    System.out.println(result);
                }
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}