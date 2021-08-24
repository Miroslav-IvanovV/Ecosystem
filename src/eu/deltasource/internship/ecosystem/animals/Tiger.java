package eu.deltasource.internship.ecosystem.animals;

import eu.deltasource.internship.ecosystem.enums.Biomes;
import eu.deltasource.internship.ecosystem.enums.Habitat;
import eu.deltasource.internship.ecosystem.enums.LivingTypes;

public class Tiger extends Carnivore {

    public Tiger() {
        this.age = 1;
        this.maxAge = 20;
        this.weight = 200;
        this.mainHabitat = Habitat.LAND;
        this.livingType = LivingTypes.ALONE;
        this.reproductionRate = 6;
        this.hungerLevel = 18;
        this.attackPoints = 75;
        this.inhabitedBiomes.add(Biomes.SAVANNA);
        this.hungerLevelModifier = 18;
    }
}
