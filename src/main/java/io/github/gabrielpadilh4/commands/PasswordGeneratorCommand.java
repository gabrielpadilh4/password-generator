package io.github.gabrielpadilh4.commands;

import io.github.gabrielpadilh4.exceptions.MissingArgumentValueException;
import io.github.gabrielpadilh4.exceptions.PasswordLengthException;
import io.github.gabrielpadilh4.models.PasswordGeneratorCliParameters;
import io.github.gabrielpadilh4.services.PasswordGeneratorService;

/**
 * @author gabrielpadilhasantos@gmail.com
 */
public class PasswordGeneratorCommand {
    public static void execute(String[] args) {
        try {
            System.out.println("********** Password Generator **********");

            PasswordGeneratorCliParameters parameters = new PasswordGeneratorCliParameters();

            for (int i = 0; i < args.length; i++) {
                final String argument = args[i];

                if (argument.equals("-h") || argument.equals("--help")) {
                    printHelp();
                    break;
                }

                if (argument.equals("-c") || argument.equals("--chars")) {
                    try {
                        int passwordLength = Integer.parseInt(args[++i]);
                        if (passwordLength < 8) {
                            throw new PasswordLengthException("Password length should have minimum of 8 characters");
                        }
                        parameters.setPasswordLength(passwordLength);
                    } catch (IndexOutOfBoundsException ie) {
                        throw new MissingArgumentValueException("Missing value for option -c, --chars");
                    }
                }

                if (argument.equals("-l") || argument.equals("--lowercase")) {
                    parameters.setLowercase(true);
                }

                if (argument.equals("-u") || argument.equals("--uppercase")) {
                    parameters.setUppercase(true);
                }

                if (argument.equals("-n") || argument.equals("--numbers")) {
                    parameters.setNumbers(true);
                }

                if (argument.equals("-s") || argument.equals("--symbols")) {
                    parameters.setSymbols(true);
                }
            }

            PasswordGeneratorService.generatePassword(parameters);

            if (args.length == 0) {
                System.out.println("****************************************");
                printHelp();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printHelp() {
        System.out.println("Options:");
        System.out.println("  -c,  --chars      Specify a password chars length, minimum and default value is 8");
        System.out.println("  -l, --lowercase  Include lowercase letters [a-z]");
        System.out.println("  -u,  --uppercase  Include uppercase letters [A-Z]");
        System.out.println("  -n,  --numbers    Include numbers 0 - 9");
        System.out.println("  -s,  --symbols    Includes symbols ~`!@#$%^&*()_-+={[}]|\\:;\"'<,>.?/");
        System.out.println("  -h,  --help       Display help information");
    }
}
