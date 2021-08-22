package eu.deltasource.internship.ecosystem.animals;

import eu.deltasource.internship.ecosystem.enums.Biomes;
import eu.deltasource.internship.ecosystem.enums.Habitat;
import eu.deltasource.internship.ecosystem.enums.LivingTypes;

public class Hyena extends Carnivore{

    public Hyena(){
        this.age = 1;
        this.maxAge = 25;
        this.weight = 50;
        this.mainHabitat = Habitat.LAND;
        this.livingType = LivingTypes.GROUP;
        this.reproductionRate = 5;
        this.hungerLevel = 14;
        this.attackPoints = 80;
        this.inhabitedBiomes.add(Biomes.SAVANNA);
    }
}
