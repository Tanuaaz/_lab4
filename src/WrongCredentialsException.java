public class WrongCredentialsException extends RuntimeException {
    private String email;
    private String password;

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public WrongCredentialsException(String message, String email, String password) {
        super(message + email);
        this.email = email;
        this.password = password;
    }
}