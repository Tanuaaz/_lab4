public class AccountAlreadyExistsException extends RuntimeException {
    final String email;

    public AccountAlreadyExistsException(String message, String email) {
        super(message + email);
        this.email = email;
    }
}
