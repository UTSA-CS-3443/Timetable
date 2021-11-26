package application.model;

import java.util.Objects;

public abstract class Account {
    private String emailAddress;
    private String password;
    private String firstName;

    protected Account(String emailAddress, String password) {
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public static boolean authentication(String email, String password, String confirm, boolean type) {
        if (type) {
            return Objects.equals(password, confirm);
        }
        return false;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
