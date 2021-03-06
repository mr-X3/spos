package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SJF {
	public static BufferedReader br;
	static int p;
	static int pid[];
	static int pri[];
	static int at[];
	static int bt[];
	static int ct[];
	static int tat[];
	static int wt[];
	static int k[];
	static int i;
	private static float avg;

	
	public static void sjf(int num) throws IOException
	{
		br = new BufferedReader(new InputStreamReader(System.in));
		int st=0,tot=0;
		int f[] = new int[num];  // f means it is flag it checks process is completed or not
		
		System.out.println("Enter the Arrival Time for Each Process: ");
		for(i=0;i<num;i++)
		{
			pid[i]=i+1;
			System.out.println("Enter AT for process "+(i+1));
			at[i] = Integer.parseInt(br.readLine());
		}			
		System.out.println("Enter the BURST Time : ");
		for(i=0;i<num;i++)
		{
			System.out.println("Enter BT for process "+(i+1));
			bt[i] = Integer.parseInt(br.readLine());
			k[i]= bt[i];
			f[i]= 0;							
		}	
		//arranging according to burst time
		while(true)
		{
			int min=99,c=num;
			if (tot==num)
				break;
			for ( i=0;i<num;i++)
			{
				if ((at[i]<=st) && (f[i]==0) && (k[i]<min))
				{	
					min=k[i];
					c=i;
				}
			}
			
			if (c==num)
				st++;
			else
			{
				k[c]--;
				st++;
				if (k[c]==0)
				{
					ct[c]= st;
					f[c]=1;
					tot++;
				}
			}
		}
		int sum=0;
		for(i=0;i<num;i++)
		{
			tat[i] = ct[i] - at[i];
			wt[i] = tat[i] - bt[i];
			sum+= wt[i];
			//avgta+= ta[i];
		}
		System.out.println("\nProcess\tAT\tBT\tCT\tTAT\tWT");
		for (int j=0;j<num;j++)
		{
			System.out.println(pid[j]+"\t"+at[j]+"\t"+bt[j]+"\t"+ct[j]+"\t"+tat[j]+"\t"+wt[j]);
		}
		avg=sum/num;
		System.out.println("\nAverage Waiting Time = "+ avg);
	}

	public static void main(String[] args) {
		try
		{
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the no of Processes: - ");
			p = Integer.parseInt(br.readLine());
				
			at = new int[p];
			bt = new int[p];
			ct = new int[p];
			tat = new int[p];
			wt = new int[p];
			pid = new int[p];
			pri = new int[p];
			k= new int[p];   // it is also stores brust time
			
			sjf(p);			
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
	}
}

//output
Enter the no of Processes: - 
2
Enter the Arrival Time for Each Process: 
Enter AT for process 1
3
Enter AT for process 2
4
Enter the BURST Time : 
Enter BT for process 1
5
Enter BT for process 2
4

Process	AT	BT	CT	TAT	WT
1	3	5	8	5	0
2	4	4	12	8	4

Average Waiting Time = 2.0
