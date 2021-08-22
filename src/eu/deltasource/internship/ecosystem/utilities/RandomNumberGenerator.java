package eu.deltasource.internship.ecosystem.utilities;

public interface RandomNumberGenerator {

    double randomPercentageBetween0and100();

    double randomPercentage(int min, int max);

    int randomNumber(int min, int max);
}
