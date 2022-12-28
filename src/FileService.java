import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class FileService {
    private static FileService instance;

    public FileService() {
    }

    public static synchronized FileService getInstance() {
        if (instance == null) {
            instance = new FileService();
        }

        return instance;
    }

    public static ArrayList<Account> readCSV(String filename) throws IOException {
        ArrayList<Account> group = new ArrayList();
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(filename));
            boolean checkFirstLine = true;

            while((line = reader.readLine()) != null) {
                if (checkFirstLine) {
                    checkFirstLine = false;
                } else {
                    String[] row = line.split(",");
                    boolean b = Boolean.parseBoolean(row[5]);
                    Account account = new Account(row[1], row[2], row[3], row[4], b);
                    group.add(account);
                }
            }
        } catch (Exception var11) {
            var11.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }

        }

        return group;
    }

    public static void writeCSV(String filename, ArrayList<Account> group) throws IOException {
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(filename));
            writer.write("id,ФИО,дата рождения,email,пароль,blocked\n");
            int cnt = 1;

            for(Iterator var4 = group.iterator(); var4.hasNext(); ++cnt) {
                Account person = (Account)var4.next();
                writer.write("" + cnt + "," + person.toString());
            }
        } catch (IOException var9) {
            var9.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }

        }

    }
}