package eu.deltasource.internship.ecosystem.animals;

import eu.deltasource.internship.ecosystem.enums.LivingType;
import eu.deltasource.internship.ecosystem.utilities.RandomNumberGenerator;

import java.util.List;


public abstract class Carnivore extends Animal implements java.lang.Comparable<Animal> {

    public static final double LONE_CARNIVORE_ATTACK_PERCENTAGE = 0.5;

    protected int hungerLevelModifier;
    protected double hungerLevel = 0;
    protected int attackPoints;

    public Carnivore(RandomNumberGenerator randomNumber) {
        super(randomNumber);
    }

    /**
     * Checks if the animal reach the maximum level of starvation and if it does set his alive variable to false.
     */
    public void starvationCheck() {
        if (this.getHungerLevel() >= 100) {
            this.die();
        }
    }

    /**
     * Increase the hunger level of the carnivore by his hunger rate modifier.
     */
    public void increaseStarvation() {
        this.setHungerLevel(this.getHungerLevel() + this.getHungerLevelModifier());
    }

    /**
     * checks if the attack gonna be successful and if it is set the herbivores parameter alive to false,
     * check if the carnivore is a lone animal or group and invoke the eat method or groupCarnivoreAttack method
     * @param herbivore gets the herbivore that gonna be attacked.
     */
    public void attack(Herbivore herbivore, List<Carnivore> carnivores) {
        double carnivoreAgeCoeff = ((double) this.getAge() / this.getMaxAge());
        double herbivoreAgeCoeff = ((double) herbivore.getAge() / herbivore.getMaxAge());
        double herdHerbivore = 1;
        double groupCarnivore = 1;

        if (herbivore.getLivingType().equals(LivingType.GROUP)) {
            herdHerbivore = Herbivore.HERD_HERBIVORE_DEFENCE_PERCENTAGE;
        }
        if (this.getLivingType().equals(LivingType.ALONE)) {
            groupCarnivore = LONE_CARNIVORE_ATTACK_PERCENTAGE;
        }


        if (carnivoreAgeCoeff * this.attackPoints / (carnivoreAgeCoeff * this.attackPoints + herbivoreAgeCoeff
                * herbivore.escapePoints) * herdHerbivore * groupCarnivore >= randomNumber.randomCoefficientBetween0and1()) {
            herbivore.die();
            {
                if (this.getLivingType().equals(LivingType.GROUP)) {
                    groupCarnivoreFeast(herbivore, carnivores);
                } else {
                    this.eat(herbivore, 1);
                }
            }
        }
    }


    /**
     * Goes through the list of carnivores and split the prey accordingly to the carnivores in the group and
     * after that calls the method eat on them.
     * @param herbivore takes the prey
     * @param carnivores takes the list of all carnivores.
     */
    public void groupCarnivoreFeast(Herbivore herbivore, List<Carnivore> carnivores) {
        int numberOfAnimalsInTHeGroup = 0;
        for (int j = 0; j < carnivores.size(); j++) {
            if (this.getClass() == carnivores.get(j).getClass()) {
                numberOfAnimalsInTHeGroup++;
            }
        }
        for (int b = 0; b < carnivores.size(); b++) {
            if (this.getClass() == carnivores.get(b).getClass()) {
                carnivores.get(b).eat(herbivore, numberOfAnimalsInTHeGroup);
            }
        }
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
        this.setHungerLevel(this.hungerLevel - (herbivore.weight / partsOfTheHerbivore) / this.weight * 100);
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
