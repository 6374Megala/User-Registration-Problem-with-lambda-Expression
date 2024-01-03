package org.example;

@FunctionalInterface
interface ValidationRule {
    void validate(String input) throws UserRegistrationException;
}
