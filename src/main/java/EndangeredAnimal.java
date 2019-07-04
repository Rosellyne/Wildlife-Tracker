import org.sql2o.*;

import java.util.List;

public class EndangeredAnimal extends Animal {
    public String age;
    public String health;

    public EndangeredAnimal(String name,int id,String age,String health){
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

    public  static List<EndangeredAnimal> all(){
        String sql="SELECT *FROM animals";
        try(Connection con=DB.sql2o.open()){
            return con.createQuery(sql).executeAndFetch(EndangeredAnimal.class);
        }
    }
    public  static EndangeredAnimal find(int id){
        try(Connection con=DB.sql2o.open()){
            String sql="SELECT *FROM animals where id=:id";
            EndangeredAnimal animal=con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(EndangeredAnimal.class);
            return  animal;
        }
    }
}
