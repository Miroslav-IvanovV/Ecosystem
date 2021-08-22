package eu.deltasource.internship.ecosystem.animals;

public abstract class Carnivore extends Animal {

    protected int hungerLevel = 0;
    protected int attackPoints;

    public void attack(Herbivore herbivore){

    }

    public void setHungerLevel(int hungerLevel) {
        this.hungerLevel = hungerLevel;
    }

    public int getHungerLevel() {
        return hungerLevel;
    }
}
