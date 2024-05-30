import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {
        // 3.Возьмите любую программу, которую вы писали до этого.. какая сердцу ближе. Отрефакторите ее
        //   (улучшите читабельность кода) -путем разбиения крупных частей на методы поменьше. Стало лучше? (надеюсь, да)

        // 1-6(3 задача)
        // Пользователь вводит четыре числа. Найти наибольшее из них.

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите четыре числа: ");

        System.out.println(Math.max(Math.max(scanner.nextInt(), scanner.nextInt()), Math.max(scanner.nextInt(), scanner.nextInt())));


    }

}

