/*---------------------------------------
 Genuine author: <name>, I.D.: <id number>
 Date: xx-xx-2020 
---------------------------------------*/
import java.util.Comparator;

public class AccountComparatorByNumber implements Comparator<BankAccount>{

	@Override
	public int compare(BankAccount account1, BankAccount account2) {
		// task 2b
		if(account1 == null | account2 == null)//If one of the parameters is null throw an exception.
			throw new IllegalArgumentException("Can't comapre null account");
		return ((Integer)account1.getAccountNumber()).compareTo((Integer)account2.getAccountNumber());//Use the comapreTo of Integer
	}

}
