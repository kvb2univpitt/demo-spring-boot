package com.github.kvb2univpitt.demo.secured.webapp.dto.account;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * Dec 30, 2020 5:40:59 AM
 *
 * @author Kevin V. Bui (kvb2univpitt@gmail.com)
 */
public class UserRegistrationForm {

    @NotBlank(message = "Username is required.")
    @Size(min = 4, max = 10, message = "Username must be between {min} to {max} characters.")
    private String username;

    @NotBlank(message = "Password is required.")
    @Size(min = 6, max = 20, message = "Password must be between {min} to {max} characters.")
    private String password;

    @NotBlank(message = "Confirm password is required.")
    @Size(min = 6, max = 20, message = "Confirm password must be between {min} to {max} characters.")
    private String confirmPassword;

    private String firstName;

    private String lastName;

    public UserRegistrationForm() {
    }

    public UserRegistrationForm(String username, String password, String confirmPassword) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public UserRegistrationForm(String username, String password, String confirmPassword, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserRegistrationForm{username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", confirmPassword=").append(confirmPassword);
        sb.append(", firstName=").append(firstName);
        sb.append(", lastName=").append(lastName);
        sb.append('}');

        return sb.toString();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
