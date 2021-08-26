package eu.deltasource.internship.ecosystem.animals;

import eu.deltasource.internship.ecosystem.enums.Biome;
import eu.deltasource.internship.ecosystem.enums.Habitat;
import eu.deltasource.internship.ecosystem.enums.LivingType;
import eu.deltasource.internship.ecosystem.utilities.RandomNumberGenerator;

public class Gazelle extends Herbivore {

    public Gazelle(RandomNumberGenerator randomNumber) {
        super(randomNumber);
        this.age = 1;
        this.maxAge = 25;
        this.weight = 25;
        this.mainHabitat = Habitat.LAND;
        this.livingType = LivingType.GROUP;
        this.reproductionRate = 5;
        this.escapePoints = 80;
        this.inhabitedBiomes.add(Biome.SAVANNA);
        this.inhabitedBiomes.add(Biome.GRASSLAND);
    }
}
