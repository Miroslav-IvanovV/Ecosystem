package eu.deltasource.internship.ecosystem.animals;

import eu.deltasource.internship.ecosystem.enums.Biomes;
import eu.deltasource.internship.ecosystem.enums.Habitat;
import eu.deltasource.internship.ecosystem.enums.LivingTypes;

public class Cheetah extends  Carnivore{

    public Cheetah(){
        this.age = 1;
        this.maxAge = 30;
        this.weight = 60;
        this.mainHabitat = Habitat.LAND;
        this.livingType = LivingTypes.ALONE;
        this.reproductionRate = 5;
        this.hungerLevel = 15;
        this.attackPoints = 110;
        this.inhabitedBiomes.add(Biomes.SAVANNA);
    }
}
