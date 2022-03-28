import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final Map<String, String> accountToSum;
    private final Map<String, String> sumToAccount;

    {
        accountToSum = new HashMap<>();
        accountToSum.put("acc1", "100");
        accountToSum.put("acc2", "200");
        accountToSum.put("acc3", "300");

        sumToAccount = new HashMap<>();
        sumToAccount.put("100", "acc1");
        sumToAccount.put("200", "acc2");
        sumToAccount.put("300", "acc3");
    }

    public String findAccount(String sum) {
        return sumToAccount.getOrDefault(sum, "account not found");
    }

    public String findSum(String account) {
        return accountToSum.getOrDefault(account, "sum not found");
    }
}
