package eu.deltasource.internship.ecosystem.animals;

import eu.deltasource.internship.ecosystem.enums.Biome;
import eu.deltasource.internship.ecosystem.enums.Habitat;
import eu.deltasource.internship.ecosystem.enums.LivingType;
import eu.deltasource.internship.ecosystem.utilities.RandomNumberGenerator;

public class Deer extends Herbivore{
    public Deer(RandomNumberGenerator randomNumber){
        super(randomNumber);
        this.age = 1;
        this.maxAge = 35;
        this.weight = 800;
        this.mainHabitat = Habitat.LAND;
        this.livingType = LivingType.GROUP;
        this.reproductionRate = 9;
        this.escapePoints = 40;
        this.inhabitedBiomes.add(Biome.GRASSLAND);
    }
}
