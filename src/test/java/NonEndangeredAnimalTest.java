import org.junit.Rule;
import org.junit.Test;
import org.junit.*;

import static org.junit.Assert.*;

public class NonEndangeredAnimalTest {
    @Rule
    public DatabaseRule database =new DatabaseRule();
    @Test
    public void NonEndangeredAnimal_instantiatesCorectly_true(){
       NonEndangeredAnimal  testNonEndangeredAnimal = new NonEndangeredAnimal("Lion",1);
        assertEquals(true,testNonEndangeredAnimal instanceof NonEndangeredAnimal);
    }
    @Test
    public void NonEndangeredAnimal_instantiatesWithName_Lion(){
       NonEndangeredAnimal  testNonEndangeredAnimal = new NonEndangeredAnimal("Lion",1);
        assertEquals("Lion",testNonEndangeredAnimal.getName());

    }
    @Test
    public void returnTrueIfNameAndIdAreSame_true(){
        NonEndangeredAnimal  testNonEndangeredAnimal = new NonEndangeredAnimal("Lion",1);
        NonEndangeredAnimal  anotherNonEndangeredAnimal = new EndangeredAnimal("Lion",1);
        assertEquals(true,testNonEndangeredAnimal.equals(anotherNonEndangeredAnimal));

    }
    @Test
    public void save_insertsNonEndangeredAnimalToDatabase_Animal() {
        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Lion", 1);
        testNonEndangeredAnimal.save();
        assertTrue(NonEndangeredAnimal.all().get().eqquals(testNonEndangeredAnimal));
    }
    @Test
    public void all_returnsAllInstancesOfNonEndageredAnimal_true(){
        NonEndangeredAnimal  firstNonEndangeredAnimal = new NonEndangeredAnimal("Lion",1);
        firstNonEndangeredAnimal.save();
        NonEndangeredAnimal  secondNonEndangeredAnimal = new NonEndangeredAnimal("Rabbit",2);
        secondNonEndangeredAnimal.save();
        assertEquals(true,NonEndangeredAnimal.all().get(0).equals(firstNonEndangeredAnimal));
        assertEquals(true,NonEndangeredAnimal.all().get(1).equals(secondNonEndangeredAnimal));
    }
    @Test
    public void save_assignsIdToNonEndangeredAnimal(){
        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Lion", 1);
        testNonEndangeredAnimal.save();
        NonEndangeredAnimal savedNonEndageredAnimal =NonEndangeredAnimal.all().get(0);
        assertEquals(testNonEndangeredAnimal.getId(),savedNonEndageredAnimal.getId());
    }
    @Test
    public  void find_returnsNonEndangeredAnimalWithSameId_secondNonEndangeredAnimal(){
        NonEndangeredAnimal  firstNonEndangeredAnimal = new NonEndangeredAnimal("Lion",1);
        firstNonEndangeredAnimal.save();
       NonEndangeredAnimal  secondNonEndangeredAnimal = new NonEndangeredAnimal("Rabbit",2);
        secondNonEndangeredAnimal.save();
        assertEquals(NonEndangeredAnimal.find(secondNonEndangeredAnimal.getId()),secondNonEndangeredAnimal);
    }


}