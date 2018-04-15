/**************************************************************************
Assignment No.D

Problem Statement :- Write a Java Program (using OOP features) to implement paging simulation using 
1. Least Recently Used (LRU)
2. Optimal algorithm

Batch :- 	RollNO :- 
***************************************************************************/

import java.io.*;
public class Paging {
	BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
	int n, page[], f, frames[], faults, count;
	double rate;
	public Paging() throws IOException{
		System.out.println("Enter number of pages");
		n=Integer.parseInt(input.readLine());
		page=new int[n];
		System.out.println("Enter number of page frames");
		f=Integer.parseInt(input.readLine());
		frames=new int[f];
		count=1;
	}

	void reset()
	{
		int j;
		for(j=0;j<f;j++)
		frames[j]=0;
		faults=0;
		count=1;
	}

	void read() throws IOException
	{
		int i;
		System.out.println("Enter the pages");
		for(i=0;i<n;i++)
		{
		System.out.println("Enter page number "+(i+1));
		page[i]=Integer.parseInt(input.readLine());
		}
		for(i=0;i<f;i++)
		frames[i]=-1;
	}

	//LRU algorithm
	void lru()
	{
		int i,j,duration[],max;
		reset();
		duration=new int[f];
		boolean found=false;
		for(i=0;i<n;i++)
		{
			for(j=0;j<f;j++)duration[j]++;
			for(j=0;j<f;j++)
			{
				if(page[i]==frames[j])
				{
					found=true;
					duration[j]=0;
				}
			}
			if(found==false)
			{
				max=0;
				for(j=0;j<f;j++)
				{
					if(duration[j]>duration[max])
						max=j;
				}
				frames[max]=page[i];
				duration[max]=0;
				faults++;
			}
		display();
		found=false;
		}
		System.out.println("Number of page faults = "+faults);
		System.out.println("Fault rate = "+(faults*1.0/n));
	}

	//optimal algorithm
	void opt()
	{
		int i,j=0,k,duration[],max,flag[];
		reset();
		duration=new int[f];
		flag=new int[f];
		boolean found=false;
		for(i=0;i<n;i++)
		{
		for(j=0;j<f;j++)
		{
		flag[j]=0;
		duration[j]=n;
		}
		for(k=i+1;k<n;k++)
		{for(j=0;j<f;j++)
		if(page[k]==frames[j]&&flag[j]==0)
		{
		duration[j]=k;
		flag[j]=1;
		}
		}
		for(j=0;j<f;j++)
		if(page[i]==frames[j])
		found=true;
		if(found==false)
		{
		max=0;
		for(j=0;j<f;j++)
		{
		if(duration[j]>duration[max])
		max=j;
		if(frames[j]<0)
		{
		max=j;
		break;
		}
		}
		frames[max]=page[i];
		faults++;
		}
		display();
		found=false;
		}
		System.out.println("Number of page faults = "+faults);
		System.out.println("Fault rate = "+(faults*1.0/n));
	}

	//display result
	void display()
	{
		int i;
		System.out.print("Page frame "+count+" :");
		for(i=0;i<f;i++)
		{
		if(frames[i]==-1)
		System.out.print(" -");
		else
		System.out.print(" "+frames[i]);
		}
		System.out.print("\n");count++;
	}

public static void main(String[] args) throws IOException{
		int option;
		String choice;
		Paging p=new Paging();
		p.read();
		BufferedReader input=new BufferedReader(new
		InputStreamReader(System.in));
		do
		{
			System.out.println("Menu");
			System.out.println("1. LRU");
			System.out.println("2. OPT");
			System.out.println("Enter option");
			option=Integer.parseInt(input.readLine());
			switch(option)
			{

			case 1: p.lru();
			break;
			case 2: p.opt();
			break;
			default: System.out.println("Invalid input");
			}
			System.out.println("Press Y to continue");
			choice=input.readLine();
		}while(choice.compareToIgnoreCase("y")==0);

	}
}
/**************************************************************
Output :-

aditi@ubuntu:~/Desktop$ javac Paging.java 
aditi@ubuntu:~/Desktop$ java Paging 
Enter number of pages
12
Enter number of page frames
3
Enter the pages
Enter page number 1
2
Enter page number 2
3
Enter page number 3
2
Enter page number 4
1
Enter page number 5
5
Enter page number 6
2
Enter page number 7
4
Enter page number 8
5
Enter page number 9
3
Enter page number 10
2
Enter page number 11
5
Enter page number 12
2
Menu
1. LRU
2. OPT
Enter option
1
Page frame 1 : 2 0 0
Page frame 2 : 2 3 0
Page frame 3 : 2 3 0
Page frame 4 : 2 3 1
Page frame 5 : 2 5 1
Page frame 6 : 2 5 1
Page frame 7 : 2 5 4
Page frame 8 : 2 5 4
Page frame 9 : 3 5 4
Page frame 10 : 3 5 2
Page frame 11 : 3 5 2
Page frame 12 : 3 5 2
Number of page faults = 7
Fault rate = 0.5833333333333334
Press Y to continue
Y
Menu
1. LRU
2. OPT
Enter option
2
Page frame 1 : 2 0 0
Page frame 2 : 2 3 0
Page frame 3 : 2 3 0
Page frame 4 : 2 3 1
Page frame 5 : 2 3 5
Page frame 6 : 2 3 5
Page frame 7 : 4 3 5
Page frame 8 : 4 3 5
Page frame 9 : 4 3 5
Page frame 10 : 2 3 5
Page frame 11 : 2 3 5
Page frame 12 : 2 3 5
Number of page faults = 6
Fault rate = 0.5
Press Y to continue
N
aditi@ubuntu:~/Desktop$ 

***************************************************************/

