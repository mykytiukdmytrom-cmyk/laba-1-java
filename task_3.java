import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

// Завдання 11 (матриця). Задана матриця A(n, n), n <= 20.
// Знайти найменше значення серед елементів стовпчика,
// сума модулів елементів якого є найбільшою.
// Якщо таких стовпців декілька, взяти перший з них.
// Клас без public, тому назва файлу не впливає на компіляцію.
class task_3 {

    public static void main(String[] args) {
        // Налаштування консолі Windows на UTF-8
        try {
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                new ProcessBuilder("cmd", "/c", "chcp 65001 > nul").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            // ігноруємо
        }
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        Scanner sc = new Scanner(System.in);

        // Введення розміру матриці
        int n;
        do {
            System.out.print("Введіть розмір матриці n (1-20): ");
            n = sc.nextInt();
        } while (n < 1 || n > 20);

        // Введення елементів матриці
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("A[" + i + "][" + j + "] = ");
                a[i][j] = sc.nextInt();
            }
        }

        // Виведення матриці
        System.out.println("\nМатриця A:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%6d", a[i][j]);
            }
            System.out.println();
        }

        // Пошук стовпчика з найбільшою сумою модулів (перший при рівності)
        int bestCol = 0;
        long maxSum = -1;
        for (int j = 0; j < n; j++) {
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += Math.abs(a[i][j]);
            }
            System.out.println("Сума модулів стовпчика " + j + " = " + sum);
            if (sum > maxSum) { // строге порівняння: беремо перший
                maxSum = sum;
                bestCol = j;
            }
        }

        // Пошук найменшого елемента у знайденому стовпчику
        int min = a[0][bestCol];
        for (int i = 1; i < n; i++) {
            if (a[i][bestCol] < min) {
                min = a[i][bestCol];
            }
        }

        System.out.println("\nСтовпчик з найбільшою сумою модулів: " + bestCol
                + " (сума = " + maxSum + ")");
        System.out.println("Найменше значення в цьому стовпчику = " + min);
    }
}
