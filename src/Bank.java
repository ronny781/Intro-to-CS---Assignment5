/*---------------------------------------
 Genuine author: <name>, I.D.: <id number>
 Date: xx-xx-2020 
---------------------------------------*/
public class Bank {

	private BankAccountsBinarySearchTree namesTree;
	private BankAccountsBinarySearchTree accountNumbersTree;

	public Bank() {
		namesTree = new BankAccountsBinarySearchTree(new AccountComparatorByName());
		accountNumbersTree = new BankAccountsBinarySearchTree(new AccountComparatorByNumber());
	}

	public BankAccount lookUp(String name){
		// create an Entry with the given name, a "dummy" accountNumber (1) and zero balance
		// This "dummy" accountNumber will be ignored when executing getData
		BankAccount lookFor = new BankAccount(name, 1, 0);
		return (BankAccount)namesTree.findData(lookFor);
	}

	public BankAccount lookUp(int accountNumber){
		// create an Entry with a "dummy" name, zero balance and the given accountNumber
		// This "dummy" name will be ignored when executing getData
		BankAccount lookFor = new BankAccount("dummy", accountNumber,0);
		return (BankAccount)accountNumbersTree.findData(lookFor);
	}

	// END OF Given code -----------------------------------

	// Complete the methods from here on

	public boolean add(BankAccount newAccount) {
		// task 6a
		boolean hasAdded = false;
		if(lookUp(newAccount.getAccountNumber()) == null & lookUp(newAccount.getName()) == null) {//If both are null it means we it doesn't exist in the trees and we can add it.
			namesTree.insert(newAccount);
			accountNumbersTree.insert(newAccount);
			hasAdded = true;//change the boolean parameter to true
		}
		return hasAdded;

	}

	public boolean delete(String name){
		// this first line is given in the assignment file
		BankAccount toRemove = lookUp(name);
		// complete this:
		boolean hasRemoved = false;
		if(toRemove!=null) {//If toRemove is exist and not null then remove it form both trees.
			namesTree.remove(toRemove);
			accountNumbersTree.remove(toRemove);
			hasRemoved = true;//change the boolean parameter to true
		}
		return hasRemoved;
	}

	public boolean delete(int accountNumber){
		// this first line is given in the assignment file
		BankAccount toRemove = lookUp(accountNumber);
		// complete this:
		boolean hasRemoved = false;
		if(toRemove!=null) {//If toRemove is exist and not null then remove it form both trees.
			namesTree.remove(toRemove);
			accountNumbersTree.remove(toRemove);
			hasRemoved = true;//change the boolean parameter to true
		}
		return hasRemoved;
	}

	public boolean depositMoney(int amount, int accountNumber){
		// task 6d
		boolean hasDeposited = false;
		BankAccount toDeposit = lookUp(accountNumber);
		if(toDeposit!=null) //If toDeposit is null it means the account didn't found.
			hasDeposited = toDeposit.depositMoney(amount);//Returns true if successful.
		return hasDeposited;
	}

	public boolean withdrawMoney(int amount, int accountNumber){
		// task 6e
		boolean hasWithdrawed = false;
		BankAccount toWithdraw = lookUp(accountNumber);
		if(toWithdraw!=null) //If toWithdraw is null it means the account didn't found.
			hasWithdrawed = toWithdraw.withdrawMoney(amount);//Returns true if successful.
		return hasWithdrawed;
	}	
}
