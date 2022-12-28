import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class FileAccountManager implements AccountManager {
    final ArrayList<Account> group;
    final String filename;

    public FileAccountManager(String str) throws IOException {
        this.filename = str;
        this.group = FileService.readCSV(this.filename);
    }

    public void register(Account account) throws IOException {
        Iterator groupIter = this.group.iterator();

        Account i;
        do {
            if (!groupIter.hasNext()) {
                System.out.println(account.getEmail() + " вы успешно зарегистрированы");
                this.group.add(account);
                FileService.writeCSV(this.filename, this.group);
                return;
            }

            i = (Account)groupIter.next();
        } while(!i.getEmail().equals(account.getEmail()));

        throw new AccountAlreadyExistsException("Пользователь уже зарегистрирован на  почту ", account.getEmail());
    }

    public Account login(String email, String password) throws AccountBlockedException, WrongCredentialsException {
        Iterator groupIter = this.group.iterator();

        Account i;
        do {
            if (!groupIter.hasNext()) {
                throw new WrongCredentialsException("Пользователя с таким логином или паролем не существует ", email, password);
            }

            i = (Account)groupIter.next();
            if (i.getEmail().equals(email) && i.getPassword().equals(password)) {
                if (i.isBlocked()) {
                    throw new AccountBlockedException("Ошибка, Ваш аккаунт заблокирован ", i.getEmail());
                }

                FailedLoginCounter.clean(i);
                System.out.println(i.getEmail() + " вход выполнен успешно.");
                return i;
            }
        } while(!i.getEmail().equals(email) && !i.getPassword().equals(password));

        FailedLoginCounter.countFaildLogin(i);
        if (!i.isBlocked()) {
            throw new WrongCredentialsException("Неверный логин или пароль ", email, password);
        } else {
            throw new WrongCredentialsException("Ошибка, Ваш аккаунт заблокирован ", email, password);
        }
    }

    public void removeAccount(String email, String password) throws WrongCredentialsException {
        boolean isExist = false;
        Iterator groupIter = this.group.iterator();

        while(groupIter.hasNext()) {
            Account i = (Account)groupIter.next();
            if (i.getEmail().equals(email) && i.getPassword().equals(password)) {
                System.out.println(i.getEmail() + " Аккаунт удален.");
                this.group.remove(i);
                isExist = true;

                try {
                    FileService.writeCSV("src/user.csv", this.group);
                } catch (IOException var7) {
                    var7.printStackTrace();
                }
                break;
            }
        }

        if (!isExist) {
            throw new WrongCredentialsException("Невозможно удлить пользователя", email, password);
        }
    }
}