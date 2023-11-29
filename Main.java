import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        List <String> roman = Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");
        if (sca.length == 3) {
        } else {
            throw new Exception("т.к.формат математической операции не удовлетворяет заданию (два опаранда и один оператор)");
        }
        if (roman.contains(sca[0]) && !roman.contains(sca[2]) || !roman.contains(sca[0]) && roman.contains(sca[2])) {
            throw new Exception("Числа не принадлежат одной системе счисления");
        }
        if (roman.contains(sca[0]) && roman.contains(sca[2])) {
            int m = Roman(sca[0]);
            int n = Roman(sca[2]);
            res = calculator(m, op, n);
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
        res = calculator(a, op, b);
        return Integer.toString(res);
    }

    private static int calculator(int x, String op, int y) throws Exception {
        int res = switch (op) {
            case "+" -> x + y;
            case "-" -> x - y;
            case "*" -> x * y;
            case "/" -> x / y;
            default -> throw new Exception("неправильный оператор");
        };
        return res;
    }

    static int Roman(String e) {
        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        int f = Arrays.asList(roman).indexOf(e);
        int a = f + 1;
        return a;
    }


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
