# Java.util.random-Security-Risks-Visualized-
Simple Python program which demonstrates vulnerabilities of the Java.util.random and nextInt()
Linear congruential random number generators should never be used in any cryptographic
algorithm because they suffer from several weaknesses. An adversary who has the internal
state of a linear congruential random number generator can predict the result of all future calls
to the random number generator. The results of subsequent calls to a linear congruential
random number generator are always dependent; recall that the definition of a random bit
generator (p. 24) requires subsequent values to be independent.
Linear congruential random number generators use four parameters:
•the modulus;
•the multiplier;
•the increment; and
•the starting value.

The Java class Random (https://docs.oracle.com/javase/8/docs/api/java/util/Random.html)
uses a linear congruential random number generator with the following values.
•modulus = 2^48
•multiplier = 25214903917 = 0x5DEECE66D
increment = 11
The initial value is determined from a seed, which is passed when the class is instantiated. The
seed is a long variable.


Write a Java program that sets the seed to 0, and uses the nextInt method of
java.util.Random to generate 10 integers. Print the results in hexadecimal.
Implement the linear congruential random number generator with the choice of modulus,
multiplier, and increment matching the values for the Java class Random. Have your program
return just the highest 32 bits and return the first 10 values. Show that your answer matches
the result obtained from the nextInt method of java.util.Random.
To understand the reason that Linear Congruential Random Number Generators are not used
for security, suppose that you know that a Java program is using the random number generator
java.util.Random with the method nextInt and that the last two values produced were
0x21e4252f and 0x454cd530. Determine the next 8 values. Conclude that if an adversary
is able to determine two consecutive outputs from java.util.Random that all subsequent
values are known.
