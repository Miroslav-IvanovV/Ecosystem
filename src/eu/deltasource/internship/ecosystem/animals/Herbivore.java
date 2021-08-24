package eu.deltasource.internship.ecosystem.animals;

public abstract class Herbivore extends Animal implements java.lang.Comparable<Animal> {

    public static final double HERD_HERBIVORE_DEFENCE_PERCENTAGE = 0.7;
    protected int escapePoints;

    /**
     * Compare two objects.
     */
    @Override
    public int compareTo(Animal o) {
        return this.getClass().getTypeName().compareTo(o.getClass().getTypeName());
    }

}
