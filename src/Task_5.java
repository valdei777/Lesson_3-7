import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Task_5 {
    public static void main(String[] args) {
        // 5.Реализуйте метод, который возвращает случайную цитату Уолтера Уайта.
        System.out.println(getQuote());
    }


    public static String downloadPage(String url) {
        StringBuilder result = new StringBuilder();
        String line;
        try {
            URLConnection connection = new URL(url).openConnection();
            connection.addRequestProperty("User-Agent", "Mozilla");
            connection.setConnectTimeout(500);
            try (InputStream is = connection.getInputStream();
                 BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                while ((line = br.readLine()) != null) {
                    result.append(line);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result.toString();
    }


    public static String getQuote (){
        String result = "";
        String author ="";
        while (! "Walter White".equals(author)) {
            String page = downloadPage("https://api.breakingbadquotes.xyz/v1/quotes");
            int startIndex = page.lastIndexOf("quote");
            int endIndex = page.indexOf("author");
            result = page.substring(startIndex + 8, endIndex - 3);

            int startAuthor = page.lastIndexOf("author");
            int endAuthor = page.lastIndexOf("}");
            author = page.substring(startAuthor + 9, endAuthor - 1);
        }
        return result;
    }
}
