package eu.deltasource.internship.ecosystem.ecosystems;

import eu.deltasource.internship.ecosystem.animals.Animal;
import eu.deltasource.internship.ecosystem.animals.Carnivore;
import eu.deltasource.internship.ecosystem.animals.Herbivore;
import eu.deltasource.internship.ecosystem.enums.LivingTypes;
import eu.deltasource.internship.ecosystem.utilities.RandomNumberGeneratorRealInput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ecosystem {

    public static List<Carnivore> carnivores = new ArrayList<>();
    public static List<Herbivore> herbivores = new ArrayList<>();

    public static void init(List<Animal> animalCollection) {

        for (int i = 0; i < animalCollection.size(); i++) {
            if (animalCollection.get(i) instanceof Carnivore) {
                carnivores.add((Carnivore) animalCollection.get(i));
            } else {
                herbivores.add((Herbivore) animalCollection.get(i));
            }
        }
    }

    public static void run(int iterations) {

        reproduce();
        attack();
        age();
        ageCheck();
        increaseStarvation();
        starvationCheck();
        cleanDeadAnimals();
        sortLists();
        System.out.println("Iteration : " + iterations);
        System.out.println("Herbivores : " + herbivores.size());
        System.out.println("Carnivore : " + carnivores.size() + "\n");
        System.out.println(carnivores);


    }

    /**
     * Sorts the list of carnivores and herbivores.
     */
    private static void sortLists() {
        Collections.sort(carnivores);
        Collections.sort(herbivores);
    }

    /**
     * Increase the hunger level of the carnivores by their hunger rate modifier
     */
    private static void increaseStarvation() {
        for (int i = 0; i < carnivores.size(); i++) {
            carnivores.get(i).setHungerLevel(carnivores.get(i).getHungerLevel() + carnivores.get(i)
                    .getHungerLevelModifier());
        }
    }

    /**
     * Carnivore attack a random herbivore and if it is successful check if the carnivore is a group animal or a
     * lone animal and after that proceed eating it with the other animals or alone.
     */
    private static void attack() {
        RandomNumberGeneratorRealInput randomNum = new RandomNumberGeneratorRealInput();
        boolean isAttackSuccessful = false;
        for (int i = 0; i < carnivores.size(); i++) {
            if (herbivores.size() > 0) {
                int chosenHerbivore = randomNum.randomNumber(0, herbivores.size() - 1);
                isAttackSuccessful = carnivores.get(i).attack(herbivores.get(chosenHerbivore));
                if (isAttackSuccessful == true) {
                    System.out.println(carnivores.get(i).getClass().getName().substring(44) + " killed a "
                    + herbivores.get(chosenHerbivore).getClass().getName().substring(44));
                    if (carnivores.get(i).getLivingType().equals(LivingTypes.GROUP)){
                        groupCarnivoreAttack(i, chosenHerbivore);
                    } else {
                        carnivores.get(i).eat(herbivores.get(chosenHerbivore), 1);
                    }
                }
            }
        }
    }

    /**
     * Checks how many animals are in the group, split the prey equally to them and after that they eat it.
     * @param i takes the carnivore index.
     * @param chosenHerbivore takes the herbivore that is attacked.
     */
    private static void groupCarnivoreAttack(int i, int chosenHerbivore) {
        int numberOfAnimalsInTHeGroup;
        numberOfAnimalsInTHeGroup = 0;
        for (int j = 0; j < carnivores.size(); j++) {
            if (carnivores.get(i).getClass() == carnivores.get(j).getClass()) {
                numberOfAnimalsInTHeGroup++;
            }
            for (int b = 0; b < carnivores.size(); b++) {
                if (carnivores.get(i).getClass() == carnivores.get(b).getClass()) {
                    carnivores.get(b).eat(herbivores.get(chosenHerbivore), numberOfAnimalsInTHeGroup);
                }
            }
        }
    }

    /**
     * Checks if the animals reach the maximum level of starvation and if it does set his alive variable to false.
     */
    private static void starvationCheck() {
        for (int i = 0; i < carnivores.size(); i++) {
            if (carnivores.get(i).getHungerLevel() >= 100) {
                carnivores.get(i).setAlive(false);
            }
        }
    }

    /**
     * Checks if the animals reached the maximum age and if its true it set his alive variable to false;
     */
    private static void ageCheck() {
        for (int i = 0; i < carnivores.size(); i++) {
            if (carnivores.get(i).getAge() == carnivores.get(i).getMaxAge()) {
                carnivores.get(i).setAlive(false);
            }
        }

        for (int i = 0; i < herbivores.size(); i++) {
            if (herbivores.get(i).getAge() == herbivores.get(i).getMaxAge()) {
                herbivores.get(i).setAlive(false);
            }
        }
    }

    /**
     * Checks if the animals are ready to reproduce and if they are it calls the reproduce method them.
     */
    private static void reproduce() {
        for (int i = 0; i < carnivores.size(); i++) {
            if (carnivores.get(i).getAge() % carnivores.get(i).getReproductionRate() == 0) {
                carnivores.add((Carnivore) carnivores.get(i).reproduce());
            }
        }

        for (int i = 0; i < herbivores.size(); i++) {
            if (herbivores.get(i).getAge()  % herbivores.get(i).getReproductionRate() == 0) {
                herbivores.add((Herbivore) herbivores.get(i).reproduce());
            }
        }
    }

    /**
     * Goes through all animals and increase their age by 1.
     */
    private static void age() {
        for (int i = 0; i < carnivores.size(); i++) {
            carnivores.get(i).setAge(carnivores.get(i).getAge() + 1);
        }

        for (int i = 0; i < herbivores.size(); i++) {
            herbivores.get(i).setAge(herbivores.get(i).getAge() + 1);
        }
    }

    /**
     * Goes through all animals and if their alive variable is set to false it removes them from the list
     */
    private static void cleanDeadAnimals() {

        for (int i = 0; i < carnivores.size(); i++) {
            if (!carnivores.get(i).isAlive()) {
                carnivores.remove(i);
            }
        }

        for (int i = 0; i < herbivores.size(); i++) {
            if (!herbivores.get(i).isAlive()) {
                herbivores.remove(i);
            }
        }
    }

}
