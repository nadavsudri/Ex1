package Ex1;
import java.util.Scanner;
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i=0; i<10;i++)
        {   String n = sc.next();
            System.out.println((Ex1.isNumber(n)));
        }
    }
}
