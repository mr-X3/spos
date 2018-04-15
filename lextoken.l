/**************************************************************************
Assignment No.B2

Problem Statement :- Write a program using Lex specifications to implement lexical analysis phase of compiler to generate tokens of subset of 'Java' program.

Batch :- 	RollNO :- 
***************************************************************************/

Program Code :-

%{
#include<stdio.h>
%}

%%
float|int|char|double|long|void|include|typedef printf("%s IS A KEYWORD\n",yytext);
["|(|)|{|}|#|;|,|%|&] printf("%s IS A SPECIAL SYMBOL\n",yytext);
["]+[a-zA-Z0-9]+["] printf("%s IS A MESSAGE\n", yytext);
[a-zA-Z] printf("%s IS A STRING CONSTANT\n", yytext);
[+|-|*|/] printf("%s IS A ARITHMATIC OPERATOR\n", yytext);
[a-zA-Z]*.h printf("%s IS A HEADER FILE\n", yytext);
[a-zA-Z]+[a-zA-Z0-9]* printf("%s IS AN IDENTIFIER\n", yytext);
[0-9]+ printf("%s IS A CONSANT\n", yytext);
= printf("%s IS AN ASSIGNMENT OPERATOR \n", yytext);
[<|>|<=|>=|<>] printf("%s IS A RELATIONAL OPERATOR\n", yytext);
[&&|!=|==] printf("%s IS A LOGICAL OPERATOR\n", yytext);
%%

int yywrap(void)
{
	return 1;
}

int main()
{
	FILE *fp = fopen("crc.cpp","r");
	yyin = fp;
	yylex();
	yywrap(); 
	return 0;
}






//crc.cpp
#include <iostream.h>
int main()
{
    int i,j,k,l;
     
    //Get Frame
    int fs;
    cout<<"\n Enter Size of data: ";
    cin>>fs;
     
    int f[20];
     
    cout<<" Enter data:";
    for(i=0;i<fs;i++)
    {
        cin>>f[i];
    }
return 0;
}
/**********************************************
Output :-
aditi@ubuntu:~/Desktop/program67$ lex  program6.l
aditi@ubuntu:~/Desktop/program67$ gcc lex.yy.c 
aditi@ubuntu:~/Desktop/program67$ ./a.out
# IS A SPECIAL SYMBOL
include IS A KEYWORD
 < IS A RELATIONAL OPERATOR
iostream.h IS A HEADER FILE
> IS A RELATIONAL OPERATOR
int IS A KEYWORD
 main IS AN IDENTIFIER
( IS A SPECIAL SYMBOL
) IS A SPECIAL SYMBOL
{ IS A SPECIAL SYMBOL
int IS A KEYWORD
 i IS A STRING CONSTANT
, IS A SPECIAL SYMBOL
j IS A STRING CONSTANT
, IS A SPECIAL SYMBOL
k IS A STRING CONSTANT
, IS A SPECIAL SYMBOL
l IS A STRING CONSTANT
; IS A SPECIAL SYMBOL
/ IS A ARITHMATIC OPERATOR
/ IS A ARITHMATIC OPERATOR
Get IS AN IDENTIFIER
 Frame IS AN IDENTIFIER
int IS A KEYWORD
 fs IS AN IDENTIFIER
; IS A SPECIAL SYMBOL
cout IS AN IDENTIFIER
< IS A RELATIONAL OPERATOR
< IS A RELATIONAL OPERATOR
" IS A SPECIAL SYMBOL
\n IS A STRING CONSTANT
 Enter IS AN IDENTIFIER
 Size IS AN IDENTIFIER
 of IS AN IDENTIFIER
 data IS AN IDENTIFIER
: " IS A SPECIAL SYMBOL
; IS A SPECIAL SYMBOL
cin IS AN IDENTIFIER
> IS A RELATIONAL OPERATOR
> IS A RELATIONAL OPERATOR
fs IS AN IDENTIFIER
; IS A SPECIAL SYMBOL
 int IS A KEYWORD
 f IS A STRING CONSTANT
[20 IS A CONSANT
]; IS A SPECIAL SYMBOL
 cout IS AN IDENTIFIER
< IS A RELATIONAL OPERATOR
< IS A RELATIONAL OPERATOR
" IS A SPECIAL SYMBOL
 Enter IS AN IDENTIFIER
 data IS AN IDENTIFIER
:" IS A SPECIAL SYMBOL
; IS A SPECIAL SYMBOL
for IS AN IDENTIFIER
( IS A SPECIAL SYMBOL
i IS A STRING CONSTANT
= IS AN ASSIGNMENT OPERATOR 
0 IS A CONSANT
; IS A SPECIAL SYMBOL
i IS A STRING CONSTANT
< IS A RELATIONAL OPERATOR
fs IS AN IDENTIFIER
; IS A SPECIAL SYMBOL
i IS A STRING CONSTANT
+ IS A ARITHMATIC OPERATOR
+ IS A ARITHMATIC OPERATOR
) IS A SPECIAL SYMBOL

    { IS A SPECIAL SYMBOL

        cin IS AN IDENTIFIER
> IS A RELATIONAL OPERATOR
> IS A RELATIONAL OPERATOR
f IS A STRING CONSTANT
[i IS A STRING CONSTANT
]; IS A SPECIAL SYMBOL

    } IS A SPECIAL SYMBOL
return IS AN IDENTIFIER
 0 IS A CONSANT
; IS A SPECIAL SYMBOL
} IS A SPECIAL SYMBOL
***********************************************/

