package eu.deltasource.internship.ecosystem.ecosystems;

import eu.deltasource.internship.ecosystem.animals.Animal;
import eu.deltasource.internship.ecosystem.animals.Carnivore;
import eu.deltasource.internship.ecosystem.animals.Herbivore;
import eu.deltasource.internship.ecosystem.enums.LivingTypes;
import eu.deltasource.internship.ecosystem.utilities.RandomNumberGeneratorRealInput;

import java.util.ArrayList;
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

        attack();
        reproduce(iterations);
        age();
        ageCheck();
        increaseStarvation();
        starvationCheck();
        cleanDeadAnimals();
        System.out.println(carnivores.size());

    }

    private static void increaseStarvation() {
        for (int i = 0; i < carnivores.size(); i++) {
            carnivores.get(i).setHungerLevel(carnivores.get(i).getHungerLevel() + 20);
        }
    }

    private static void attack() {
        RandomNumberGeneratorRealInput randomNum = new RandomNumberGeneratorRealInput();
        boolean isAttackSuccessful = false;
        int numberOfAnimalsInTHeGroup;
        for (int i = 0; i < carnivores.size(); i++) {
            if (herbivores.size() > 0) {
                int chosenHerbivore = randomNum.randomNumber(0, herbivores.size() - 1);
                isAttackSuccessful = carnivores.get(i).attack(herbivores.get(chosenHerbivore));
                if (isAttackSuccessful == true) {
                    if (carnivores.get(i).getLivingType().equals(LivingTypes.GROUP)) {
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
                    } else {
                        carnivores.get(i).eat(herbivores.get(chosenHerbivore), 1);
                    }
                }
            }
        }
    }

    private static void starvationCheck() {
        for (int i = 0; i < carnivores.size(); i++) {
            if (carnivores.get(i).getHungerLevel() >= 100) {
                carnivores.get(i).setAlive(false);
            }
        }
    }

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

    private static void reproduce(int iterations) {
        for (int i = 0; i < carnivores.size(); i++) {
            if (iterations % carnivores.get(i).getReproductionRate() == 0) {
                i++;
                while (i < carnivores.size()) {
                    if (iterations % carnivores.get(i).getReproductionRate() == 0) {
                        carnivores.add((Carnivore) carnivores.get(i).reproduce());
                        i++;
                        break;
                    }
                    i++;
                }
            }
        }

        for (int i = 0; i < herbivores.size(); i++) {
            if (iterations % herbivores.get(i).getReproductionRate() == 0) {
                i++;
                while (i < herbivores.size()) {
                    if (iterations % herbivores.get(i).getReproductionRate() == 0) {
                        herbivores.add((Herbivore) herbivores.get(i).reproduce());
                        i++;
                        break;
                    }
                    i++;
                }
            }
        }
    }

    private static void age() {
        for (int i = 0; i < carnivores.size(); i++) {
            carnivores.get(i).setAge(carnivores.get(i).getAge() + 1);
        }

        for (int i = 0; i < herbivores.size(); i++) {
            herbivores.get(i).setAge(herbivores.get(i).getAge() + 1);
        }
    }

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
