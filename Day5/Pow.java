package Day5;

public class Pow {

    public static double pow(double x, int n) {
        // Base Case: Any number to the power of 0 is 1.

        if (n == 0)
            return 1.0;

        long temp = n; // to avoid integer overlap

        if (temp < 0) {
            x = 1 / x;
            temp = -temp;
        }

        double ans = 1.0;
        for (long i = 0; i < temp; i++) {
            ans *= x;
        }
        return ans;
    }

    public static double power(double x, long n) {
        if (n == 0)
            return 1.0;

        if (n == 1)
            return x;

        if (n % 2 == 0) {
            return power(x * x, n / 2);
        }
        // If 'n' is odd
        // Recursive call: x * power(x, n-1)

        return x * power(x, n - 1);
    }

    public double myPow(double x, int n) {

        long exp = n;

        if (exp < 0) {
            x = 1 / x;
            exp = -exp;
        }

        return fastPow(x, exp);
    }

    private double fastPow(double x, long n) {

        if (n == 0)
            return 1.0;

        double half = fastPow(x, n / 2);

        if (n % 2 == 0)
            return half * half;

        return half * half * x;
    }

}