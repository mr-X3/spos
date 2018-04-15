/**************************************************************************
Assignment No.B5
Problem Statement :- Write a program using YACC specifications to implement syntax analysis phase of compiler to recognize simple and compound sentences given in input file.
Batch :- 	RollNO :- 
***************************************************************************/


%option noyywrap
%{
char test='s';
%}
%%
(""[aA][nN][dD]"")|(""[oO][rR]"")|(""[bB][uU][tT]"") {test='c';}
. {;}
\n return 0;
%%
int main()
{
yylex();
if(test=='s')
 printf("\n Its a simple sentence\n");
else if(test=='c')
 printf("\n This is compound sentence\n");
return 0;
}



/*****************************************
Output:-
aditi@ubuntu:~/Desktop/program67$ lex  program9.l
aditi@ubuntu:~/Desktop/program67$ gcc lex.yy.c
aditi@ubuntu:~/Desktop/program67$ ./a.out
sky is blue and grass is green 

 This is compound sentence
aditi@ubuntu:~/Desktop/program67$ ./a.out
what is my name?

Its a simple sentence
aditi@ubuntu:~/Desktop/program67$ 
********************************************/
