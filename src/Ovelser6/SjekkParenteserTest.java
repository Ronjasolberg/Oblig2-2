
package Ovelser6;

import static Ovelser6.ParentesSjekker.sjekkParenteser;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.EmptyStackException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SjekkParenteserTest {

    String s = "{ [ ( ) ] }";
    String s1 = "{ [ ( ) }";
    String s2 = "[ ( ) ] }";
    String s3 = "{ [ ( ] ) }";
    String javaprogram = """
class HelloWorld {
public static void main(String[] args) {
System.out.println("Hello World!");
}
}
""";

    @Test
    void sjekkParenteserTest() {
        assertTrue(sjekkParenteser(s));
        assertFalse(sjekkParenteser(s1));
        assertFalse(sjekkParenteser(s2));
        assertFalse(sjekkParenteser(s3));
        assertTrue(sjekkParenteser(javaprogram));
    }

}

