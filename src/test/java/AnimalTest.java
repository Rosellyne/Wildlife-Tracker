import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.*;

public class AnimalTest {
    @Test
    public void animal_instantiatesCorectly_true(){
        Animal  testAnimal = new Animal("Lion",1);
        assertEquals(true,testAnimal instanceof Animal);
    }
    @Test
    public void getName_animalinstantiatesWithName_Lion(){
        Animal  testAnimal = new Animal("Lion",1);
        assertEquals("Lion",testAnimal.getName());

    }
    @Test
    public void returnTrueIfNameAndIdAreSame_true(){
        Animal  testAnimal = new Animal("Lion",1);
        Animal  secondAnimal = new Animal("Lion",1);
        assertTrue(testAnimal.equals(secondAnimal));

    }
    @Test
    public void save_insertsObjectsIntoDatabase_Animal(){
        Animal  testAnimal = new Animal("Lion",1);
        testAnimal.save();
        assertEquals(Animal.all().get(0).equals(testAnimal));
    }



}