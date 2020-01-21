

Project was done with openjdk-11 and jfx-11.
	my laptop wouldn't run javafx with openjdk-8.
	couldn't download oracle-java-8.

File paths are specific to my computer and thus may not run outside of my laptop.
implementing of relative paths did not work and caused errors.



******************************************************************************************************

UML Diagram are located in UMLDiagrams directory.
Javadoc is located in javadoc directory.

******************************************************************************************************

Each client has a seperate file. The files hold the transactions in total

Negative values for AccountBalance are allowed, not fully ignored. It's a one time overdraft.
User cannot make purchases or withdrawals until account is positive again.
Once positive user can once more go into overdraft.
No limits set to transaction amounts.

Possible implementations:
	1. balance shown without need to click update balance button (on initialization)
	2. admin class can access customer account balances
	3. More Visual appeal
	4. Better implementation of file paths. relative paths would not work for some reason.
	5. label transactions within customer files. 
		-Strong understanding of RegEx, can make it possible to print type of
		 transaction(purchase, withdrawal, or deposit)
		-can lead to search function with type of transaction and value of transaction
