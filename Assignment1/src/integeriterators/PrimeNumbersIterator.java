package integeriterators;

public class PrimeNumbersIterator implements IntegerIterator {

	private int currentPrime;
	private int initialStart;

	public PrimeNumbersIterator() {
		// TODO implement me
		this.currentPrime = 2;
		this.initialStart = 2;
	}
	
	public PrimeNumbersIterator(int n) {
		// TODO implement me
		this.initialStart = NextPrime(n);
		this.currentPrime = this.initialStart;
	}
	
	@Override
	public boolean hasNext() {
		// TODO implement me
		return true;
	}
	
	@Override
	public Integer next() {
		// TODO implement me
		int toReturn = this.currentPrime;
		this.currentPrime = this.NextPrime(++currentPrime);
		return toReturn;
	}
	
	public void reset() {
		// TODO implement me
		this.currentPrime = this.initialStart;
	}

	private int NextPrime(int n){
		int num = n;
		while(!isPrime(num))
			num++;
		return num;
    }

	private boolean isPrime(int n){
		if (n <= 1) return false;
		if (n==2) return true;
		if( n% 2 ==0) return false;
		for(int i = 3; i <= Math.sqrt(n); i+=2) {
			if (n % i == 0) return false;
		}
		return true;
	}

}
