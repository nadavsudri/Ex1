package Ex1;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.Random;

public class Ex1Test {
    /** static String method for tests only - provides a random valid number
     * base is assigned using random library (2-16)
     * then using a stringbuilder appends the chars by order to create a valid string
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
        for (int i = 0; i < 10; i++)
        {
            randNumbs[i] = rndNumStr();
            System.out.println(randNumbs[i]);
        }
        int c=0;
        for (int i =0; i<randNumbs.length; i++)
        {
            if (Ex1.isNumber("123b5"))
            {c++;}
        }
        Assertions.assertEquals(10,c);
    }

    @Test
    void int2Number() {
        int num = Ex1.number2Int("A132BbG");
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
}
