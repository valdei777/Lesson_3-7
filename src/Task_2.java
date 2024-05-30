public class Task_2 {
    public static void main(String[] args) {
        // 2.Реализуйте метод, который из двух массивов строк собирает третий, в котором чередуются элементы первых двух
        String[] mas0 = {"0-0", "0-1", "0-2", "0-3", "0-4", "0-5", "0-6", "0-7", "0-8", "0-9"};
        String[] mas1 = {"1-0", "1-1", "1-2", "1-3", "1-4", "1-5", "1-6", "1-7", "1-8", "1-9"};

        String[] mas2 = countMas(mas0, mas1);

        for(String i : mas2) {
            System.out.println(i);
        }
    }

    public static String[] countMas(String[] mas0, String[] mas1) {
        String[] mas2 = new String[mas0.length + mas1.length];

        int i = 0;
        int j = 0;
        while(i < mas0.length) {
            mas2[j++] = mas0[i];
            mas2[j++] = mas1[i];
            i++;
        }

        return mas2;
    }
}
