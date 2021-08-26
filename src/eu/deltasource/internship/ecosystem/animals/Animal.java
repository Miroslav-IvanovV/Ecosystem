package eu.deltasource.internship.ecosystem.animals;

import eu.deltasource.internship.ecosystem.enums.Biome;
import eu.deltasource.internship.ecosystem.enums.Gender;
import eu.deltasource.internship.ecosystem.enums.Habitat;
import eu.deltasource.internship.ecosystem.enums.LivingType;
import eu.deltasource.internship.ecosystem.utilities.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public abstract class Animal {

    protected Gender gender;
    protected RandomNumberGenerator randomNumber;
    protected List<Biome> inhabitedBiomes = new ArrayList<>();
    protected int age;
    protected int maxAge;
    protected double weight;
    protected Habitat mainHabitat;
    protected int reproductionRate;
    protected LivingType livingType;
    protected boolean alive = true;

    public Animal(RandomNumberGenerator randomNumber){
        this.randomNumber = randomNumber;

        if (randomNumber.randomNumber(1,100) < 50){
            gender = Gender.MALE;
        } else {
            gender = Gender.FEMALE;
        }
    }

    public void ageing() {
            this.setAge(this.getAge() + 1);
        }

    /**
     * Checks if the animals reached the maximum age and if its true it set his alive variable to false;
     */
    public void ageCheck() {

        if (this.getAge() > this.getMaxAge()) {
            this.die();
        }

    }

    /**
     * Checks if animal is ready to reproduce and if yes it returns a new animal from the same type.
     * @return a new animal from the same type.
     */
    public Animal reproduce() {

        if (this.isReadyToReproduceCheck()) {
            try {
                return this.getClass().getDeclaredConstructor(RandomNumberGenerator.class).newInstance(randomNumber);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return null;
    }

    public boolean isReadyToReproduceCheck() {
        return this.getAge() % this.getReproductionRate() == 0;
    }

    /**
     * Checks if the animal inhabit the biome.
     * @param biome takes the biome that you want to check if the animal inhabit.
     * @return true if the animal inhabit the biome.
     */
    public boolean checkInhabitedBiomes(String biome) {
        for (int i = 0; i < this.inhabitedBiomes.size(); i++) {
            if (biome.equalsIgnoreCase(String.valueOf(inhabitedBiomes.get(i)))) {
                return true;
            }
        }
        return false;
    }

    public int getReproductionRate() {
        return reproductionRate;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void die() {
        this.alive = false;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public LivingType getLivingType() {
        return livingType;
    }

    public Gender getGender() {
        return gender;
    }
}
