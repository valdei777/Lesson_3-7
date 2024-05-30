import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_8 {
    public static void main(String[] args) {
        // 8.Реализуйте метод, который принимает два LocalDate, и сохраняет все снимки дня NASA в указанный промежуток

        // 2022 05 20
        // 2022 05 23

        System.out.println("Введите дату (yyyy mm dd) с которой вы хотите получить описание снимка");
        Scanner scanner = new Scanner(System.in);

        List dates = getDatesFromInterval(LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()),
                LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));

        for(Object x : dates) {
            System.out.println(getExplanation(x));
        }

    }

    public static List<LocalDate> getDatesFromInterval (LocalDate dateFrom, LocalDate dateTill) {
        return dateFrom.datesUntil(dateTill.plusDays(1)).collect(Collectors.toList());
    }


    private static String getExplanation(Object date) {
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
