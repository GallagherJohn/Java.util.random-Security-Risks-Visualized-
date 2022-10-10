import java.util.*;
public class Project2
{
long seed;
 
 public static void main(String[] args)
 {
 
 Random r = new Random();
 r.setSeed(0);
 int randomNumber = r.nextInt();
 System.out.println("First random number for seed 0: " +
Integer.toHexString(randomNumber) + "\n");
 System.out.println("10 random numbers using java.util.math.Random(): \n");
 for (int i = 0; i < 10; i++)
 {
 System.out.println((i+1) + ": " +
Integer.toHexString(randomNumber));
 randomNumber = r.nextInt();
 }
 
 System.out.println("\nUsing Linear Function exRandom: ");
 System.out.println("(Using numbers from example ontop of page 2 of assignment, we see that the values repeat. x5 = x1 = 1 and x6 = x2 = 8) \n");
 exRandom();
 System.out.println();
 System.out.println("\nTesting linear congruential random number generator: ");
 LCRNG();
 
 // START OF PART TWO CODEEEEEEEE
 System.out.println();
 System.out.println("Test for part two:");
 long firstVal = 0x21e4252f0000L;
 long secondVal = 0x454cd530L; //1162663216 in decimal
 long max = 0x21e4252fffffL;
 
 //incorporating values from java Random() function
 long a = 0x5DEECE66DL; //multiplier
 long m = 281474976710656L; //modulus = 2^48
 long c = 0xBL; //increment = 11 in decimal
 long ran;
 
 for (long i = firstVal; i <= max; i++)
 {
 ran = (((a * i) + c) % m);
 if (Long.toHexString(ran).contains(Long.toHexString(secondVal)))
 {
 System.out.println("This is the value that yields the second value: " + Long.toHexString(i));
 }
 }
 
 // this gives us i = 21e4252f7b65

 System.out.println("Here are the rest of the values: ");
 int count = 0;
 long last = 0x21e4252f7b65L;
 while(count < 10) //this provides the next ten values - EXTRA CREDIT?
 {
 ran = (((a * last) + c) % m);
 System.out.println((count+1) + ": " + Long.toHexString(ran>>>16));
 last = ran;
 count++;
 }
 // END OF PART 2 CODEEEEEEEE
 
 }
 
 public static void exRandom()
 {
 long seed = 0; 
 for (int i = 0; i < 10; i++)
 {
 long ran = ((seed * 7 + 1)%10) ;
 seed = ran;
 System.out.println(ran);
 }
 }
 
 public static void LCRNG()
 {
//formula Xn+1 = (aXn + c) (mod m)
long a = 0x5DEECE66DL; //multiplier
 long m = 281474976710656L; //modulus = 2^48
 long c = 0xBL; //increment = 11 in decimal
 long s = 0L; //seed set to 0
 long x0 = (s ^ a)&(m-1);
 System.out.println("Initial value x0:" + x0);
 System.out.println("Printing first ten values (x1 through x10): ");
 s = (((a * s) + c) % m); //need to do this to initialize x0 for the c value of 11
 int count = 0;
 long last = x0;
 long ran = 0;
 while(count < 10) //this provides x1 through x10
 {
 ran = (((a * last) + c) % m);
 System.out.println((count+1) + ": " + Long.toHexString(ran>>>16));
 last = ran;
 count++;
 }
 
 }
}