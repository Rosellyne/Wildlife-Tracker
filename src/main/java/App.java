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
            String location=request.queryParams("location");
            String age = request.queryParams(" age");
            String animalName = request.queryParams("animalName");
            String health = request.queryParams("health");
            String species = request.queryParams("species");
            String ranger = request.queryParams("ranger");
            Sighting newSighting = new Sighting(animalName,location,1);
            newSighting.save();
            List<Sighting> allSightings = Sighting.all();
            List<EndangeredAnimal> allAnimal= EndangeredAnimal.all();
            List<NonEndangeredAnimal> animal=NonEndangeredAnimal.all();
            model.put("sightings",Sighting.all());
            model.put("animal",allAnimal);
            model.put("animal",animal);
            model.put("animal",animalName);
            return new ModelAndView(model,"sighting.hbs");
        },new HandlebarsTemplateEngine());




        get ("/sighting/new",(request, response) -> {
            Map<String,Object>model =new HashMap<>();
            model.put("sightings",Sighting.all());
            model.put("animal",EndangeredAnimal.all());
            model.put("animals",NonEndangeredAnimal.all());
            return new ModelAndView(model,"sighting.hbs");
        },new HandlebarsTemplateEngine());

    }
}
