import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Task_4 {
    public static void main(String[] args) {
        // 4.Отрефакторите(улучшите читабельность) кода вашей реализации анализа курса валют.

        // http://www.cbr.ru/scripts/XML_dynamic.asp?date_req1=02/03/2001&date_req2=14/03/2001&VAL_NM_RQ=R01235

        for(int y = 1994; y <=2024; y++) {
            String url;
            String page = "";
            int j = 2;
            while (! page.contains("<Value>")) {
                String d;
                if (j < 10) {
                    d = "0" + j;
                } else {
                    d = String.valueOf(j);
                }
                url = getUrl(d, String.valueOf(y));
                page = downloadPage(url);
                j++;
            }
            System.out.println(parserPage(page));
        }
    }


    public static String getUrl(String day, String year) {

        String url = "http://www.cbr.ru/scripts/XML_dynamic.asp?date_req1=" + day + "/02/" + year + "2023&date_req2=" + day + "/02/" + year + "&VAL_NM_RQ=R01235";

        return url;
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

    public static String parserPage (String page) {
        int valueStart = page.indexOf("<Value>") + 7;
        int valueEnd = page.indexOf("</Value>");
        String courseStr = page.substring(valueStart, valueEnd);
        String result = courseStr.replace(",", ".");

        return result;
    }
}
