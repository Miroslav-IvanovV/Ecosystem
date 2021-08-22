package eu.deltasource.internship.ecosystem.animals;

import eu.deltasource.internship.ecosystem.enums.Biomes;
import eu.deltasource.internship.ecosystem.enums.Habitat;
import eu.deltasource.internship.ecosystem.enums.LivingTypes;

public class Hare extends Herbivore{

    public Hare(){
        this.age = 1;
        this.maxAge = 24;
        this.weight = 5;
        this.mainHabitat = Habitat.LAND;
        this.livingType = LivingTypes.ALONE;
        this.reproductionRate = 3;
        this.escapePoints = 100;
        this.inhabitedBiomes.add(Biomes.SAVANNA);
    }
}
