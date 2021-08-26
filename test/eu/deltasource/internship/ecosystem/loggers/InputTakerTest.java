package eu.deltasource.internship.ecosystem.loggers;

import eu.deltasource.internship.ecosystem.animals.Animal;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputTakerTest {

    @Test
    void takingInput() {
        //GIVEN
        List<Animal> list;
        String input = "Savanna";
        String inputForAnimals = "0\r0\r0\r0\r0\r0\r0\r1";
        InputStream in = new ByteArrayInputStream(inputForAnimals.getBytes());
        System.setIn(in);

        //WHEN
        list = InputTaker.takingInput(input);

        //THEN
        assertTrue(list.size() == 1);

    }
    @Test
    void chooseBiome() {
        //GIVEN
        String inputForAnimals = "savanna";
        InputStream in = new ByteArrayInputStream(inputForAnimals.getBytes());
        System.setIn(in);

        //WHEN
        String string = InputTaker.chooseBiome();

        //THEN
        assertTrue(string.equalsIgnoreCase("SAVANNA"));


    }
}