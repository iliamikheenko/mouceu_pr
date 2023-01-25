package lazy_evaluation;

import java.util.function.Supplier;

public class Lazy<T> {
    private T instance;
    private Supplier<T> supplier;
    public Lazy(Supplier<T> supplier) {
        this.supplier = supplier;
    }
    public T get() {
        if (instance== null) instance = supplier.get();
        return instance;
    }

    public static int compute(int num){
        System.out.println("Compute started...");
        return num*100;
    }
    public static void main(String[] args) {
        int value = 5;
        Lazy<Integer> temp = new Lazy<>(() -> compute(value));

        if (value > 5 && temp.get() > 100) {
            System.out.println("First way: " + temp.get());
        } else {
            System.out.println("Second way");
        }
    }
}


