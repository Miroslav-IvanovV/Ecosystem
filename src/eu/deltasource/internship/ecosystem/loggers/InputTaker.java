package eu.deltasource.internship.ecosystem.loggers;

import eu.deltasource.internship.ecosystem.animals.*;
import eu.deltasource.internship.ecosystem.enums.Biome;
import eu.deltasource.internship.ecosystem.utilities.RandomNumberGenerator;
import eu.deltasource.internship.ecosystem.utilities.RandomNumberGeneratorRealInput;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

public class InputTaker {

    public static final List<Animal> takingInput(String biome) {

        List<Animal> allAnimals = new ArrayList<>();
        RandomNumberGeneratorRealInput randomNumber = new RandomNumberGeneratorRealInput();

        allAnimals.add(new Tiger(randomNumber));
        allAnimals.add(new Buffalo(randomNumber));
        allAnimals.add(new Cheetah(randomNumber));
        allAnimals.add(new Gazelle(randomNumber));
        allAnimals.add(new Hare(randomNumber));
        allAnimals.add(new Hyena(randomNumber));
        allAnimals.add(new Lion(randomNumber));
        allAnimals.add(new Zebra(randomNumber));


        int input;
        Scanner scanner = new Scanner(System.in);
        List<Animal> listOfAnimals = new ArrayList<>();

        for (int i = 0; i < allAnimals.size(); i++) {
            if (allAnimals.get(i).checkInhabitedBiomes(biome)) {
                String nameOfAnimal = allAnimals.get(i).getClass().getSimpleName();
                System.out.println("how many of " + nameOfAnimal + " you want to add");
                input = scanner.nextInt();
                for (int j = 0; j < input; j++) {
                    try {
                        listOfAnimals.add(allAnimals.get(i).getClass()
                                .getDeclaredConstructor(RandomNumberGenerator.class).newInstance(randomNumber));
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        }

        return listOfAnimals;
    }

    public static int inputIterations() {
        System.out.println("How many years do you want to simulate.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static String chooseBiome() {
        String chosenBiome;
        Scanner scanner = new Scanner(System.in);
        Biome[] possibleValues = Biome.values();
        System.out.println("in which biome do you wanna simulate your ecosystem");
        System.out.print("choose from : ");
        for (int i = 0; i < possibleValues.length; i++) {
            System.out.print(possibleValues[i] + " ");
        }
        chosenBiome = scanner.nextLine();
        while (true) {
            for (int i = 0; i < possibleValues.length; i++) {
                if (chosenBiome.equalsIgnoreCase(possibleValues[i].toString())) {
                    return chosenBiome;
                }
            }
            System.out.println("wrong input, please select a valid biome");
            chosenBiome = scanner.nextLine();
        }
    }

}
