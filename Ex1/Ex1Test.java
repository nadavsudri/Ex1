package Ex1;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class Ex1Test {
    @Test
    void number2Int()
    {
        String number = "A132BbG";
        int number2 = Ex1.number2Int(number);
        Assertions.assertEquals(660267, number2);
    }

    @Test
    void isNumber() {
        String number = "A132BbG";
        boolean result = Ex1.isNumber(number);
        Assertions.assertTrue(result);
    }

    @Test
    void int2Number() {
        int num = Ex1.number2Int("A132BbG");
        int base = 16;
        Assertions.assertEquals("A132BbG", Ex1.int2Number(num,base));
    }

    @Test
    void testEquals() {
        String number = "A132BbG";
        int number2 = Ex1.number2Int(number);
        Assertions.assertEquals(number, Ex1.int2Number(number2,16));
    }

    @Test
    void maxIndex() {
        String[] nums_test = {"A12FFbG","11b2","AAAAAbG"};
        int max = Ex1.maxIndex(nums_test);
        Assertions.assertEquals(2, max);
    }
}
