package eu.deltasource.internship.ecosystem.utilities;

import java.util.Random;

public class RandomNumberGeneratorRealInput implements RandomNumberGenerator {

    @Override
    public double randomPercentageBetween0and100() {
        int min = 0, max = 100;
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return (double) randomNum / 100;
    }

    @Override
    public double randomPercentage(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return (double) randomNum / 100;
    }
}
