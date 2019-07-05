import org.sql2o.*;

import java.util.List;

public class NonEndangeredAnimal extends Animal{

    public String age;
    public String health;

    public String getAge() {
        return age;
    }

    public String getHealth() {
        return health;
    }

    public NonEndangeredAnimal(String name, int id, String age, String health){
        this.name =name;
        this.id =id;
        this.age =age;
        this.health=health;

    }
    public static  final String MAX_HEALTH_LEVEL = "healthy";
    public static  final String MID_HEALTH_LEVEL = "okay";
    public static  final String MIN_HEALTH_LEVEL = "ill";

    public static  final String MAX_AGE_LEVEL = "adult";
    public static  final String MID_AGE_LEVEL = "young";
    public static  final String MIN_AGE_LEVEL = "newborn";

    public  static List<NonEndangeredAnimal> all(){
        String sql="SELECT *FROM animals";
        try(Connection con=DB.sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetch(NonEndangeredAnimal.class);
        }
    }
    public  static NonEndangeredAnimal find(int id) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT *FROM animals where id=:id";
            NonEndangeredAnimal animal = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(NonEndangeredAnimal.class);
            return animal;
        }

    }

    @Override
    public void save() {
        try(Connection con=DB.sql2o.open()){
            String sql="INSERT INTO animals (name,age,health,id)VALUES(:name,:age,:health,:id)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("age", this.age)
                    .addParameter("health", this.health)
                    .addParameter("id", this.id)
                    .executeUpdate()
                    .getKey();
        }

    }
}
