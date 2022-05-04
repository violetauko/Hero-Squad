package com;

import com.models.Hero;
import com.models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static spark.Spark.*;

import static spark.Spark.staticFileLocation;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }
    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");
        Squad.setUpNewSquad();
        Hero.setUpNewHero();



        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());
// show new hero form
        get("/hero-form",(request, response) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

//process hero form
        post("/hero/new",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            Integer age = Integer.valueOf(req.queryParams("age"));
            String specialPower = req.queryParams("specialPower");
            String weakness = req.queryParams("weakness");
            Hero hero = new Hero(name,age,specialPower,weakness);
            model.put("hero",hero);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

//display
        get("/hero-detail", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> hero = Hero.getAll();
            model.put("hero", hero);
            return new ModelAndView(model, "hero-detail.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad-form",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad-detail",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads = Squad.getInstances();
            model.put("squads",squads);
            ArrayList<Hero> members = Hero.getAll();
            model.put("heroes",members);
            Squad squad = Squad.findBySquadId(1);
            model.put("allSquadMembers", squad.getMembers());
            return new ModelAndView(model, "squad-detail.hbs");
        }, new HandlebarsTemplateEngine());

        post("/squad/new",(request,response)-> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            Integer size = Integer.parseInt(request.queryParams("size"));
            String cause = request.queryParams("cause");
            Squad squad = new Squad(name,cause,size);
            request.session().attribute("item",name);
            model.put("item",request.session().attribute("item"));
            model.put("squad",squad);
            return new ModelAndView(model,"success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/new/member/:squadId",(request,response)->{
            Map<String, Object> model = new HashMap<>();
            request.session().attribute("selectedSquad",request.params("squadId"));
            model.put("selectedSquad", request.session().attribute("selectedSquad"));
            model.put("item",1);
            return new ModelAndView(model, "success.hbs");
        },new HandlebarsTemplateEngine());

        get("/squad/new/:id",(req,res)->{
            Map<String, Object> model = new HashMap<>();
            int id= Integer.parseInt(req.params("id"));
            Hero hero = Hero.findById(id);
            Squad squad = Squad.findBySquadId(1);
            squad.setMember(hero);
            model.put("item", hero.getName());
            model.put("hero",squad.getName());
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
