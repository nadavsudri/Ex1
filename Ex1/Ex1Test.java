package Ex1;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class Ex1Test {
    /** static String method for tests only - provides a random valid number
     * base is assigned using random library (2-16)
     * then using a stringbuilder appends the chars by order to create a valid string
     * returns the string in a valid format
     * **/
    private static String rndNumStr()
    {
        Random random = new Random();
        int base = random.nextInt(15) + 2;
        // Convert base to a valid char base [2,16]
        char baseChar = Ex1.int_to_char(base);
        int length = random.nextInt(5) + 1; // Length of the number (1 to 5 chars)
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(base-1)+1;
            if (digit < 10) {
                number.append(digit); // Append numeric digits for 0-9
            }
            else {
                number.append(Ex1.int_to_char(digit)); // Append A-F for 10-15
            }
        }
        return number.toString() + "b" + baseChar;
    }
    @Test
    void number2Int()
    {
        String number = "A132BbG";
        int number2 = Ex1.number2Int(number);
        Assertions.assertEquals(660267, number2);
        String number3 = "016473b1";
        Assertions.assertEquals(-1, Ex1.number2Int(number3));}

    @Test
    void isNumber() {
        String [] randNumbs = new String[10];
        for (int i = 0; i < 10; i++) {randNumbs[i] = rndNumStr();}
        int c=0;
        for (int i =0; i<randNumbs.length; i++)
        {
            if (Ex1.isNumber(randNumbs[i]))
            {c++;}
        }
        Assertions.assertEquals(10,c);
    }

    @Test
    void int2Number() {
        int num = Ex1.number2Int("A132BbG");
        int num2 = 1256;
        String l = Ex1.int2Number(num2,2);
        int base = 16;
        Assertions.assertEquals("A132BbG", Ex1.int2Number(num,base));
    }

    @Test
    void testEquals() {
        String number = rndNumStr();
        int number2 = Ex1.number2Int(number);
        Assertions.assertEquals(number2,Ex1.number2Int(number) );
    }
    @Test
    void maxIndex() {
        String[] nums_test = {"A12FFbG","11b2","AAAAAbG"};
        int max = Ex1.maxIndex(nums_test);
        Assertions.assertEquals(2, max);
    }
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
       Assertions.assertEquals(v,11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v,2);
        int v2 = Ex1.number2Int(s2);
        Assertions.assertEquals(v,v2);
        Assertions.assertTrue(Ex1.equals(s10,s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for(int i=0;i<good.length;i=i+1) {
            boolean ok = Ex1.isNumber(good[i]);
            Assertions.assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for(int i=0;i<not_good.length;i=i+1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            Assertions.assertFalse(not_ok);
        }
    }
}
