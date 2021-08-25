import java.util.Iterator;
import java.util.NoSuchElementException;



public class ThresholdBankAccountsIterator implements Iterator<BankAccount> {

	private BinaryTreeInOrderIterator<BankAccount> iterator;
	private BankAccount current;
	private int balanceThreshold;

	public ThresholdBankAccountsIterator(BankAccountsBinarySearchTree bankAccountsTree, int balanceThreshold) {
		// task 5c
		this.balanceThreshold = balanceThreshold;
		this.iterator = (BinaryTreeInOrderIterator<BankAccount>) bankAccountsTree.iterator();
		if(!iterator.hasNext())
			current = null;//If the tree is empty assign current to be null.
		else {
			this.current = iterator.next();
			while(current.getBalance()<balanceThreshold & iterator.hasNext())//Make sure the first current meets the condition.
				this.current = iterator.next();
			if(current.getBalance()<balanceThreshold)//If there is no one that meets the condition, assign current to be null.
				current = null;
		}
	}

	//Complete the following method
	@Override
	public boolean hasNext() {
		// task 5c
		return current!=null;//While current isn't null return true.
	}

	//Complete the following method
	@Override

	public BankAccount next() {
		// task 5c
		if(!hasNext())//If there is no next throw an exception
			throw new NoSuchElementException();
		boolean isFound = false; //Is there another BankAccount that meets the condition?
		BankAccount currToReturn = current;//Holds the last found BankAccount 
		while(iterator.hasNext() & !isFound) {//Prepare the next BankAccount that meets the condition
			current = iterator.next();
			if(current.getBalance()>=balanceThreshold){//If we found a BankAccount that meets the condition, the assign true to isFound.
				isFound = true;
			}
			if(!isFound)//If we haven't found any number it means we finish iterating so there is no next one. Then set current to be null.
				current= null;
		}
		return currToReturn;
	}
}
