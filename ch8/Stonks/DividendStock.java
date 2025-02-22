public class DividendStock extends Stock {
	private double dividends;

	public DividendStock(String symbol) {
		//call superclass constructor, pass it symbol
		//get back init of symbol, totalShares, and totalCost
		super(symbol);
		this.dividends = 0.0;
	}

	public void payDividend(double amountPerShare) {
		//dividends = dividends + (amountPerShare * getTotalShares());
		dividends += amountPerShare * getTotalShares();	
	}

	public double getProfit(double currentPrice) {
		return super.getProfit(currentPrice) + dividends;
	}
}
