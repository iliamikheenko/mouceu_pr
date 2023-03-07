package multithreading.deadlock;

public class AccountRunner {

    public static void main(String[] args) throws InterruptedException {
        var account1 = new Account(20000);
        var account2 = new Account(20000);
        var accountThread1 = new AccountThread(account1, account2);
        var accountThread2 = new AccountThread(account2, account1);

        accountThread1.start();
        accountThread2.start();

        accountThread1.join();
        accountThread2.join();

        System.out.println(account1);
        System.out.println(account2);

    }
}
