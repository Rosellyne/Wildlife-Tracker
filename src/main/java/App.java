import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
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
            return new ModelAndView(model,"sighting.hbs");
        },new HandlebarsTemplateEngine());



        get ("/animal",(request, response) -> {
            Map<String,Object>model =new HashMap<>();
            return new ModelAndView(model,"animal-form.hbs");
        },new HandlebarsTemplateEngine());
    }
}
