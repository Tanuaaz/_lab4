import java.util.HashMap;

public class FailedLoginCounter {
    private static FailedLoginCounter instance;
    private static HashMap<Account, Integer> counter = new HashMap();

    public FailedLoginCounter() {
    }

    public static synchronized FailedLoginCounter getInstance() {
        if (instance == null) {
            instance = new FailedLoginCounter();
        }

        return instance;
    }

    public static void countFaildLogin(Account account) {
        if (!counter.containsKey(account)) {
            counter.put(account, 0);
        }

        counter.put(account, (Integer)counter.get(account) + 1);
        if ((Integer)counter.get(account) > 4) {
            account.setBlock();
        }

    }

    public static void clean(Account account) {
        counter.put(account, 0);
    }
}
