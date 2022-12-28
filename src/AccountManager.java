import java.io.IOException;

public interface AccountManager {
    void register(Account var1) throws IOException;

    Account login(String var1, String var2) throws AccountBlockedException, WrongCredentialsException;

    void removeAccount(String var1, String var2) throws WrongCredentialsException;
}