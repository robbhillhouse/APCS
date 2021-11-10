import java.text.DecimalFormat;
import java.util.Scanner;

public class BMICalculator {
    /**
     * convert English to metric units, perform the BMI calculation.
     * NOTE you will have to convert the supplied information from the user into the appropriate metric values
     * due 11/9/21
     * @param inches
     * @param pounds
     * @return
     */
    public static double computeBMI(int inches, int pounds) {
        //1 inch == 0.0254 meters
        //1 pound == 0.454 kg
        if (inches <= 0)
            return 0;
        return pounds * .454 / Math.pow(inches * 0.0254, 2);
    }

    public static void main(String[] args) {
        StringInputParser obj = new StringInputParser();
        Scanner in = new Scanner(System.in);
            while (true) {
                try {
                    System.out.print("Enter your height in the format ft'in\": ");
                    String input = in.next();
                    int inches = obj.extractInt(input);
                    System.out.println("Your height is: " + inches);
            /*String input = in.nextLine();
            int x = obj.extractInt(input);
            System.out.println(x);
            x++;
            System.out.println(x);*/
                    DecimalFormat df = new DecimalFormat("0.00");
                    //System.out.print("Enter height: ");
                    //Integer height = in.nextInt();
                    System.out.print("Enter weight: ");
                    int weight = in.nextInt();
                    //print BMI here
                    System.out.println("Your BMI is: " + df.format(computeBMI(inches, weight)));
                    System.out.println("Continue (Y/N): ");
                    String cont = in.next();
                    if (!cont.toLowerCase().equals("y"))
                        break;
                } catch (Exception e) {
                    //System.err.println("your mom does not exist");
                    e.printStackTrace();
            System.out.println("End of program");
            //System.out.println(computeBMI(70, 125));
        }
        }
    }
}
