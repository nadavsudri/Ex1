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
    public static void main(String[] args) {
        while ((true)) // Goes on until user type 'quit'
        {   String first = get_First();
            if (first.equals("quit")){System.exit(0);}
            num_show(first);
            while(!Ex1.isNumber(first)){
                first = get_First();
                if (first.equals("quit")){System.exit(0);}
                num_show(first);
            }
            String second = get_Second();
            if (second.equals("quit")){System.exit(0);}
            num_show(second);
            while(!Ex1.isNumber(second)){
                second = get_Second();
                if (second.equals("quit")){System.exit(0);}
                num_show(second);
            }
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a base to calculate (Range [2,16]): -> ");
            int base = sc.nextInt();
            System.out.println();
            int sum = (Ex1.number2Int(first)+Ex1.number2Int(second));
            int mult = (Ex1.number2Int(first)*Ex1.number2Int(second));
            System.out.println(first+" + "+ second +" = " + Ex1.int2Number(sum,base));
            System.out.println(first+ " * " + second + " = " + Ex1.int2Number(mult,base));
            System.out.println();
            String[] nums = {first,second,Ex1.int2Number(sum,base),Ex1.int2Number(mult,base)};
            System.out.print("Max number From ");
            print_arr(nums);
            System.out.print("is: " + nums[Ex1.maxIndex(nums)]);
            System.out.println();
            System.out.println("_______________The_End_____________");


        }
    }
}
