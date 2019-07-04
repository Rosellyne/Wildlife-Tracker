import org.sql2o.*;

import java.util.List;

public class NonEndangeredAnimal extends Animal{
//    private String age;
//    private String health;

    public NonEndangeredAnimal(String name,int id){
        this.name=name;
        this.id=id;
//        this.age ="";
//        this.health ="";
    }
    public  static List<NonEndangeredAnimal> all(){
        String sql="SELECT *FROM animals";
        try(Connection con=DB.sql2o.open()){
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(NonEndangeredAnimal.class);
        }
    }
    public  static NonEndangeredAnimal find(int id){
        try(Connection con=DB.sql2o.open()){
            String sql="SELECT *FROM animals where id=:id";
            NonEndangeredAnimal animal=con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(NonEndangeredAnimal.class);
            return  animal;
        }
    }
}
