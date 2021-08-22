package eu.deltasource.internship.ecosystem.animals;

import eu.deltasource.internship.ecosystem.enums.Biomes;
import eu.deltasource.internship.ecosystem.enums.Habitat;
import eu.deltasource.internship.ecosystem.enums.LivingTypes;

public class Buffalo extends Herbivore {

    public Buffalo() {
        this.age = 1;
        this.maxAge = 35;
        this.weight = 800;
        this.mainHabitat = Habitat.LAND;
        this.livingType = LivingTypes.GROUP;
        this.reproductionRate = 9;
        this.escapePoints = 40;
        this.inhabitedBiomes.add(Biomes.SAVANNA);
    }
}
