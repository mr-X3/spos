/**************************************************************************
Assignment No.A3

Problem Statement :- Design suitable data structures and implement pass-I of a two-pass macro-processor using Python

Batch :- 	RollNO :- 
***************************************************************************/

//macroInput.txt
MACRO
INCR1 &FIRST &SECOND=DATA9
A 1 &FIRST
L 2 &SECOND
MEND
MACRO
INCR2 &ARG1 &ARG2=DATA5
L 3 &ARG1
ST 4 &ARG2
MEND
START
 USING * BASE
 INCR1 DATA1
 INCR2 DATA3 DATA4
FOUR DC F'4'
FIVE DC F'5'
BASE EQU 8
TEMP DS 1F
 DROP 8
 END



Program Code :-

macroIn = open("macroInput.txt","r")

lines = macroIn.readlines()

mntc = 1
mdtc = 0
alac = 0

mnt  = []
ala = []
mdt = []


prev = ""

flag = 0
for line in lines:
	line = line.replace("\n","")
	sp = line.split()

	if prev =="MACRO" and flag == 1:
		mnt.append([mntc,sp[0],mdtc])
		for arg in sp[1:]:
			sa =  arg.split("=")
			if len(sa) == 2:
				ala.append([alac,mntc,sa[0],sa[1]])
			else:
				ala.append([alac,mntc,sa[0]])

			alac += 1
		mntc += 1


	if sp[0].upper() == "MACRO":
		prev = sp[0].upper()
		flag = 1
		
	elif flag == 1:
		prev = sp[0].upper()
		mdt.append(line)
		mdtc += 1
		if sp[0].upper() == "MEND":
			flag = 0

mntFile = open("mnt.txt","w")
print "\n MNT Table"
for m in mnt:
	print m


print "\n argument list table"
for arg in ala:
	print arg

print "\n macro definition table"
for l in mdt:
	print l


/****************************************************
Output :-

aditi@ubuntu:~/Desktop/SPOSA/a3$ python macroPassOne.py 

 MNT Table
[1, 'INCR1', 0]
[2, 'INCR2', 4]

 argument list table
[0, 1, '&FIRST']
[1, 1, '&SECOND', 'DATA9']
[2, 2, '&ARG1']
[3, 2, '&ARG2', 'DATA5']

 macro definition table
INCR1 &FIRST &SECOND=DATA9
A 1 &FIRST
L 2 &SECOND
MEND
INCR2 &ARG1 &ARG2=DATA5
L 3 &ARG1
ST 4 &ARG2
MEND
aditi@ubuntu:~/Desktop/SPOSA/a3$ 

*******************************************************/








