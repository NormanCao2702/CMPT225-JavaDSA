package integeriterators;

import java.util.NoSuchElementException;

public class RangeIterator implements IntegerIterator
{
	private int currentIndex;
	private int start;
	private int end;
	/**
	 * Creates an iterator for the infinite sequence 0,1,2,...
	 */
	public RangeIterator() {
		// TODO implement me
		this.start = 0;
		this.currentIndex = 0;
		this.end = Integer.MAX_VALUE;
	}
	
	/**
	 * Creates an iterator for the infinite sequence s,s+1,s+2...
	 */
	public RangeIterator(int s) {
		// TODO implement me
		this.start = s;
		this.currentIndex = s;
		this.end = Integer.MAX_VALUE;
	}
	
	/**
	 * Creates an iterator for the finite sequence [s,s+1,s+2...t-1]
	 * @throws IllegalArgumentException if t<s
	 */
	public RangeIterator(int s, int t) {
		// TODO implement me
		if(s>=t){
			throw new IllegalArgumentException("s has to be smaller than t");
		}
		this.start = s;
		this.currentIndex = s;
		this.end = t;
	}
	
	@Override
	public boolean hasNext() {
		// TODO implement me
		return this.currentIndex < this.end;
	}
	
	@Override
	public Integer next() {
		// TODO implement me
		if(!hasNext()){
			throw new NoSuchElementException("No more elements in range");
		}
		return this.currentIndex++;
	}
	
	public void reset() {
		// TODO implement me
		this.currentIndex = this.start;
	}
}
