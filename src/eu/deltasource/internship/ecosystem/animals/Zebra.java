package eu.deltasource.internship.ecosystem.animals;

import eu.deltasource.internship.ecosystem.enums.Biomes;
import eu.deltasource.internship.ecosystem.enums.Habitat;
import eu.deltasource.internship.ecosystem.enums.LivingTypes;

public class Zebra extends Herbivore {

    public Zebra() {
        this.age = 1;
        this.maxAge = 40;
        this.weight = 300;
        this.mainHabitat = Habitat.LAND;
        this.livingType = LivingTypes.GROUP;
        this.reproductionRate = 10;
        this.escapePoints = 80;
        this.inhabitedBiomes.add(Biomes.SAVANNA);
    }
}
