
public class RodCutting {
	private int [][] rodTable;
	private int lengthOfRod;
	private int [] prices;
	public RodCutting(int lengthOfRod, int[] prices) {
		super();
		this.lengthOfRod = lengthOfRod;
		this.prices = prices;
		rodTable = new int[prices.length+1][lengthOfRod+1];
	}
	public void solve() {
		//initialize
		for(int i=1;i<prices.length;i++) {
			for(int j=0;j<=lengthOfRod;j++) {
				if(i<=j) {
					rodTable[i][j] = Math.max(rodTable[i-1][j], prices[i]+rodTable[i-1][j-i]);
				}else {
					rodTable[i][j] = rodTable[i-1][j];
				}
			}
		}
	}
	public void displayResult() {
		System.out.println("Optimal profit: $"+rodTable[prices.length-1][lengthOfRod]);
		for(int n=prices.length-1, w = lengthOfRod;n>0;) {
			if(rodTable[n][w]!=0 && rodTable[n][w]!= rodTable[n-1][w]) {
				System.out.println("We make cut: "+ n+"m");
			}else {
				n--;
			}
		}
	}
	
}
