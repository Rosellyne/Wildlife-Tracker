import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.staticFileLocation;
import static spark.Spark.*;


public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");


        get("/",(request, response) -> {
            Map<String,Object>model =new HashMap<>();
            return new ModelAndView(model,"index.hbs");
        },new HandlebarsTemplateEngine());

        get ("/sighting",(request, response) -> {
            Map<String,Object>model =new HashMap<>();
            return new ModelAndView(model,"sighting-form.hbs");
        },new HandlebarsTemplateEngine());

        post("/sighting/new",(request,response)->{
            Map<String, Object> model = new HashMap<>();
            String sightingLocation=request.queryParams("sightingLocation");
            String animalAge = request.queryParams(" animalAge");
            String animalName = request.queryParams("animalName");
            String animalHealth = request.queryParams("animalHealth");
            String userName = request.queryParams("userName");
            List<Sighting> allSightings = Sighting.all();
            List<EndangeredAnimal> allAnimal= EndangeredAnimal.all();
            List<NonEndangeredAnimal> animal=NonEndangeredAnimal.all();
            model.put("sightings",allSightings);
            model.put("animal",allAnimal);
            model.put("animal",animal);
            return new ModelAndView(model,"sighting.hbs");
        },new HandlebarsTemplateEngine());



        get ("/animal",(request, response) -> {
            Map<String,Object>model =new HashMap<>();
            return new ModelAndView(model,"animal-form.hbs");
        },new HandlebarsTemplateEngine());


        post("/animal/new",(request,response)->{
            Map<String, Object> model = new HashMap<>();
            boolean endangered = request.queryParams("endangered")!=null;
            if (endangered) {
                String name = request.queryParams("name");
//                EndangeredAnimal endangeredAnimal = new EndangeredAnimal;
//                endangeredAnimal.save();
            }else{
                String name = request.queryParams("name");

            }

            return new ModelAndView(model,"sighting.hbs");
        },new HandlebarsTemplateEngine());
    }
}
