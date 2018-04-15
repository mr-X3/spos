/**************************************************************************
Assignment No.C2

Problem Statement :- Write a Java program to implement Banker‘s Algorithm 

Batch :- 	RollNO :- 
***************************************************************************/

import java.io.*;
public class banker{
	public static void main(String[] str) throws IOException{
		BufferedReader read=new BufferedReader(new InputStreamReader(System.in));
		int n,m,k,avail[],allo[][],max[][],need[][],flag[];
		System.out.println("Enter number of processes :-");
		n=Integer.parseInt(read.readLine());
		//page=new int[n];
		System.out.println("Enter number of resouces :-");
		m=Integer.parseInt(read.readLine());
		//frames=new int[f];
		flag=new int[n];
		avail=new int[m];
		
		allo=new int[n][m];
		max=new int[n][m];
		need=new int[n][m];

		System.out.println("Enter Resouces Available :-");
		for(int i=0;i<m;i++){
			System.out.println("Resource "+i+"=");
			k=Integer.parseInt(read.readLine());
			avail[i]=k;
		}
		
		System.out.println("\n\nEnter values for max[][] matrix");
		for(int i=0;i<n;i++){
			flag[i]=0;
			for(int j=0;j<m;j++){
			System.out.println("P"+i+"&R"+j+" = ");
			k=Integer.parseInt(read.readLine());
			max[i][j]=k;
			}
		}	

		System.out.println("\n\nEnter values for allocation[][] matrix");
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
			System.out.println("P"+i+"&R"+j+" = ");
			k=Integer.parseInt(read.readLine());
			allo[i][j]=k;
			}
		}

		//calculating need matrix
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++)
			need[i][j]=max[i][j]-allo[i][j];
		}

//Displaying result
		System.out.println("\n----------------------\nMAX[][] matrix");
		for(int i=0;i<n;i++){
			
			for(int j=0;j<m;j++){
			System.out.print(max[i][j]+"\t");
			}
			System.out.println();
		}	
		
		System.out.println("\n----------------------\nALLOCATION[][] matrix");
		for(int i=0;i<n;i++){
			
			for(int j=0;j<m;j++){
			System.out.print(allo[i][j]+"\t");
			}
			System.out.println();
		}	

		System.out.println("\n----------------------\nNEED[][] matrix");
		for(int i=0;i<n;i++){
			
			for(int j=0;j<m;j++){
			System.out.print(need[i][j]+"\t");
			}
			System.out.println();
		}			

		//finding safe state
		for(int i=0;i<n;i++){
			if(flag[i]==0 && need[i][0]<=avail[0]){
				System.out.println("\nProcess"+(i+1)+" executed");
				for(int j=0;j<m;j++){
					avail[j]=avail[j]+allo[i][j];
					System.out.print(avail[j]+"\t");}
				flag[i]=1;
			}
			}
}
	}
/****************************************************
Output :-

aditi@ubuntu:~/Desktop/SPOSCD$ javac banker.java
aditi@ubuntu:~/Desktop/SPOSCD$ java banker
Enter number of processes :-
5
Enter number of resouces :-
3
Enter Resouces Available :-
Resource 0=
3
Resource 1=
3
Resource 2=
2


Enter values for max[][] matrix
P0&R0 = 
7
P0&R1 = 
5
P0&R2 = 
3
P1&R0 = 
3
P1&R1 = 
2
P1&R2 = 
2
P2&R0 = 
9
P2&R1 = 
0
P2&R2 = 
2
P3&R0 = 
2
P3&R1 = 
2
P3&R2 = 
2
P4&R0 = 
4
P4&R1 = 
3
P4&R2 = 
3


Enter values for allocation[][] matrix
P0&R0 = 
0
P0&R1 = 
1
P0&R2 = 
0
P1&R0 = 
2
P1&R1 = 
0
P1&R2 = 
0
P2&R0 = 
3
P2&R1 = 
0
P2&R2 = 
2
P3&R0 = 
2
P3&R1 = 
1
P3&R2 = 
1
P4&R0 = 
0
P4&R1 = 
0
P4&R2 = 
2

----------------------
MAX[][] matrix
7	5	3	
3	2	2	
9	0	2	
2	2	2	
4	3	3	

----------------------
ALLOCATION[][] matrix
0	1	0	
2	0	0	
3	0	2	
2	1	1	
0	0	2	

----------------------
NEED[][] matrix
7	4	3	
1	2	2	
6	0	0	
0	1	1	
4	3	1	

Process2 executed
5	3	2	
Process4 executed
7	4	3	
Process5 executed
7	4	5	
aditi@ubuntu:~/Desktop/SPOSCD$
**********************************************************/

