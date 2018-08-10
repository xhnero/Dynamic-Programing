
public class Knapsack {
	private int numberOfitems;
	private int capacityOfKnapsack;
	private int [] values;
	private int [] weights;
	private int [][] knapsackTable;
	private int totalBenefit;
	public Knapsack(int numberOfitems, int capacityOfKnapsack, int[] values, int[] weights) {
		super();
		this.numberOfitems = numberOfitems;
		this.capacityOfKnapsack = capacityOfKnapsack;
		this.values = values;
		this.weights = weights;
		this.knapsackTable = new int [numberOfitems+1][capacityOfKnapsack + 1];
	}
	public void solveProblem() {
		for(int i =1;i<numberOfitems;i++) {
			for(int w=1;w<capacityOfKnapsack;w++) {
				int notTakingItem = knapsackTable[i-1][w];
				int takingItem = 0;
				if(w>=weights[i-1]) {
					takingItem = values[i-1] + knapsackTable[i][w-weights[i-1]];
				}
				knapsackTable[i][w] = Math.max(notTakingItem, takingItem);
			}
		}
		totalBenefit = knapsackTable[numberOfitems][capacityOfKnapsack];
	}
	public void displayResult() {
		System.out.println("Total benefit: " + totalBenefit);
		for(int n=numberOfitems, w= capacityOfKnapsack;n>0;n--) {
			if(knapsackTable[n][w]!=0 && knapsackTable[n][w]!=knapsackTable[n-1][w]) {
				System.out.println("item was taken: "+n);
				w = w-weights[n];
				
			}
		}
	}
	

}
