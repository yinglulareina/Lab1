public class FractionImpl implements Fraction {
    private int numerator;
    private int denominator;

    /**
     * Constructor for FractionImpl.
     * @throws IllegalArgumentException if denominator is <= 0
     */
    public FractionImpl(int numerator, int denominator) {
        if (denominator <= 0) {
            throw new IllegalArgumentException("Denominator must be positive.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        this.normalize();
    }

    //Euclid’s algorithm
    private static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (b == 0) return a; //base case
        return gcd(b, a % b);//recursion
    }

    private void normalize() {
        //simplfy
        int common = gcd(this.numerator, this.denominator);
        this.numerator = numerator/common;
        this.denominator = denominator/common;

        //denominator is set to be always positive
        if (this.denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
    }

    @Override
    public String toString() {
        //return numerator/deminator in the simplest form
        return (numerator) + "/" + (denominator);
    }

    @Override
    public double toDouble() {
        return (double) this.numerator/this.denominator;
    }

    @Override
    public Fraction reciprocal() {
        if (this.numerator == 0) {
            throw new IllegalArgumentException("Cannot take reciprocal of zero.")
        }
        return new FractionImpl(this.denominator, this.numerator);
    }

    @Override
    public Fraction add(Fraction other) {
        int addN = this.numerator * other.getDenominator() + other.getNumerator() * this.denominator;
        int addD = this.denominator * other.getDenominator();
        return new FractionImpl(addN, addN);
    }

    @Override
    public int compareTo(Fraction other) {
        long first = (long)this.numerator * other.getDenominator();
        long second = (long)other.getNumerator() * this.denominator;
        return Long.compare(first, second);
    }
}