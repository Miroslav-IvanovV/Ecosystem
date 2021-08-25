package eu.deltasource.internship.ecosystem;

import eu.deltasource.internship.ecosystem.animals.Animal;
import eu.deltasource.internship.ecosystem.loggers.InputTaker;

import java.util.List;

import static eu.deltasource.internship.ecosystem.loggers.InputTaker.inputIterations;

public class Main {

    public static void main(String[] args) {

        int iterations;
        List<Animal> list = InputTaker.takingInput(InputTaker.chooseBiome());
        iterations = inputIterations();
        Simulator.simulate(list, iterations);
    }
}
