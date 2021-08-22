package eu.deltasource.internship.ecosystem.animals;

import eu.deltasource.internship.ecosystem.utilities.RandomNumberGeneratorRealInput;

public abstract class Carnivore extends Animal {

    protected double hungerLevel = 0;
    protected int attackPoints;

    public boolean attack(Herbivore herbivore){
        double carnivoreAgeQueff = ((double) this.getAge() / this.getMaxAge());
        double herbivoreAgeQueff = ((double) herbivore.getAge() / herbivore.getMaxAge());
        RandomNumberGeneratorRealInput randomNum = new RandomNumberGeneratorRealInput();

        if(carnivoreAgeQueff * this.attackPoints / (carnivoreAgeQueff * this.attackPoints  + herbivoreAgeQueff
        * herbivore.escapePoints) <= randomNum.randomPercentageBetween0and100()){
            herbivore.setAlive(false);
            return true;
        }
        return false;
    }

    public void setHungerLevel(double hungerLevel) {

        if (hungerLevel > 100){
            hungerLevel = 100;
        }
        if (hungerLevel < 0){
            hungerLevel = 0;
        }

        this.hungerLevel = hungerLevel;
    }

    public double getHungerLevel() {
        return hungerLevel;
    }

    public void eat(Herbivore herbivore, int partsOfTheHerbivore ) {
        this.setHungerLevel(this.hungerLevel - (herbivore.weight / partsOfTheHerbivore) / this.weight );
    }
}
