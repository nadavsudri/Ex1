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
        String number3 = "016473b1";
        Assertions.assertEquals(-1, Ex1.number2Int(number3));
    }

    @Test
    void isNumber() {
        String number = "A132BbG";
        String number2 = "123456";
        String number3 = "AABBCCbG";
        String number4= "567AbH";
        String number5 = "11b02";
        String number6 = "7699b";
        int t = 0, f = 0;
        String [] numbs = {number,number2,number3,number4,number5,number6};
        for (int i =0; i<5; i++){if (Ex1.isNumber(numbs[i])){t++;}else{f++;}}
        Assertions.assertEquals(1,t/f);
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
