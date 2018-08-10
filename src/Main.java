
public class Main {

	public static void main(String[] args) {
		// Test Fibonacci using DP
		Fibonacci fibonacci = new Fibonacci();
		System.out.println(fibonacci.fibonacciDP(1000));
		// Test knapsack
		// Test coin change;
		/**
		 * int numberOfCoins = 10;
			int [] values = {1,2,3,4,5,6,7,8,9,10};
			int threshold = 4000;
			CoinChange coinChange = new CoinChange(numberOfCoins, threshold, values);
			System.out.println(coinChange.solve());
		 */
		//test subsetsum
		int [] numbers = {1,4,2};
		int sum = 7;
		Subsetsum subsetsum = new Subsetsum(numbers, sum);
		subsetsum.solve();
		subsetsum.displayResult();
	}

}
