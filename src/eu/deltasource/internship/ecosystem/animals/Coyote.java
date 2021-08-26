package eu.deltasource.internship.ecosystem.animals;

import eu.deltasource.internship.ecosystem.enums.Biome;
import eu.deltasource.internship.ecosystem.enums.Habitat;
import eu.deltasource.internship.ecosystem.enums.LivingType;
import eu.deltasource.internship.ecosystem.utilities.RandomNumberGenerator;

public class Coyote extends Carnivore {

    public Coyote(RandomNumberGenerator randomNumber) {
        super(randomNumber);
        this.age = 1;
        this.maxAge = 22;
        this.weight = 30;
        this.mainHabitat = Habitat.LAND;
        this.livingType = LivingType.GROUP;
        this.reproductionRate = 7;
        this.hungerLevel = 25;
        this.attackPoints = 50;
        this.hungerLevelModifier = 17;
        this.inhabitedBiomes.add(Biome.GRASSLAND);
    }
}