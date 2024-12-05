package Ex1;
import java.util.Enumeration;
public class Ex1 {
    private static boolean numValid(String s) // return false if number part contains invalid numbers (e.g H or Z)
    {
        for(char c : s.toCharArray()){if (char_to_int(c)==-1)return false;}
        return true;
    }
    private static int char_to_int(char ch) // switching char digits to return corresponding integers
    {
        switch (ch){
            case 'A'->{return 10;}
            case 'B'->{return 11;}
            case 'C'->{return 12;}
            case 'D'->{return 13;}
            case 'E'->{return 14;}
            case 'F'->{return 15;}
            case 'G'->{return 16;}
            case '0'->{return 0;}
            case '1'->{return 1;}
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
    public static char int_to_char(int i)//Switching integers to return corresponding chars
    {
        switch (i){
            case 0->{return '0';}
            case 1->{return '1';}
            case 2->{return '2';}
            case 3->{return '3';}
            case 4->{return '4';}
            case 5->{return '5';}
            case 6->{return '6';}
            case 7->{return '7';}
            case 8->{return '8';}
            case 9-> {return'9';}
            case 10-> {return'A';}
            case 11-> {return'B';}
            case 12-> {return'C';}
            case 13-> {return'D';}
            case 14-> {return'E';}
            case 15-> {return'F';}
            case 16-> {return'G';}

        }
        return 'X';
    }
    public static boolean baseValid( char s)//checks if the base is valid (1-9 OR A-G)
    {
        return char_to_int(s) != -1;
    }
    private static boolean is_digits_only(String s) // checks if a string contains digits only
    {boolean ans = true;
        for (int i = 0; i < s.length(); i++)
        {
            if(!Character.isDigit(s.charAt(i))){ans = false;}
        }
        return ans;
    }
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     * @param num a String representing a number in basis [2,16]
     * @return
     * first, checks if the string is digits only, if so returns the number as int (digits only - base 10)
     * then checks if the number is valid with is number (return -1 if not)
     * then devices the string to a number (numeric value) and a base
     * and then begin to loop over the string digits, multiplying each digit in its  base to the corresponding power (ex. -> 124b10 -> 4*10^0 + 2*10^1 + 1*10^2)
     * lastly return the answer
     */

    public static int number2Int(String num) {
        int ans = -1;
        if(is_digits_only(num)){return Integer.parseInt(num);}
        if(!isNumber(num)){return -1;}
        else {
            String num_str = num.substring(0,num.indexOf("b"));
            int basePart = char_to_int( num.charAt(num.indexOf("b")+1)); // creates a int for the base
            if (basePart==10){return Integer.parseInt(num.substring(0,num.indexOf("b")));} // if the base is 10, returns the numeric part
            else
            {
                int dec_sum=0,power= num_str.length()-1; // 2 integers - one for the sum of the digits, one for the power (power assinged to the size of the string -1)
                for (char c:num_str.toCharArray())// loop every char in num_str, and calc -> dig*base^[index] (ex. -> 124b10 -> 4*10^0 + 2*10^1 + 1*10^2)
                {
                    dec_sum = dec_sum+(char_to_int(c)*(int)(Math.pow(basePart,power))); // calculate  dig*base^[index] and assign it to dec_sum
                    power--; // reduces the power by 1
                    ans = dec_sum;// Assign dec_sum to ans
                }
        return ans;
            }
        }
    }
    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     * the function is built on elimination procces, and returns false anytime a certain "invalid" property is recognized.
     * fisrt, checks if "b" is 0,1 or more times in the string, if greater than 1, return false
     * second, it creates different chars for the numerical part, and the base (to later be processed as integers)
     * then it checks if the base is valid (if 1<base<17) and return false if it's out of range
     * lastly it goes over all the numeric part and checks if there is a digit greater than the base.
     * if a certain string passed all these conditions, it is considered valid.
     */
    public static boolean isNumber(String a) {
        boolean ans = true;
        if (is_digits_only(a)){return true;}
        int count = 0;
        for(int i = 0; i < a.length(); i++){if(a.charAt(i)=='b'){count++;}}///checks if b  appears in the string less or ,more then 1
        if (count>1){return false;}
        String numPart;
        if (!a.contains("b")){numPart =  a;}
        else { numPart= a.substring(0,a.indexOf("b"));}/// create seperate string for the numeric part
        if (a.charAt(a.length()-1)=='b'){return false;} // if there is a 'b', but nothing after it, return false
        char basePart = a.charAt(a.indexOf('b')+1); /// creates a char for the base
        if(char_to_int(basePart)>16||char_to_int(basePart)<=1){return false;} /// checks if the base is within 2-16
        if(!numValid(numPart)){return false;}
        if(!baseValid(basePart)){return false;}
        for(char current_letter : numPart.toCharArray()) ///checks if there is any digit larger than the base
        {
            if(char_to_int(current_letter)>=char_to_int(basePart)){return false;}
        }
        return ans;
    }
    /**
     * this function receives 2 integers, num And base, then returns the number validly in given base.
     * first, a string builder is used to append chars ot a new string, later will be our number.
     * then, a temp_str is used to loop over the integer digits with a for loop
     * the loop will break if the num is 0 (later is devided)
     * then the loop finds the remainder for every digit, and append id to ans
     * lastly, num is divided by the base in order to proceed to the next division.
     * then, ans is reversed (digits appends backwords [the division worked its way from the lergest to smallest])
     * lastly ans is appended "b" and a char representing the base.
     * **/
    public static String int2Number(int num, int base) {
        StringBuilder ans = new StringBuilder(); /// define ans as string builder to append and reverse the necessary chars
        String temp_str = String.valueOf(num);/// gets a string with val on num
        for (char c : temp_str.toCharArray())
        {
            if (num==0){break;}// makes sure not to go on if num is 0
            ans.append(int_to_char(num % base));//adds the digit to the number based on the remainder
            num /= base;//divide by the base to proceed to next digit
        }
        ans.reverse();// reverse the number (the loop built it backwards
        ans.append("b");
        ans.append(int_to_char(base));
        return ans.toString(); /// returning the string value of ans
    }
    public static boolean equals(String n1, String n2) {
        return number2Int(n1)==number2Int(n2); /// Uses the number2int method to compare values
    }

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     *
     */
    public static int maxIndex(String[] arr) /// Runs over arr and using the method number2int, compares every number in the array (assume 1st is the biggest)
    {
        int ans = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if (number2Int(arr[i]) > number2Int(arr[ans])){ans = i;}
        }
        return ans;
    }
}