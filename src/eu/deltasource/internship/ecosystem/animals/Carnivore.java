package eu.deltasource.internship.ecosystem.animals;

import eu.deltasource.internship.ecosystem.enums.LivingTypes;
import eu.deltasource.internship.ecosystem.utilities.RandomNumberGeneratorRealInput;

public abstract class Carnivore extends Animal implements java.lang.Comparable<Animal> {

    public static final double LONE_CARNIVORE_ATTACK_PERCENTAGE = 0.5;
    protected int hungerLevelModifier;
    protected double hungerLevel = 0;
    protected int attackPoints;


    /**
     * checks if the attack gonna be successful and if it is set the herbivores parameter alive to false.
     * @param herbivore gets the herbivore that gonna be attacked.
     * @return true if attack is successful.
     */
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

    /**
     * Lower the hungerLevel of the carnivore.
     * @param herbivore takes the pray that gonna be eaten.
     * @param partsOfTheHerbivore takes at how many parts the herbivore will be split.
     */
    public void eat(Herbivore herbivore, int partsOfTheHerbivore) {
        this.setHungerLevel(this.hungerLevel - (herbivore.weight / partsOfTheHerbivore) / this.weight);
    }

    /**
     * Compare two objects.
     */
    @Override
    public int compareTo(Animal o) {
        return this.getClass().getTypeName().compareTo(o.getClass().getTypeName());
    }

    public int getHungerLevelModifier() {
        return hungerLevelModifier;
    }
}
