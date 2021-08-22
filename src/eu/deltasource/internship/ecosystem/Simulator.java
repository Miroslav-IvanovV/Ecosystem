package eu.deltasource.internship.ecosystem;

import eu.deltasource.internship.ecosystem.animals.Animal;
import eu.deltasource.internship.ecosystem.ecosystems.Ecosystem;

import java.util.List;

public class Simulator {

    public static void simulate(List<Animal> animalCollection, int iterations) {

        Ecosystem.init(animalCollection);
        for (int i = 0; i < iterations; i++) {
            Ecosystem.run(i + 1);
        }

    }
}
