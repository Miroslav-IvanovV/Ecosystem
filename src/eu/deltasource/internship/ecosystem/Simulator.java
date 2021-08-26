package eu.deltasource.internship.ecosystem;

import eu.deltasource.internship.ecosystem.animals.Animal;
import eu.deltasource.internship.ecosystem.ecosystems.Ecosystem;

import java.util.List;

public class Simulator {

    /**
     * It simulates year by year.
     * @param animalCollection takes all of the animals in the simulation.
     * @param iterations takes how many years are gonna be simulate.
     */
    public static void simulate(List<Animal> animalCollection, int iterations) {

        Ecosystem ecosystem = new Ecosystem(animalCollection);
        for (int i = 1; i <= iterations; i++) {
            ecosystem.run(i);
        }

    }
}
