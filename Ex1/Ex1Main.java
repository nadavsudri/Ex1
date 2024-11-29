package Ex1;
import java.util.Scanner;
public class Ex1Main {
    public static void main(String[] args) {
        /*System.out.print("Enter a number in a valid format (Type 'quit' to exit)': -> ");
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        if (n.equals("quit")){System.exit(0);}
        while (!Ex1.isNumber(n))
        {
            System.out.print("Not a valid number, please try again: -> ");
            n = sc.next();
        }*/
        Scanner sc = new Scanner(System.in);
       String[] nums = {"19999999bA","1168bA","2222b4","234BbD","637b9","33a34"};
       for (String num : nums) {
           System.out.println(Ex1.number2Int(num));
       }
        System.out.println(Ex1.maxIndex(nums));



    }
}
