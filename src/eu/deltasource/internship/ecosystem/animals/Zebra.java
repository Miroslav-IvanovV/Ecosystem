package eu.deltasource.internship.ecosystem.animals;

import eu.deltasource.internship.ecosystem.enums.Biome;
import eu.deltasource.internship.ecosystem.enums.Habitat;
import eu.deltasource.internship.ecosystem.enums.LivingType;
import eu.deltasource.internship.ecosystem.utilities.RandomNumberGenerator;

public class Zebra extends Herbivore {

    public Zebra(RandomNumberGenerator randomNumber) {
        super(randomNumber);
        this.age = 1;
        this.maxAge = 40;
        this.weight = 300;
        this.mainHabitat = Habitat.LAND;
        this.livingType = LivingType.GROUP;
        this.reproductionRate = 10;
        this.escapePoints = 80;
        this.inhabitedBiomes.add(Biome.SAVANNA);
    }
}
