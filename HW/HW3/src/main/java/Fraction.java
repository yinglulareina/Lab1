/**
 * Fraction interface represents a rational number.
 * It extends Comparable to provide ordering based on the fraction's value.
 */
public interface Fraction extends Comparable<Fraction> {
    /** @return the numerator of this fraction */
    int getNumerator();

    /** @return the denominator of this fraction */
    int getDenominator();

    /** @param n the new numerator */
    void setNumerator(int n);

    /** @param d the new numerator */
    void setDenominator(int d);

    /** @return the decimal value of the fraction */
    double toDouble();

    /** @return a new fraction that is the reciprocal of the current one */
    Fraction reciprocal();

    /** @param other the fraction to add */
    Fraction add(Fraction other);

    /** @param other the fraction to compare to */
    @Override
    int compareTo(Fraction other);
}