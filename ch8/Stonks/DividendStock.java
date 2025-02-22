public class DividendStock extends Stock {
	private double dividends;

	public void payDividend(double amountPerShare) {
		dividends += amountPerShare * getTotalShares();	
	}
}
