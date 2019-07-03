import org.junit.Rule;
import org.junit.Test;
import org.junit.*;

import static org.junit.Assert.*;

public class EndangeredAnimalTest {
        @Rule
        public DatabaseRule database =new DatabaseRule();
        @Test
        public void EndangeredAnimal_instantiatesCorectly_true(){
            EndangeredAnimal  testEndangeredAnimal = new EndangeredAnimal("Lion",1);
            assertEquals(true,testEndangeredAnimal instanceof EndangeredAnimal);
        }
        @Test
        public void EndangeredAnimal_instantiatesWithName_Lion(){
            EndangeredAnimal  testEndangeredAnimal = new EndangeredAnimal("Lion",1);
            assertEquals("Lion",testEndangeredAnimal.getName());

        }
        @Test
        public void returnTrueIfNameAndIdAreSame_true(){
            EndangeredAnimal  testEndangeredAnimal = new EndangeredAnimal("Lion",1);
            EndangeredAnimal  anotherEndangeredAnimal = new EndangeredAnimal("Lion",1);
            assertEquals(true,testEndangeredAnimal.equals(anotherEndangeredAnimal));

        }
        @Test
        public void save_insertsEndangeredAnimalToDatabase_Animal() {
            EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Lion", 1);
            testEndangeredAnimal.save();
            assertTrue(EndangeredAnimal.all().get(0).equals(testEndangeredAnimal));
        }
        @Test
        public void all_returnsAllInstancesOfEndangeredAnimal_true(){
                EndangeredAnimal  firstEndangeredAnimal = new EndangeredAnimal("Lion",1);
                firstEndangeredAnimal.save();
                EndangeredAnimal  secondEndangeredAnimal = new EndangeredAnimal("Rabbit",2);
                secondEndangeredAnimal.save();
            assertEquals(true,EndangeredAnimal.all().get(0).equals(firstEndangeredAnimal));
            assertEquals(true,EndangeredAnimal.all().get(1).equals(secondEndangeredAnimal));
        }
        @Test
        public void save_assignsIdToEndangeredAnimal(){
            EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Lion", 1);
            testEndangeredAnimal.save();
            EndangeredAnimal savedEndangeredAnimal =EndangeredAnimal.all().get(0);
            assertEquals(testEndangeredAnimal.getId(),savedEndangeredAnimal.getId());
        }
        @Test
        public  void find_returnsEndangeredAnimalWithSameId_secondEndangeredAnimal(){
            EndangeredAnimal  firstEndangeredAnimal = new EndangeredAnimal("Lion",1);
            firstEndangeredAnimal.save();
            EndangeredAnimal  secondEndangeredAnimal = new EndangeredAnimal("Rabbit",2);
            secondEndangeredAnimal.save();
            assertEquals(EndangeredAnimal.find(secondEndangeredAnimal.getId()),secondEndangeredAnimal);
        }
//        @Test
//        public void EndangeredAnimal_instantiatesWithMaxHealthLevel() {
//            EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Lion", 1);
//            assertEquals(testEndangeredAnimal.);
//        }


    }

