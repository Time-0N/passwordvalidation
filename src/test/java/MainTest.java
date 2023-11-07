import org.example.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MainTest {

    @Test
    void passwordvalidation_whenPassword7Letters_thenReturnFalse() {
        //GIVEN
        String password = "Methfan";

        //WHEN
        boolean actual = Main.passwordRequirements(password);

        //THEN
        assertFalse(actual);

    }

    @Test
    void passwordvalidation_whenPasswordLongerThen8Letters_thenReturnTrue() {
        //GIVEN
        String password = "Methenjoyer69";

        //WHEN
        boolean actual = Main.passwordRequirements(password);

        //THEN
        assertTrue(actual);

    }

    @Test
    void passwordvalidation_whenPasswordContainsNumber_thenReturnTrue() {
        //GIVEN
        String password = "Methhead69";

        //WHEN
        boolean actual = Main.passwordRequirements(password);

        //THEN
        assertTrue(actual);

    }

    @Test
    void passwordvalidation_whenPasswordNotContainsNumber_thenReturnFalse() {
        //GIVEN
        String password = "Methhead";

        //WHEN
        boolean actual = Main.passwordRequirements(password);

        //THEN
        assertFalse(actual);

    }

    @Test
    void passwordvalidation_whenPasswordContainsUpperAndLowercase_thenReturnTrue() {
        //GIVEN
        String password = "TheCook420";

        //WHEN
        boolean actual = Main.passwordRequirements(password);

        //THEN
        assertTrue(actual);

    }

    @Test
    void passwordvalidation_whenPasswordNotContainsUpperAndLowercase_thenReturnFalse() {
        //GIVEN
        String password = "walterwhite";

        //WHEN
        boolean actual = Main.passwordRequirements(password);

        //THEN
        assertFalse(actual);

    }

    @Test
    void passwordvalidation_whenPasswordUsedOnce_thenReturnFalse() {
        //GIVEN
        String password = "ICooked";
        String[] oldPassword = {"ICooked"};

        //WHEN
        boolean actual = Main.didPasswordGetUsed(password,oldPassword);

        //THEN
        assertFalse(actual);

    }
}
