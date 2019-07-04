import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class SightingTest {
    @Rule
     public DatabaseRule database =new DatabaseRule();
    @Test
    public  void  Sighting_instantiatesCorrectly_true(){
        Sighting newSighting = new Sighting("purity","Zone A",1);
        assertTrue(newSighting instanceof Sighting);
    }
    @Test
    public  void  Sighting_isSavedOnDatabase_true(){
        Sighting newSighting = new Sighting("purity","Zone A",1);
        newSighting.save();
        assertTrue(Sighting.all().get(0).equals(newSighting));
    }
//    @Test
//    public  void  Sighting_returnsSightingWithSameId_SecondSighting(){
//        Sighting firstSighting = new Sighting("purity","Zone A",1);
//        firstSighting.save();
//        Sighting secondSighting = new Sighting("bradley","Zone C",2);
//        secondSighting.save();
//        assertEquals(secondSighting,Sighting.find(secondSighting.getId()));
//    }
//    @Test
//    public  void  Sighting_assignsAnIdToEachSighting_getId(){
//        Sighting newSighting = new Sighting("purity","Zone A",1);
//        newSighting.save();
//       Sighting testSighting = Sighting.all().get(0);
//        assertEquals(newSighting.getId(),newSighting.getId());
//    }
//    @Test
//    public  void  Sighting_canBeDeletedFromDatabase_true(){
//        Sighting newSighting = new Sighting("bilha","Zone D",3);
//        newSighting.save();
//        newSighting.delete();
//        assertEquals(0,Sighting.all().size());
//    }

}