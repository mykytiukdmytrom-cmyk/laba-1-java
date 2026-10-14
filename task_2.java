import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

// Завдання 11. Сума об'єднання масивів A(n), n <= 500 і B(m), m <= 200.
// Клас без public, тому назва файлу не впливає на компіляцію.
class hui {

    public static void main(String[] args) {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                new ProcessBuilder("cmd", "/c", "chcp 65001 > nul").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
        }
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        Scanner sc = new Scanner(System.in);

        // Введення масиву A
        int n;
        do {
            System.out.print("Введіть розмір масиву A (1-500): ");
            n = sc.nextInt();
        } while (n < 1 || n > 500);

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("A[" + i + "] = ");
            a[i] = sc.nextInt();
        }

        // Введення масиву B
        int m;
        do {
            System.out.print("Введіть розмір масиву B (1-200): ");
            m = sc.nextInt();
        } while (m < 1 || m > 200);

        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            System.out.print("B[" + i + "] = ");
            b[i] = sc.nextInt();
        }

        // Формуємо об'єднання: кожен елемент по одному разу
        ArrayList<Integer> union = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!union.contains(a[i])) {
                union.add(a[i]);
            }
        }
        for (int i = 0; i < m; i++) {
            if (!union.contains(b[i])) {
                union.add(b[i]);
            }
        }

        // Виведення елементів та суми
        long sum = 0;
        System.out.print("Елементи об'єднання: ");
        for (int x : union) {
            System.out.print(x + " ");
            sum += x;
        }
        System.out.println();
        System.out.println("Сума елементів об'єднання = " + sum);
    }
}