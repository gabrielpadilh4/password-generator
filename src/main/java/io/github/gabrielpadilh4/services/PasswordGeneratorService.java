package io.github.gabrielpadilh4.services;

import io.github.gabrielpadilh4.models.PasswordGeneratorCliParameters;

/**
 * @author gabrielpadilhasantos@gmail.com
 */
public class PasswordGeneratorService {

    private static final String LOWERCASE_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "~`!@#$%^&*()_-+={[}]|\\:;\"'<,>.?/";

    public static void generatePassword(PasswordGeneratorCliParameters parameters) {
        String characters = getCharacters(parameters);

        int charactersSize = characters.length();

        StringBuilder generatedPassword = new StringBuilder();

        for (int i = 0; i < parameters.getPasswordLength(); i++) {
            int index = (int) (Math.random() * charactersSize);
            generatedPassword.append(characters.charAt(index));
        }

        if (!isMatchingPasswordRequirements(generatedPassword.toString(), parameters)) {
            generatePassword(parameters);
        } else {
            System.out.println("Your password is: " + generatedPassword);
        }
    }

    private static String getCharacters(PasswordGeneratorCliParameters parameters) {
        StringBuilder charactersList = new StringBuilder("");

        if (parameters.isLowercase()) {
            charactersList.append(LOWERCASE_ALPHABET);
        }

        if (parameters.isUppercase()) {
            charactersList.append(UPPERCASE_ALPHABET);
        }

        if (parameters.isNumbers()) {
            charactersList.append(NUMBERS);
        }

        if (parameters.isSymbols()) {
            charactersList.append(SYMBOLS);
        }

        if (charactersList.length() == 0) {
            charactersList.append(LOWERCASE_ALPHABET + UPPERCASE_ALPHABET + NUMBERS + SYMBOLS);
        }

        return charactersList.toString();
    }

    private static boolean isMatchingPasswordRequirements(String password, PasswordGeneratorCliParameters parameters) {
        boolean hasLowercaseLetters = false;
        boolean hasUppercaseLetters = false;
        boolean hasNumbers = false;
        boolean hasSymbols = false;

        for (int i = 0; i < password.length(); i++) {
            char character = password.charAt(i);

            if (Character.isLowerCase(character) && parameters.isLowercase()) {
                hasLowercaseLetters = true;
            }

            if (Character.isUpperCase(character) && parameters.isUppercase()) {
                hasUppercaseLetters = true;
            }

            if (Character.isDigit(character) && parameters.isNumbers()) {
                hasNumbers = true;
            }

            if (SYMBOLS.contains(String.valueOf(character)) && parameters.isSymbols()) {
                hasSymbols = true;
            }
        }

        return hasLowercaseLetters == parameters.isLowercase() && hasUppercaseLetters == parameters.isUppercase()
                && hasNumbers == parameters.isNumbers() && hasSymbols == parameters.isSymbols();
    }
}
