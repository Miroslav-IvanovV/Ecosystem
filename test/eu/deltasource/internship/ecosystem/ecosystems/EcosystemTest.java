package eu.deltasource.internship.ecosystem.ecosystems;

import eu.deltasource.internship.ecosystem.animals.Animal;
import eu.deltasource.internship.ecosystem.animals.Buffalo;
import eu.deltasource.internship.ecosystem.animals.Cheetah;
import eu.deltasource.internship.ecosystem.animals.Hyena;
import eu.deltasource.internship.ecosystem.utilities.RandomNumberGenerator;
import eu.deltasource.internship.ecosystem.utilities.RandomNumberGeneratorTestInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EcosystemTest {
    private RandomNumberGenerator randomNumber;

    @BeforeEach
    void initRandomNumber(){
        randomNumber = new RandomNumberGeneratorTestInput();
    }

    @Test
    void init() {

        //GIVEN
        List<Animal> listWithAnimals = new ArrayList<>();
        listWithAnimals.add(new Buffalo(randomNumber));
        listWithAnimals.add(new Cheetah(randomNumber));

        //WHEN
        Ecosystem ecosystem = new Ecosystem(listWithAnimals);

        //THEN
        assertTrue(ecosystem.getCarnivores().size() == 1 && ecosystem.getHerbivores().size() == 1);
    }

    @Test
    void run() {
        //GIVEN
        List<Animal> list = new ArrayList<>();
        list.add(new Hyena(randomNumber));
        Ecosystem ecosystem = new Ecosystem(list);

        //WHEN
        ecosystem.run(1);

        //THEN
        assertTrue(list.size() == 1);
    }
}