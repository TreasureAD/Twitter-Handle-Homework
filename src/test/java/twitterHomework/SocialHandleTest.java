package twitterHomework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashSet;

public class SocialHandleTest {

    @Test
    public void createHandleTest() {
        // Given
        SocialHandle sh = new SocialHandle();
        String handleInput = "myhandle";

        // When
        String result = sh.createHandle(handleInput);

        // Then
        assertEquals("@myhandle", result);
    }

    @Test
    public void checkHandleLessThan9CharactersTest() {
        // Given
        SocialHandle sh = new SocialHandle();
        String handleInput1 = "abcdefgh";
        String handleInput2 = "abcdefghiuh";

        // When
        String result1 = sh.createHandle(handleInput1);
        String result2 = sh.createHandle(handleInput2);

        // Then
        assertEquals("@abcdefgh", result1);
        assertEquals("@abcdefghi", result2);
    }

    @Test
    public void checkEmptyOrBlankCharactersTest() {
        // Given
        SocialHandle sh = new SocialHandle();
        String emptyInput = "";
        String blankInput = "   ";

        // When
        String result1 = sh.createHandle(emptyInput);
        String result2 = sh.createHandle(blankInput);

        // Then
        assertEquals("Invalid handle", result1);
        assertEquals("Invalid handle", result2);
    }

    @Test
    public void addHandleTest() {
        // Given
        SocialHandle sh = new SocialHandle();
        String handleInput = "myhandle";

        // When
        sh.addHandle(handleInput);
        sh.addHandle(handleInput);

        // Then
        HashSet<String> handles = sh.getHandles();
        assertEquals(1, handles.size());
        assertTrue(handles.contains("@myhandle"));
    }

    @Test
    public void removeHandleTest() {
        // Given
        SocialHandle sh = new SocialHandle();
        String handleInput = "toRemove";
        sh.addHandle(handleInput);

        // When
        sh.removeHandle(handleInput);

        // Then
        assertFalse(sh.getHandles().contains("@toremove"));
    }
}
