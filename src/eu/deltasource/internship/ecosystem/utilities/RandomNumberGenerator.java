package eu.deltasource.internship.ecosystem.utilities;

public interface RandomNumberGenerator {

    /**
     * @return a random number between 0 and 1.
     */
    double randomCoefficientBetween0and1();

    /**
     * @param min gets the minimum coefficient.
     * @param max gets the maximum coefficient.
     * @return a random coefficient.
     */
    double randomCoefficient(int min, int max);

    /**
     * @param min gets the minimum number.
     * @param max gets the maximum number.
     * @return a random number.
     */
    int randomNumber(int min, int max);
}
