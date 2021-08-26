package eu.deltasource.internship.ecosystem.animals;

import eu.deltasource.internship.ecosystem.enums.Biome;
import eu.deltasource.internship.ecosystem.enums.Habitat;
import eu.deltasource.internship.ecosystem.enums.LivingType;
import eu.deltasource.internship.ecosystem.utilities.RandomNumberGenerator;

public class Antelope extends Herbivore{
    public Antelope(RandomNumberGenerator randomNumber){
        super(randomNumber);
        this.age = 1;
        this.maxAge = 30;
        this.weight = 55;
        this.mainHabitat = Habitat.LAND;
        this.livingType = LivingType.GROUP;
        this.reproductionRate = 7;
        this.escapePoints = 80;
        this.inhabitedBiomes.add(Biome.GRASSLAND);
    }
}
