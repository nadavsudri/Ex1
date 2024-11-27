package Ex1;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Enumeration;

/**
 * This class represents a simple solution for Ex1.Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
    public static boolean numValid(String s) /// return false if number part contains invalid numbers (e.g H or Z)
    {   String not_val = "HIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < s.length(); i++) ///run over the string and checks for ivnalid characters
        {
            if(not_val.indexOf(s.charAt(i))>=0){return false;}
        }
        for(char c : s.toCharArray()){if (char_to_int(c)==-1)return false;}
        return true;

    }
    public static int char_to_int(char ch) /// switching char digits to return corresponding integers
    {
        switch (ch){
            case'A'->{return 10;}
            case 'B'->{return 11;}
            case 'C'->{return 12;}
            case 'D'->{return 13;}
            case 'E'->{return 14;}
            case 'F'->{return 15;}
            case 'G'->{return 16;}
            case '0'->{return 0;}
            case'1'->{return 1;}
            case '2'->{return 2;}
            case '3'->{return 3;}
            case '4'->{return 4;}
            case '5'->{return 5;}
            case '6'->{return 6;}
            case '7'->{return 7;}
            case '8'->{return 8;}
            case '9'->{return 9;}
        }
        return -1;
    }
    public static boolean baseValid( char s)///checks if the base is valid (1-9 OR A-G)
    {
        String s_base = String.valueOf(s);
        return char_to_int(s) != -1;
    }
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     * @param num a String representing a number in basis [2,16]
     * @return
     */

    public static int number2Int(String num) {
        int ans = -1;
        if(!isNumber(num)){return -1;}
        else {

        return ans;
             }
    }
    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {
        boolean ans = true;
        int count = 0;
        for(int i = 0; i < a.length(); i++){if(a.charAt(i)=='b'){count++;}}///checks if b  appears in the string less or ,more then 1
        if (count!=1){return false;}
        String numPart = a.substring(0,a.indexOf("b")); /// create seperate string for the numeric part
        char basePart = a.charAt(a.indexOf("b")+1); /// creates a char for the base
        if(char_to_int(basePart)>16||char_to_int(basePart)<=1){return false;} /// checks if the base is within 2-16
        if(!numValid(numPart)){return false;}
        if(!baseValid(basePart)){return false;}
        for(char c : numPart.toCharArray()) ///checks if there is any digit larger than the base
        {
            if(char_to_int(c)>=char_to_int(basePart)){return false;}
        }
        return ans;
    }

    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     * @param num the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        String ans = "";
        // add your code here

        ////////////////////
        return ans;
    }

    /**
     * Checks if the two numbers have the same value.
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = true;
        // add your code here

        ////////////////////
        return ans;
    }

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     *
     */
    public static int maxIndex(String[] arr) {
        int ans = 0;
        // add your code here

        ////////////////////
        return ans;
    }
}