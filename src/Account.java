public class Account {
    private String name;
    private String date;
    private String email;
    private String password;
    private Boolean blocked = false;

    public Account(String name, String date, String email, String password, boolean blocked) {
        this.name = name;
        this.date = date;
        this.email = email;
        this.password = password;
        this.blocked = false;
    }

    public String toString() {
        return this.name + "," + this.date + "," + this.email + "," + this.password + "," + this.blocked + "\n";
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean isBlocked() {
        return this.blocked;
    }

    public void setBlock() {
        this.blocked = true;
    }
}

