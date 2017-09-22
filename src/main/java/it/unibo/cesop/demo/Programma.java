package it.unibo.cesop.demo;

import spark.ModelAndView;
import spark.template.jade.JadeTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Programma {

    public static void main(String[] args){

        //Set Java Spark server port
        port(8080);

        //Set static file folder
        staticFileLocation("/public/css");

        //URL Solr
        final String url = "http://localhost:8983/solr";

        get("/", (request, response) -> {
            Map<String, String> model = new HashMap<>();
            model.put("message", "Hello Jade!");
            return new ModelAndView(model, "index"); // located in resources/templates directory
        }, new JadeTemplateEngine());

        post("/cerca", (request, response) -> {
            //Start time
            float startTime = System.currentTimeMillis();

            String cerca = request.queryParams("cerca");
            Map<String, String> model = new HashMap<>();
            model.put("message", cerca);
            float endTime = System.currentTimeMillis();
            float total = (endTime - startTime) / 1000;
            model.put("total", String.valueOf(total));

            return new ModelAndView(model, "cerca"); // located in resources/templates directory
        }, new JadeTemplateEngine());


    }
}
