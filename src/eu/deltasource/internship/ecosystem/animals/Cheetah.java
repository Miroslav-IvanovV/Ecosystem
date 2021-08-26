package eu.deltasource.internship.ecosystem.animals;

import eu.deltasource.internship.ecosystem.enums.Biome;
import eu.deltasource.internship.ecosystem.enums.Habitat;
import eu.deltasource.internship.ecosystem.enums.LivingType;
import eu.deltasource.internship.ecosystem.utilities.RandomNumberGenerator;

public class Cheetah extends Carnivore {

    public Cheetah(RandomNumberGenerator randomNumber) {
        super(randomNumber);
        this.age = 1;
        this.maxAge = 30;
        this.weight = 60;
        this.mainHabitat = Habitat.LAND;
        this.livingType = LivingType.ALONE;
        this.reproductionRate = 5;
        this.hungerLevel = 15;
        this.attackPoints = 110;
        this.inhabitedBiomes.add(Biome.SAVANNA);
        this.hungerLevelModifier = 15;
    }
}
