class Solution {
    public int mySqrt(int x) {
        return (int)findSquareRoot(x , 22);
    }
 
    public   double findSquareRoot(double number, int iterations) {
      
        if (number < 0) {
            throw new IllegalArgumentException("Cannot calculate the square root of a negative number.");
        }
        if (number == 0) {
            return 0;
        }

        // Start with an initial guess (half of the target number)
        double guess = number / 2.0;

        // Run the approximation loop
        for (int i = 0; i < iterations; i++) {
            guess = (guess + (number / guess)) / 2.0;
        }

        return guess;
    }

    
}
