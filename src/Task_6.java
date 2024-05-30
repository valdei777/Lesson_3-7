import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;

public class Task_6 {
    public static void main(String[] args) {
        // 6.Реализуйте метод, который выводит explanation сегодняшнего снимка дня NASA


        LocalDate date = LocalDate.now();

        String explanation = getExplanation(date);

        System.out.println(explanation);
    }

    private static String getExplanation(LocalDate date) {
        String page = downloadPage("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&date=" + date);

        int startIndexExplanation = page.indexOf("explanation") + 14;
        int endIndexExplanation = page.indexOf("hdurl") - 3;

        return page.substring(startIndexExplanation, endIndexExplanation);
    }


    public static String downloadPage(String url) {
        StringBuilder page = new StringBuilder();
        String line;


        try {
            URLConnection connection = new URL(url).openConnection();
            try (InputStream is = connection.getInputStream();
                 BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                while ((line = br.readLine()) != null) {
                    page.append(line);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return page.toString();
    }


}
