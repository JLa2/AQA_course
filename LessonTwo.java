public class LessonTwo {
    // Задание 1.

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");

    }

    // Задание 2.
    public static void checkSumSign() {
        int a = 4;
        int b = 6;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }

    }

    // Задание 3.
    public static void printColor() {
        int value = 89;
        if (value < 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Жёлтый");
        } else if (value > 100) {
            System.out.println("Зелёный");
        }
    }

    // Задание 4.
    public static void compareNumbers() {
        int a = 10;
        int b = 17;
        if (a >= b) {
            System.out.println("a>=b");
        } else {
            System.out.println("a<b");
        }

    }

    // Задание 5.
    public static boolean checkRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    // Задание 6.
    public static void printSign(int a) {
        if (a >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }

    // Задание 7.
    public static boolean isNegative(int a) {
        return a < 0;
    }

    // Задание 8.
    public static void repeatString(String text, int count) {
        for (int i = 0; i < count; i++) {
            System.err.println(text);
        }
    }

    // Задание 9.
    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    // Задание 10.
    public static void replaceValues() {
        int[] arr = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        System.out.println("arr.length:" + arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(java.util.Arrays.toString(arr));
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }

        }
    }

    // Задание 11.
    public static void fillArray() {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        System.out.println(java.util.Arrays.toString(arr));
    }

    // Задание 12.
    public static void multiplyIfLessThanSix() {
        int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println("arr.length:" + arr.length);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
        System.out.println(java.util.Arrays.toString(arr));
    }

    // Задание 13.
    public static void fillDiagonal() {
        int[][] matrix = new int[5][5];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = 1;
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(java.util.Arrays.toString(matrix[i]));
        }
    }

    // Задание 14.
    public static int[] createFilledArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;

    }

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(checkRange(10, 5));
        printSign(5);
        printSign(-3);
        System.out.println(isNegative(9));
        repeatString("Java", 3);
        System.out.println(isLeapYear(2020));
        replaceValues();
        fillArray();
        multiplyIfLessThanSix();
        fillDiagonal();
        System.out.println(java.util.Arrays.toString(createFilledArray(5, 7)));
    }
}