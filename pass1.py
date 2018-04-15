/*******************************************************************
Assignment No.A1

Problem Statement :- Design suitable data structures and implement pass-I of a two-pass assembler for pseudo-machine in Python. Implementation should consist of a few instructions from each category and few assembler directives.

Batch :- 	RollNo :- 
*********************************************************************/

//input.txt
START  101
MOVER  BREG  ONE  
AGAIN  MULT  BREG  TERM  
MOVER  CREG  TERM 
ADD  CREG  N  
MOVEM  CREG  TERM  
N  DS  2
RESULT  DS  2    
ONE  DC  1    
TERM  DS  1    
END

//opcode.txt
MOVER 1
MULT 2
ADD 3
MOVEM 4

Program Code :-

inCode =open("input.txt","r")
opCodeFile = open("opcode.txt","r")

opLines = opCodeFile.readlines()

opCodes = {}
for line in opLines:
line = line.replace("\n","")
sp = line.split()
opCodes[sp[0]] = sp[1]


line1 = inCode.readline()

sp = line1.split()

location_counter = int(sp[1])

cnt =0 

symbol_tables = {}

lines = inCode.readlines()

for line in lines:

line = line.replace("\n","")
sp = line.split()

ifsp[0] == "END":
break
elifsp[0] in opCodes:
location_counter += 1
elifsp[1] == "DS" or sp[1] == "DC":
        d = int(sp[2])
location_counter += d
symbol_tables[sp[0]] = location_counter

else:
symbol_tables[sp[0]] = location_counter
location_counter += 1

print "symbol_table"
printsymbol_tables


/**************************************************
Output :-

aditi@ubuntu:~/Desktop/SPOSA/a1$ python pass1.py
symbol_table
{'AGAIN': 102, 'TERM': 112, 'ONE': 111, 'RESULT': 110, 'N': 108}
aditi@ubuntu:~/Desktop/SPOSA/a1$ 

**************************************************/





