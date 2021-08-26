package eu.deltasource.internship.ecosystem.utilities;

import java.util.Random;

public class RandomNumberGeneratorRealInput implements RandomNumberGenerator {

    @Override
    public double randomCoefficientBetween0and1() {
        int min = 0, max = 100;
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return (double) randomNum / 100;
    }

    @Override
    public double randomCoefficient(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return (double) randomNum / 100;
    }

    @Override
    public int randomNumber(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}
