import org.junit.Rule;
import org.junit.Test;
import org.junit.*;

import static org.junit.Assert.*;

public class EndangeredAnimalTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void EndangeredAnimal_instantiatesCorectly_true() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Lion", 1, "adult", "healthy");
        assertEquals(true, testEndangeredAnimal instanceof EndangeredAnimal);
    }

    @Test
    public void EndangeredAnimal_instantiatesWithName_Lion() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Lion", 1, "adult", "healthy");
        assertEquals("Lion", testEndangeredAnimal.getName());

    }

    @Test
    public void EndangeredAnimal_instantiatesWithAge_adult() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Lion", 1, "adult", "healthy");
        assertEquals("adult", testEndangeredAnimal.getAge());
    }

    @Test
    public void EndangeredAnimal_instantiatesWithHealth_healthy() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Lion", 1, "adult", "healthy");
        assertEquals("healthy", testEndangeredAnimal.getHealth());
    }

    @Test
    public void returnTrueIfNameAndIdAreSame_true() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Lion", 1, "adult", "healthy");
        EndangeredAnimal anotherEndangeredAnimal = new EndangeredAnimal("Lion", 1, "adult", "healthy");
        assertEquals(true, testEndangeredAnimal.equals(anotherEndangeredAnimal));

    }

    @Test
    public void save_insertsEndangeredAnimalToDatabase_Animal() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Lion", 1, "adult", "healthy");
        testEndangeredAnimal.save();
        assertTrue(EndangeredAnimal.all().get(0).equals(testEndangeredAnimal));
    }

    @Test
    public void all_returnsAllInstancesOfEndangeredAnimal_true() {
        EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Lion", 1, "adult", "healthy");
        firstEndangeredAnimal.save();
        EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Rabbit", 2, "young", "okay");
        secondEndangeredAnimal.save();
        assertEquals(true, EndangeredAnimal.all().get(0).equals(firstEndangeredAnimal));
        assertEquals(true, EndangeredAnimal.all().get(1).equals(secondEndangeredAnimal));
    }

    @Test
    public void save_assignsIdToEndangeredAnimal() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Lion", 1, "adult", "healthy");
        testEndangeredAnimal.save();
        EndangeredAnimal savedEndangeredAnimal = EndangeredAnimal.all().get(0);
        assertEquals(testEndangeredAnimal.getId(), savedEndangeredAnimal.getId());
    }

    @Test
    public void find_returnsEndangeredAnimalWithSameId_secondEndangeredAnimal() {
        EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Lion", 1, "adult", "healthy");
        firstEndangeredAnimal.save();
        EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Rabbit", 2, "adult", "healthy");
        secondEndangeredAnimal.save();
        assertEquals(EndangeredAnimal.find(secondEndangeredAnimal.getId()), secondEndangeredAnimal);
    }

    @Test
    public void EndangeredAnimal_instantiatesWithMaxHealthLevel() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Lion", 1, "adult", "healthy");
        assertEquals(testEndangeredAnimal.getHealth(),EndangeredAnimal.MAX_HEALTH_LEVEL);
    }
    @Test
    public void EndangeredAnimal_instantiatesWithMidHealthLevel() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Lion", 1, "adult", "okay");
        assertEquals(testEndangeredAnimal.getHealth(),EndangeredAnimal.MID_HEALTH_LEVEL);
    }
    @Test
    public void EndangeredAnimal_instantiatesWithMinHealthLevel() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Lion", 1, "adult", "ill");
        assertEquals(testEndangeredAnimal.getHealth(),EndangeredAnimal.MIN_HEALTH_LEVEL);
    }
    @Test
    public void EndangeredAnimal_instantiatesWithMaxAgeLevel() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Lion", 1, "adult", "ill");
        assertEquals(testEndangeredAnimal.getAge(),EndangeredAnimal.MAX_AGE_LEVEL);
    }
    @Test
    public void EndangeredAnimal_instantiatesWithMidAgeLevel() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Lion", 1, "young", "ill");
        assertEquals(testEndangeredAnimal.getAge(), EndangeredAnimal.MID_AGE_LEVEL);
    }
    @Test
    public void EndangeredAnimal_instantiatesWithMinAgeLevel() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Lion", 1, "newborn", "ill");
        assertEquals(testEndangeredAnimal.getAge(), EndangeredAnimal.MIN_AGE_LEVEL);
    }
}




