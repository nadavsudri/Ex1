This is my solution to Ex1 from CS 101;
this program recives 2 Strings of different base numbers and a int base, calculates the sum and multiplication, and shows the results in the form of the given base.
then prints the values in a "List" form {x1,x2,x3,x4} and prints the biggest number.
my solution first checks if the strings entered are in a valid format, and will not move on unless the number is indeed valid.
the solution is based on the tamplate provided in the assiment sheet (https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/edit?usp=sharing&ouid=113711744349547563645&rtpof=true&sd=true), and some other side methoods i wrote.
every methood has explanatory comments, and a test methood provided on the Ex1Test.java file.
in any given momnet, user can type 'quit' for the program to stop.

Here's an example output for provided an invalid String "12118b7" :
________________________________________________________________________
Enter first number in a valid format (Type 'quit' to exit)': -> 12118b7

Number = 12118b7| is valid?: false| Value: -1
Err: Not a valid number: 12118b7
________________________________________________________________________

Here's an example output for provided Strings {"12118b9" , "AA12bG"} (both valid) and the int base 12:
________________________________________________________________________

Enter first number in a valid format (Type 'quit' to exit)': -> 12118b9

Number = 12118b9| is valid?: true| Value: 8117

Enter second number in a valid format (Type 'quit' to exit)': -> AA12bG

Number = AA12bG| is valid?: true| Value: 43538

Enter a base to calculate (Range [2,16]): -> 12


12118b9 + AA12bG = 25A87bC
12118b9 * AA12bG = 9A42884AbC

Max number From [12118b9,AA12bG,25A87bC,9A42884AbC]
is: 9A42884AbC --> 353397946 in decimal

_______________The_End_____________
________________________________________________________________________

