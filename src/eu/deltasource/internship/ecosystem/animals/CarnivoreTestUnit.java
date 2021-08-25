package eu.deltasource.internship.ecosystem.animals;

import eu.deltasource.internship.ecosystem.enums.Biome;
import eu.deltasource.internship.ecosystem.enums.Habitat;
import eu.deltasource.internship.ecosystem.enums.LivingType;
import eu.deltasource.internship.ecosystem.utilities.RandomNumberGenerator;

public class CarnivoreTestUnit extends Carnivore {

        public CarnivoreTestUnit(RandomNumberGenerator randomNumber) {
            super(randomNumber);
            this.age = 1;
            this.maxAge = 35;
            this.weight = 100;
            this.mainHabitat = Habitat.LAND;
            this.livingType = LivingType.GROUP;
            this.reproductionRate = 9;
            this.hungerLevel = 15;
            this.attackPoints = 110;
            this.inhabitedBiomes.add(Biome.SAVANNA);
            this.hungerLevelModifier = 100;
        }
}
