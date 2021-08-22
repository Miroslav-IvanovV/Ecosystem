package eu.deltasource.internship.ecosystem.animals;

import eu.deltasource.internship.ecosystem.enums.Biomes;
import eu.deltasource.internship.ecosystem.enums.Habitat;
import eu.deltasource.internship.ecosystem.enums.LivingTypes;

public class Lion extends Carnivore {

    public Lion() {
        this.age = 1;
        this.maxAge = 30;
        this.weight = 150;
        this.mainHabitat = Habitat.LAND;
        this.livingType = LivingTypes.GROUP;
        this.reproductionRate = 20;
        this.hungerLevel = 50;
        this.attackPoints = 80;
        this.inhabitedBiomes.add(Biomes.SAVANNA);
    }
}
