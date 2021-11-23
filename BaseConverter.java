import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.util.Scanner;
import java.io.File;
import java.io.*;
/**
 * Main method for class BaseConverter
 * @version Monday 11/22/2021
 * @author 23hillhouse
 */
public class BaseConverter {
    String alpha = "0123456789ABCDEF";
    // Constructor for class.
    public BaseConverter() {
        //create a Scanner that opens values10.dat
        //print each line to the screen
    }
    // Convert a String num in fromBase to base-10 int.
    public int strToInt(String num, String fromBase) {
        int base = Integer.parseInt(fromBase);
        int sum = 0, exp = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            sum += alpha.indexOf("" + num.charAt(i)) * Math.pow(base, exp);
            exp++;
        }
        return sum;
    }
    // Convert a base-10 int to a String number of base toBase.
    public String intToStr(int num, int toBase) {
        String toNum = "";
        while (num > 0) {
            toNum = "" + alpha.charAt(num % toBase) + toNum;
            num /= toBase;
        }
        return toNum;
    }
    public void myExtra()   {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Pictures and data Files", "jpg", "gif", "dat", "txt");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " +
                    chooser.getSelectedFile().getName());
        }
    }
    /**
     * Opens the file stream, inputs data one line at a time, converts, prints
     * the result to the console window and writes data to the output stream.
     */
    public void inputConvertPrintWrite() {
        Scanner sc = null;
        PrintWriter pw = null;
        try {
            sc = new Scanner(new File("datafiles/values10.dat"));
            pw = new PrintWriter(new File("datafiles/converted.dat"));
            while (sc.hasNext()) {
                String[] line = sc.nextLine().split("\t");
                int fromBase = Integer.parseInt(line[1]);
                int toBase = Integer.parseInt(line[2]);
                if (fromBase < 2 || fromBase > 16) {
                    System.out.println("Invalid input base " + fromBase);
                } else if (toBase < 2 || toBase > 16) {
                    System.out.println("Invalid input base " + toBase);
                } else {
                    System.out.println(line[0] + " base " + fromBase + " = " + intToStr(strToInt(line[0], line[1]), toBase) + " base " + toBase);
                    pw.print(line[0] + line [1] + "\t" + intToStr(strToInt(line[0], line[1]), Integer.parseInt(line[2])) + "\t" + line[2]);
                    pw.println();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (sc != null)
            sc.close();
        if (pw != null)
            pw.close();
    }
    /**
     * main method for class BaseConverter
     * @param args command line arguments if needed
     */
    // Main method for class BaseConverter. Yours should look just like this!
    public static void main(String[] args) {
        BaseConverter app = new BaseConverter();
        app.inputConvertPrintWrite();
        app.myExtra();
    }
}