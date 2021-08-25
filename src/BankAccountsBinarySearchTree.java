/*---------------------------------------
 Genuine author: <name>, I.D.: <id number>
 Date: xx-xx-2020 
---------------------------------------*/
import java.util.Comparator;
import java.util.Iterator;

public class BankAccountsBinarySearchTree extends BinarySearchTree<BankAccount>{

	public BankAccountsBinarySearchTree(Comparator<BankAccount> myComparator) {
		super(myComparator);
	}
	
	// Complete the following methods
    public void balance(){
		// task 5b
		List<BankAccount> list = new DynamicArray<>();
		Iterator<BankAccount> iter = this.iterator();
		while(iter.hasNext())//Fills the list with the objects by inOrder.
			list.add(iter.next());
		root = null;
		buildBalancedTree(list, 0, list.size()-1);
	}
	// Complete the following methods
	private void buildBalancedTree(List<BankAccount> list, int low, int high){
		// task 5b
		if(high<low)//Base case, there is no more objects to insert
			return;
		int middle = (high - low)/2 + low;
		this.insert(list.get(middle));//Inserts the middle node
		buildBalancedTree(list,low,middle-1);//Do the same recursively with the list from the beginning to middle -1
		buildBalancedTree(list,middle+1,high);//Do the same recursively with the list from middle +1 to the end

	}
}
