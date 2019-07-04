import org.sql2o.*;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

public class Sighting implements DatabaseManagement{
    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public int getAnimalId() {
        return animalId;
    }

    public String getName() {
        return name;
    }

    private String name;
    private int id;
    private String location;
    private int animalId;
    private Timestamp timestamp;

    public Timestamp getTimestamp() {
        return timestamp;

    }
    public Sighting(String name, String location, int animalId){
        this.name=name;
        this.location=location;
        this.animalId=animalId;


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sighting)) return false;
        Sighting sighting = (Sighting) o;
        return id == sighting.id &&
                animalId == sighting.animalId &&
                Objects.equals(name, sighting.name) &&
                Objects.equals(location, sighting.location) &&
                Objects.equals(timestamp, sighting.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, location, animalId, timestamp);
    }
    public static List<Sighting>all(){
        String sql ="SELECT * FROM sightings";
        String now="SELECT timestamp FROM sightings";
        try(Connection con=DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Sighting.class);
        }
    }


    public static Sighting find(int id){
        String sql ="SELECT*FROM sightings WHERE id=:id";
        try(Connection con=DB.sql2o.open()){
            Sighting sighting =con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sighting.class);
            return sighting;

        }
    }

    public void save(){
        try(Connection con =DB.sql2o.open()){
            String sql="INSERT INTO sightings(name,location,animalId,timestamp)VALUES(:name,:location,:animalId,now())";

            this.id =(int)con.createQuery(sql,true)
                    .addParameter("name",this.name)
                    .addParameter("location",this.location)
                    .addParameter("animalId",this.animalId)
                    .executeUpdate()
                    .getKey();
            System.out.println(this.id);
        }
    }
    @Override
    public void delete(){
        try(Connection con=DB.sql2o.open()){
            String sql="DELETE FROM sightings WHERE id=:id";
            con.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        }
    }


}
