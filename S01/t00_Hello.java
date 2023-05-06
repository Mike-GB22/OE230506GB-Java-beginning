import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class t00_Hello {
    public static void main(String[] args) {
        System.out.println("Hello, World");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
        System.out.println(formatter.format(now));
    }
}