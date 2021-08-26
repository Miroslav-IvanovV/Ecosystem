package eu.deltasource.internship.ecosystem.animals;

import eu.deltasource.internship.ecosystem.enums.Biome;
import eu.deltasource.internship.ecosystem.enums.Habitat;
import eu.deltasource.internship.ecosystem.enums.LivingType;
import eu.deltasource.internship.ecosystem.utilities.RandomNumberGenerator;

public class Tiger extends Carnivore {

    public Tiger(RandomNumberGenerator randomNumber) {
        super(randomNumber);
        this.age = 1;
        this.maxAge = 20;
        this.weight = 200;
        this.mainHabitat = Habitat.LAND;
        this.livingType = LivingType.ALONE;
        this.reproductionRate = 6;
        this.hungerLevel = 18;
        this.attackPoints = 75;
        this.inhabitedBiomes.add(Biome.SAVANNA);
        this.hungerLevelModifier = 18;
    }
}
