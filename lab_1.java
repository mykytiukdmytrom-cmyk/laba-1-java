import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;

/**
 * Лабораторна робота. Варіант 1.
 * Вираз: a + (a + b - 1) / (a^2 + 2) - (a*b)^3
 */
public class lab_1 {

    // Варіант 1: вхідні дані — дійсні, результат — дійсний
    static double calcDoubleToDouble(double a, double b) {
        return a + (a + b - 1) / (a * a + 2) - Math.pow(a * b, 3);
    }

    // Варіант 2: вхідні дані — цілі, результат — дійсний
    static double calcIntToDouble(int a, int b) {
        // перетворюємо на double, щоб уникнути цілочисельного ділення
        double numerator = a + b - 1;
        double denominator = (double) a * a + 2;
        return a + numerator / denominator - Math.pow((double) a * b, 3);
    }

    // Варіант 3: вхідні дані — дійсні, результат — цілий
    static int calcDoubleToInt(double a, double b) {
        double result = a + (a + b - 1) / (a * a + 2) - Math.pow(a * b, 3);
        return (int) result; // відкидання дробової частини
    }

    static void setupUtf8Console() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                new ProcessBuilder("cmd", "/c", "chcp 65001 > nul")
                        .inheritIO().start().waitFor();
            }
        } catch (Exception ignored) {
            // якщо не вдалося — продовжуємо без змін
        }
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
    }

    public static void main(String[] args) {
        setupUtf8Console();
        Scanner sc = new Scanner(System.in).useLocale(Locale.US); // дробові числа через крапку

        //Варіант 1
        System.out.println("Варіант 1: дійсні -> дійсний");
        System.out.print("Введіть a: ");
        double a1 = sc.nextDouble();
        System.out.print("Введіть b: ");
        double b1 = sc.nextDouble();
        System.out.println("Результат = " + calcDoubleToDouble(a1, b1));

        //Варіант 2
        System.out.println("\nВаріант 2: цілі -> дійсний");
        System.out.print("Введіть a (ціле): ");
        int a2 = sc.nextInt();
        System.out.print("Введіть b (ціле): ");
        int b2 = sc.nextInt();
        System.out.println("Результат = " + calcIntToDouble(a2, b2));

        //Варіант 3
        System.out.println("\nВаріант 3: дійсні -> цілий");
        System.out.print("Введіть a: ");
        double a3 = sc.nextDouble();
        System.out.print("Введіть b: ");
        double b3 = sc.nextDouble();
        System.out.println("Результат = " + calcDoubleToInt(a3, b3));

        sc.close();
    }
}