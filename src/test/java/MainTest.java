import org.example.Main;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class MainTest {

    @Test
    void passwordvalidation_whenPassword7Letters_thenReturnFalse() {
        //GIVEN
        String password = "M3thfan";
        ArrayList<String> oldPassword = new ArrayList<String>();
        oldPassword.add("ICooked");

        //WHEN
        boolean actual = Main.passwordRequirements(password,oldPassword);

        //THEN
        assertFalse(actual);

    }

    @Test
    void passwordvalidation_whenPasswordLongerThen8Letters_thenReturnTrue() {
        //GIVEN
        String password = "Methenjoyer69";
        ArrayList<String> oldPassword = new ArrayList<String>();
        oldPassword.add("ICooked");

        //WHEN
        boolean actual = Main.passwordRequirements(password,oldPassword);

        //THEN
        assertTrue(actual);

    }

    @Test
    void passwordvalidation_whenPasswordContainsNumber_thenReturnTrue() {
        //GIVEN
        String password = "Methhead69";
        ArrayList<String> oldPassword = new ArrayList<String>();
        oldPassword.add("ICooked");

        //WHEN
        boolean actual = Main.passwordRequirements(password,oldPassword);

        //THEN
        assertTrue(actual);

    }

    @Test
    void passwordvalidation_whenPasswordNotContainsNumber_thenReturnFalse() {
        //GIVEN
        String password = "Methhead";
        ArrayList<String> oldPassword = new ArrayList<String>();
        oldPassword.add("ICooked");

        //WHEN
        boolean actual = Main.passwordRequirements(password,oldPassword);

        //THEN
        assertFalse(actual);

    }

    @Test
    void passwordvalidation_whenPasswordContainsUpperAndLowercase_thenReturnTrue() {
        //GIVEN
        String password = "TheCook420";
        ArrayList<String> oldPassword = new ArrayList<String>();
        oldPassword.add("ICooked");

        //WHEN
        boolean actual = Main.passwordRequirements(password,oldPassword);

        //THEN
        assertTrue(actual);

    }

    @Test
    void passwordvalidation_whenPasswordNotContainsUpperAndLowercase_thenReturnFalse() {
        //GIVEN
        String password = "walterwhite";
        ArrayList<String> oldPassword = new ArrayList<String>();
        oldPassword.add("ICooked");

        //WHEN
        boolean actual = Main.passwordRequirements(password,oldPassword);

        //THEN
        assertFalse(actual);

    }

    @Test
    void passwordvalidation_whenPasswordUsedOnce_thenReturnFalse() {
        //GIVEN
        String password = "ICooked";
        ArrayList<String> oldPassword = new ArrayList<String>();
        oldPassword.add("ICooked");

        //WHEN
        boolean actual = Main.passwordRequirements(password,oldPassword);

        //THEN
        assertFalse(actual);

    }
}
