import org.example.UserRegistration;
import org.example.UserRegistrationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserRegistrationTest {
    @Test
    public void testValidFirstName() {
        try {
            UserRegistration.validateInput("Megala",UserRegistration.firstNameValidationRule());
        } catch (UserRegistrationException e) {
            System.out.println("Unexpected exception: " + e.getMessage());

        }
    }


    @Test
    public void testInvalidFirstName() {
        try {
            UserRegistration.validateInput("m",UserRegistration.firstNameValidationRule());
            System.out.println("Expected InvalidFirstNameException, but no exception was thrown");
        } catch (UserRegistrationException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
            Assert.assertEquals("Invalid First Name", e.getMessage());
        }
    }

    @Test
    public void testValidLastName() {
        try {
            UserRegistration.validateInput("Ravi",UserRegistration.lastNameValidationRule());
        } catch (UserRegistrationException e) {
            System.out.println("Unexpected exception: " + e.getMessage());

        }
    }

    @Test
    public void testInvalidLastName() {
        try {
            UserRegistration.validateInput("R",UserRegistration.lastNameValidationRule());
            System.out.println("Expected InvalidLastNameException, but no exception was thrown");
        } catch (UserRegistrationException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
            Assert.assertEquals("Invalid Last Name", e.getMessage());
        }

    }

    @Test
    public void testValidEmail() {
        try {
            UserRegistration.validateInput("goutham.y@bridgelabz.com",UserRegistration.emailValidationRule());
        } catch (UserRegistrationException e) {
            System.out.println("Unexpected exception: " + e.getMessage());

        }
    }

    @Test
    public void testInvalidEmail() {
        try {
            UserRegistration.validateInput("invalid.email",UserRegistration.emailValidationRule());
            System.out.println("Expected InvalidEmailException, but no exception was thrown");
        } catch (UserRegistrationException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
            Assert.assertEquals("Invalid Email", e.getMessage());

        }
    }

    @Test
    public void testValidMobileNumber() {
        try {
            UserRegistration.validateInput("91 9919819801",UserRegistration.mobileNumberValidationRule());

            System.out.println("Valid Mobile Number");
        }catch (UserRegistrationException e) {
            System.out.println("Unexpected exception: " + e.getMessage());

        }
    }
    @Test
    public void testInvalidMobileNumber() {
        try {
            UserRegistration.validateInput("123",UserRegistration.mobileNumberValidationRule());
            System.out.println("Expected InvalidMobileNumberException, but no exception was thrown");
        }catch (UserRegistrationException e) {
            Assert.assertEquals("Invalid Mobile Number", e.getMessage());
            System.out.println(e.getMessage());

        }
    }



    @Test
    public void testValidPassword() {
        try {
            UserRegistration.validateInput("Pass@word1",UserRegistration.passwordValidationRule());

            System.out.println("Valid password");
        } catch (UserRegistrationException e) {
            System.out.println("Unexpected exception: " + e.getMessage());

        }
    }
    @Test
    public void testInvalidPassword() {
        try {
            UserRegistration.validateInput("password",UserRegistration.passwordValidationRule());

            System.out.println("Valid password");
        } catch (UserRegistrationException e) {
            Assert.assertEquals("Invalid Password", e.getMessage());
            System.out.println(e.getMessage());

        }
    }



    @ParameterizedTest
    @ValueSource(strings = { "abc.xyz@bl.co.in", "def@gh.com", "ijk@lmn.opq"})
    public void testParameterizedValidEmail(String email) {
        try {
            UserRegistration.validateInput(email,UserRegistration.emailValidationRule());
        } catch (UserRegistrationException e) {
            System.out.println("Unexpected exception: " + e.getMessage());

        }
    }
}
