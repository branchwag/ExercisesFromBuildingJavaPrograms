public class Stock {
	private String symbol;
	private int totalShares;
	private double totalCost;

	public Stock(String theSymbol) {

		if (theSymbol == null) {
			throw new NullPointerException();
		}

		symbol = theSymbol;
		totalShares = 0;
		totalCost = 0.0;
	}

	public double getProfit(double currentPrice) {
		if (currentPrice < 0.0) {
			throw new IllegalArgumentException();
		}
		//(current price * shares) - (cost * shares)
		return totalShares * currentPrice - totalCost;
	}

	public void purchase(int shares, double pricePerShare) {
		if (shares < 0 || pricePerShare < 0) {
			throw new IllegalArgumentException();
		}
		//set totalCost equal to shares * pricePerShare
		totalShares += shares;
		totalCost += shares * pricePerShare;
	}
}
