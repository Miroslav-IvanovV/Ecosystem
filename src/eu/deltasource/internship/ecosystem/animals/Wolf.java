package eu.deltasource.internship.ecosystem.animals;

import eu.deltasource.internship.ecosystem.enums.Biome;
import eu.deltasource.internship.ecosystem.enums.Habitat;
import eu.deltasource.internship.ecosystem.enums.LivingType;
import eu.deltasource.internship.ecosystem.utilities.RandomNumberGenerator;

public class Wolf extends Carnivore {

    public Wolf(RandomNumberGenerator randomNumber){
        super(randomNumber);
        this.age = 1;
        this.maxAge = 24;
        this.weight = 60;
        this.mainHabitat = Habitat.LAND;
        this.livingType = LivingType.GROUP;
        this.reproductionRate = 8;
        this.hungerLevel = 25;
        this.attackPoints = 45;
        this.hungerLevelModifier = 17;
        this.inhabitedBiomes.add(Biome.GRASSLAND);

    }
}
