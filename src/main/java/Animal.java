
import java.util.List;
import java.util.Objects;
import org.sql2o.*;

public  abstract class Animal {
    public String name;
    public int id;


    public int getId() {
        return id;
    }

//    public Animal(String name, int id) {
//        this.name = name;
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return id == animal.id &&
                Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
    public void save(){
        try(Connection con=DB.sql2o.open()){
            String sql="INSERT INTO animals(name) VALUES(:name)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name",this.name)
                    .executeUpdate()
            .getKey();
        }
    }
//    public  static List<Animal> all(){
//        String sql="SELECT *FROM animals";
//        try(Connection con=DB.sql2o.open()){
//            return con.createQuery(sql).executeAndFetch(Animal.class);
//        }
//    }
//    public  static Animal find(int id){
//        try(Connection con=DB.sql2o.open()){
//            String sql="SELECT *FROM animals where id=:id";
//            Animal animal=con.createQuery(sql)
//                    .addParameter("id",id)
//                    .executeAndFetchFirst(Animal.class);
//            return  animal;
//        }
//    }
}