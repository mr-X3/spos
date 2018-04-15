/**************************************************************************
Assignment No.B1

Problem Statement :- Write a program to create Dynamic Link Library for any mathematical operation and write an application program to test it. (Java Native Interface / Use VB or VC++).

Batch :- 	RollNO :- 
***************************************************************************/
//MathOperation.java
package math;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class MathOPeration {
public static void add(){
	try{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter no1");
	int no1=Integer.parseInt(br.readLine());
	System.out.println("Enter no2");
	int no2=Integer.parseInt(br.readLine());
	System.out.println("Addition is"+(no1+no2));
	}
	catch(Exception e){System.out.println(e);}
}
public static void subtract(){
	try{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter no1");
	int no1=Integer.parseInt(br.readLine());
	System.out.println("Enter no2");
	int no2=Integer.parseInt(br.readLine());
	System.out.println("Subtraction is"+(no1-no2));
	}
	catch(Exception e){System.out.println(e);}
}
public static void multiply(){
	try{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter no1");
	int no1=Integer.parseInt(br.readLine());
	System.out.println("Enter no2");
	int no2=Integer.parseInt(br.readLine());
	System.out.println("Multiplication is"+(no1*no2));
	}
	catch(Exception e){System.out.println(e);}
}
}
//Test.java
import java.io.*;
public class Test {
public static void main(String arg[]) throws IOException{

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
System.out.println("\nOperations you may perform :- \n1.ADD\n2.Mulitply\n3.Subtract\n\nEnter Operation: - ");
		
int choice = Integer.parseInt(br.readLine());
switch(choice){
	case 1: math.MathOPeration.add();
		break;
	case 2: math.MathOPeration.multiply();
		break;
	case 3: math.MathOPeration.subtract();
		break;
	default:System.out.println("Invalid choice") ;
		break;
}
}
}
/****************************************************************
Output :-
aditi@ubuntu:~$ cd Desktop/p1
aditi@ubuntu:~/Desktop/p1$ javac Test.java 
aditi@ubuntu:~/Desktop/p1$ java Test

Operations you may perform :- 
1.ADD
2.Mulitply
3.Subtract

Enter Operation: - 
1
Enter no1
12
Enter no2
23
Addition is35
aditi@ubuntu:~/Desktop/p1$ java Test

Operations you may perform :- 
1.ADD
2.Mulitply
3.Subtract

Enter Operation: - 
2
Enter no1
90
Enter no2
2
Multiplication is180
aditi@ubuntu:~/Desktop/p1$ java Test

Operations you may perform :- 
1.ADD
2.Mulitply
3.Subtract

Enter Operation: - 
3
Enter no1
90  
Enter no2
65
Subtraction is25
aditi@ubuntu:~/Desktop/p1$
******************************************************************/

