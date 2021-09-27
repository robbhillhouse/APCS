import java.util.Objects;
import java.util.Scanner;

class ABC_123 {
    /**
     * @author Robert Hillhouse
     * @version 9/28/2021
     */
    public static class SimpleIOMath {
        private String name;
        private int age;
        private int favNumber;

        private int smallestPrime(int num) {
            int smallest = 2;
            for (int i = 2; i <= (int) (Math.sqrt(num)) + 1; i++) {
                if (num % i == 0)
                    return i;
            }
            return num;
        }

        //prompts the user for input
        public void promptUser() {
            Scanner input = new Scanner(System.in);
            System.out.println("* Sit yourself down, take a seat *");
            System.out.println("* All you gotta do is repeat after me *");
            System.out.println("Question 1: What is your name?");
            name = input.nextLine();
            System.out.println("Question 2: How old are you?");
            age = input.nextInt();
            System.out.println("Question 3: What is your favorite number?");
            favNumber = input.nextInt();
        }

        //prints the info from the user input
        public void printInfo() {
            System.out.println("I'm gonna teach you how to sing it out\n" +
                    "Come on, come on, come on\n" +
                    "Let me tell you what it's all about\n" +
                    "Reading, writing, arithmetic\n" +
                    "Are the branches of the learning tree");
            System.out.println("Your name is: " + name);
            System.out.println("Your age is: " + age);
            System.out.println("The first prime factor of " + age + " is: " + smallestPrime(age));
            System.out.println("Your favorite number is: " + favNumber);
            System.out.println("Your favorite number squared is: " + (favNumber * favNumber));
        }

        //if else statement for ubuntu
        public void myExtra() {
            Scanner input = new Scanner(System.in);
            System.out.println("What is your favorite South African Saying: ");
            String saying = input.nextLine();
            if (Objects.equals(saying, "ubuntu")) {
                System.out.println("That's our favorite South African Saying too!");
            } else {
                System.out.println("Well our favorite South African saying is ubuntu");
            }
        }

        //main method
        public static void main(String[] args) {
            SimpleIOMath obj = new SimpleIOMath();
            obj.promptUser();
            obj.printInfo();
            obj.myExtra();
            System.out.println("*end of program*");
        }
    }
}

