import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("введите арифметическое выражение:");
        Scanner scan = new Scanner(System.in);
        String sc = scan.nextLine();
        System.out.println(calc(sc));
    }

    public static String calc(String input) throws Exception {
        String[] sca = input.split(" ");
        String op = sca[1];
        int res;
        if (sca.length == 3){
        } else {
            throw new Exception("т.к.формат математической операции не удовлетворяет заданию (два опаранда и один оператор)");
        }
        if (sca[0].matches(Arrays.toString(roman)) && !sca[2].matches(Arrays.toString(roman)) || !sca[0].matches(Arrays.toString(roman)) && sca[2].matches(Arrays.toString(roman))) {
            throw new Exception("Числа не принадлежат одной системе счисления");
        }
        if (sca[0].matches(Arrays.toString(roman)) && sca[2].matches(Arrays.toString(roman))) {
            int m = Roman(sca[0]);
            int n = Roman(sca[2]);
            res = calculat(m, op, n);
            if (res > 0) {
                return arabToRoman(res);
            }
            throw new Exception("т.к. в римской системе нет отрицательных чисел");
        }
        int a = Integer.parseInt(sca[0]);
        int b = Integer.parseInt(sca[2]);
        if (a < 1 | a > 10 | b < 1 | b > 10) {
            throw new Exception("неправильный диапазон");
        }
        res = calculat(a, op, b);
        return Integer.toString(res);
    }

    private static int calculat(int x, String op, int y) throws Exception {
        return switch (op) {
            case "+" -> x + y;
            case "-" -> x - y;
            case "*" -> x * y;
            case "/" -> x / y;
            default -> throw new Exception("неправильный оператор");
        };

    }

    static int Roman(String e) {
        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        return Arrays.asList(roman).indexOf(e) + 1;
    }

    static String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

    static String arabToRoman(int a) {
        String[] roman = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] arab = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String result = "";
        while (a > 0) {
            for (int i = 0; i < arab.length; i++) {
                while (a >= arab[i]) {
                    result += roman[i];
                    a -= arab[i];
                }
            }
        }
        return result;
    }
}
