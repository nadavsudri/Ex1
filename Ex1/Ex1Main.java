/**
 * By nadav sudri - 322714924
 * ---Output---
 * Enter first number in a valid format (Type 'quit' to exit)': -> 1121212b2
 * Number = 1121212b2| is valid?: false| Value: -1
 * Err: Not a valid number: 1121212b2
 * Enter first number in a valid format (Type 'quit' to exit)': -> 1001001101b2
 * Number = 1001001101b2| is valid?: true| Value: 589
 * Enter second number in a valid format (Type 'quit' to exit)': -> 1789bB
 * Number = 1789bB| is valid?: true| Value: 2275
 * Enter a base to calculate (Range [2,16]): -> 11
 * 1001001101b2 + 1789bB = 2174bB
 * 1001001101b2 * 1789bB = 83581AbB
 * Max number From [1001001101b2,1789bB,2174bB,83581AbB]
 * is: 83581AbB --> 1339975 in decimal
 * _______________The_End_____________
 * **/

package Ex1;
import java.sql.SQLOutput;
import java.util.Scanner;
public class Ex1Main {
    public static void num_show(String num)// prints the number according to its validity
    {
        System.out.println("Number = " + num + "| is valid?: " +Ex1.isNumber(num)+"| Value: "+Ex1.number2Int(num));
        if (!Ex1.isNumber(num)){
            System.out.println("Err: Not a valid number: "+num);
        }
        System.out.println();
    }
    public static String get_First() // Gets from user the first number
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number in a valid format (Type 'quit' to exit)': -> ");
        String num = sc.nextLine();
        System.out.println();
        return num;
    }
    public static int get_base() // Gets from user the base as integer
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a base to calculate (Range [2,16]): -> ");
        int num = sc.nextInt();
        System.out.println();
        return num;
    }
    public static String get_Second() // Gets from user the second number
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter second number in a valid format (Type 'quit' to exit)': -> ");
        String num= sc.nextLine();
        System.out.println();
        return num;
    }
    public static void print_arr(String[]arr){
        System.out.print("[");
        boolean first = true;
        for (String s : arr){
            if (first){System.out.print(s);}
            else{System.out.print(","+s);}
            first = false;
        }
        System.out.println("]");
    } //prints array in format of [x,y,z,w]
    /**
     * Main function, get as input 2 strings and an integer, (for each one the function will only accept valid formats)
     * then prints the sum and multiplication of the two numbers, and show it in the given base as an output.
     * lastly it shows the maximum between the numbers (num1,num2,sum,mult)
     * any time the user types 'quit' the program will stop running
     * **/
    public static void main(String[] args)
    { String first = new String();
        String second = new String();
        while (!(first.equals("quit")||(second.equals("quit")))) // Goes on until user type 'quit'
        {   first = get_First();
            if (first.equals("quit")){System.exit(0);} // exit if user types 'quit'
            num_show(first); // print the number
            while(!Ex1.isNumber(first)){ // repeats the scanning as long as the number provided is not valid.
                first = get_First();
                num_show(first);
            }
             second = get_Second();
            if (second.equals("quit")){System.exit(0);} // exit if user types 'quit'
            num_show(second);//print the number
            while(!Ex1.isNumber(second)){// repeats the scanning as long as the number provided is not valid.
                second = get_Second();
                num_show(second);
            }
            int base = get_base();
            while (!Ex1.baseValid(Ex1.int_to_char(base))) //while the base is valid ([2,16])
            {base = get_base();}
            System.out.println();
            int sum = (Ex1.number2Int(first)+Ex1.number2Int(second)); // the sum of the 2 numbers
            int mult = (Ex1.number2Int(first)*Ex1.number2Int(second)); // the multiplication  of the 2 numbers
            System.out.println(first+" + "+ second +" = " + Ex1.int2Number(sum,base));//printing the numbers in the choosen base
            System.out.println(first+ " * " + second + " = " + Ex1.int2Number(mult,base));//printing the numbers in the choosen base
            System.out.println();
            String[] nums = {first,second,Ex1.int2Number(sum,base),Ex1.int2Number(mult,base)};//create an array of strings
            System.out.print("Max number From ");
            print_arr(nums); // prints the array in a format of : [a1,a2,a3....]
            System.out.print("is: " + nums[Ex1.maxIndex(nums)]+" --> " + Ex1.number2Int(nums[Ex1.maxIndex(nums)])+" in decimal");
            System.out.println();
        }
    }
}
