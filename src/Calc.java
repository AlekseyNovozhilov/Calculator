import java.util.Scanner;

public class Calc {

    private static String[] chars;
    private static char operation;
    private static int number1, number2;
    private static int result;
    private static boolean greekOrRoman;
    private static Convert convert;


    public static void main(String[] args) throws Exception {

        convert = new Convert();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение используя арабские или римские числа от 1 до 10");
        System.out.println("Вводить данные нужно через пробел.");
        System.out.println("Пример: 2 * 4 или II + IV");
        String userInput = scanner.nextLine();
        System.out.println("Ответ: " + calc(userInput));
    }



    public static String calc (String input) throws Exception {

        chars = input.split(" ");

        if (chars.length != 3) throw new Exception("Выражение введено некорректно.");

        if (convert.isRoman(chars[0]) && convert.isRoman(chars[2])) {
            greekOrRoman = true;
            number1 = convert.returnNumber(chars[0]);
            number2 = convert.returnNumber(chars[2]);
            examinationLessOrMoreTen();
        } else if (!convert.isRoman(chars[0]) && !convert.isRoman(chars[2])) {
            greekOrRoman = false;
            number1 = convertStringToInteger(chars[0]);
            number2 = convertStringToInteger(chars[2]);
            examinationLessOrMoreTen();
        } else {
            throw new Exception("Нужно вводить только числа одного типа");
        }

        char x = chars[1].charAt(0);
        if (x == '+') {
            operation = '+';
        } else if (x == '-') {
            operation = '-';
        } else if (x == '*') {
            operation = '*';
        } else if (x == '/') {
            operation = '/';
        } else {
            throw new Exception("Не верная арифмитическая операция");
        }

        if (number2 > 0) {
            switch (operation) {
                case '+':
                    result = number1 + number2;
                    break;
                case '-':
                    result = number1 - number2;
                    break;
                case '*':
                    result = number1 * number2;
                    break;
                case '/':
                    result = number1 / number2;
            }
        } else {
            throw new Exception("Делить на 0 нельзя!");
        }

        if (!greekOrRoman) {
            return String.valueOf(result);
        } else if (result == 10 ||
                result == 20 ||
                result == 30 ||
                result == 40 ||
                result == 50 ||
                result == 60 ||
                result == 70 ||
                result == 80 ||
                result == 90 ||
                result == 100) {
            return convert.getKeysByValue(result);
        } else if (result > 10) {
            int num = result;
            int[] digits = Integer.toString(num).chars().map(c -> c - '0').toArray();
            int y = digits[0] * 10;
            return (convert.getKeysByValue(y) + "" + convert.getKeysByValue(digits[1]));
        } else if (result > 0) {
            return convert.getKeysByValue(result);
        } else {
            throw new Exception("Результат вычисления римских чисел не может быть отрицательным или 0.");
        }
    }

    public static Integer convertStringToInteger(String value) {
        int number;
        number = Integer.parseInt(value);
        return number;
    }

    public static void examinationLessOrMoreTen() throws Exception {
        if (number1 < 0 || number1 > 10 || number2 < 0 || number2 > 10) {
            throw new Exception("Число должно быть положительным и не больше 10.");
        }
    }
}
