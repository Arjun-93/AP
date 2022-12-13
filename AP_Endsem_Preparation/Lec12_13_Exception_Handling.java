package AP_Endsem_Preparation;

import java.io.IOException;
import java.util.Scanner;

public class Lec12_Exception_Handling {
    public static void main(String[] args) {

    }
}

class GFG{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        int[] arr = new int[4];
        System.out.println("Input your 12th class percentage");
        try{
            double val = sc.nextDouble();
            if(val>100 | val<0){
                throw new ArithmeticException("The Percentage value must be between 0 to 100");
            }
            int i = arr[3];
            System.out.println("Inside try block");
            // for throwing pre defined exception we have to use "throw" keyword

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println(e);
            e.printStackTrace();
        } finally {
            System.out.println("Finally Block Executed");
        }
        System.out.print("Outside try catch block");
    }
}
/*
There are two types of Exception
These functions are called checked exceptions. The remaining exceptions are called
unchecked exceptions.
If a function has a checked exception, the compiler won’t compile unless the exception is
either handled or the function is declared as a function that throws the exception.
 Error and Runtime Exception are unchecked Exception

 All others are checked exception.
 */