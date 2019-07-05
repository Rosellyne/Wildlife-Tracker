import org.junit.Rule;
import org.junit.Test;
import org.junit.*;

import static org.junit.Assert.*;

public class NonEndangeredAnimalTest {
    @Rule
    public DatabaseRule database =new DatabaseRule();
    @Test
    public void NonEndangeredAnimal_instantiatesCorectly_true(){
       NonEndangeredAnimal  testNonEndangeredAnimal = new NonEndangeredAnimal("Lion",1,"adult", "healthy");
        assertEquals(true,testNonEndangeredAnimal instanceof NonEndangeredAnimal);
    }
    @Test
    public void NonEndangeredAnimal_instantiatesWithName_Lion(){
       NonEndangeredAnimal  testNonEndangeredAnimal = new NonEndangeredAnimal("Lion",1,"adult", "healthy");
        assertEquals("Lion",testNonEndangeredAnimal.getName());

    }
    @Test
    public void returnTrueIfNameAndIdAreSame_true(){
        NonEndangeredAnimal  testNonEndangeredAnimal = new NonEndangeredAnimal("Lion",1,"adult", "healthy");
        NonEndangeredAnimal  anotherNonEndangeredAnimal = new NonEndangeredAnimal("Lion",1,"adult", "healthy");
        assertEquals(true,testNonEndangeredAnimal.equals(anotherNonEndangeredAnimal));

    }
    @Test
    public void save_insertsNonEndangeredAnimalToDatabase_Animal() {
        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Lion", 1,"adult", "healthy");
        testNonEndangeredAnimal.save();
        assertTrue(NonEndangeredAnimal.all().get(0).equals(testNonEndangeredAnimal));
    }
    @Test
    public void all_returnsAllInstancesOfNonEndangeredAnimal_true(){
        NonEndangeredAnimal  firstNonEndangeredAnimal = new NonEndangeredAnimal("Lion",1,"adult", "healthy");
        firstNonEndangeredAnimal.save();
        NonEndangeredAnimal  secondNonEndangeredAnimal = new NonEndangeredAnimal("Rabbit",2,"adult", "healthy");
        secondNonEndangeredAnimal.save();
        assertEquals(true,NonEndangeredAnimal.all().get(0).equals(firstNonEndangeredAnimal));
        assertEquals(true,NonEndangeredAnimal.all().get(1).equals(secondNonEndangeredAnimal));
    }
    @Test
    public void save_assignsIdToNonEndangeredAnimal(){
        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Lion", 1,"adult", "healthy");
        testNonEndangeredAnimal.save();
        NonEndangeredAnimal savedNonEndageredAnimal =NonEndangeredAnimal.all().get(0);
        assertEquals(testNonEndangeredAnimal.getId(),savedNonEndageredAnimal.getId());
    }
    @Test
    public  void find_returnsNonEndangeredAnimalWithSameId_secondNonEndangeredAnimal(){
        NonEndangeredAnimal  firstNonEndangeredAnimal = new NonEndangeredAnimal("Lion",1,"adult", "healthy");
        firstNonEndangeredAnimal.save();
       NonEndangeredAnimal  secondNonEndangeredAnimal = new NonEndangeredAnimal("Rabbit",2,"adult", "healthy");
        secondNonEndangeredAnimal.save();
        assertEquals(NonEndangeredAnimal.find(secondNonEndangeredAnimal.getId()),secondNonEndangeredAnimal);
    }
    @Test
    public void NonEndangeredAnimal_instantiatesWithMaxHealthLevel() {
        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Lion", 1, "adult", "healthy");
        assertEquals(testNonEndangeredAnimal.getHealth(),NonEndangeredAnimal.MAX_HEALTH_LEVEL);
    }
    @Test
    public void NonEndangeredAnimal_instantiatesWithMidHealthLevel() {
        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Lion", 1, "adult", "okay");
        assertEquals(testNonEndangeredAnimal.getHealth(),NonEndangeredAnimal.MID_HEALTH_LEVEL);
    }
    @Test
    public void NonEndangeredAnimal_instantiatesWithMinHealthLevel() {
        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Lion", 1, "adult", "ill");
        assertEquals(testNonEndangeredAnimal.getHealth(),NonEndangeredAnimal.MIN_HEALTH_LEVEL);
    }
    @Test
    public void NonEndangeredAnimal_instantiatesWithMaxAgeLevel() {
        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Lion", 1, "adult", "ill");
        assertEquals(testNonEndangeredAnimal.getAge(),NonEndangeredAnimal.MAX_AGE_LEVEL);
    }
    @Test
    public void NonEndangeredAnimal_instantiatesWithMidAgeLevel() {
        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Lion", 1, "young", "ill");
        assertEquals(testNonEndangeredAnimal.getAge(), NonEndangeredAnimal.MID_AGE_LEVEL);
    }
    @Test
    public void NonEndangeredAnimal_instantiatesWithMinAgeLevel() {
        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Lion", 1, "newborn", "ill");
        assertEquals(testNonEndangeredAnimal.getAge(), NonEndangeredAnimal.MIN_AGE_LEVEL);
    }


}