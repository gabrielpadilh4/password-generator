package io.github.gabrielpadilh4.models;

/**
 * @author gabrielpadilhasantos@gmail.com
 */
public class PasswordGeneratorCliParameters {

    private final int DEFAULT_PASSWORD_LENGTH = 8;
    private int passwordLength;
    private boolean lowercase;
    private boolean uppercase;
    private boolean numbers;
    private boolean symbols;

    public PasswordGeneratorCliParameters() {
        this.setPasswordLength(DEFAULT_PASSWORD_LENGTH);
        this.lowercase = false;
        this.uppercase = false;
        this.numbers = false;
        this.symbols = false;
    }

    public int getPasswordLength() {
        return passwordLength;
    }

    public void setPasswordLength(int passwordLength) {
        this.passwordLength = passwordLength;
    }

    public boolean isLowercase() {
        return lowercase;
    }

    public void setLowercase(boolean lowercase) {
        this.lowercase = lowercase;
    }

    public boolean isUppercase() {
        return uppercase;
    }

    public void setUppercase(boolean uppercase) {
        this.uppercase = uppercase;
    }

    public boolean isNumbers() {
        return numbers;
    }

    public void setNumbers(boolean numbers) {
        this.numbers = numbers;
    }

    public boolean isSymbols() {
        return symbols;
    }

    public void setSymbols(boolean symbols) {
        this.symbols = symbols;
    }
}
