/*---------------------------------------
 Genuine author: <name>, I.D.: <id number>
 Date: xx-xx-2020 
---------------------------------------*/
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrimeIterator implements Iterator<Integer> {

	private List<Integer> primes;

	//Complete the following methods
	public PrimeIterator(){
		// task 0
		primes = new DynamicArray<Integer>();
		primes.add(2);//Initialize the list with the first prime number.
	}

    public boolean hasNext(){
        // task 0
        return primes.get(primes.size()-1) > 0 ;
        // While the number haven't reached to the Max integer value and not got negative due to overflow continue the iteration.
    }

    public Integer next(){
        // task 0
        if(!hasNext())//If there there is no next throw an exception.
            throw new NoSuchElementException();
        int current = primes.get(primes.size()-1);//The last prime we found, return him at the end
        //Meanwhile prepare for the next call and find the next prime number.
        boolean isfound = false;
        int nextPrimeNominee = current+1;//Takes the last prime we found and increases him by one
        while(!isfound) {//While we haven't found a new prime number.
            boolean isprime = true;
            for(int i = 0; i< primes.size() & primes.get(i) <= Math.sqrt(nextPrimeNominee) & isprime ; i++) {

                if(nextPrimeNominee%primes.get(i)==0) {//If the number divides by one of the members of the list he isn't prime.
                    isprime = false;
                    nextPrimeNominee++;//Determine the nominee to be the next natural number
                }
            }
            if(isprime) {//If the loop has finished and isprime is true then we found a new prime number.
                isfound = true;
                primes.add(nextPrimeNominee);//Add him to the list
            }
        }
        return current;
    }
	
	
}
