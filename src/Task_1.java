import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        // 1.Реализуйте метод, который находит из трех чисел то, которое делится на 2 остальных; или возвращает -1, если такого нет
        int x, y, z, c;
        System.out.println("Введите три числа: ");
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt();
        y = scanner.nextInt();
        z = scanner.nextInt();


        if ((c = method(x, y, z)) != -1) {
            System.out.println(c);
        } else {
            System.out.println("Ни одно введёное число не делится на два других!!!");
        }





    }
    public static int method(int x, int y, int z) {
        if(delitel(x, y) != -1) {
            if(delitel(x, z) != -1) {
                return x;
            }
        } else if (delitel(y, x) != -1) {
            if (delitel(y, z) != -1) {
                return y;
            }
        } else if (delitel(z, x) != -1) {
            if (delitel(z, y) != -1) {
                return z;
            }
        }

        return -1;
    }

    public static int delitel(int x, int y) {
        if(x % y == 0) {
            return x;
        } else {
            return  -1;
        }
    }
}
