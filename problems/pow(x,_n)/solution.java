class Solution {
    public double myPow(double x, int n) {
        long exp = n;
        
        // negative exponential
        if (exp < 0) {
            x = 1 / x;
            // Switch signs;
            exp = -exp;
        }
        
        return fastPow(x, exp);
    }
    
    private double fastPow(double x, long n) {    
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        
        if (n % 2 == 0) {
            return half * half;
        }
            
        return half * half * x;
    }
}