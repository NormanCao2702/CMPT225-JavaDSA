package integeriterators;

import java.util.NoSuchElementException;

public class ArrayIterator implements IntegerIterator
{
	private int[] ar;
	private int currentIndex;
	private boolean isCircular;
	/**
	 * Creates an iterchatator for ar
	 */
	public ArrayIterator(int[] ar) {
		// TODO implement me
		this.ar = ar;
		this.isCircular = false;
		this.currentIndex = 0;
	}
	
	/**
	 * Creates an iterator for the ar
	 * If isCurcular is true, the iterator will be infinite,
	 * outputting the array in circle 
	 * ar[0],ar[1]...ar[ar.length-1],ar[0],ar[1]...ar[ar.length-1],ar[0]...
	 */
	public ArrayIterator(int[] ar, boolean isCircular) {
		// TODO implement me
		this.ar = ar;
		this.isCircular = isCircular;
		this.currentIndex = 0;
	}
	
	@Override
	public boolean hasNext() {
		// TODO implement me
		if(isCircular){
			return true;
		}
		else {
			return this.currentIndex < this.ar.length;
		}
	}
	
	@Override
	public Integer next() {
		// TODO implement me
		if(!hasNext()){
			throw new NoSuchElementException("No more elements in the iterator");
		}
		int currentElement = this.ar[currentIndex];
		currentIndex++;
		if(isCircular && currentIndex >= this.ar.length){
			this.currentIndex = 0;
		}
		return currentElement;
	}
	
	public void reset() {
		// TODO implement me
		this.currentIndex = 0;
	}
}
