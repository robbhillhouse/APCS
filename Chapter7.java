public class Chapter7 {
    public static int months(int i) {
        double val = 100;
        int months = 0;
        while(val > 5) {
            val -= (.1*val);
            months ++;
    return months;
    }
        return months;
    }
    public static int maxChange(int num) {
        int q = 0, d = 0, n = 0, p = 0;
        int count = 0;
        for(q = 0; 25*q <= num; q++) {
            for(d = 0; 10*d+25*q <= num; d++) {
                for(n = 0; 5*n+10*d+25*q <= num; n++) {
                    p = num - (q * 25 + d * 10 + n * 5);
                    count ++;
                    //System.out.println(num + "¢ " + q + " quarters " + d + " dimes " + n + " nickels " + p + " pennies ");
                }
            }
        }
        System.out.println("Permeutations = "+ count);
        /*p = num - (q*25 + d*10 + n*5);
        n = num - (q*25 + d*10 + p);
        d = num - (q*25 + n + p);
        q = num - (d + n + p);
        System.out.println(p, n, d, q);
        return num;*/
        return num;
    }
    public static int sumDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    public static void main(String[] args)  {
        // determinate loop - for loop
        // the code will repeat FOR x times
        // initialization of a counter variable
        // limit test/boolean condition
        // incrementation
        System.out.println(months(7));
        System.out.println(maxChange(100));
        /*System.out.println(sumDigits(5128));
        for(int i = 0; i < 10; i ++)  {
            System.out.print(i + " ");
        }
        System.out.print("who do we appreciate");

        int[] nums = {2, 4, 6, 8};
        // for each loop
        // repeat for each item in a list or array
        for(int a : nums)   {
            System.out.print(a + " ");
        }
        System.out.println("who do we appreciate");

        String[] myBruhs = {"Charith", "Charith", "Pete", "Zebee", "Nikolas"};

        boolean dupe = false;
        for (int out = 0; out < myBruhs.length; out++)  {
            for(int in = out+1; in < myBruhs.length; in++)  {
                if (myBruhs[out].equals(myBruhs[in]))   {
                    System.out.println(myBruhs[out] + " has a duplicate");
                    dupe = true;
                }
            }
        }

        if (!dupe)  {
            System.out.println("No duplicates");
        }

        Scanner in = new Scanner(System.in);
        double popMex = 123.8;
        double input;
        int year = 2014;
        System.out.println("give me a number: ");
        input = in.nextDouble();
        while(popMex <= input) {
            year += 1;
            double growth = popMex * 0.005;
            popMex += growth;
        }
        System.out.println(year);


        // for each loop
        for(String s : myBruhs)
            System.out.print(s + " ");
            System.out.println();
            // counter-driven loop
        for(int i = myBruhs.length-1; i >= 0; i--)
            System.out.print(myBruhs[i] + " ");
        System.out.println();

        int num = 5128, sum = 0;
        while(num > 0)  {
            sum += num % 10;
            num /= 10;
        }
        System.out.println(sum);

        /*
        num = 5128
        sum = 0
        while num > 0:
            sum += num % 10
            num //= 10
         print(sum)
         */
        /*Scanner in = new Scanner(System.in);
        String input;
        do {
            System.out.println("Lars are you kidding? ");
            input = in.nextLine();
        }   while(input.toLowerCase().equals("no"));

        while(true) {
            System.out.print("keep going? ");
            input = in.nextLine();
            if(input.equals("no"))
                break;
            else if(input.equals("yes"));
            continue;
            //else if(input.equals());*/

        }
}
