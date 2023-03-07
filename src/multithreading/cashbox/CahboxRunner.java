package multithreading.cashbox;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

public class CahboxRunner {
    public static void main(String[] args) {
        Queue<Cashbox> cashboxes = new ArrayDeque<>(List.of(new Cashbox(), new Cashbox()));
        List<Thread> threads = Stream.of(new BuyerThread(cashboxes),
                        new BuyerThread(cashboxes),
                        new BuyerThread(cashboxes),
                        new BuyerThread(cashboxes),
                        new BuyerThread(cashboxes),
                        new BuyerThread(cashboxes),
                        new BuyerThread(cashboxes),
                        new BuyerThread(cashboxes),
                        new BuyerThread(cashboxes),
                        new BuyerThread(cashboxes),
                        new BuyerThread(cashboxes),
                        new BuyerThread(cashboxes),
                        new BuyerThread(cashboxes))
                .map(Thread::new)
                .peek(Thread::start)
                .toList();
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();            }
        }
    }
}
