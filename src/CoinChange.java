
public class CoinChange {
	private int numberOfCoins;
	private int threshold;
	private int [] values;
	private int [][] coinTable;
	public CoinChange(int numberOfCoins, int threshold, int[] values) {
		super();
		this.numberOfCoins = numberOfCoins;
		this.threshold = threshold;
		this.values = values;
		this.coinTable = new int[numberOfCoins+1][threshold+1];
	}
	public int solve() {
		//initial table
		for(int i=0;i<=numberOfCoins;i++)
		{
			coinTable[i][0] = 1;
		}
		for(int j=0;j<=threshold;j++) {
			coinTable[0][j] = 0;
		}
		for(int i =1;i<numberOfCoins+1;i++)
		{
			for(int j = 1;j<threshold+1;j++) {
				// not taking the coin
				int notTakingCoin = coinTable[i-1][j];
				// taking coin
				int coinTaking = 0;
				if(values[i-1]<=j) {
					coinTaking = coinTable[i][j-values[i-1]];
				}
				coinTable[i][j] = notTakingCoin + coinTaking;
			}
		}
		return coinTable[numberOfCoins][threshold];
	}
	
	
}
