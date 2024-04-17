import java.util.ArrayList;
import java.util.List;

public class main {
    public static long power(int x, int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result = Math.multiplyExact(x, result);
        }
        return result;
    }

    public static List<int[]> calcTriples(int max, int power) {
        List<int[]> result = new ArrayList<>();
        for (int a = 1; a <= max; a++) {
            for (int b = 1; b <= max; b++) {
                for (int c = Math.max(a, b) + 1; c <= max; c++) {
                    try {
                        long abPwr = power(a, power) + power(b, power);
                        long cPwr = power(c, power);
                        if (abPwr == cPwr) {
                            result.add(new int[] { a, b, c });
                        }
                        if (abPwr <= cPwr) {
                            break;
                        }
                    } catch (ArithmeticException e) {
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<int[]> result = calcTriples(5000, 3);
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        System.out.println(result.size());
        System.out.println("Rechenzeit: " + time + "ms");
    }
}