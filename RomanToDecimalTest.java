import static org.junit.Assert.*;

public class RomanToDecimalTest {

    @org.junit.Test
    public void romanToDecimal() {
        //valid assertEquals
        assertEquals(RomanToDecimal.romanToDecimal("MDCIX"), 1609);
        assertEquals(RomanToDecimal.romanToDecimal("CL"), 150);
        assertEquals(RomanToDecimal.romanToDecimal("XI"), 11);
        assertEquals(RomanToDecimal.romanToDecimal("IX"), 9);
        assertEquals(RomanToDecimal.romanToDecimal("CD"), 400);
        assertEquals(RomanToDecimal.romanToDecimal("CM"), 900);
        assertEquals(RomanToDecimal.romanToDecimal("IV"), 4);
        assertEquals(RomanToDecimal.romanToDecimal("XL"), 40);
        assertEquals(RomanToDecimal.romanToDecimal("MMM"), 3000);
        assertEquals(RomanToDecimal.romanToDecimal("LX"), 60);
        //logically incorrect assertEquals
        assertEquals(RomanToDecimal.romanToDecimal("IXIX"), 20);
        assertEquals(RomanToDecimal.romanToDecimal("IVIV"), 10);
        assertEquals(RomanToDecimal.romanToDecimal("CMCM"), 2000);
        assertEquals(RomanToDecimal.romanToDecimal("XLXL"), 100);
        //invalid assertEquals
        assertEquals(RomanToDecimal.romanToDecimal("your mom"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("JOE"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("TEST"), -1);
        //assertNotEquals
        assertNotEquals(RomanToDecimal.romanToDecimal("CMDLXIM"), 384957934);
        assertNotEquals(RomanToDecimal.romanToDecimal("MMMMMCLIX"), 1);
    }
}