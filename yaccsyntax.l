/**************************************************************************
Assignment No.B4
Problem Statement :- Write a program using YACC specifications to implement syntax analysis phase of compiler to validate type and syntax of variable declaration in Java.
Batch :- 	RollNO :- 
***************************************************************************/
//Lex Program
%{
#include<stdio.h>
#include "y.tab.h"
%}
%%
int|float|char return BUILTIN;
"," return COMMA;
";" return SC;
[a-zA-Z]+[a-zA-Z0-9]* return ID;
\n return 0;
%%
//YACC Program
%{
#include<stdio.h>
void yyerror(char*);
%}
%token ID BUILTIN SC NL COMMA
%%
start :BUILTIN varlist SC {printf("valid varible declaration\n");}
|
varlist :varlist COMMA ID
|
ID;
%%
void yyerror(char *str)
{
printf("%s \n",str);
}
int yywrap()
{
return 0;
}
int main(void)
{
yyparse();
return 0;
}










/***************************************************************
Output :-
aditi@ubuntu:~/Desktop/SPOSB$ lex prog8.l
aditi@ubuntu:~/Desktop/SPOSB$ yacc -d prog8.y
aditi@ubuntu:~/Desktop/SPOSB$ cc -c lex.yy.c y.tab.c
aditi@ubuntu:~/Desktop/SPOSB$ cc -o parser lex.yy.o y.tab.o -ll
aditi@ubuntu:~/Desktop/SPOSB$ ./parser
char str,str1[];
 []valid varible declaration
aditi@ubuntu:~/Desktop/SPOSB$ ./parser
int a;
 valid varible declaration
aditi@ubuntu:~/Desktop/SPOSB$ ./parser
int a,b,c
 syntax error 
aditi@ubuntu:~/Desktop/SPOSB$
***************************************************************/

