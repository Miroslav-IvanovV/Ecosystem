package eu.deltasource.internship.ecosystem.animals;

import eu.deltasource.internship.ecosystem.enums.Biome;
import eu.deltasource.internship.ecosystem.enums.Habitat;
import eu.deltasource.internship.ecosystem.enums.LivingType;
import eu.deltasource.internship.ecosystem.utilities.RandomNumberGenerator;

public class AnimalTestUnit extends  Animal{

    public AnimalTestUnit(RandomNumberGenerator randomNumber) {
        super(randomNumber);
        this.age = 1;
        this.maxAge = 5;
        this.weight = 800;
        this.mainHabitat = Habitat.LAND;
        this.livingType = LivingType.GROUP;
        this.reproductionRate = 1;
        this.inhabitedBiomes.add(Biome.SAVANNA);
    }
}
