package eu.deltasource.internship.ecosystem.loggers;

import eu.deltasource.internship.ecosystem.Simulator;
import eu.deltasource.internship.ecosystem.animals.*;
import eu.deltasource.internship.ecosystem.enums.Biomes;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

public class InoutTaker {

    public static void takingInput(String biome) {

        List<Animal> allAnimals = new ArrayList<>();

        allAnimals.add(new Buffalo());
        allAnimals.add(new Cheetah());
        allAnimals.add(new Gazelle());
        allAnimals.add(new Hare());
        allAnimals.add(new Hyena());
        allAnimals.add(new Lion());
        allAnimals.add(new Tiger());
        allAnimals.add(new Zebra());


        int input, iterations = 0;
        Scanner scanner = new Scanner(System.in);
        List<Animal> listOfAnimals = new ArrayList<>();

        for (int i = 0; i < allAnimals.size(); i++){
            if (allAnimals.get(i).checkInhabitedBiomes(biome)){
                String nameOfAnimal = allAnimals.get(i).getClass().getName().substring(44);
                System.out.println("how many of " + nameOfAnimal +" you want to add");
                input = scanner.nextInt();
                for (int j = 0; j < input; j++){
                    try{
                        listOfAnimals.add(allAnimals.get(i).getClass().newInstance());
                    } catch (Exception e){
                        System.out.println(e);
                    }
                }
            }
        }

        iterations = inputIterations();
        Simulator.simulate(listOfAnimals, iterations);
    }

    public static int inputIterations(){
        System.out.println("How many years do you want to simulate.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static String chooseBiome(){
        String chosenBiome;
        Scanner scanner = new Scanner(System.in);
        Biomes[] possibleValues = Biomes.values();
        System.out.println("in which biome do you wanna simulate your ecosystem");
        System.out.print("choose from : ");
        for (int i = 0; i < possibleValues.length; i++){
            System.out.print(possibleValues[i] + " ");
        }
        chosenBiome = scanner.nextLine();
        while (true){
            for (int i = 0; i < possibleValues.length; i++){
                if (chosenBiome.equalsIgnoreCase(possibleValues[i].toString())){
                    return chosenBiome;
                }
            }
            System.out.println("wrong input, please select a valid biome");
            chosenBiome = scanner.nextLine();
        }
    }

}
