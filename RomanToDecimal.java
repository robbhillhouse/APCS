import java.util.Locale;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Robert Hillhouse
 * @version 10/3/21
 */

public class RomanToDecimal {
    /**
     * For each roman numeral I changed the string to an int corresponding to the roman numeral's value
     * @param roman
     * @return
     */
    public static int romanToDecimal(String roman) {
        int decimal = 0;
        for (int i = 0; i < roman.length(); i++) {
            String sub = roman.substring(i, i+1).toUpperCase();
            //System.out.println("DEBUG: " + roman.substring(i, i+1).toUpperCase());
            if(sub.equals("I"))   {
                decimal += 1;
            }
            else if(sub.equals("V")) {
                decimal += 5;
            }
            else if(sub.equals("X"))  {
                decimal += 10;
            }
            else if(sub.equals("L"))  {
                decimal += 50;
            }
            else if(sub.equals("C"))  {
                decimal += 100;
            }
            else if(sub.equals("D"))  {
                decimal += 500;
            }
            else if(sub.equals("M"))  {
                decimal += 1000;
            }
            else {
                return -1;
            }
        }
        String upper = roman.toUpperCase();
        if(upper.indexOf("IV") != -1)
            decimal -= 2;
        if(upper.indexOf("IX") != -1)
            decimal -= 2;
        if(upper.indexOf("XL") != -1)
            decimal -= 20;
        if(upper.indexOf("LC") != -1)
            decimal -= 20;
        if(upper.indexOf("CD") != -1)
            decimal -= 200;
        if(upper.indexOf("CM") != -1)
            decimal -= 200;
        if(upper.indexOf("DM") != -1)
            decimal -= 200;
        return decimal;
    }

    public static void main(String[] args)  {
        Scanner user = new Scanner(System.in);
        for(String temp : args) {
            int val = romanToDecimal(temp);
            if(val == -1)
                System.out.println("Input: " + temp + " => output: Invalid");
            else
                System.out.println("Input: " + temp + " => output: " + val);

        }
        System.out.println("Enter Roman Numerals: ");
        String input = user.nextLine();
        int decimal = romanToDecimal(input);
        if (decimal == -1) {
            System.out.println("input: " + input.toUpperCase() + " => output: invalid");
        }
        else    {
            System.out.println("input: " + input.toUpperCase() + " => output: " + decimal);
        }

    }
}