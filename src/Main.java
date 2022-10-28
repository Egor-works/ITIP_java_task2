import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        System.out.println("№ 1 " + repeat("mice", 5));
        System.out.println("№ 2 " + differenceMaxMin(new int[]{10, 4, 1, 4, -10, -50, 32, 21}));
        System.out.println("№ 3 " + isAvgWhole(new int[]{1, 3}));
        System.out.println("№ 4 " + Arrays.toString(cumulativeSum(new int[]{1, 2, 3})));
        System.out.println("№ 5 " + getDecimalPlaces("43.20"));
        System.out.println("№ 6 " + Fibonacci(3));
        System.out.println("№ 7 " + isValid("59001"));
        System.out.println("№ 8 " + isStrandingPair("ratio", "orator"));
        System.out.println("№ 9 " + "isPrefix: " + isPrefix("automation", "auto-") + "\n" + "    " + "isSuffix: " + isSuffix("arachnophobia", "-phobia"));
        System.out.println("№ 10 " + boxSeq(0));
    }
    /** Функция, повторяющая каждый символ в строке заданное количество раз **/
    public static String repeat(String string, int count) {
        StringBuilder str = new StringBuilder();
        for (char chr : string.toCharArray()) {
            str.append(String.valueOf(chr).repeat(count));
        }
        return str.toString();
    }

    /** Функция, принимающая массив и возвращающая разницу между самым большим и самым маленьким числами**/
    public static int differenceMaxMin(int[] array) {
        return Arrays.stream(array).max().getAsInt() - Arrays.stream(array).min().getAsInt();
    }

    /** Функция, принимающая массив и возвращающая является ли среднее значение всех элементов целым **/
    public static boolean isAvgWhole(int[] array) {
        return Arrays.stream(array).sum() % array.length == 0;
    }

    /** Метод принимающий массив целых чисел и возвращающий массив в котором каждое целое число является суммой самого себя и всех предыдущих чисел **/
    public static int[] cumulativeSum(int[] array) {
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = 0; j <= i ; j++) {
                sum += array[j];
            }
            newArray[i] = sum;
        }
        return newArray;
    }

    /** Функция, возвращающая число десятичных знаков, которое имеет число, заданное в виде строки **/
    public static int getDecimalPlaces(String decimal) {
        if (decimal.indexOf('.') != -1) {
            return decimal.length() - 1 - decimal.indexOf('.');
        }
        else return 0;
    }

    /** Функция, при заданном числе, возвращающий соответствующее число Фибоначчи**/
    public static int Fibonacci(int number) {
        if (number == 0) return 1;
        else if (number == 1) return 1;
        else return Fibonacci(number - 1) + Fibonacci(number - 2);
    }

    /** Функция, определябщая является ли введённая строка почтовым индексом **/
    public static boolean isValid(String address) {
        try {
            Integer.parseInt(address);
            return address.length() == 5;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    /** Функция, определяющая образуют ли две введённые строки странную пару **/
    public static boolean isStrandingPair(String first, String second) {
        return first.charAt(0) == second.charAt(second.length() - 1) && first.charAt(first.length() - 1) == second.charAt(0);
    }

    /** Функция, определяющая начинается ли строка назаданный префикс **/
    public static boolean isPrefix(String word, String prefix) {
        return word.startsWith(prefix.substring(0, prefix.indexOf('-')));
    }
    /** Функция, определяющая заканчивается ли строка назаданный суффикс **/
    public static boolean isSuffix(String word, String suffix) {
        return word.endsWith(suffix.substring(1));
    }

     /** Функция, принимающая шаг и возвращающая количество полей на этом шаге последовательности **/
     public static int boxSeq(int step) {
         if (step == 1) return 3;
         else if (step % 2 == 1) return boxSeq(step - 1) + 3;
         else if (step % 2 == 0 && step > 0) return boxSeq(step - 1) - 1;
         else return 0;

     }
}