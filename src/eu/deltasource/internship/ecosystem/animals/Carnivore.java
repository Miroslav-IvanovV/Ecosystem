package eu.deltasource.internship.ecosystem.animals;

import eu.deltasource.internship.ecosystem.enums.LivingTypes;
import eu.deltasource.internship.ecosystem.utilities.RandomNumberGeneratorRealInput;

public abstract class Carnivore extends Animal {

    public static final double LONE_CARNIVORE_ATTACK_PERCENTAGE = 0.5;
    protected double hungerLevel = 0;
    protected int attackPoints;

    public boolean attack(Herbivore herbivore) {
        double carnivoreAgeCoeff = ((double) this.getAge() / this.getMaxAge());
        double herbivoreAgeCoeff = ((double) herbivore.getAge() / herbivore.getMaxAge());
        RandomNumberGeneratorRealInput randomNum = new RandomNumberGeneratorRealInput();
        double herdHerbivore = 1;
        double groupCarnivore = 1;

        if (herbivore.getLivingType().equals(LivingTypes.GROUP)){
            herdHerbivore = Herbivore.HERD_HERBIVORE_DEFENCE_PERCENTAGE;
        }
        if (this.getLivingType().equals(LivingTypes.ALONE)){
            groupCarnivore = LONE_CARNIVORE_ATTACK_PERCENTAGE;
        }

        if (carnivoreAgeCoeff * this.attackPoints / (carnivoreAgeCoeff * this.attackPoints + herbivoreAgeCoeff
                * herbivore.escapePoints) * herdHerbivore * groupCarnivore >= randomNum.randomPercentageBetween0and100()) {
            herbivore.setAlive(false);
            return true;
        }
        return false;
    }

    public void setHungerLevel(double hungerLevel) {

        if (hungerLevel > 100) {
            hungerLevel = 100;
        }
        if (hungerLevel < 0) {
            hungerLevel = 0;
        }

        this.hungerLevel = hungerLevel;
    }

    public double getHungerLevel() {
        return hungerLevel;
    }

    public void eat(Herbivore herbivore, int partsOfTheHerbivore) {
        this.setHungerLevel(this.hungerLevel - (herbivore.weight / partsOfTheHerbivore) / this.weight);
    }
}
