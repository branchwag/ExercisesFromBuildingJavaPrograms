public class Stock {
	private String symbol;
	private int totalShares;
	private double totalCost;

	public Stock(String symbol) {

		if (symbol == null) {
			throw new NullPointerException();
		}

		this.symbol = symbol;
		totalShares = 0;
		totalCost = 0.0;
	}

	public Stock(String symbol, int shares, double pricePerShare) {
		if (symbol == null) {
			throw new NullPointerException();
		}
		if (shares < 0 || pricePerShare < 0) {
			throw new IllegalArgumentException();
		}
		this.symbol = symbol;
		totalShares = shares;
		totalCost = shares * pricePerShare;
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
/* It would be useful to have a few other methods in our Stock objects. For
example, it would be good to implement accessors for the Stock ’s data (the
symbol, number of shares, and so on), and a toString method to easily
print Stock objects. We could even add a second constructor that would
accept an initial number of shares and cost. These features are left for you
to implement as exercises.
	*/
	public String getSymbol() {
		return symbol;
	}

	public int getTotalShares() {
		return totalShares;
	}

	public double getTotalCost() {
		return totalCost;
	}

	@Override
	public String toString() {
		return "Stock info: Symbol - " + symbol + " Shares - " + totalShares + " Cost - " + totalCost;
	}
}
