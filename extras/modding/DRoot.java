public class DRoot {
  public static int digital_root(int n) {
    // Base case: if n is a single digit, return it
    if (n < 10) {
      return n;
    }
    
    // Sum the digits
    int sum = 0;
    while (n > 0) {
      sum += n % 10;  // Add the last digit
      n /= 10;        // Remove the last digit
    }
    
    // Recursively call digital_root with the sum
    return digital_root(sum);
  }
}
