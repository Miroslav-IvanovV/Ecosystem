package eu.deltasource.internship.ecosystem.animals;

import eu.deltasource.internship.ecosystem.utilities.RandomNumberGenerator;
import eu.deltasource.internship.ecosystem.utilities.RandomNumberGeneratorTestInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarnivoreTest {
    private RandomNumberGenerator randomNumber;

    @BeforeEach
    void initRandomNumber(){
        randomNumber = new RandomNumberGeneratorTestInput();
    }

    @Test
    void attack() {
        //GIVEN
        List<Carnivore> carnivoreList = new ArrayList<>();
        Carnivore carnivore = new CarnivoreTestUnit(randomNumber);
        Herbivore herbivore = new Hare(randomNumber);
        carnivoreList.add(carnivore);

        //WHEN
        carnivore.attack(herbivore,carnivoreList);

        //THEN
        assertFalse(herbivore.isAlive());
    }

    @Test
    void eat() {
        //GIVEN
        CarnivoreTestUnit carnivore = new CarnivoreTestUnit(randomNumber);
        Herbivore bunny = new Hare(randomNumber);

        //WHEN
        carnivore.eat(bunny,1);

        //THEN
        assertTrue(carnivore.getHungerLevel() == 10);
    }

    @Test
    void starvationCheck() {

        //GIVEN
        CarnivoreTestUnit carnivore = new CarnivoreTestUnit(randomNumber);

        //WHEN
        carnivore.increaseStarvation();
        carnivore.starvationCheck();

        //THEN
        assertFalse(carnivore.isAlive());
    }

    @Test
    void increaseStarvation() {
        //GIVEN
        CarnivoreTestUnit carnivore = new CarnivoreTestUnit(randomNumber);

        //WHEN
        carnivore.increaseStarvation();

        //THEN
        assertTrue(carnivore.getHungerLevel() == 100);
    }


    @Test
    void groupCarnivoreFeast() {
        //GIVEN
        List<Carnivore> carnivoreList = new ArrayList<>();
        Herbivore here = new Hare(randomNumber);
        for (int i = 0; i < 5; i++){
            carnivoreList.add(new CarnivoreTestUnit(randomNumber));
        }

        //WHEN
        carnivoreList.get(0).groupCarnivoreFeast(here,carnivoreList);

        //THEN
        assertTrue(carnivoreList.get(0).getHungerLevel() == 14);

    }

}