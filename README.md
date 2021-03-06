﻿# Visitor-Prototype-Observer-Design-Pattern-Word-Count

Date: Wednesday, November 23, 2016
Author: Sandesh Nimhan
E-mail: snimhan1@binghamton.edu


PURPOSE:
[
	Understanding and implementing Visitor, Prototype, Observer Design Pattern. By developing an efficient system to count words in a large file and fully functional backup generation system. (Back up of BST data structure is created and is updated immediately on node level if any changes made to the old one.)
]

DATA STRUCTURE:
[
	Binary Search Tree: each node contains unique word and its necessary attributes
	Its fast and easy to iterate through BST than normal tree. Height of tree is less as it is balanced. 
	Time complexity is O(n) as with search for a word in tree.
]


TO COMPILE:
[
	ant all 
]

TO RUN: 
[
	ant run -Darg0=input.txt -Darg1=output.txt -Darg2=100
]

[
-Darg2 : Number of Interations, to test the efficiency of 1st two visitors (populate_Data_Structure_Visitor and word_Count_Visitor) in milliseconds
]

SAMPLE OUTPUT:

[ 
	Total words: 10123
	Distinct words: 3152
	Character count: 43474
]
Output of 4th visitor is shown on console.
Two small input files input1.txt and input2.txt are provided to test it.
