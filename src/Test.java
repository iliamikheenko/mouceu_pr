import java.util.List;
import java.util.function.Predicate;

public class Test {
    public static int totalValueWithoutPredicate(List<Integer> numbers){
        int sum = 0;
        for (Integer num: numbers) {
            sum += num;
        }
        return sum;
    }
    public static int totalEvenValueWithoutPredicate(List<Integer> numbers){
        int sum = 0;
        for (Integer num: numbers) {
            if (num %2 == 0) sum += num;
        }
        return sum;
    }
    public static int totalOddValueWithoutPredicate(List<Integer> numbers){
        int sum = 0;
        for (Integer num: numbers) {
            if (num %2 != 0) sum += num;
        }
        return sum;
    }
    public static int totalValueWithPredicate(List<Integer> numbers, Predicate<Integer> selector){
        int sum = 0;
        for (Integer num: numbers) {
            if (selector.test(num)) sum += num;
        }
        return sum;
    }
    public static boolean isOdd(int number){
        return number%2 != 0;
    }
    public static boolean isEven(int number){
        return number%2 == 0;
    }

    public static int totalValue(List<Integer> numbers, Predicate<Integer> selector){
        return numbers.stream()
                .filter(selector)
                .mapToInt(e -> e)
                .sum();
    }



    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(totalValueWithoutPredicate(numbers));
        System.out.println(totalEvenValueWithoutPredicate(numbers));
        System.out.println(totalOddValueWithoutPredicate(numbers));
        System.out.println("______________");
        System.out.println(totalValueWithPredicate(numbers, ignore -> true));
        System.out.println(totalValueWithPredicate(numbers, number -> number%2 == 0));
        System.out.println(totalValueWithPredicate(numbers, number -> number%2 != 0));
        System.out.println("______________");
        System.out.println(totalValueWithPredicate(numbers, ignore -> true));
        System.out.println(totalValueWithPredicate(numbers, TotalValue::isEven));
        System.out.println(totalValueWithPredicate(numbers, TotalValue::isOdd));
        System.out.println("______________");
        System.out.println(totalValue(numbers, ignore -> true));
        System.out.println(totalValue(numbers, TotalValue::isEven));
        System.out.println(totalValue(numbers, TotalValue::isOdd));
    }
}
