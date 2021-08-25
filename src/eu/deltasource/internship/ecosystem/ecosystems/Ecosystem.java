package eu.deltasource.internship.ecosystem.ecosystems;

import eu.deltasource.internship.ecosystem.animals.Animal;
import eu.deltasource.internship.ecosystem.animals.Carnivore;
import eu.deltasource.internship.ecosystem.animals.Herbivore;
import eu.deltasource.internship.ecosystem.utilities.RandomNumberGeneratorRealInput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Ecosystem {

    private List<Carnivore> carnivores = new ArrayList<>();
    private List<Herbivore> herbivores = new ArrayList<>();
    private HashMap<String, Integer> animalFemaleAndMaleMap = new HashMap<>();

    public Ecosystem(List<Animal> list){
        init(list);
    }

    private void init(List<Animal> animalCollection) {

        for (int i = 0; i < animalCollection.size(); i++) {
            if (animalCollection.get(i) instanceof Carnivore) {
                carnivores.add((Carnivore) animalCollection.get(i));
            } else {
                herbivores.add((Herbivore) animalCollection.get(i));
            }
        }
    }

    public void run(int iterations) {

        reproduce();
        attack();
        ageing();
        ageCheck();
        increaseStarvation();
        starvationCheck();
        cleanDeadAnimals();
        sortLists();
        System.out.println("Iteration : " + iterations);
        System.out.println("Herbivores : " + herbivores.size());
        System.out.println("Carnivore : " + carnivores.size() + "\n");


    }

    /**
     * Sorts the list of carnivores and herbivores.
     */
    private void sortLists() {
        Collections.sort(carnivores);
        Collections.sort(herbivores);
    }

    /**
     * Increase the hunger level of the carnivores by their hunger rate modifier
     */
    private void increaseStarvation() {
        for (int i = 0; i < carnivores.size(); i++) {
            carnivores.get(i).increaseStarvation();
        }
    }

    /**
     * Carnivores attack a random herbivore.
     */
    private void attack() {
        RandomNumberGeneratorRealInput randomNum = new RandomNumberGeneratorRealInput();
        for (int i = 0; i < carnivores.size(); i++) {
            if (herbivores.size() > 0) {
                int chosenHerbivore = randomNum.randomNumber(0, herbivores.size() - 1);
                carnivores.get(i).attack(herbivores.get(chosenHerbivore) ,carnivores);
            }
        }
    }

    /**
     * Checks if the animals reach the maximum level of starvation and if it does set his alive variable to false.
     */
    private void starvationCheck() {
        for (int i = 0; i < carnivores.size(); i++) {
            carnivores.get(i).starvationCheck();
        }
    }

    /**
     * Checks if the animals reached the maximum age and if its true it set his alive variable to false;
     */
    private void ageCheck() {
        for (int i = 0; i < carnivores.size(); i++) {
            carnivores.get(i).ageCheck();
        }

        for (int i = 0; i < herbivores.size(); i++) {
            herbivores.get(i).ageCheck();
        }
    }

    /**
     * Calls the method reproduce on all animals.
     */
    private void reproduce() {
        Animal newAnimal;
        for (int i = 0; i < carnivores.size(); i++) {
            newAnimal = (Carnivore) carnivores.get(i).reproduce();
            if (newAnimal != null) {
                carnivores.add((Carnivore) newAnimal);
            }
        }

        for (int i = 0; i < herbivores.size(); i++) {
            newAnimal = (Herbivore) herbivores.get(i).reproduce();
            if (newAnimal != null) {
                herbivores.add((Herbivore) newAnimal);
            }
        }
    }

    /**
     * Goes through all animals and increase their age by 1.
     */
    private void ageing() {
        for (int i = 0; i < carnivores.size(); i++) {
            carnivores.get(i).ageing();
        }

        for (int i = 0; i < herbivores.size(); i++) {
            herbivores.get(i).ageing();
        }
    }

    /**
     * Goes through all animals and if their alive variable is set to false it removes them from the list
     */
    private void cleanDeadAnimals() {

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

    public List<Carnivore> getCarnivores() {
        return carnivores;
    }

    public List<Herbivore> getHerbivores() {
        return herbivores;
    }
}
