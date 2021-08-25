package eu.deltasource.internship.ecosystem.animals;

import eu.deltasource.internship.ecosystem.enums.Biome;
import eu.deltasource.internship.ecosystem.enums.Habitat;
import eu.deltasource.internship.ecosystem.enums.LivingType;
import eu.deltasource.internship.ecosystem.utilities.RandomNumberGenerator;

public class Hare extends Herbivore {

    public Hare(RandomNumberGenerator randomNumber) {
        super(randomNumber);
        this.age = 1;
        this.maxAge = 24;
        this.weight = 5;
        this.mainHabitat = Habitat.LAND;
        this.livingType = LivingType.ALONE;
        this.reproductionRate = 3;
        this.escapePoints = 100;
        this.inhabitedBiomes.add(Biome.SAVANNA);
    }
}
