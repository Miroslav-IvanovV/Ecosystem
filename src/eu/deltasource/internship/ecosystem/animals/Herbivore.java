package eu.deltasource.internship.ecosystem.animals;

import eu.deltasource.internship.ecosystem.utilities.RandomNumberGenerator;

public abstract class Herbivore extends Animal implements java.lang.Comparable<Animal> {

    public static final double HERD_HERBIVORE_DEFENCE_PERCENTAGE = 0.7;

    protected int escapePoints;

    public Herbivore(RandomNumberGenerator randomNumber) {
        super(randomNumber);
    }

    /**
     * Compare two objects.
     */
    @Override
    public int compareTo(Animal o) {
        return this.getClass().getTypeName().compareTo(o.getClass().getTypeName());
    }

}
