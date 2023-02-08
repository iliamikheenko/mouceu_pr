package lazy_evaluation;
public class LazyEvaluation1 {
    public static int compute(int number){
        System.out.println("Compute started...");
        return number*1000;
    }

    public static void main(String[] args) {
        int value = 5;
        int temp = compute(value);

        if (value > 5 && temp > 100) {
            System.out.println("First way: " + temp);
        } else {
            System.out.println("Second way");
        }
    }
}
