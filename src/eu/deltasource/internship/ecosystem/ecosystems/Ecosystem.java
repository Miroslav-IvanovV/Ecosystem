package eu.deltasource.internship.ecosystem.ecosystems;

import eu.deltasource.internship.ecosystem.animals.Animal;
import eu.deltasource.internship.ecosystem.animals.Carnivore;
import eu.deltasource.internship.ecosystem.animals.Herbivore;
import eu.deltasource.internship.ecosystem.utilities.RandomNumberGenerator;
import eu.deltasource.internship.ecosystem.utilities.RandomNumberGeneratorRealInput;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Ecosystem {

    private List<Carnivore> carnivores = new ArrayList<>();
    private List<Herbivore> herbivores = new ArrayList<>();
    private HashMap<String, Integer> animalFemaleAndMaleMap = new HashMap<>();
    private int deathCounter = 0, newBornCounter = 0;

    public Ecosystem(List<Animal> list) {
        init(list);
    }

    /**
     * split the animals to carnivores and herbivores.
     * @param animalCollection gets the animals of the ecosystem.
     */
    private void init(List<Animal> animalCollection) {
        for (int i = 0; i < animalCollection.size(); i++) {
            if (animalCollection.get(i) instanceof Carnivore) {
                carnivores.add((Carnivore) animalCollection.get(i));
            } else {
                herbivores.add((Herbivore) animalCollection.get(i));
            }
        }
    }

    /**
     * simulate a year in the ecosystem.
     * @param iterations gets the iteration that we are in right now.
     */
    public void run(int iterations) {
        deathCounter = 0;
        newBornCounter = 0;

        reproduceCheck();
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
        System.out.println("Carnivore : " + carnivores.size());
        System.out.println("Newborns : " + newBornCounter);
        System.out.println("Death : " + deathCounter + "\n");


    }


    /**
     * Checks if the animal is ready to reproduce
     */
    private void reproduceCheck() {
        for (int i = 0; i < carnivores.size(); i++) {
            carnivores.get(i).isReadyToReproduceCheck();
        }
        for (int i = 0; i < herbivores.size(); i++) {
            herbivores.get(i).isReadyToReproduceCheck();
        }
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
                carnivores.get(i).attack(herbivores.get(chosenHerbivore), carnivores);
                if (!herbivores.get(chosenHerbivore).isAlive()){
                    herbivores.remove(chosenHerbivore);
                    deathCounter++;
                }
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
        int iterationsToReproduce = 0;
        RandomNumberGenerator randomNumber = new RandomNumberGeneratorRealInput();
        Animal newAnimal = null;
        Class<Animal> c = null;

        for (int i = 0; i < carnivores.size(); i++) {
            if (carnivores.get(i).isReadyToReproduceCheck()) {
                    animalFemaleAndMaleMap.put(carnivores.get(i).getGender() + carnivores.get(i).getClass()
                            .getName(), animalFemaleAndMaleMap.getOrDefault(carnivores.get(i).getGender()
                            + carnivores.get(i).getClass().getName(), 0) + 1);

            }
        }

        for (int i = 0; i < herbivores.size(); i++) {
            if (herbivores.get(i).isReadyToReproduceCheck()) {
                animalFemaleAndMaleMap.put(herbivores.get(i).getGender() + herbivores.get(i).getClass()
                        .getName(), animalFemaleAndMaleMap.getOrDefault( herbivores.get(i).getGender()
                        + herbivores.get(i).getClass().getName(), 0) + 1);

            }
        }

        for (Map.Entry<String, Integer> entry : animalFemaleAndMaleMap.entrySet()){
            if(entry.getKey().charAt(0) == 'M'){
                iterationsToReproduce = Math.min(animalFemaleAndMaleMap.get(entry.getKey()) == null ? 0
                        : animalFemaleAndMaleMap.get(entry.getKey()), animalFemaleAndMaleMap.get("FEMALE"
                        + entry.getKey().substring(4)) == null ? 0 : animalFemaleAndMaleMap.get("FEMALE"
                        + entry.getKey().substring(4)));
                newBornCounter += iterationsToReproduce;

                try {
                    c = (Class<Animal>) Class.forName(entry.getKey().substring(4));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

            for (int i = 0; i < iterationsToReproduce; i++){
                try {
                    newAnimal = c.getDeclaredConstructor(RandomNumberGenerator.class).newInstance(randomNumber);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }

                if (newAnimal instanceof Carnivore){
                    carnivores.add((Carnivore) newAnimal);
                } else {
                    herbivores.add((Herbivore) newAnimal);
                }
            }
        }
        animalFemaleAndMaleMap.clear();
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
                deathCounter++;
            }
        }

        for (int i = 0; i < herbivores.size(); i++) {
            if (!herbivores.get(i).isAlive()) {
                herbivores.remove(i);
                deathCounter++;
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
