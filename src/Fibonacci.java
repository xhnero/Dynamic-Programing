import java.beans.ConstructorProperties;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
	private Map<Integer,Integer> memoizeTable;
	public Fibonacci() {
		this.memoizeTable = new HashMap<>();
		this.memoizeTable.put(0, 0);
		this.memoizeTable.put(1, 1);		
	}
	// O(n) complexity time
	public int fibonacciDP(int n) {
		// base case
		if(this.memoizeTable.containsKey(n)) return this.memoizeTable.get(n);
		//Recursive case
		else {
			this.memoizeTable.put(n-1,fibonacciDP(n-1));
			this.memoizeTable.put(n-2, fibonacciDP(n-2));
			int res = this.memoizeTable.get(n-1) + this.memoizeTable.get(n-2);
			this.memoizeTable.put(n, res);
			return res;
		}
	}

}
