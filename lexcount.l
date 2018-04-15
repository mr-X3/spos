/**************************************************************************
Assignment No.B3
Problem Statement :- Write a program using Lex specifications to implement lexical analysis phase of compiler to count no. of words, lines and characters of given input file.
Batch :- 	RollNO :- 
***************************************************************************/
%{
#include<stdio.h>
int ch=0, bl=0, ln=0, wr=0;
%}
%%
[\n] {ln++;wr++;}
[\t] {bl++;wr++;}
[" "] {bl++;wr++;}
[^\n\t] {ch++;}
%%
int yywrap(void)
{
	return 1;
}
int main()
{
FILE *fp=fopen("input.txt","r"); 
char file[10];
yyin=fp;
yylex();
printf("\nTotal No. of Characters are=%d\nTotal No. of Blank Spaces=%d\nTotalNo.of Lines=%d\nTotalNo.ofWords=%d\n",ch,bl,ln,wr);
return 0;
}
//input.txt
gescoe te computer
god is great
gescoe te computer
god is great
gescoe te computer
god is great
gescoe te computer
god is great

/********************************************
Output :-
aditi@ubuntu:~/Desktop/program67$ lex  program7.l
aditi@ubuntu:~/Desktop/program67$ gcc lex.yy.c
aditi@ubuntu:~/Desktop/program67$ ./a.out

Total No. of Characters are=104
Total No. of Blank Spaces=16
TotalNo.of Lines=8
TotalNo.ofWords=24
aditi@ubuntu:~/Desktop/program67$ 

*********************************************/

