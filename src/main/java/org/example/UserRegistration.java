package org.example;

public class UserRegistration {
    public static void validateInput(String input, ValidationRule validationRule) throws UserRegistrationException {
        validationRule.validate(input);
    }

    public static void main(String[] args) {
        try {
            validateInput("Megala", firstNameValidationRule());
            validateInput("Ravi", lastNameValidationRule());
            validateInput("abc.xyz@bl.co.in", emailValidationRule());
            validateInput("91 9919819801", mobileNumberValidationRule());
            validateInput("Pass@word1", passwordValidationRule());


            validateInput("abc.xyz@bl.co.in", emailValidationRule());
            validateInput("invalid.email", emailValidationRule());
        } catch (UserRegistrationException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public static ValidationRule firstNameValidationRule() {
        return input -> {
            if (!input.matches("[A-Z]{1}[a-zA-Z]{2,}")) {
                throw new UserRegistrationException("Invalid First Name");
            }
        };
    }

    public static ValidationRule lastNameValidationRule() {
        return input -> {
            if (!input.matches("[A-Z]{1}[a-zA-Z]{2,}")) {
                throw new UserRegistrationException("Invalid Last Name");
            }
        };
    }

    public static ValidationRule emailValidationRule() {
        return input -> {
            if (!input.matches("[a-zA-Z]+(\\w)*((\\-|\\+|\\.)\\w+)*@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,})?(\\.[a-zA-Z]{2,})")) {
                throw new UserRegistrationException("Invalid Email");
            }
        };
    }

    public static ValidationRule mobileNumberValidationRule() {
        return input -> {
            if (!input.matches("(91){1}\\s+[6-9][0-9]{9}")) {
                throw new UserRegistrationException("Invalid Mobile Number");
            }
        };
    }

    public static ValidationRule passwordValidationRule(){
        return input ->{
            if(!input.matches(".*[A-Z].*") || !hasMinimumLength(input) || !input.matches(".*\\d.*") || !input.matches(".*\\W.*")){
                throw  new UserRegistrationException("Invalid Password");
            }
        };
    }

    private static boolean hasMinimumLength(String input) {
        return input.length() >= 8;
    }
}


