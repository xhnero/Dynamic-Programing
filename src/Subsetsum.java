
public class Subsetsum {
	private boolean [][] dp;
	private int [] s;
	private int sum;
	public Subsetsum(int [] s,int sum) {
		this.s = s;
		this.sum = sum;
		this.dp = new boolean [s.length+1][sum+1];
	}
	public void solve() {
		//initialize
		for(int i=0;i<s.length+1;i++) {
			dp[i][0] = true;
		}
		for(int i=1;i<s.length+1;i++) {
			for(int j=0;j<sum+1;j++) {
				if(j<s[i-1]) {
					dp[i][j] = dp[i-1][j];
				}else {
					if(dp[i-1][j]) dp[i][j] = dp[i-1][j];
					else {
						dp[i][j] = dp[i-1][j-s[i-1]];
					}
				}
			}
		}
		System.out.println("Solution: " +dp[s.length][sum]);
	}
	
	public void displayResult(){
		int j = sum;
		int i = s.length;
		while(j>0||i>0) {
			if(dp[i][j] ==dp[i-1][j]) {
				i--;
			}else{
				System.out.println("We take "+s[i-1]);
				j= j-s[i-1];
				i--;
			}
		}
	}
}
