package lazy_evaluation;

public class LazyEvaluation {
    public static int compute(int number){
        System.out.println("Compute started...");
        return number*100;
    }






    public static void main(String[] args) {
        int value = 5;


        if (value > 5 && compute(value) > 100) {
            System.out.println("First way :" + compute(value));
        } else {
            System.out.println("Second way");
        }
    }
}
