package eu.deltasource.internship.ecosystem.animals;

import eu.deltasource.internship.ecosystem.enums.Biome;
import eu.deltasource.internship.ecosystem.enums.Habitat;
import eu.deltasource.internship.ecosystem.enums.LivingType;
import eu.deltasource.internship.ecosystem.utilities.RandomNumberGenerator;

public class Hyena extends Carnivore {

    public Hyena(RandomNumberGenerator randomNumber) {
        super(randomNumber);
        this.age = 1;
        this.maxAge = 25;
        this.weight = 50;
        this.mainHabitat = Habitat.LAND;
        this.livingType = LivingType.GROUP;
        this.reproductionRate = 5;
        this.hungerLevel = 14;
        this.attackPoints = 80;
        this.inhabitedBiomes.add(Biome.SAVANNA);
        this.hungerLevelModifier = 14;

    }
}
