package eu.deltasource.internship.ecosystem.animals;

import eu.deltasource.internship.ecosystem.enums.Biome;
import eu.deltasource.internship.ecosystem.enums.Habitat;
import eu.deltasource.internship.ecosystem.enums.LivingType;
import eu.deltasource.internship.ecosystem.utilities.RandomNumberGenerator;

public class Lion extends Carnivore {

    public Lion(RandomNumberGenerator randomNumber) {
        super(randomNumber);
        this.age = 1;
        this.maxAge = 30;
        this.weight = 150;
        this.mainHabitat = Habitat.LAND;
        this.livingType = LivingType.GROUP;
        this.reproductionRate = 20;
        this.hungerLevel = 50;
        this.attackPoints = 80;
        this.inhabitedBiomes.add(Biome.SAVANNA);
        this.hungerLevelModifier = 20;
    }
}
