package eu.deltasource.internship.ecosystem.animals;

import eu.deltasource.internship.ecosystem.utilities.RandomNumberGenerator;
import eu.deltasource.internship.ecosystem.utilities.RandomNumberGeneratorTestInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    private RandomNumberGenerator randomNumber;

    @BeforeEach
    void initRandomNumber(){
        randomNumber = new RandomNumberGeneratorTestInput();
    }

    @Test
    void reproduce() {

        //Given
        AnimalTestUnit animal = new AnimalTestUnit(randomNumber);

        //WHEN
        Animal reproduceTest = animal.reproduce();

        //THEN
        assertTrue(reproduceTest instanceof AnimalTestUnit);
    }

    @Test
    void checkInhabitedBiomes() {

        //Given
        AnimalTestUnit animal = new AnimalTestUnit(randomNumber);

        //THEN
        assertTrue(animal.checkInhabitedBiomes("Savanna"));
    }

    @Test
    void die() {

        //Given
        AnimalTestUnit animal = new AnimalTestUnit(randomNumber);

        //WHEN
        animal.die();

        //THEN
        assertFalse(animal.isAlive());
    }

    @Test
    void ageing() {

        //GIVEN
        AnimalTestUnit animal = new AnimalTestUnit(randomNumber);
        int animalAgeBeforeAgeing = animal.getAge();

        //WHEN
        animal.ageing();

        //THEN
        assertTrue(animal.getAge() == animalAgeBeforeAgeing + 1);
    }

    @Test
    void ageCheck() {

        //GIVEN
        AnimalTestUnit animal = new AnimalTestUnit(randomNumber);

        //WHEN
        for (int i = 0; i < 5; i++){
            animal.ageing();
        }
        animal.ageCheck();

        //THEN
        assertFalse(animal.alive);
    }
}