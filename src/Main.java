import java.io.IOException;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws IOException {
        String filename = "src/user.csv";
        FileAccountManager accountManager = new FileAccountManager(filename);
        Account a = new Account("Денис Емельянов", "01.11.2001", "de2001@mail.ru", "12345", false);
        Account b = new Account("Игнатович Игорь", "01.12.2001", "ii2001@mail.ru", "54321", false);

        try {
            accountManager.register(a);
        } catch (AccountAlreadyExistsException except) {
            System.out.println(except.getMessage());
        }

        try {
            accountManager.register(b);
        } catch (AccountAlreadyExistsException except) {
            System.out.println(except.getMessage());
        }

        try {
            accountManager.register(a);
        } catch (AccountAlreadyExistsException except) {
            System.out.println(except.getMessage());
        }

        try {
            accountManager.login(a.getEmail(), "123");
        } catch (AccountBlockedException | WrongCredentialsException except) {
            System.out.println(except.getMessage());
        }

        try {
            accountManager.login(b.getEmail(), "543");
        } catch (AccountBlockedException | WrongCredentialsException except) {
            System.out.println(except.getMessage());
        }

        try {
            accountManager.login(a.getEmail(), "123");
        } catch (AccountBlockedException | WrongCredentialsException except) {
            System.out.println(except.getMessage());
        }

        try {
            accountManager.login(a.getEmail(), "123");
        } catch (AccountBlockedException | WrongCredentialsException except) {
            System.out.println(except.getMessage());
        }

        try {
            accountManager.login(a.getEmail(), "123");
        } catch (AccountBlockedException | WrongCredentialsException except) {
            System.out.println(except.getMessage());
        }

        try {
            accountManager.login(a.getEmail(), "123");
        } catch (AccountBlockedException | WrongCredentialsException except) {
            System.out.println(except.getMessage());
        }

        try {
            accountManager.login(a.getEmail(), a.getPassword());
        } catch (AccountBlockedException | WrongCredentialsException except) {
            System.out.println(except.getMessage());
        }

        try {
            accountManager.login(b.getEmail(), "543");
        } catch (AccountBlockedException | WrongCredentialsException except) {
            System.out.println(except.getMessage());
        }

        try {
            accountManager.login(b.getEmail(), b.getPassword());
        } catch (AccountBlockedException | WrongCredentialsException except) {
            System.out.println(except.getMessage());
        }

        try {
            accountManager.login(b.getEmail(), "543");
        } catch (AccountBlockedException | WrongCredentialsException except) {
            System.out.println(except.getMessage());
        }

        try {
            accountManager.login(b.getEmail(), "543");
        } catch (AccountBlockedException | WrongCredentialsException except) {
            System.out.println(except.getMessage());
        }

        try {
            accountManager.login(b.getEmail(), "543");
        } catch (AccountBlockedException | WrongCredentialsException except) {
            System.out.println(except.getMessage());
        }

        try {
            accountManager.login(b.getEmail(), "543");
        } catch (AccountBlockedException | WrongCredentialsException except) {
            System.out.println(except.getMessage());
        }

        try {
            accountManager.login(b.getEmail(), b.getPassword());
        } catch (AccountBlockedException | WrongCredentialsException except) {
            System.out.println(except.getMessage());
        }

        try {
            accountManager.removeAccount(a.getEmail(), a.getPassword());
        } catch (WrongCredentialsException except) {
            System.out.println(except.getMessage());
        }

        try {
            accountManager.removeAccount(b.getEmail(), "654");
        } catch (WrongCredentialsException except) {
            System.out.println(except.getMessage());
        }

        try {
            accountManager.removeAccount(b.getEmail(), b.getPassword());
        } catch (WrongCredentialsException except) {
            System.out.println(except.getMessage());
        }

    }
}