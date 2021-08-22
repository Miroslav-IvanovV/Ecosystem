package eu.deltasource.internship.ecosystem.animals;

import eu.deltasource.internship.ecosystem.enums.Biomes;
import eu.deltasource.internship.ecosystem.enums.Habitat;
import eu.deltasource.internship.ecosystem.enums.LivingTypes;

public class Gazelle extends Herbivore{

    public Gazelle(){
        this.age = 1;
        this.maxAge = 25;
        this.weight = 25;
        this.mainHabitat = Habitat.LAND;
        this.livingType = LivingTypes.GROUP;
        this.reproductionRate = 5;
        this.escapePoints = 80;
        this.inhabitedBiomes.add(Biomes.SAVANNA);
    }
}
