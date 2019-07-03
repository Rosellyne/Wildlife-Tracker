import java.sql.Timestamp;

public class Sighting {
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private String name;
    private int id;
    private String location;
    private int animalId;
    private Timestamp timestamp;
}
