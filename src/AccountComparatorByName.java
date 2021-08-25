/*---------------------------------------
 Genuine author: <name>, I.D.: <id number>
 Date: xx-xx-2020 
---------------------------------------*/
import java.util.Comparator;

public class AccountComparatorByName implements Comparator<BankAccount>{

	@Override
    public int compare(BankAccount account1, BankAccount account2) {
		// task 2a
		if(account1 == null | account2 == null)//If one of the parameters is null throw an execption
			throw new IllegalArgumentException("Can't comapre null account");
		return account1.getName().compareTo(account2.getName());

	}

}
