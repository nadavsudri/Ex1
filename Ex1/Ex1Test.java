package Ex1;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.Random;
/**
 * this is my test file for Ex1.
 * the tests included are both the required one and also some of mine.
 * any function that is not being tested, is simple at most, and doesn't make any complicated operations.
 * my tests search for bugs or extreme cases.
 * for testing my is number method I created a random string method, to find if the tested method do well if tested on 10000 numbers
 * **/
public class Ex1Test {
    /** static String method for tests only - provides a random valid number
     * base is assigned using random library (2-16)
     * then using a stringbuilder appends the chars by order to create a valid string
     * returns the string in a valid format
     * **/
    private static String random_valid_Num()
    {
        Random random = new Random();
        int base = random.nextInt(15) + 2;
        // Convert base to a valid char base [2,16]
        char baseChar = Ex1.int_to_char(base);
        int length = random.nextInt(5) + 1; // Length of the number (1 to 5 chars)
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(base-1)+1;
            number.append(digit);
        }
        return number + "b" + baseChar;
    }
    @Test
    void number2Int()
    {
        String number = "A132BbG";
        int number2 = Ex1.number2Int(number);
        Assertions.assertEquals(660267, number2);
        String number3 = "016473b1";
        Assertions.assertEquals(-1, Ex1.number2Int(number3));
        int x = 0;
        String b = "0000000b4";
        int zero = x+Ex1.number2Int(b);
        Assertions.assertEquals(0, zero);
    }
    @Test
    void isNumber() {
        int size = 10000;
        String [] randNumbs = new String[size];
        for (int i = 0; i < randNumbs.length; i++) {randNumbs[i] = random_valid_Num();}
        int c=0;
        for (String randNumb : randNumbs) {
            if (Ex1.isNumber(randNumb)) {
                c++;
            }
        }
        Assertions.assertEquals(size,c);
        String x1 = "-100101b2";
        String x2 = "22b12";
        String x3 = "AA@bG";
        String x4 = "aa12bG";
        String [] invalds = {x1,x2,x3,x4,"","0000000b","0b0"};
        boolean ok = true;
        for (int i =0; i<6; i++){ok = Ex1.isNumber(invalds[i]);}
        Assertions.assertFalse(ok);
    }
    @Test
    void int2Number() {
        int num = Ex1.number2Int("A132BbG");
        int base = 16;
        Assertions.assertEquals("A132BbG", Ex1.int2Number(num,base));
        Assertions.assertEquals("", Ex1.int2Number(11,1));
        Assertions.assertEquals("", Ex1.int2Number(11,0));
        Assertions.assertNotEquals("", Ex1.int2Number(11,2));

    }

    @Test
    void testEquals() {
        String number = random_valid_Num();
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
        for (String s : good) {
            boolean ok = Ex1.isNumber(s);
            Assertions.assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for (String s : not_good) {
            boolean not_ok = Ex1.isNumber(s);
            Assertions.assertFalse(not_ok);
        }
    }
}
