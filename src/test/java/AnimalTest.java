//import org.junit.Test;
//import org.junit.*;
//import static org.junit.Assert.*;
//
//public class AnimalTest {
//    @Rule
//    public DatabaseRule database =new DatabaseRule();
//    @Test
//    public void animal_instantiatesCorectly_true(){
//        Animal  testAnimal = new Animal("Lion",1);
//        assertEquals(true,testAnimal instanceof Animal);
//    }
//    @Test
//    public void getName_animalinstantiatesWithName_Lion(){
//        Animal  testAnimal = new Animal("Lion",1);
//        assertEquals("Lion",testAnimal.getName());
//
//    }
//    @Test
//    public void returnTrueIfNameAndIdAreSame_true(){
//        Animal  testAnimal = new Animal("Lion",1);
//        Animal  secondAnimal = new Animal("Lion",1);
//        assertTrue(testAnimal.equals(secondAnimal));
//
//    }
//    @Test
//    public void save_insertsObjectsIntoDatabase_Animal(){
//        Animal  testAnimal = new Animal("Lion",1);
//        testAnimal.save();
//        assertTrue(Animal.all().get(0).equals(testAnimal));
//    }
//
//    @Test
//    public void all_returnsAllInstancesOfAnimal_true(){
//        Animal  firstAnimal = new Animal("Lion",1);
//        Animal  secondAnimal = new Animal("Rabbit",2);
//        firstAnimal.save();
//        secondAnimal.save();
//        assertEquals(true,Animal.all().get(0).equals(firstAnimal));
//        assertEquals(true,Animal.all().get(1).equals(secondAnimal));
//    }
//    @Test
//    public void save_assignsIdToObject(){
//        Animal  testAnimal = new Animal("Lion",1);
//        testAnimal.save();
//        Animal savedAnimal =Animal.all().get(0);
//        assertEquals(testAnimal.getId(),savedAnimal.getId());
//    }
//    @Test
//    public  void find_returnsAnimalWithSameId_secondAnimal(){
//     Animal  firstAnimal = new Animal("Lion",1);
//        firstAnimal.save();
//        Animal  secondAnimal = new Animal("Rabbit",2);
//        secondAnimal.save();
//    assertEquals(Animal.find(secondAnimal.getId()),secondAnimal);
//}
//
//
//}