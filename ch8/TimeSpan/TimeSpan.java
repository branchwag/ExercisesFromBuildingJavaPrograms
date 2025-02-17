public class TimeSpan {
	private int totalMinutes;

	public TimeSpan(int hours, int minutes) {
		totalMinutes = 0;
		add(hours, minutes);
	}

	public void add(int hours, int minutes) {
		if (hours < 0 || minutes < 0) { 
			throw new IllegalArgumentException();
		}
	
		totalMinutes += 60 * hours + minutes;
	}

	public String toString() {
		return (totalMinutes / 60) + "h " + (totalMinutes % 60) + "m";
	}
}


